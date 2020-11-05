package com.lexuantung.hrm2.controller.user;


import com.lexuantung.hrm2.entity.*;

import com.lexuantung.hrm2.entity.view.ShowTimeWorking;
import com.lexuantung.hrm2.model.request.user.DetailRequest;
import com.lexuantung.hrm2.model.request.user.EmpRequest;
import com.lexuantung.hrm2.model.response.DetailResponse;
import com.lexuantung.hrm2.repository.*;
import com.lexuantung.hrm2.service.DetailService;
import com.lexuantung.hrm2.service.EmpService;
import com.lexuantung.hrm2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private EmpService empService;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private DetailRepository detailRepository;
    @Autowired
    private CongNhatRepository congNhatRepository;
    @Autowired
    private DetailService detailService;
    @Autowired
    private TimeWorkingRepository timeWorkingRepository;


    @GetMapping("/")
    public String viewHomePage(Model model, Principal principal) {
        System.out.println(principal.getName());
     //   List<Detail> details = detailService.findAllByEmployeePhone(principal.getName());
        List<ShowTimeWorking> details = detailService.findAllByPhone(principal.getName());
        model.addAttribute("details", details);
        return "userInfor.html";
   }
    @GetMapping("/checkIn/{id}")
    public String checkIn(@PathVariable("id") long id, Principal principal, Model model){
        detailService.checkIn(id);
        model.addAttribute("details", detailService.findWorkingTime(principal.getName()));
        return viewHomePage( model, principal);
    }
    @GetMapping("/checkOut/{id}")
    public String checkOut(@PathVariable("id") long id,  Principal principal, Model model){
        detailService.checkOut(id);
        model.addAttribute("details", detailService.findWorkingTime(principal.getName()));
        return viewHomePage( model, principal);
    }
    @GetMapping("/insertDetail")
    public String insert(Model model){
        Detail detail = new Detail();
        List<CongNhat> congNhats = congNhatRepository.findAll();
        List<Job> jobs = jobRepository.findAll();
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("detail", detail);
        model.addAttribute("congNhats", congNhats);
        model.addAttribute("jobs", jobs);
        model.addAttribute("projects", projects);
        return "updateDetail.html";
    }

    @PostMapping("/insert")
    public String insertDetail(Principal principal, Model model, DetailRequest request){
//        if(result.hasErrors()){
//////            return "403.html";
//////        }
        model.addAttribute("congNhat", "");
        model.addAttribute("job", "");
        model.addAttribute("project", "");

        Employee employee = empService.findEmpByPhone(principal.getName());
        request.setEmployee(employee);
        detailService.insert(request);
        return viewHomePage(model, principal);
    }
}

package com.lexuantung.hrm2.controller.admin;


import com.lexuantung.hrm2.entity.Employee;
import com.lexuantung.hrm2.entity.Role;
import com.lexuantung.hrm2.model.request.user.EmpRequest;
import com.lexuantung.hrm2.model.response.RoleResponse;
import com.lexuantung.hrm2.repository.EmployeeRepository;
import com.lexuantung.hrm2.service.EmpService;
import com.lexuantung.hrm2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class HomeController  {
    @Autowired
    private EmpService empService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return findPaginated(1, "name", "asc", model);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Employee> page = empService.findAndPaging(pageNo, pageSize, sortField, sortDir);
        List<Employee> listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listEmployees", listEmployees);
        return "index.html";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id") long id, Model model){

        empService.delete(id);
        model.addAttribute("employee", empService.findAll());
        return findPaginated(1, "name", "asc", model);
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Employee employee = employeeRepository.findEmployeeById(id);
        RoleResponse role = roleService.findOne(id);
        model.addAttribute("employee", employee);
        model.addAttribute("role", role);
        return "updateEmployee.html";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") long id, EmpRequest request, BindingResult result, Model model){
        if(result.hasErrors()){
            return "403.html";
        }
        empService.insert(request);
        return findPaginated(1, "name", "asc", model);
    }
}
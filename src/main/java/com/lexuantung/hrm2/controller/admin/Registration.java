package com.lexuantung.hrm2.controller.admin;

import com.lexuantung.hrm2.entity.Employee;
import com.lexuantung.hrm2.model.request.user.EmpRequest;
import com.lexuantung.hrm2.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class Registration {

    @Autowired
    private EmpService empService;

    @ModelAttribute("user")
    public EmpRequest empRequest(){
        return new EmpRequest();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid EmpRequest request, BindingResult result) {

        Employee existing = empService.findEmpByPhone(request.getPhone());

        if (existing != null){
            result.rejectValue("phone", null, "There is already an account registered with that phone number");
        }
        if (result.hasErrors()){
            return "registration";
        }

        empService.insert(request);
        return "redirect:/registration?success";
    }
}

package com.lexuantung.hrm2.controller;

import com.lexuantung.hrm2.service.EmpService;
import com.lexuantung.hrm2.service.SecurityService;
import com.lexuantung.hrm2.service.impl.securityImpl.EmpValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController  {
    @Autowired
    private EmpService empService;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private EmpValidation validation;



    @GetMapping("/login")
    public String login(Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("error", "Your phone number and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

//    @GetMapping("/")
//    public String userInfor(Model model, Principal principal){
//        String phoneNum = principal.getName();
//        return "index.html";
//    }
}

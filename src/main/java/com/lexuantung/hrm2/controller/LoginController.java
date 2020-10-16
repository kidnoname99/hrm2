package com.lexuantung.hrm2.controller;

import com.lexuantung.hrm2.entity.Employee;
import com.lexuantung.hrm2.model.request.user.LoginRequest;

import com.lexuantung.hrm2.service.EmpService;
import com.lexuantung.hrm2.service.SecurityService;
import com.lexuantung.hrm2.service.impl.EmpValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.Principal;


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

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }
}

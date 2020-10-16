package com.lexuantung.hrm2.service.impl;

import com.lexuantung.hrm2.entity.Employee;
import com.lexuantung.hrm2.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import org.springframework.validation.ValidationUtils;


@Component
public class EmpValidation implements Validator {
    @Autowired
    private EmpService empService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Employee employee = (Employee) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (employee.getPhone().length() < 1 || employee.getPhone().length() > 13) {
            errors.rejectValue("phoneNumber", "Size.userForm.username");
        }
        if (empService.findEmpByPhone(employee.getPhone()) != null) {
            errors.rejectValue("phoneNumber", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (employee.getPassword().length() < 5 || employee.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }


    }
}

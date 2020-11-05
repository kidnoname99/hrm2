package com.lexuantung.hrm2.service;


import com.lexuantung.hrm2.entity.Employee;
import com.lexuantung.hrm2.model.request.user.EmpRequest;
import com.lexuantung.hrm2.model.request.user.LoginRequest;
import com.lexuantung.hrm2.model.response.EmployeeResponse;
import com.lexuantung.hrm2.entity.Employee;
import com.lexuantung.hrm2.model.request.user.EmpRequest;
import com.lexuantung.hrm2.model.request.user.LoginRequest;
import com.lexuantung.hrm2.model.response.EmployeeResponse;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface EmpService  {
    void insert(EmpRequest empRequest);
    void update(EmpRequest empRequest);
    void delete(Long id);
    Employee findEmpByPhone(String phoneNumber);
    void save(Employee employee);
    List<Employee> findAll();
    Page<Employee> findAndPaging(int pageNo, int pageSize, String sortField, String sortDirection);

}

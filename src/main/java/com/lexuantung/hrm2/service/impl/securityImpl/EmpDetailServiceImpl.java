package com.lexuantung.hrm2.service.impl.securityImpl;

import com.lexuantung.hrm2.entity.Employee;
import com.lexuantung.hrm2.entity.Role;
import com.lexuantung.hrm2.repository.EmployeeRepository;
import com.lexuantung.hrm2.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmpDetailServiceImpl implements UserDetailsService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        System.out.println("phone input:"+phone);

        Employee employee = employeeRepository.findEmployeeByPhone(phone);

        if (employee == null){
            throw new UsernameNotFoundException("Invalid phone or password.");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = employee.getRoles();
        for (Role role : roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
       // roles.toString();

        return new org.springframework.security.core.userdetails.User(employee.getPhone(), employee.getPassword(), grantedAuthorities);
    }

}


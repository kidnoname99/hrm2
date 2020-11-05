package com.lexuantung.hrm2.service.impl;


import com.lexuantung.hrm2.entity.Employee;
import com.lexuantung.hrm2.entity.Role;
import com.lexuantung.hrm2.model.request.user.EmpRequest;
import com.lexuantung.hrm2.model.request.user.LoginRequest;
import com.lexuantung.hrm2.model.response.EmployeeResponse;
import com.lexuantung.hrm2.model.response.RoleResponse;
import com.lexuantung.hrm2.repository.EmployeeRepository;
import com.lexuantung.hrm2.repository.RoleRepository;
import com.lexuantung.hrm2.service.EmpService;
import com.lexuantung.hrm2.entity.Employee;
import com.lexuantung.hrm2.entity.Role;
import com.lexuantung.hrm2.model.request.user.EmpRequest;
import com.lexuantung.hrm2.repository.EmployeeRepository;
import com.lexuantung.hrm2.repository.RoleRepository;
import com.lexuantung.hrm2.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmpService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleService roleService;
    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public void insert(EmpRequest empRequest) {
        Employee employee = new Employee();
        empRequest.setPassword(bCryptPasswordEncoder.encode(empRequest.getPassword()));

        BeanUtils.copyProperties(empRequest,employee);
//        insertPermission(empRequest.getRoleID(), empRequest.getId());

        employeeRepository.save(employee);
    }

    @Override
    public void update(EmpRequest empRequest) {
        empRequest.setPassword(bCryptPasswordEncoder.encode(empRequest.getPassword()));
        Employee employee = new Employee();
        BeanUtils.copyProperties(empRequest,employee);
//
//        Set<Role> roles = new HashSet<>();
////        for (Long id: empRequest.getIds()){
////            Role role = roleRepository.getOne(id);
////            roles.add(role);
////        }
//        employee.setRoles(roles);
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {

        Employee employee = employeeRepository.findEmployeeById(id);
        for (Role role: employee.getRoles()){
            role.getEmps().remove(employee);
        }
        employeeRepository.delete(employee);
    }

    @Override
    public Employee findEmpByPhone(String phoneNumber) {
        System.out.println("go emp service");
        return employeeRepository.findEmployeeByPhone(phoneNumber);

    }

    @Override
    public void save(Employee employee) {
        employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        employee.setRoles(new HashSet<>(roleRepository.findAll()));
        employeeRepository.save(employee);
    }

//

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAndPaging(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageable);
    }

    public void insertPermission(long empId, long roleId){

        entityManager.createNativeQuery("insert into permission(role_id,employee_id) value (?,?);")
                .setParameter(1, roleId)
                .setParameter(2, empId)
                .executeUpdate();
    }

//
}

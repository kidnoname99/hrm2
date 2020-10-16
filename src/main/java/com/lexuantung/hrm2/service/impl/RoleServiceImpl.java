package com.lexuantung.hrm2.service.impl;

import com.lexuantung.hrm2.entity.Role;
import com.lexuantung.hrm2.model.response.RoleResponse;
import com.lexuantung.hrm2.repository.RoleRepository;
import com.lexuantung.hrm2.service.RoleService;
import com.lexuantung.hrm2.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;



    @Override
    public RoleResponse findOne(Long id) {
        Optional<Role> role = roleRepository.findById(id);


        RoleResponse roleResponse = new RoleResponse();
        BeanUtils.copyProperties(role, roleResponse);
        return roleResponse;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }
}

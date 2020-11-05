package com.lexuantung.hrm2.service;

import com.lexuantung.hrm2.entity.Role;
import com.lexuantung.hrm2.model.response.RoleResponse;

import java.util.List;

public interface RoleService {
    RoleResponse findOne(Long id);
    List<Role> findAll();

}

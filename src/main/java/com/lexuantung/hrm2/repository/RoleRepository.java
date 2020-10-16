package com.lexuantung.hrm2.repository;


import com.lexuantung.hrm2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RoleRepository extends JpaRepository<Role, Long> {
    Role findRolesById();
}

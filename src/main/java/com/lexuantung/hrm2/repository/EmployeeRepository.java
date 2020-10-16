package com.lexuantung.hrm2.repository;


import com.lexuantung.hrm2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findEmployeeByPhone(String phone);
}

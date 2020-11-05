package com.lexuantung.hrm2.repository;

import com.lexuantung.hrm2.entity.view.ShowTimeWorking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TimeWorkingRepository extends JpaRepository<ShowTimeWorking, Long> {
    @Query("select s from ShowTimeWorking s where s.phone = :phone")
    List<ShowTimeWorking> findAllByPhone(@Param("phone") String phone);
}

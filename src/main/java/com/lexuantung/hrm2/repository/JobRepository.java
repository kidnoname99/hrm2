package com.lexuantung.hrm2.repository;

import com.lexuantung.hrm2.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}

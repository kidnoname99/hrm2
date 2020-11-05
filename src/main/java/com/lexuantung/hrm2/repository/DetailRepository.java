package com.lexuantung.hrm2.repository;

import com.lexuantung.hrm2.entity.Detail;
import com.lexuantung.hrm2.model.response.DetailResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface DetailRepository extends JpaRepository<Detail, Long>{

//    @Query("SELECT detail, e FROM Detail detail join detail.employee e where e.phone = :phone  ")
//    List<Detail> findAllByEmployee_Phone(@Param("phone") String phone);
   // List<Detail> findAllByEmployee_Phone(String phone);
    Detail findDetailById(long id);

}

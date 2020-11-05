package com.lexuantung.hrm2.service.impl;

import com.lexuantung.hrm2.entity.*;
import com.lexuantung.hrm2.entity.view.ShowTimeWorking;
import com.lexuantung.hrm2.model.request.user.DetailRequest;
import com.lexuantung.hrm2.model.response.DetailResponse;
import com.lexuantung.hrm2.repository.*;
import com.lexuantung.hrm2.service.DetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailRepository detailRepository;
    @Autowired
    private TimeWorkingRepository timeWorkingRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CongNhatRepository congNhatRepository;
    @Autowired
    private JobRepository jobRepository;


    @Override
    public List<ShowTimeWorking> findAllByPhone(String phone) {

       return timeWorkingRepository.findAllByPhone(phone);

    }

    @Override
    public List<DetailResponse> findWorkingTime(String phone) {
        List<ShowTimeWorking> showTimeWorkings = timeWorkingRepository.findAllByPhone(phone);
        List<DetailResponse> responses = new ArrayList<>();
        for ( ShowTimeWorking source: showTimeWorkings ) {
            DetailResponse target= new DetailResponse();
            BeanUtils.copyProperties(source , target);

            responses.add(target);
        }

        return responses;
    }

    @Override
    public void checkIn(long id) {
       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();


        Detail detail = detailRepository.findDetailById(id);
        detail.setStartTime(time);
        detailRepository.save(detail);
    }

    @Override
    public void checkOut(long id) {
        LocalDateTime time = LocalDateTime.now();

        Detail detail = detailRepository.findDetailById(id);
        detail.setEndTime(time);
        detailRepository.save(detail);
    }

    @Override
    public void insert(DetailRequest detailRequest) {
        Detail detail = new Detail();
        BeanUtils.copyProperties(detailRequest, detail);
        detailRepository.save(detail);
    }

    @Override
    public void update(long id, long pId, long eId, long idCn, long jId) {

    }


}

package com.lexuantung.hrm2.service;

import com.lexuantung.hrm2.entity.Detail;

import com.lexuantung.hrm2.entity.view.ShowTimeWorking;
import com.lexuantung.hrm2.model.request.user.DetailRequest;
import com.lexuantung.hrm2.model.response.DetailResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DetailService {
    List<ShowTimeWorking> findAllByPhone(String phone);

    List<DetailResponse> findWorkingTime(String phone);

    void checkIn(long id);
    void checkOut(long id);

    void insert(DetailRequest detailRequest);

    void update(long id, long pId, long eId, long idCn, long jId);
}

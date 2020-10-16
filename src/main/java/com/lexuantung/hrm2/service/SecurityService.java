package com.lexuantung.hrm2.service;


public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String phone, String password);
}

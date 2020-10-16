package com.lexuantung.hrm2.model.request;

import lombok.Data;

@Data
public class UserApiRequest {
    String userName;
    String password;
    String email;
    String phone;
}

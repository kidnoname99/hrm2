package com.lexuantung.hrm2.model.request.user;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;


public class EmpRequest {
    private  Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String cmnd;
    @NotEmpty
    private String address;
    @NotEmpty
    private String password;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String confirmPassword;

    private Long roleID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleID() {
        return roleID;
    }

    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

package com.lexuantung.hrm2.model.response;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DetailResponse {
    private long id;
    private String name;
    private String job;
    private String project;
    private String phone;
    private long jobSalary;
    private long cnSalary;
    private String cnName;
    private String kiemSat;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long workingTime;
    private long overTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public String getKiemSat() {
        return kiemSat;
    }

    public void setKiemSat(String kiemSat) {
        this.kiemSat = kiemSat;
    }

    public long getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(long jobSalary) {
        this.jobSalary = jobSalary;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public long getCnSalary() {
        return cnSalary;
    }

    public void setCnSalary(long cnSalary) {
        this.cnSalary = cnSalary;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public long getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(long workingTime) {
        this.workingTime = workingTime;
    }

    public long getOverTime() {
        return overTime;
    }

    public void setOverTime(long overTime) {
        this.overTime = overTime;
    }
}

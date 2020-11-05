package com.lexuantung.hrm2.entity.view;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "showTimeWorking")
public class ShowTimeWorking {
    @Id
    private long id;
    private String name;
    private String job;
    private String project;
    private String phone;
    private float jobSalary;
    private float cnSalary;
    private String cnName;
    private String kiemSat;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Float workingTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
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

    public float getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(float jobSalary) {
        this.jobSalary = jobSalary;
    }

    public float getCnSalary() {
        return cnSalary;
    }

    public void setCnSalary(float cnSalary) {
        this.cnSalary = cnSalary;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getKiemSat() {
        return kiemSat;
    }

    public void setKiemSat(String kiemSat) {
        this.kiemSat = kiemSat;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Float getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Float workingTime) {
        this.workingTime = workingTime;
    }
}

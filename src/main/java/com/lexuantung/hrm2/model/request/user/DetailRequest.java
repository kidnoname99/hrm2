package com.lexuantung.hrm2.model.request.user;

import com.lexuantung.hrm2.entity.CongNhat;
import com.lexuantung.hrm2.entity.Employee;
import com.lexuantung.hrm2.entity.Job;
import com.lexuantung.hrm2.entity.Project;

import java.time.LocalDateTime;

public class DetailRequest {
    private long id;
    private Employee employee;
    private Job job;
    private Project project;
    private CongNhat congNhat;
    private String kiemSat;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public CongNhat getCongNhat() {
        return congNhat;
    }

    public void setCongNhat(CongNhat congNhat) {
        this.congNhat = congNhat;
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

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}

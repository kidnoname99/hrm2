package com.lexuantung.hrm2.entity;



import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Table(name = "detail")
public class Detail {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "startTime")
    private LocalDateTime startTime;
    @Column(name = "endTime")
    private LocalDateTime endTime;
    @Column(name = "kiemSat")
    private String kiemSat;

    @ManyToOne
    @JoinColumn(name="idCN", referencedColumnName = "id")
    private CongNhat congNhat;

    @ManyToOne
    @JoinColumn(name="idJob", referencedColumnName="id")
    private Job job;

    @ManyToOne
    @JoinColumn(name="projId", referencedColumnName="id")
    private Project project;

    @ManyToOne
    @JoinColumn(name="empId", referencedColumnName="id")
    private Employee employee;

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

    public String getKiemSat() {
        return kiemSat;
    }

    public void setKiemSat(String kiemSat) {
        this.kiemSat = kiemSat;
    }

    public CongNhat getCongNhat() {
        return congNhat;
    }

    public void setCongNhat(CongNhat congNhat) {
        this.congNhat = congNhat;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

package com.lexuantung.hrm2.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "congNhat")
public class CongNhat {
    @Id
    @Column(name = "id")
    private Long id;
    @Column
    private String name;
    @Column
    private float salary;

    @OneToMany(targetEntity = Detail.class, mappedBy = "congNhat")
    private List<Detail> details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}

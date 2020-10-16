package com.lexuantung.hrm2.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "job")
public class Job {
    @Id
    @Column(name = "id")
    private Long id;
    @Column
    private String name;
    @Column
    private float salary;

    @OneToMany(mappedBy = "job", targetEntity = Detail.class)
    private Set<Detail> details;

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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Set<Detail> getDetails() {
        return details;
    }

    public void setDetails(Set<Detail> details) {
        this.details = details;
    }
}

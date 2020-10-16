package com.lexuantung.hrm2.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id")
    private Long id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<Employee> emps = new HashSet<Employee>();

    public Role() {
    }

    public Role(Long id, String name, Set<Employee> emps) {
        this.id = id;
        this.name = name;
        this.emps = emps;
    }

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

    public Set<Employee> getEmps() {
        return emps;
    }

    public void setEmps(Set<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emps=" + emps +
                '}';
    }
}

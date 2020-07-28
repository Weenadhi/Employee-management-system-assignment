package com.hms.employeemanagement.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @Column(nullable =false)
    private int departmentId;


    @Column(nullable =false)
    @Enumerated(EnumType.STRING)
    private DepartmentName departmentName;

    @OneToMany(mappedBy ="employeeId.department",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Employee> employee;


    public Department() {
    }

    public Department(DepartmentName departmentName, int departmentId) {
        this.departmentName = departmentName;
        this.departmentId = departmentId;
    }


    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public DepartmentName getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(DepartmentName departmentName) {
        this.departmentName = departmentName;
    }

}


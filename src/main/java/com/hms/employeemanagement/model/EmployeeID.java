package com.hms.employeemanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;



@Embeddable
public class EmployeeID implements Serializable {

    private long employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

    public EmployeeID(long employeeId, Department department) {
        this.employeeId = employeeId;
        this.department = department;
    }

    public EmployeeID() {
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

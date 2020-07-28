package com.hms.employeemanagement.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@AssociationOverride(name = "employeeId.department",
        joinColumns = @JoinColumn(name = "department_id"))
public class Employee {

    @EmbeddedId
    private EmployeeID employeeId;

    @Column(nullable =false)
    private String name;

    @Column(nullable =false)
    private int age;

    @Column(nullable =false)
    private String gender;

    @Column(nullable =false)
    private String designation;

    @Column(nullable =false)
    private String email;

    @Column(nullable =false)
    private String mobileNumber;
    @Column(nullable =false)
    private String nic;

    @Column(nullable =false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joinedDate;

    public Employee(int age,String name,String gender, String designation,String email,String mobileNumber,String nic,Date joinedDate, EmployeeID employeeId ){
        this.age=age;
        this.name=name;
        this.gender=gender;
        this.designation=designation;
        this.email=email;
        this.mobileNumber=mobileNumber;
        this.nic=nic;
        this.joinedDate=joinedDate;
        this.employeeId=employeeId;

    }

    public Employee() {
    }

    public EmployeeID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeID employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

}






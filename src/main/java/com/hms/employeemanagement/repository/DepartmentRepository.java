package com.hms.employeemanagement.repository;

import com.hms.employeemanagement.model.Department;
import com.hms.employeemanagement.model.DepartmentName;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

   // Department findByDeptName (DepartmentName departmentName);
}

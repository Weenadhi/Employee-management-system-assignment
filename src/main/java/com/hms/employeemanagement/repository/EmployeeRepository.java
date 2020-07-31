package com.hms.employeemanagement.repository;

import com.hms.employeemanagement.model.Employee;
import com.hms.employeemanagement.model.EmployeeID;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, EmployeeID> {


    @Query(
            value = "SELECT * FROM employee",
            nativeQuery = true
    )
    List<Employee> findAllEmp();

    @Query(
            value = "select * from  employee where name=:name",
            nativeQuery = true
    )
    List<Employee> findByName(@Param("name") String name);

    @Query(
            value = "SELECT * FROM employee e ,department d WHERE e.department_id=d.department_id AND department_name=:departmentName",
            nativeQuery = true
    )
    List<Employee> findByDeptName(@Param("departmentName") String departmentName);

    @Query(
            value = "SELECT * FROM employee WHERE nic LIKE '90%' AND TIMESTAMPDIFF(YEAR, joined_date, CURRENT_DATE())>=5",
            nativeQuery = true)
    List<Employee> findByNic(@Param("nic") String nic);


    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM employee WHERE employee_id=:employeeId AND department_id=:departmentId",
            nativeQuery = true
    )
    void deleteById(@Param("employeeId") long employeeId ,@Param("departmentId") int departmentId);



    @Query(value = "SELECT * FROM employee WHERE employee_id=:employee_id",nativeQuery = true)
    Employee findEmployeeByEmployeeID(@Param("employee_id") long employeeID);
}

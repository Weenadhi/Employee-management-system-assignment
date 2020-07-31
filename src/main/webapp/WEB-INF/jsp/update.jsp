<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Management System</title>
</head>
<body>
<h1 style="text-align: center;">Update Employee</h1>
<div class="container">
    <%--@elvariable id="employee" type="com.hms.employeemanagement.dto.EmployeeDTO"--%>
    <form:form method="POST" modelAttribute="employee" action="/updateEmployee">
        <form:label path="employeeID">Employee ID:</form:label>
        <form:input path="employeeID" value="${employee.employeeID}" readonly="true"/><br/><br/>
        <form:label path="name" >Name:</form:label>
        <form:input path="name" value="${employee.name}" /><br/><br/>
        <form:label path="age" >Age:</form:label>
        <form:input path="age" value="${employee.age}" /><br/><br/>
        <form:label path="gender" >Gender:</form:label>
        <form:input path="gender" value="${employee.gender}" /><br/><br/>
        <form:label path="designation" >Designation:</form:label>
        <form:input path="designation" value="${employee.designation}" /><br/><br/>
        <form:label path="email">Email:</form:label>
        <form:input path="email" value="${employee.email}"/><br/><br/>
        <form:label path="mobileNumber" >Mobile Number:</form:label>
        <form:input path="mobileNumber" value="${employee.mobileNumber}" /><br/><br/>
        <form:label path="nic">NIC:</form:label>
        <form:input path="nic" value="${employee.nic}"/><br/><br/>
        <form:label path="joinedDate">Joined Date:</form:label>
        <form:input type="date" path="joinedDate" value="${dateFormat.format(employee.joinedDate)}" /><br/><br/>
        <form:label path="departmentID">Department:</form:label>
        <form:input path="departmentID" value="${employee.departmentID}"/>
        <br/>
        <br/>
        <form:button>Update</form:button>
    </form:form>
</div>



</body>
</html>
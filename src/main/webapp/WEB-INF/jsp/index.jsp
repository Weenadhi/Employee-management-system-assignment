<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Management System</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;">Employee Management System</h1>


<h3>All Employees</h3><br />
<table>
    <tr>
        <th>Employee ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Gender</th>
        <th>Designation</th>
        <th>Email</th>
        <th>Mobile Number</th>
        <th>NIC</th>
        <th>Joined Date</th>
        <th>Department ID</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.employeeID}</td>
            <td>${employee.name}</td>
            <td>${employee.age}</td>
            <td>${employee.gender}</td>
            <td>${employee.designation}</td>
            <td>${employee.email}</td>
            <td>${employee.mobileNumber}</td>
            <td>${employee.nic}</td>
            <td>${dateFormat.format(employee.joinedDate)}</td>
            <td>${employee.departmentID}</td>
            <td><a href="/update/${employee.employeeID}">Edit</a></td>
            <td><a href="/delEmpByID?employeeId=${employee.employeeID}&departmentId=${employee.getDepartmentID()}">Delete</a></td>

        </tr>
    </c:forEach>
</table><br /><br />
<form action="/register">
    <button class="w3-button w3-blue" type="submit">Register new employee</button>
</form>

</body>
</html>
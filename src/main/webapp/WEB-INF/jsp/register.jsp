<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel = "stylesheet">
    <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

    <!-- Javascript -->
    <script>
        $(function() {
            $( "#datepicker-12" ).datepicker();
            $( "#datepicker-12" ).datepicker("setDate", "10w+1");
        });
    </script>

</head>
<body>
<h1 style="text-align: center;">Register new employee</h1>

<div class="container">
    <form:form method="post" modelAttribute="employee"  action="/addEmployee">
        <table >
            <tr>
                <td>Employee ID :</td>
                <td><form:input path="employeeID" /></td>
            </tr>
            <tr>
                <td>Departmet ID :</td>
                <td><form:input path="departmentID" /></td>
            </tr>
            <tr>
                <td>Name :</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Age :</td>
                <td><form:input path="age" /></td>
            </tr>
            <tr>
                <td>Gender :</td>
                <td><form:input path="gender" /></td>
            </tr>
            <tr>
                <td>Designation :</td>
                <td><form:input path="designation" /></td>
            </tr>
            <tr>
                <td>Email :</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Mobile Number :</td>
                <td><form:input path="mobileNumber" /></td>
            </tr>
            <tr>
                <td>NIC :</td>
                <td><form:input path="nic" /></td>
            </tr>
            <tr>
                <td>Joined Date :</td>
<%--                <td><form:input path="joinedDate" /></td>--%>
                <td><form:input type = "text" id = "datepicker-12" path="joinedDate" /></td>
            </tr>

        <td colspan="2"><input type="submit" value="Save" /></td>
        </table>
    </form:form>

<%--@elvariable id="employee" type="com.hms.employeemanagement.dto.EmployeeDTO"--%>
<%--    <form:form method="POST" action="/addEmployee">--%>
<%--        <form:label path="employeeID">Employee ID:</form:label>--%>
<%--        <form:input path="employeeID"/><br/><br/>--%>
<%--        <form:label path="name">Name:</form:label>--%>
<%--        <form:input path="name"/><br/><br/>--%>
<%--        <form:label path="age">Age:</form:label>--%>
<%--        <form:input path="age"/><br/><br/>--%>
<%--        <form:label path="gender">Gender:</form:label>--%>
<%--        <form:input path="gender"/><br/><br/>--%>
<%--        <form:label path="designation">Designation:</form:label>--%>
<%--        <form:input path="designation"/><br/><br/>--%>
<%--        <form:label path="email">Email:</form:label>--%>
<%--        <form:input path="email"/><br/><br/>--%>
<%--        <form:label path="mobileNumber">Mobile Number:</form:label>--%>
<%--        <form:input path="mobileNumber"/><br/><br/>--%>
<%--        <form:label path="nic">NIC:</form:label>--%>
<%--        <form:input path="nic"/><br/><br/>--%>
<%--        <form:label path="joinedDate">Joined Date:</form:label>--%>
<%--        <form:input type="date" path="joinedDate"/><br/><br/>--%>
<%--        <form:label path="departmentID">Department:</form:label>--%>
<%--        <form:select path="departmentID" >--%>
<%--            <c:forEach var="department" items="${departments}">--%>
<%--                <form:option value="${department.departmentId}">${department.departmentName}</form:option>--%>
<%--            </c:forEach>--%>
<%--        </form:select>--%>
<%--        <br/>--%>
<%--        <br/>--%>
<%--        <form:button>Register</form:button>--%>
<%--    </form:form>--%>
</div>
</body>
</html>
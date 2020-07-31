<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search by department name</title>
</head>
<body>
<%--@elvariable id="search" type=""--%>
<form:form method="get" modelAttribute="search" action="/">
    <form:label path="deptName">Search By Department Name  </form:label>
    <form:select path="deptName">
        <option >select</option>
        <c:forEach var="department" items="${departments}">
            <option value="${department.departmentName}"  <c:if test="${department.departmentName == search.departmentName}">selected</c:if>>${department.departmentName}</option>
        </c:forEach>
    </form:select>
    <form:button>Search</form:button>
</form:form>
</body>
</html>
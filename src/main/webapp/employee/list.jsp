<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee list</title>
</head>
<body>
<h1>Employees</h1>
<p>
    <a href="/employees?action=create">Create new employee</a>
</p>
<table border="1px">
    <tr>
        <td>Name</td>
        <td>Age</td>
        <td>Role</td>
        <td>Room</td>
        <td>Salary</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>

    <c:forEach items="${requestScope['employees']}" var="employee">
        <tr>
            <td><a href="/employees?action=view&id=${employee.getId()}">${employee.getName()}</a></td>
            <td>${employee.getAge()}</td>
            <td>${employee.getRole()}</td>
            <td>${employee.getRoom()}</td>
            <td>${employee.getSalary()} USD</td>
            <td><a href="/employees?action=edit&id=${employee.getId()}">Edit</a></td>
            <td><a href="/employees?action=delete&id=${employee.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

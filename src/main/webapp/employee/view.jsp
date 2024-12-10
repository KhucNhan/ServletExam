<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 12/10/2024
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Employee</title>
</head>
<body>
<h1>Employee details</h1>
<p>
    <a href="/employees">Back to employee list</a>
</p>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["employee"].getName()}</td>
    </tr>
    <tr>
        <td>Age: </td>
        <td>${requestScope["employee"].getAge()}</td>
    </tr>
    <tr>
        <td>Role: </td>
        <td>${requestScope["employee"].getRole()}</td>
    </tr>
    <tr>
        <td>Room: </td>
        <td>${requestScope["employee"].getRoom()}</td>
    </tr>
    <tr>
        <td>Salary: </td>
        <td>${requestScope["employee"].getSalary()}</td>
    </tr>
</table>
</body>
</html>

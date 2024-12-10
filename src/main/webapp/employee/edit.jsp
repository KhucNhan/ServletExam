<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit employee</title>
</head>
<body>
<h1>Edit employee</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span style="color: lawngreen">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/employees">Back to employee list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Employee information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${requestScope["employee"].getName()}"></td>
            </tr>
            <tr>
                <td>Age: </td>
                <td><input type="number" name="age" id="age" value="${requestScope["employee"].getAge()}"></td>
            </tr>
            <tr>
                <td>Role: </td>
                <td><input type="text" name="role" id="role" value="${requestScope["employee"].getRole()}"></td>
            </tr>
            <tr>
                <td>Room: </td>
                <td><input type="text" name="room" id="room" value="${requestScope["employee"].getRoom()}"></td>
            </tr>
            <tr>
                <td>Salary: </td>
                <td><input type="number" name="salary" id="salary" value="${requestScope["employee"].getSalary()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update employee"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create employee</title>
</head>
<body>
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
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Age: </td>
                <td><input type="number" name="age" id="age"></td>
            </tr>
            <tr>
                <td>Role: </td>
                <td><input type="text" name="role" id="role"></td>
            </tr>
            <tr>
                <td>Room: </td>
                <td><input type="text" name="room" id="room"></td>
            </tr>
            <tr>
                <td>Salary: </td>
                <td><input type="number" name="salary" id="salary"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create employee"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

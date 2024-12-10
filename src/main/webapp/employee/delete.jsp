<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete employee</title>
</head>
<body>
<h1>Delete employee</h1>
<p>
    <a href="/employees">Back to employee list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Employee information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td>${requestScope["employee"].getName()}</td>
            </tr>
            <tr>
                <td>Age:</td>
                <td>${requestScope["employee"].getAge()}</td>
            </tr><tr>
                <td>Role:</td>
                <td>${requestScope["employee"].getRole()}</td>
            </tr>
            <tr>
                <td>Room:</td>
                <td>${requestScope["employee"].getRoom()}</td>
            </tr>
            <tr>
                <td>Salary:</td>
                <td>${requestScope["employee"].getSalary()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete employee"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

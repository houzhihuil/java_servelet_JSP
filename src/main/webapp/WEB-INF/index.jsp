<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Exercice 1</title>
</head>
<body>
<form action="ex1" method="post">
    <label for="username">Username</label>
    <input type="text" name="username" id="username">
    <br>
    <label for="password">Password</label>
    <input type="password" name="password" id="password">
    <br>
    <br>
    <input type="submit" value="login">
</form>
<%
    String message = "";
    if (request.getAttribute("message") != null) {
        message = request.getAttribute("message").toString();
    }
%>
<p style="color:red"><%=message%>
</p>


</body>
</html>
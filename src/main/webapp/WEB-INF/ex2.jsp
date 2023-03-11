<%--
  Created by IntelliJ IDEA.
  User: PHILIP
  Date: 2023-03-10
  Time: 9:13 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Exercice 2</title>
</head>
<body>
<form  method="POST" action="ex2">
  <label for="temperature">Entrer la temperature</label>
  <input type="number" name="temperature" id="temperature" >
  <br>
  <label>Choisir l'unité</label>
  <input type="radio" name="unite" value="celsius" checked> Celsius
  <input type="radio" name="unite" value="fahrenheit"> Fahrenheit
  <br>
  <input type="submit" value="convertir">
</form>
<%
  String message = "";
  if (request.getAttribute("message") != null) {
    message = request.getAttribute("message").toString();
  }

%>
<p style="color:green"><%=message%>
</body>
</html>
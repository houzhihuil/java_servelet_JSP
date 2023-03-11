<%@ page import="cgodin.models.entities.Car" %>
<%@ page import="java.util.List" %>
<%@ page import="cgodin.models.entities.CarSales" %>
<%--
 Created by IntelliJ IDEA.
 User: PHILIP
 Date: 2023-03-10
 Time: 5:26 p.m.
 To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des voitures</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <style>
        .my-custom-class {
            margin-left: 50px;
        }
    </style>
</head>
<body>

<h1 class="display-1 text-success text-center">Liste des voitures</h1>
<%
    List<CarSales> carSales = (List<CarSales>) request.getAttribute("carSales");


%>
<table class="table table-hover my-custom-class">
    <thead>
    <tr>
        <th>Maker</th>
        <th>Model</th>
        <th>Total Quantity</th>
    </tr>
    </thead>
    <tbody>

<%
    for (CarSales c: carSales) {
%>
<tr>
    <td><%=c.getMaker()%></td>
    <td><%=c.getModel()%></td>
    <td><%=c.getTotalQuantity()%></td>
</tr>
<%
    }
%>

    </tbody>
</table>
</body>
</html>

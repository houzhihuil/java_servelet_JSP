<%@ page import="cgodin.models.entities.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: PHILIP
  Date: 2023-03-10
  Time: 4:30 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des commandes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <style>
        .my-custom-class {
            margin-left: 50px;
        }
    </style>
</head>
<body>
<h1 class="display-1 text-success text-center">Liste des commandes</h1>
<%
    List<Order> commandes = (List<Order>) request.getAttribute("commandes");
%>
<p class="h1 text-primary text-center">Il y a <%=commandes.size()%> commandes trouvés.</p>
<table class="table table-hover my-custom-class">
    <thead>
    <tr>
        <th>Id</th>
        <th>Maker</th>
        <th>Model</th>
        <th>Customer_id</th>
        <th>Date_order</th>
        <th>Quantity</th>
    </tr>
    </thead>
    <tbody>
    <% for (Order o : commandes) { %>
    <tr>
        <td><%= o.getId() %></td>
        <td><%= o.getMaker() %></td>
        <td><%= o.getModel() %></td>
        <td><%= o.getCustomerID() %></td>
        <td><%= o.getDateOrder() %></td>
        <td><%= o.getQuantity() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>

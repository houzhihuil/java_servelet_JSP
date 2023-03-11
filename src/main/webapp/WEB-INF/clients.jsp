<%@ page import="cgodin.models.entities.Customer" %>
<%@ page import="java.util.List" %> <%--
  Created by IntelliJ IDEA.
  User: PHILIP
  Date: 2023-03-10
  Time: 11:20 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des clients</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <style>
        .my-custom-class {
            margin-left: 50px;
        }
    </style>
</head>
<body>
<h1 class="display-1 text-success text-center">Liste des clients</h1>
<%
    List<Customer> clients = (List<Customer>) request.getAttribute("clients");
%>
<p class="h1 text-primary text-center">Il y a <%=clients.size()%> clients trouvés.</p>
<a href="ex3v" class="btn btn-warning">Voitures les plus commmandées</a> &nbsp;&nbsp;
<a href="ex3ajoutclient" class="btn btn-primary">Nouveau client</a>

<table class="table table-hover my-custom-class">
    <thead>
    <tr>
        <th>Id</th>
        <th>Nom complet</th>
        <th>Numéro de téléphone</th>
    </tr>
    </thead>
    <tbody>
    <% for (Customer c : clients) { %>
    <tr>
        <td><%= c.getId() %></td>
        <td><%= c.getFullName() %></td>
        <td><%= c.getPhoneNumber() %></td>
        <td class="btn btn-info"> <a href="ex3Commandes?id=<%=c.getId()%>" />Commande</td>
        <td class="btn btn-primary"><a href="ex3ajoutcommande?id=<%=c.getId()%>">Ajouter</a> </td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>

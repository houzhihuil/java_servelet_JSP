<%@ page import="cgodin.models.entities.Car" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: PHILIP
  Date: 2023-03-10
  Time: 9:28 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout d'une commande</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

</head>
<body>
<h1 class="text-primary">Formulaire d'ajout d'une nouvelle commande</h1>
<form action="ex3ajoutcommande" method="post">
    <div class="mb-3">
        <label for="maker_model" class="form-label">Choisir la voiture</label>
        <select class="form-control" id="maker_model" name="maker_model">
            <%
                for (Car car : (List<Car>)request.getAttribute("voitures")) {
            %>
            <option><%=car.getMaker()%>_<%=car.getModel()%></option>
            <%
                }
            %>
        </select>
    </div>
    <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
    <div class="mb-3">
        <label for="quantity" class="form-label">Quantité</label>
        <input type="number" class="form-control" id="quantity" name="quantity">
    </div>
    <button type="submit" class="btn btn-primary">Commander</button>
</form>
</body>
</html>

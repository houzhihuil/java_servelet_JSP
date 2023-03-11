<%--
  Created by IntelliJ IDEA.
  User: GG
  Date: 2022-12-07
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajout d'un client</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

</head>
<body>
<h1 class="text-primary">Formulaire d'ajout d'un nouveua client</h1>
<form action="ex3ajoutclient" method="post">
    <div class="mb-3">
        <label for="fullname" class="form-label">Nom complet</label>
        <input type="text" class="form-control" id="fullname" name="fullname">
    </div>
    <div class="mb-3">
        <label for="phonenumber" class="form-label">Téléphone</label>
        <input type="text" class="form-control" id="phonenumber" name="phonenumber">
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
</form>
</body>
</html>

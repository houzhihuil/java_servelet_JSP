<%--
  Created by IntelliJ IDEA.
  User: GG
  Date: 2022-12-05
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome page</title>
</head>
<body>
<h1>Salut <em style="color:red"><%= request.getParameter("username") %></em>  à la page d'accueil.</h1>
<%
    String test = "";
    if (request.getAttribute("test") != null) {
        test = request.getAttribute("test").toString();
    }
%>

<h1>Salut  <em style="color:red"> <%=test%> </em>à la page d'accueil.</h1>
</body>
</html>

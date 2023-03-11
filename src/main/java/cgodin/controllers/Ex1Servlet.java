package cgodin.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Ex1Servlet", value = "/ex1")
public class Ex1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(username.equals("admin") && password.equals("Admin2022!")){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
            request.setAttribute("test", "Administradeur");
            rd.forward(request, response);
        }else{
            request.setAttribute("message", "Attention! vérifier les données saisies");
            doGet(request, response);
        }
    }
}

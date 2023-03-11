package cgodin.controllers;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Exercice2Servlet", value = "/ex2")
public class Ex2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ex2.jsp");
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int temp = Integer.parseInt(request.getParameter("temperature"));
        String uniteSource = request.getParameter("unite");
        String uniteDestiny ="";
        int result = 0;
        String message = "";
        if(uniteSource.equals("celsius")) {
            //faire la conversion en Fahrenheit
            result = (temp * 9 / 5) + 32;
            uniteDestiny = "Fahrenheit";
        }
        else if(uniteSource.equals("fahrenheit")) {
            //faire la conversion en Fahrenheit
            result = (temp - 32) * 5 / 9;
            uniteDestiny = "Celsius";
        }
        message = temp + " " + uniteSource+ "  ==> " + result + " " + uniteDestiny;
        request.setAttribute("message", message);
        doGet(request, response);
    }
}


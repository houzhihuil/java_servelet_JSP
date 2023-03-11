package cgodin.controllers;

import cgodin.models.DAO.CustomerDAO;
import cgodin.models.DAO.ManagerDAO;
import cgodin.models.entities.Customer;
import cgodin.models.entities.Order;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Ex3Servlet", value = "/ex3")
public class Ex3Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers =  customerDAO.AllCustomers();

         // déleguer l'affichage à un page jsp
        request.setAttribute("clients", customers);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/clients.jsp");
        rd.forward(request, response);






    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

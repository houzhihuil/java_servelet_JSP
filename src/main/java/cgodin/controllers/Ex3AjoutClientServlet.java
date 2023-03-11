package cgodin.controllers;

import cgodin.models.DAO.CustomerDAO;
import cgodin.models.DAO.ICustomerDAO;
import cgodin.models.entities.Customer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Ex3AjoutClientServlet", value = "/ex3ajoutclient")
public class Ex3AjoutClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ajoutclient.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullname");
        String phoneNumber = request.getParameter("phonenumber");
        //créer un client en mémoire
        Customer customer = new Customer();
        customer.setFullName(fullName);
        customer.setPhoneNumber(phoneNumber);
        //stocker le client dans la BD
        ICustomerDAO customerDAO = new CustomerDAO();
        int nbLines = customerDAO.Add(customer);
        if( nbLines > 0){ //sucess
            List<Customer> customers = customerDAO.AllCustomers();
            //déleguer l'affichage à une page JSP
            request.setAttribute("clients", customers);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/clients.jsp");
            rd.forward(request, response);
        }else{ //echec
            doGet(request, response);
        }

    }
}

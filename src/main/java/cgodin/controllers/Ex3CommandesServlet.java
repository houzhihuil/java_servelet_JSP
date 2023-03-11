package cgodin.controllers;

import cgodin.models.DAO.ManagerDAO;
import cgodin.models.entities.Order;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Ex3CommandesServlet", value = "/ex3Commandes")
public class Ex3CommandesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idClient =  Integer.parseInt(request.getParameter("id"));
        ManagerDAO managerDAO = new ManagerDAO();
        List <Order> commandes = managerDAO.GetOrdersByCustomer(idClient);

        // déleguer l'affichage à un page jsp
        request.setAttribute("commandes", commandes);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/commandes.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

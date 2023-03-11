package cgodin.controllers;

import cgodin.models.DAO.IManagerDAO;
import cgodin.models.DAO.ManagerDAO;
import cgodin.models.entities.Car;
import cgodin.models.entities.Order;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Ex3VoituresServlet", value = "/ex3voitures")
public class Ex3VoituresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IManagerDAO managerDAO = new ManagerDAO();
        List<Car> voitures = managerDAO.GetSortedCars();
        List<Integer> quantites = managerDAO.GetSortedQuantities();
        //déleguer l'affichage à une page JSP
        request.setAttribute("voitures", voitures);
        request.setAttribute("quantites", quantites);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/voitures.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

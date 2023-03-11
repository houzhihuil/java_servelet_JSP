package cgodin.controllers;

import cgodin.models.DAO.IManagerDAO;
import cgodin.models.DAO.ManagerDAO;
import cgodin.models.entities.Car;
import cgodin.models.entities.CarSales;
import cgodin.models.entities.Order;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Ex3vServlet", value = "/ex3v")
public class Ex3vServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IManagerDAO managerDAO = new ManagerDAO();
        List<CarSales> carSales = managerDAO.GetSortedCarSales();

        //déleguer l'affichage à une page JSP
        request.setAttribute("carSales", carSales);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/v.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

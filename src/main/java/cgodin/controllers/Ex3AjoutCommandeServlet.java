package cgodin.controllers;

import cgodin.models.DAO.IManagerDAO;
import cgodin.models.DAO.ManagerDAO;
import cgodin.models.entities.Car;
import cgodin.models.entities.Order;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "Ex3AjoutCommandeServlet", value = "/ex3ajoutcommande")
public class Ex3AjoutCommandeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idClient  = Integer.parseInt(request.getParameter("id"));
        IManagerDAO managerDAO = new ManagerDAO();
        List<Car> voitures = managerDAO.GetAllCars();
        //déleguer l'affichage à une page JSP
        request.setAttribute("voitures", voitures);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ajoutcommande.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idClient  = Integer.parseInt(request.getParameter("id"));
        int quantity  = Integer.parseInt(request.getParameter("quantity"));
        String maker_model = request.getParameter("maker_model");
        String maker = maker_model.substring(0, maker_model.indexOf("_"));
        String model = maker_model.substring(maker_model.indexOf("_") + 1);
        Order order = new Order();
        order.setMaker(maker);
        order.setModel(model);
        order.setCustomerID(idClient);
        order.setDateOrder(LocalDate.now());
        order.setQuantity(quantity);
        System.out.println(order);
        IManagerDAO managerDAO = new ManagerDAO();
        int nbLines = managerDAO.addOrderToCustomer(idClient, order);
        if( nbLines > 0) { //sucess
            List<Order> commandes = managerDAO.GetOrdersByCustomer(idClient);
            //déleguer l'affichage à une page JSP
            request.setAttribute("commandes", commandes);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/commandes.jsp");
            rd.forward(request, response);
        }
    }

}

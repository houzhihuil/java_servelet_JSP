package cgodin.models.DAO;
import cgodin.models.entities.*;

import java.util.*;

public interface IManagerDAO {
    void establishConnection();
    void closeConnection();
    List<Order> GetOrdersByCustomer(int id);
    List<Order> GetOrdersByYear(int year);
    int addOrderToCustomer(int id, Order order);

    List<Car> GetAllCars();

    List<Car> GetSortedCars();
    List<Integer> GetSortedQuantities();
    //
    List<CarSales> GetSortedCarSales();// combine the two above
}

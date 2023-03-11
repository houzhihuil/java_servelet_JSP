package cgodin.models.DAO;

import cgodin.models.entities.Car;
import cgodin.models.entities.CarSales;
import cgodin.models.entities.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerDAO implements IManagerDAO{
    public static String URL = "jdbc:mysql://mysql-philippehou.alwaysdata.net:3306/philippehou_demo_109";
    public static final String USERNAME ="289337_root";
    public static final String PASSWORD = "Tm3x-dCQ7k3mLMf";
    Connection connection = null;
    @Override
    public void establishConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if(connection != null){
                System.out.println("Connexion établié");
            }
            else{
                System.out.println("Connexion non établié");
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void closeConnection() {
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> GetOrdersByCustomer(int id) {
        try {
            //1
            establishConnection();
            //2
            Statement statement = connection.createStatement();
            //3
            ResultSet result = statement.executeQuery("SELECT * FROM TblOrder WHERE customer_id = " + id);
            //4
            List<Order> orders = new ArrayList<Order>();
            while (result.next()){
                Order order = new Order();
                order.setId( result.getInt("id"));
                order.setMaker(result.getString("maker"));
                order.setModel(result.getString("model"));
                order.setCustomerID(result.getInt("customer_id"));
                order.setDateOrder(result.getDate("date_order").toLocalDate());
                order.setQuantity(result.getInt("quantity"));
                orders.add(order);
            }
            //5
            closeConnection();
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> GetOrdersByYear(int year) {
         //ResultSet result = stat
        try {
            //1
            establishConnection();
            //2
            Statement statement = connection.createStatement();
            //3
            ResultSet result = statement.executeQuery("SELECT * FROM TblOrder WHERE date_order LIKE '" + year + "%'"  );

            //4
            List<Order> orders = new ArrayList<Order>();
            while (result.next()){
                Order order = new Order();
                order.setId( result.getInt("id"));
                order.setMaker(result.getString("maker"));
                order.setModel(result.getString("model"));
                order.setCustomerID(result.getInt("customer_id"));
                order.setDateOrder(result.getDate("date_order").toLocalDate());
                order.setQuantity(result.getInt("quantity"));
                orders.add(order);
            }
            //5
            closeConnection();
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int addOrderToCustomer(int id, Order order) {

        try {
            //1. établir une connexion
            establishConnection();

            //2. créer une déclaration
            Statement statement = connection.createStatement();

            //3. exécuter une requête
            int nbLines = statement.executeUpdate("INSERT INTO TblOrder (maker, model, customer_id, date_order, quantity) " +
                    " VALUES ('"+order.getMaker() +"', '"+ order.getModel()+"', "+ id +", '"+ order.getDateOrder()+"', "+ order.getQuantity()+")");

            //5. fermer la connexion
            closeConnection();

            return nbLines;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Car> GetAllCars() {
        try {
            //1. établir une connexion
            establishConnection();

            //2. créer une déclaration
            Statement statement = connection.createStatement();

            //3. exécuter une requête
            ResultSet result = statement.executeQuery("SELECT * FROM TblCar");

            //4. manipuler le résultat
            List<Car> cars = new ArrayList<Car>();
            while(result.next()){
                Car car = new Car();
                car.setMaker(result.getString("maker"));
                car.setModel(result.getString("model"));
                car.setPrice(result.getInt("price"));
                cars.add(car);
            }

            //5. fermer la connexion
            closeConnection();

            return cars;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> GetSortedCars() {
        try {
            //1. établir une connexion
            establishConnection();

            //2. créer une déclaration
            Statement statement = connection.createStatement();

            //3. exécuter une requête
            ResultSet result = statement.executeQuery("SELECT ca.maker, ca.model FROM TblCar ca, TblOrder co WHERE ca.maker = co.maker AND ca.model = co.model GROUP BY ca.maker, ca.model ORDER by SUM(co.quantity) DESC;");

            //4. manipuler le résultat
            List<Car> sorted = new ArrayList<>();
            while(result.next()){
                Car car = new Car();
                car.setMaker(result.getString(1)); //maker
                car.setModel(result.getString(2)); //model
                sorted.add(car);
            }

            //5. fermer la connexion
            closeConnection();

            return sorted;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Integer> GetSortedQuantities() {
        try {
            //1. établir une connexion
            establishConnection();

            //2. créer une déclaration
            Statement statement = connection.createStatement();

            //3. exécuter une requête
            ResultSet result = statement.executeQuery("SELECT SUM(co.quantity) FROM TblCar ca, TblOrder co WHERE ca.maker = co.maker AND ca.model = co.model GROUP BY ca.maker, ca.model ORDER by SUM(co.quantity) DESC;");

            //4. manipuler le résultat
            List<Integer> sorted = new ArrayList<>();
            while(result.next()){
                int quantity = result.getInt(1); // quantity
                sorted.add(quantity);
            }

            //5. fermer la connexion
            closeConnection();

            return sorted;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CarSales> GetSortedCarSales() {
        try {
            //1. établir une connexion
            establishConnection();

            //2. créer une déclaration
            Statement statement = connection.createStatement();

            //3. exécuter une requête
            ResultSet result = statement.executeQuery("SELECT ca.maker, ca.model, SUM(co.quantity) AS total_quantity \n" +
                    "FROM TblCar ca \n" +
                    "JOIN TblOrder co ON ca.maker = co.maker AND ca.model = co.model \n" +
                    "GROUP BY ca.maker, ca.model \n" +
                    "ORDER BY total_quantity DESC;  ");

            //4. manipuler le résultat
            List<CarSales> sorted = new ArrayList<>();
            while(result.next()){
                CarSales car = new CarSales();
                car.setMaker(result.getString("maker")); //maker
                car.setModel(result.getString("model")); //model
                car.setTotalQuantity(result.getInt("total_quantity")); // qty
                sorted.add(car);
            }

            //5. fermer la connexion
            closeConnection();

            return sorted;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

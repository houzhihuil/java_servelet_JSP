package cgodin.models.DAO;

import cgodin.models.entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// DAO : Data access object
public class CustomerDAO implements ICustomerDAO{
    public final String URL = "jdbc:mysql://mysql-philippehou.alwaysdata.net:3306/philippehou_demo_109";
    public final String USERNAME ="289337_root";
    public  final String PASSWORD = "Tm3x-dCQ7k3mLMf";
    Connection connection = null;
    @Override
    public void etablishConnexion() {
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
    public void closeConnexion() {
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> AllCustomers() {
        try {
            //1
            etablishConnexion();
            //2
            Statement statement = connection.createStatement();
            //3
            ResultSet result = statement.executeQuery("SELECT * FROM TblCustomer");
            //4
            List<Customer> customers = new ArrayList<Customer>();
            while (result.next()){
                Customer customer = new Customer();
                customer.setId( result.getInt("id"));
                customer.setFullName(result.getString("full_name"));
                customer.setPhoneNumber(result.getString("phone_number"));
                customers.add(customer);
            }
            //5
            closeConnexion();
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int Add(Customer customer) {
        try {
            //1. établir une connexion
            etablishConnexion();

            //2. créer une déclaration
            Statement statement = connection.createStatement();

            //3. exécuter une requête
            String fullName = customer.getFullName();
            String phoneNumber = customer.getPhoneNumber();
            int nbLines = statement.executeUpdate("INSERT INTO TblCustomer (full_name, phone_number) VALUES ( '" + fullName+ "', '" + phoneNumber+ "' ) ");


            //5. fermer la connexion
            closeConnexion();

            return nbLines;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int edit(int id, Customer customer) {
        try {
            //1. établir une connexion
            etablishConnexion();

            //2. créer une déclaration
            Statement statement = connection.createStatement();

            //3. exécuter une requête
            String fullName = customer.getFullName();
            String phoneNumber = customer.getPhoneNumber();
            int nbLines = statement.executeUpdate("UPDATE TblCustomer SET full_name = '" + fullName+ "', phone_number = '" + phoneNumber+ "' WHERE id = " + id);


            //5. fermer la connexion
            closeConnexion();

            return nbLines;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int remove(int id) {
        try {
            //1. établir une connexion
            etablishConnexion();

            //2. créer une déclaration
            Statement statement = connection.createStatement();

            //3. exécuter une requête

            int nbLines = statement.executeUpdate("DELETE FROM TblCustomer  WHERE id = " + id);


            //5. fermer la connexion
            closeConnexion();

            return nbLines;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

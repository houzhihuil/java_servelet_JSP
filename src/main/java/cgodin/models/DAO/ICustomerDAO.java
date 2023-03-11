package cgodin.models.DAO;

import cgodin.models.entities.Customer;

import java.util.List;

public interface ICustomerDAO {
    void etablishConnexion();
    void closeConnexion();
    List<Customer> AllCustomers();
    int Add(Customer customer);
    int edit(int id, Customer customer);
    int remove(int id);
}

package cgodin.models.entities;

import java.time.LocalDate;

public class Order {
    private int id;
    private String maker;
    private String model;
    private int customerID;
    private LocalDate dateOrder;
    private int quantity;

    public Order() {
    }

    public Order(int id, String maker, String model, int customerID, LocalDate dateOrder, int quantity) {
        this.id = id;
        this.maker = maker;
        this.model = model;
        this.customerID = customerID;
        this.dateOrder = dateOrder;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                ", customerID=" + customerID +
                ", dateOrder=" + dateOrder +
                ", quantity=" + quantity +
                '}';
    }
}

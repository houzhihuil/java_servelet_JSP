package cgodin.models.entities;

// une entité: classe Java qui réprensente dans l'application la table SQL da la BD.
public class Customer {
    private int id;
    private String fullName;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String fullName, String phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }

    public Customer(int id, String fullName, String phonNumber) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phonNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

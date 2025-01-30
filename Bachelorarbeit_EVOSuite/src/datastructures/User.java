package datastructures;

import services.LanguageService;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Account account;
    private final List<Order> orders = new ArrayList<>();

    public User(int id, String firstName, String lastName, String email, String phoneNumber, Account account) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public List<Order> getOrders() { return orders; }
    public void addOrder(Order order) { this.orders.add(order); }

    @Override
    public String toString() {
        return "User{" +
                LanguageService.getValue("UserID") + " " + id + ", " +
                LanguageService.getValue("UserFirstName") + " " + firstName + ", " +
                LanguageService.getValue("UserLastName") + " " + lastName + ", " +
                LanguageService.getValue("UserEmail") + " " + email + ", " +
                LanguageService.getValue("UserPhoneNumber") + " " + phoneNumber + ", " +
                LanguageService.getValue("UserOrders") + " " + orders +
                '}';
    }
}
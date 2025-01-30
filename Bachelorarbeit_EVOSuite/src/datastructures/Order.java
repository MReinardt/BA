package datastructures;

import services.LanguageService;

public class Order {

    private int orderId;
    private String status;
    private int price;

    public Order(int orderId, int price) {
        this.orderId = orderId;
        this.status = "CREATED";
        this.price = price;
    }

    public int getOrderId() { return orderId; }

    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() { return price; }

    @Override
    public String toString() {
        return "Order{" +
                LanguageService.getValue("OrderID") + " " + orderId + ", " +
                LanguageService.getValue("OrderStatus") + " " + status + ", " +
                LanguageService.getValue("OrderPrice") + " " + price +
                '}';
    }
}
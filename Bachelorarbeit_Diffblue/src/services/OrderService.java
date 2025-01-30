package services;

import exceptions.InsufficientFundsException;
import exceptions.InvalidOrderException;
import exceptions.OrderNotFoundException;
import datastructures.Order;
import datastructures.User;

public class OrderService {

    public void createOrder(User user, int orderPrice) throws InvalidOrderException {
        validateUser(user);
        if (orderPrice < 1) {
            throw new InvalidOrderException("OrderPrice must be greater than 1.");
        }
        Order order = new Order(user.getOrders().size(), orderPrice);
        user.addOrder(order);
    }

    public void payOrder(User user, int orderID) throws InvalidOrderException, OrderNotFoundException {
        validateUserBalance(user, findOrder(user, orderID).getPrice());
        user.getAccount().setBalance(user.getAccount().getBalance() - findOrder(user, orderID).getPrice());
        updateOrderStatusIfValid(user, orderID, "CREATED", "PAID", "pay");
    }

    public void shipOrder(User user, int orderID) throws InvalidOrderException, OrderNotFoundException {
        updateOrderStatusIfValid(user, orderID, "PAID", "PAID", "ship");
    }

    public void deliverOrder(User user, int orderID) throws InvalidOrderException, OrderNotFoundException {
        updateOrderStatusIfValid(user, orderID, "SHIPPED", "DELIVERED", "deliver");
    }

    private void updateOrderStatusIfValid(User user, int orderID, String currentState, String newState, String action)
            throws InvalidOrderException, OrderNotFoundException {
        if (getOrderState(user, orderID).equals(currentState)) {
            updateOrderStatus(user, orderID, newState);
            System.out.println("The order has been " + action + "ed.");
        } else {
            throw new InvalidOrderException("OrderState is invalid. Can't " + action + " order with state " + getOrderState(user, orderID));
        }
    }

    private void updateOrderStatus(User user, int orderID, String status) throws OrderNotFoundException {
        validateUser(user);
        Order order = findOrder(user, orderID);
        order.setStatus(status);
    }

    private String getOrderState(User user, int orderID) throws OrderNotFoundException {
        validateUser(user);
        Order order = findOrder(user, orderID);
        return order.getStatus();
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new NullPointerException("User cannot be null.");
        }
    }

    private void validateUserBalance(User user, int orderPrice) {
        if (user.getAccount().getBalance() < orderPrice) {
            throw new InsufficientFundsException("User balance is insufficient.");
        }
    }

    private Order findOrder(User user, int orderID) throws OrderNotFoundException {
        return user.getOrders().stream()
                .filter(o -> o.getOrderId() == orderID)
                .findFirst()
                .orElseThrow(() -> new OrderNotFoundException("Order with ID " + orderID + " not found."));
    }
}
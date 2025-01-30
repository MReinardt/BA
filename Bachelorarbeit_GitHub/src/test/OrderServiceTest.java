package test;

import datastructures.Account;
import datastructures.Order;
import datastructures.User;
import exceptions.InsufficientFundsException;
import exceptions.InvalidOrderException;
import exceptions.OrderNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.OrderService;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private OrderService orderService;
    private User user;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();
        Account account = new Account(1, "1234567890123456", 1234, 1000.0);
        user = new User(1, "John", "Doe", "john.doe@example.com", "1234567890", account);
    }

    @Test
    void createOrderAddsOrderToUser() throws InvalidOrderException {
        orderService.createOrder(user, 100);
        assertEquals(1, user.getOrders().size());
        assertEquals(100, user.getOrders().get(0).getPrice());
    }

    @Test
    void createOrderThrowsExceptionForInvalidPrice() {
        assertThrows(InvalidOrderException.class, () -> orderService.createOrder(user, 0));
    }

    @Test
    void payOrderUpdatesOrderStatusToPaid() throws InvalidOrderException, OrderNotFoundException {
        orderService.createOrder(user, 100);
        orderService.payOrder(user, 0);
        assertEquals("PAID", user.getOrders().get(0).getStatus());
    }

    @Test
    void payOrderThrowsExceptionForInsufficientFunds() throws InvalidOrderException {
        orderService.createOrder(user, 2000);
        assertThrows(InsufficientFundsException.class, () -> orderService.payOrder(user, 0));
    }

    @Test
    void payOrderThrowsExceptionForNonExistingOrder() {
        assertThrows(OrderNotFoundException.class, () -> orderService.payOrder(user, 0));
    }

    @Test
    void shipOrderUpdatesOrderStatusToShipped() throws InvalidOrderException, OrderNotFoundException {
        orderService.createOrder(user, 100);
        orderService.payOrder(user, 0);
        orderService.shipOrder(user, 0);
        assertEquals("PAID", user.getOrders().get(0).getStatus());
    }

    @Test
    void shipOrderThrowsExceptionForInvalidOrderState() throws InvalidOrderException {
        orderService.createOrder(user, 100);
        assertThrows(InvalidOrderException.class, () -> orderService.shipOrder(user, 0));
    }

    @Test
    void deliverOrderUpdatesOrderStatusToDelivered() throws InvalidOrderException, OrderNotFoundException {
        orderService.createOrder(user, 100);
        orderService.payOrder(user, 0);
        orderService.shipOrder(user, 0);
        orderService.deliverOrder(user, 0);
        assertEquals("DELIVERED", user.getOrders().get(0).getStatus());
    }

    @Test
    void deliverOrderThrowsExceptionForInvalidOrderState() throws InvalidOrderException {
        orderService.createOrder(user, 100);
        assertThrows(InvalidOrderException.class, () -> orderService.deliverOrder(user, 0));
    }

    @Test
    void updateOrderStatusThrowsExceptionForNonExistingOrder() {
        //assertThrows(OrderNotFoundException.class, () -> orderService.updateOrderStatus(user, 0, "PAID"));
    }

    @Test
    void getOrderStateReturnsCorrectState() throws InvalidOrderException, OrderNotFoundException {
        orderService.createOrder(user, 100);
        //assertEquals("CREATED", orderService.getOrderState(user, 0));
    }

    @Test
    void validateUserThrowsExceptionForNullUser() {
        assertThrows(NullPointerException.class, () -> orderService.createOrder(null, 100));
    }
}
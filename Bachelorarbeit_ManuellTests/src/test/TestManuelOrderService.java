package test;

import datastructures.Account;
import datastructures.User;
import exceptions.InsufficientFundsException;
import exceptions.InvalidOrderException;
import exceptions.OrderNotFoundException;
import services.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test: OrderService")
public class TestManuelOrderService {

    private User user_1;
    private OrderService orderService;

    @BeforeEach
    void SetUp() {
        orderService = new OrderService();
        Account accountGerman = new Account(1, "DE12345678901234567890", 1234, 10000);
        user_1 = new User(1, "Max", "Mustermann", "maxmustermann@gmail.com", "+491234567890", accountGerman);
    }

    @Test
    @DisplayName("Test OrderService >> check Exception Handling wrong orderPrice")
    void test_OrderServiceExceptionHandling() {
        assertThrowsExactly(InvalidOrderException.class, () -> orderService.createOrder(user_1, -100));
    }

    @Test
    @DisplayName("Test OrderService >> check Exception Handling wrong orderPrice")
    void test_OrderServiceExceptionHandling_1() throws InvalidOrderException {
        orderService.createOrder(user_1, 100000000);
        assertEquals(1, user_1.getOrders().size());
        assertThrowsExactly(InsufficientFundsException.class, () -> orderService.payOrder(user_1, 0));

    }

    @Test
    @DisplayName("Test OrderService >> check Exception Handling paying order with wrong orderID")
    void test_OrderServiceExceptionHandling_2() {
        assertThrowsExactly(OrderNotFoundException.class, () -> orderService.payOrder(user_1, 0));
    }

    @Test
    @DisplayName("Test OrderService >> check Exception Handling ")
    void test_OrderServiceExceptionHandling_3() {
        assertThrowsExactly(NullPointerException.class, () -> orderService.createOrder(null, 1));
    }

    @Test
    @DisplayName("Test OrderService >> check paying order")
    void test_OrderServicePayOrder() throws InvalidOrderException, OrderNotFoundException {
        orderService.createOrder(user_1, 100);
        assertEquals(1, user_1.getOrders().size());
        orderService.payOrder(user_1, 0);
        assertEquals("PAID", user_1.getOrders().get(0).getStatus());
    }

    @Test
    @DisplayName("Test OrderService >> check shipping order")
    void test_OrderServiceShipOrder() throws InvalidOrderException, OrderNotFoundException {
        orderService.createOrder(user_1, 100);
        assertEquals(1, user_1.getOrders().size());
        orderService.payOrder(user_1, 0);
        orderService.shipOrder(user_1, 0);
        //Expected: Error because of wrong code
        assertEquals("SHIPPED", user_1.getOrders().get(0).getStatus());
    }

    @Test
    @DisplayName("Test OrderService >> check delivering order status")
    void test_OrderServiceDeliverOrder() throws InvalidOrderException, OrderNotFoundException {
        orderService.createOrder(user_1, 100);
        assertEquals(1, user_1.getOrders().size());
        orderService.payOrder(user_1, 0);
        orderService.shipOrder(user_1, 0);
        //Expected: Error because of wrong code
        orderService.deliverOrder(user_1, 0);
        assertEquals("DELIVERED", user_1.getOrders().get(0).getStatus());
    }
}

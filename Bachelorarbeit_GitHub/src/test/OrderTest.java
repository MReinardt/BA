package test;

import datastructures.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order(1, 100);
    }

    @Test
    void getOrderIdReturnsCorrectId() {
        assertEquals(1, order.getOrderId());
    }

    @Test
    void getStatusReturnsCorrectStatus() {
        assertEquals("CREATED", order.getStatus());
    }

    @Test
    void setStatusUpdatesStatusCorrectly() {
        order.setStatus("SHIPPED");
        assertEquals("SHIPPED", order.getStatus());
    }

    @Test
    void getPriceReturnsCorrectPrice() {
        assertEquals(100, order.getPrice());
    }

    @Test
    void toStringReturnsCorrectString() {
        String expected = "Order{OrderID 1, OrderStatus CREATED, OrderPrice 100}";
        assertEquals(expected, order.toString());
    }

    @Test
    void setStatusToNullThrowsException() {
        assertThrows(NullPointerException.class, () -> order.setStatus(null));
    }

    @Test
    void setPrice() {
        //order.setPrice(200);
        assertEquals(200, order.getPrice());
    }

    @Test
    void setStatusToEmptyStringUpdatesStatus() {
        order.setStatus("");
        assertEquals("", order.getStatus());
    }
}
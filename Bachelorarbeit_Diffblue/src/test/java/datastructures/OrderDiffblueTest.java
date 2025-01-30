package test.java.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;


import datastructures.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderDiffblueTest {
    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Order#Order(int, int)}
     *   <li>{@link Order#setStatus(String)}
     *   <li>{@link Order#getOrderId()}
     *   <li>{@link Order#getPrice()}
     *   <li>{@link Order#getStatus()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    void testGettersAndSetters() {
        // Arrange and Act
        Order actualOrder = new Order(1, 1);
        actualOrder.setStatus("Status");
        int actualOrderId = actualOrder.getOrderId();
        int actualPrice = actualOrder.getPrice();

        // Assert that nothing has changed
        assertEquals("Status", actualOrder.getStatus());
        assertEquals(1, actualOrderId);
        assertEquals(1, actualPrice);
    }
}

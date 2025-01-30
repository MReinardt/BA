package test.java.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;


import datastructures.Account;
import datastructures.Order;
import datastructures.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserDiffblueTest {
    /**
     * Test {@link User#addOrder(Order)}.
     * <p>
     * Method under test: {@link User#addOrder(Order)}
     */
    @Test
    @DisplayName("Test addOrder(Order)")
    void testAddOrder() {
        // Arrange
        User user = new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d));
        Order order = new Order(1, 1);

        // Act
        user.addOrder(order);

        // Assert
        List<Order> orders = user.getOrders();
        assertEquals(1, orders.size());
        assertSame(order, orders.get(0));
    }

    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link User#User(int, String, String, String, String, Account)}
     *   <li>{@link User#setAccount(Account)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setFirstName(String)}
     *   <li>{@link User#setId(int)}
     *   <li>{@link User#setLastName(String)}
     *   <li>{@link User#setPhoneNumber(String)}
     *   <li>{@link User#toString()}
     *   <li>{@link User#getAccount()}
     *   <li>{@link User#getEmail()}
     *   <li>{@link User#getFirstName()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getLastName()}
     *   <li>{@link User#getOrders()}
     *   <li>{@link User#getPhoneNumber()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    void testGettersAndSetters() {
        // Arrange and Act
        User actualUser = new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d));
        Account account = new Account(1, "42", 10, 10.0d);

        actualUser.setAccount(account);
        actualUser.setEmail("jane.doe@example.org");
        actualUser.setFirstName("Jane");
        actualUser.setId(1);
        actualUser.setLastName("Doe");
        actualUser.setPhoneNumber("6625550144");
        String actualToStringResult = actualUser.toString();
        Account actualAccount = actualUser.getAccount();
        String actualEmail = actualUser.getEmail();
        String actualFirstName = actualUser.getFirstName();
        int actualId = actualUser.getId();
        String actualLastName = actualUser.getLastName();
        List<Order> actualOrders = actualUser.getOrders();

        // Assert that nothing has changed
        assertEquals("6625550144", actualUser.getPhoneNumber());
        assertEquals("Doe", actualLastName);
        assertEquals("Jane", actualFirstName);
        assertEquals("User{Benutzer ID: 1, Vorname: Jane, Nachname: Doe, E-Mail: jane.doe@example.org, Telefonnummer:"
                + " 6625550144, Bestellungen: []}", actualToStringResult);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals(1, actualId);
        assertTrue(actualOrders.isEmpty());
        assertSame(account, actualAccount);
    }
}

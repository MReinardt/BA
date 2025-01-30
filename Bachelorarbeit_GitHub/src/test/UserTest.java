package test;

import datastructures.Account;
import datastructures.Order;
import datastructures.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(1, "1234567890123456", 1234, 1000.0);
        user = new User(1, "John", "Doe", "john.doe@example.com", "1234567890", account);
    }

    @Test
    void getIdReturnsCorrectId() {
        assertEquals(1, user.getId());
    }

    @Test
    void getFirstNameReturnsCorrectFirstName() {
        assertEquals("John", user.getFirstName());
    }

    @Test
    void getLastNameReturnsCorrectLastName() {
        assertEquals("Doe", user.getLastName());
    }

    @Test
    void getEmailReturnsCorrectEmail() {
        assertEquals("john.doe@example.com", user.getEmail());
    }

    @Test
    void getPhoneNumberReturnsCorrectPhoneNumber() {
        assertEquals("1234567890", user.getPhoneNumber());
    }

    @Test
    void getAccountReturnsCorrectAccount() {
        assertEquals(account, user.getAccount());
    }

    @Test
    void addOrderAddsOrderToList() {
        Order order = new Order(1, 100);
        user.addOrder(order);
        assertEquals(1, user.getOrders().size());
        assertEquals(order, user.getOrders().get(0));
    }

    @Test
    void toStringReturnsCorrectString() {
        String expected = "User{UserID 1, UserFirstName John, UserLastName Doe, UserEmail john.doe@example.com, UserPhoneNumber 1234567890, UserOrders []}";
        assertEquals(expected, user.toString());
    }

    @Test
    void setIdUpdatesIdCorrectly() {
        user.setId(2);
        assertEquals(2, user.getId());
    }

    @Test
    void setFirstNameUpdatesFirstNameCorrectly() {
        user.setFirstName("Jane");
        assertEquals("Jane", user.getFirstName());
    }

    @Test
    void setLastNameUpdatesLastNameCorrectly() {
        user.setLastName("Smith");
        assertEquals("Smith", user.getLastName());
    }

    @Test
    void setEmailUpdatesEmailCorrectly() {
        user.setEmail("jane.smith@example.com");
        assertEquals("jane.smith@example.com", user.getEmail());
    }

    @Test
    void setPhoneNumberUpdatesPhoneNumberCorrectly() {
        user.setPhoneNumber("0987654321");
        assertEquals("0987654321", user.getPhoneNumber());
    }

    @Test
    void setAccountUpdatesAccountCorrectly() {
        Account newAccount = new Account(2, "6543210987654321", 4321, 2000.0);
        user.setAccount(newAccount);
        assertEquals(newAccount, user.getAccount());
    }
}
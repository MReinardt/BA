package test;

import datastructures.Account;
import datastructures.Order;
import datastructures.User;
import services.LanguageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test: User")
public class TestManuelUser {

    private User user;
    private Account account;
    private Order order;

    @BeforeEach
    public void setUp() {
        Locale.setDefault(Locale.forLanguageTag("en-US"));
        account = new Account(1, "test", 1234, 10000);
        user = new User(1, "John", "Doe", "johndoe@example.com", "+491234567890",account);
        order = new Order(1, 100);
    }

    @Test
    @DisplayName("Test User >> constructor and getters")
    public void testConstructorAndGetters() {
        assertEquals(1, user.getId());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("johndoe@example.com", user.getEmail());
        assertEquals("+491234567890", user.getPhoneNumber());
        assertEquals(account, user.getAccount());
    }

    @Test
    @DisplayName("Test User >> setters")
    public void testSetters() {
        Account account1 = new Account(2, "test1", 12345, 100000);
        user.setId(2);
        user.setFirstName("Jane");
        user.setLastName("Smith");
        user.setEmail("jane.smith@example.com");
        user.setPhoneNumber("+491234567891");
        user.addOrder(order);
        user.setAccount(account1);

        assertEquals(2, user.getId());
        assertEquals("Jane", user.getFirstName());
        assertEquals("Smith", user.getLastName());
        assertEquals("jane.smith@example.com", user.getEmail());
        assertEquals("+491234567891", user.getPhoneNumber());
        assertEquals(order, user.getOrders().get(0));
        assertEquals(account1, user.getAccount());
    }

    @Test
    @DisplayName("Test User >> toString() for englisch")
    void testToStringEnglisch() {
        LanguageService.setLanguage("en", "US");
        String expected = "User{User ID: 1, First Name: John, Last Name: Doe, Email: johndoe@example.com, Phone Number: +491234567890, Orders: []}";
        assertEquals(expected, user.toString());
    }

    @Test
    @DisplayName("Test User >> toString() for german")
    void testToStringGerman() {
        LanguageService.setLanguage("de", "DE");
        String expected = "User{Benutzer ID: 1, Vorname: John, Nachname: Doe, E-Mail: johndoe@example.com, Telefonnummer: +491234567890, Bestellungen: []}";
        assertEquals(expected, user.toString());
    }

    @Test
    @DisplayName("Test User >> toString() for french")
    void testToStringFrench() {
        LanguageService.setLanguage("fr", "FR");
        String expected = "User{ID utilisateur: 1, Prénom: John, Nom: Doe, E-mail: johndoe@example.com, Numéro de téléphone: +491234567890, Commandes: []}";
        assertEquals(expected, user.toString());
    }
}

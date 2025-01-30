package test;

import datastructures.Order;
import services.LanguageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test: Order")
public class TestManuelOrder {
    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order(1, 1000);
    }

    @Test
    @DisplayName("Test Order >> constructor and getters")
    public void testConstructorAndGetters() {
        assertEquals(1, order.getOrderId());
        assertEquals("CREATED", order.getStatus());
        assertEquals(1000, order.getPrice());
    }

    @Test
    @DisplayName("Test Order >> setters")
    public void testSetters() {
        order.setStatus("PAID");
        assertEquals("PAID", order.getStatus());
    }

    @Test
    @DisplayName("Test Order >> toString for englisch")
    public void testToStringEnglisch() {
        Locale.setDefault(Locale.forLanguageTag("en-US"));
        LanguageService.setLanguage("en", "US");
        String expectedEnglisch = "Order{Order ID: 1, Status: CREATED, Price: 1000}";
        assertEquals(expectedEnglisch, order.toString());
    }

    @Test
    @DisplayName("Test Order >> toString for german")
    public void testToStringGerman() {
        Locale.setDefault(Locale.forLanguageTag("de-DE"));
        LanguageService.setLanguage("de", "DE");
        String expectedGerman = "Order{Bestell ID: 1, Status: CREATED, Preis: 1000}";
        assertEquals(expectedGerman, order.toString());
    }

    @Test
    @DisplayName("Test Order >> toString for french")
    public void testToStringFrench() {
        Locale.setDefault(Locale.forLanguageTag("fr-FR"));
        LanguageService.setLanguage("fr", "FR");
        String expectedFrench = "Order{ID de commande: 1, Statut: CREATED, Prix: 1000}";
        assertEquals(expectedFrench, order.toString());
    }
}

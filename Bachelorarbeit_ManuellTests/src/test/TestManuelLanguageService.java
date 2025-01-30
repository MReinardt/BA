package test;

import services.LanguageService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Test: LanguageService")
public class TestManuelLanguageService {

    @Test
    @DisplayName("Test Localisation >> check if default language is english")
    void testDefaultLanguage_en_US() {
        Locale.setDefault(Locale.forLanguageTag("en-US"));
        LanguageService.setLanguage(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());

        assertEquals("en", LanguageService.getCurrentLanguage());
        assertEquals("US", LanguageService.getCurrentCountry());

        assertEquals("Welcome to the application!", LanguageService.getValue("welcome"));
        assertEquals("Goodbye!", LanguageService.getValue("farewell"));
    }

    @Test
    @DisplayName("Test Localisation >> check if default language is german")
    void testDefaultLanguage_de_DE() {
        Locale.setDefault(Locale.forLanguageTag("de-DE"));
        LanguageService.setLanguage(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());

        assertEquals("de", LanguageService.getCurrentLanguage());
        assertEquals("DE", LanguageService.getCurrentCountry());

        assertEquals("Willkommen in der Anwendung!", LanguageService.getValue("welcome"));
        assertEquals("Auf Wiedersehen!", LanguageService.getValue("farewell"));
    }

    @Test
    @DisplayName("Test Localisation >> check if default language is french")
    void testDefaultLanguage_fr_FR() {
        Locale.setDefault(Locale.forLanguageTag("fr-FR"));
        LanguageService.setLanguage(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());

        assertEquals("fr", LanguageService.getCurrentLanguage());
        assertEquals("FR", LanguageService.getCurrentCountry());

        assertEquals("Bienvenue dans l'application!", LanguageService.getValue("welcome"));
        assertEquals("Au revoir!", LanguageService.getValue("farewell"));
    }

    @Test
    @DisplayName("Test Localisation >> check if default language is spanic")
    void testDefaultLanguage_es_ES() {
        Locale.setDefault(Locale.forLanguageTag("es-ES"));
        LanguageService.setLanguage(Locale.getDefault().getLanguage(), Locale.getDefault().getCountry());

        assertEquals("es", LanguageService.getCurrentLanguage());
        assertEquals("ES", LanguageService.getCurrentCountry());

        assertEquals("Hello, {0}!", LanguageService.getValue("greeting"));
        assertEquals("Goodbye!", LanguageService.getValue("farewell"));
    }

    @Test
    @DisplayName("Test Localisation >> change language to german")
    void testChangeLanguageToGerman() {
        LanguageService.setLanguage("de", "DE");

        assertEquals("de", LanguageService.getCurrentLanguage());
        assertEquals("DE", LanguageService.getCurrentCountry());

        assertEquals("Willkommen in der Anwendung!", LanguageService.getValue("welcome"));
        assertEquals("Auf Wiedersehen!", LanguageService.getValue("farewell"));
    }

    @Test
    @DisplayName("Test Localisation >> change language to french")
    void testChangeLanguageToFrench() {
        LanguageService.setLanguage("fr", "FR");

        assertEquals("fr", LanguageService.getCurrentLanguage());
        assertEquals("FR", LanguageService.getCurrentCountry());

        assertEquals("Bienvenue dans l'application!", LanguageService.getValue("welcome"));
        assertEquals("Au revoir!", LanguageService.getValue("farewell"));
    }

    @Test
    @DisplayName("Test Localisation >> change to non existing language")
    void testChangeToNonExistingLanguage() {
        Locale.setDefault(Locale.forLanguageTag("en-US"));
        LanguageService.setLanguage("es", "ES");

        assertEquals("es", LanguageService.getCurrentLanguage());
        assertEquals("ES", LanguageService.getCurrentCountry());

        assertEquals("Hello, {0}!", LanguageService.getValue("greeting"));
        assertEquals("Goodbye!", LanguageService.getValue("farewell"));
    }

    @Test
    @DisplayName("Test Localisation >> missing key")
    void testMissingKey() {
        String missingKeyMessage = LanguageService.getValue("nonexistentKey");
        assertTrue(missingKeyMessage.startsWith("Key 'nonexistentKey' not found"));
    }

    @Test
    @DisplayName("Test Localisation >> missing key")
    void testEmptyKey() {
        assertTrue(LanguageService.getValue("empty").isEmpty());
    }
}
package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.LanguageService;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class LanguageServiceTest {

    @BeforeEach
    void setUp() {
        LanguageService.setLanguage("en", "US");
    }

    @Test
    void setLanguageUpdatesLocaleCorrectly() {
        LanguageService.setLanguage("fr", "FR");
        assertEquals("fr", LanguageService.getCurrentLanguage());
        assertEquals("FR", LanguageService.getCurrentCountry());
    }

    @Test
    void getValueReturnsCorrectValueForExistingKey() {
        assertEquals("Hello", LanguageService.getValue("greeting"));
    }

    @Test
    void getValueReturnsErrorMessageForNonExistingKey() {
        String expectedMessage = "Key 'non_existing_key' not found in language: en-US";
        assertEquals(expectedMessage, LanguageService.getValue("non_existing_key"));
    }

    @Test
    void getCurrentLanguageReturnsCorrectLanguage() {
        assertEquals("en", LanguageService.getCurrentLanguage());
    }

    @Test
    void getCurrentCountryReturnsCorrectCountry() {
        assertEquals("US", LanguageService.getCurrentCountry());
    }

    @Test
    void setLanguageWithInvalidLocaleDefaultsToEnglish() {
        LanguageService.setLanguage("invalid", "INVALID");
        assertEquals("en", LanguageService.getCurrentLanguage());
        assertEquals("US", LanguageService.getCurrentCountry());
    }
}
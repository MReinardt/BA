package services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LanguageServiceDiffblueTest {
    /**
     * Test {@link LanguageService#setLanguage(String, String)}.
     * <p>
     * Method under test: {@link LanguageService#setLanguage(String, String)}
     */
    @Test
    @DisplayName("Test setLanguage(String, String)")
    void testSetLanguage() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange and Act
        LanguageService.setLanguage("en", "GB");
    }

    /**
     * Test {@link LanguageService#getValue(String)}.
     * <p>
     * Method under test: {@link LanguageService#getValue(String)}
     */
    @Test
    @DisplayName("Test getValue(String)")
    void testGetValue() {
        // Arrange, Act and Assert
        assertEquals("Key 'Key' not found in language: de-DE", LanguageService.getValue("Key"));
    }

    /**
     * Test {@link LanguageService#getCurrentLanguage()}.
     * <p>
     * Method under test: {@link LanguageService#getCurrentLanguage()}
     */
    @Test
    @DisplayName("Test getCurrentLanguage()")
    void testGetCurrentLanguage() {
        // Arrange, Act and Assert
        assertEquals("de", LanguageService.getCurrentLanguage());
    }

    /**
     * Test {@link LanguageService#getCurrentCountry()}.
     * <p>
     * Method under test: {@link LanguageService#getCurrentCountry()}
     */
    @Test
    @DisplayName("Test getCurrentCountry()")
    void testGetCurrentCountry() {
        // Arrange, Act and Assert
        assertEquals("DE", LanguageService.getCurrentCountry());
    }
}

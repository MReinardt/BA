package test;

import services.ValidationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test: ValidationService")
public class TestManuelValidationService {


    @Test
    @DisplayName("Test ValidationService >> test if wrong email is not valid")
    void test_ValidationServiceWrongEMail() {
        assertFalse(ValidationService.isEmailValid("33333"));
        assertFalse(ValidationService.isEmailValid("test@"));
        assertFalse(ValidationService.isEmailValid("test@.com"));
        assertFalse(ValidationService.isEmailValid("test@com"));
        assertFalse(ValidationService.isEmailValid("test.com"));
    }

    @Test
    @DisplayName("Test ValidationService >> test if right email is valid")
    void test_ValidationServiceRightEMail() {
        assertTrue(ValidationService.isEmailValid("maxmustermann@gmail.com"));
        assertTrue(ValidationService.isEmailValid("max-mustermann@gmail.com"));
        assertTrue(ValidationService.isEmailValid("max.mustermann@gmail.com"));
        assertTrue(ValidationService.isEmailValid("max35.mustermann@gmail.com"));
    }

    @Test
    @DisplayName("Test ValidationService >> test if wrong phone number is not valid")
    void test_ValidationServiceWrongPhoneNumber() {
        assertFalse(ValidationService.isPhoneNumberValid("0123-456789"));//Sonderzeichen
        assertFalse(ValidationService.isPhoneNumberValid("fads2345678901"));//Buchstaben
        assertFalse(ValidationService.isPhoneNumberValid("+502345678956"));//falscher Ländercode
        assertFalse(ValidationService.isPhoneNumberValid("+49176 344333322"));//Leerzeichen
        assertFalse(ValidationService.isPhoneNumberValid("030/2345678956"));//Sonderzeichen
    }

    @Test
    @DisplayName("Test ValidationService >> test if right phone number is valid")
    void test_ValidationServiceRightPhoneNumber() {
        assertTrue(ValidationService.isPhoneNumberValid("0301234567"));//Festnetznummer
        assertTrue(ValidationService.isPhoneNumberValid("015112345678"));//Handynummer
        assertTrue(ValidationService.isPhoneNumberValid("+49301234567"));//Internationale Festnetznummer
        assertTrue(ValidationService.isPhoneNumberValid("004915112344"));//Internationale Handynummer
    }

    @Test
    @DisplayName("Test ValidationService >> test if wrong IBAN is not valid")
    void test_ValidationServiceWrongIBAN() {
        assertFalse(ValidationService.isGermanIbanValid("DE123456789012345678"));//zu kurz
        assertFalse(ValidationService.isGermanIbanValid("DE1234567890123456789013312312"));//zu lang
        assertFalse(ValidationService.isGermanIbanValid("DE1234567890123456789a"));//Buchstabe
        assertFalse(ValidationService.isGermanIbanValid("DE123456789012-4567893"));//Sonderzeichen
    }

    @Test
    @DisplayName("Test ValidationService >> test if right IBAN is valid")
    void test_ValidationServiceRightIBAN() {
        assertTrue(ValidationService.isGermanIbanValid("DE12345678901234567890"));
        assertTrue(ValidationService.isGermanIbanValid("DE12345678901234567891"));
        assertTrue(ValidationService.isGermanIbanValid("DE12345678901234567892"));
    }
}
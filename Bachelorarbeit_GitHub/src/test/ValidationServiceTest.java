package test;

import org.junit.jupiter.api.Test;
import services.ValidationService;

import static org.junit.jupiter.api.Assertions.*;

class ValidationServiceTest {

    @Test
    void isEmailValidReturnsTrueForValidEmail() {
        assertTrue(ValidationService.isEmailValid("test@example.com"));
    }

    @Test
    void isEmailValidReturnsFalseForInvalidEmail() {
        assertFalse(ValidationService.isEmailValid("invalid-email"));
    }

    @Test
    void isPhoneNumberValidReturnsTrueForValidPhoneNumber() {
        assertTrue(ValidationService.isPhoneNumberValid("+491234567890"));
    }

    @Test
    void isPhoneNumberValidReturnsFalseForInvalidPhoneNumber() {
        assertFalse(ValidationService.isPhoneNumberValid("12345"));
    }

    @Test
    void isGermanIbanValidReturnsTrueForValidIban() {
        assertTrue(ValidationService.isGermanIbanValid("DE89370400440532013000"));
    }

    @Test
    void isGermanIbanValidReturnsFalseForInvalidIban() {
        assertFalse(ValidationService.isGermanIbanValid("DE123"));
    }
}
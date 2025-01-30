package services;

public class ValidationService {

    public static boolean isEmailValid(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    public static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.matches("^(\\+49|0049|0)?[1-9]\\d{1,4}\\d{1,12}$");
    }

    public static boolean isGermanIbanValid(String iban) {
        return iban.matches("^DE\\d{20}$");
    }
}
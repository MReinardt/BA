package services;

import datastructures.Account;
import datastructures.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestDataGenerator {
    private final String[] firstNames = { "Max", "Sophie", "Lukas", "Anna", "Paul", "Laura", "Jonas", "Emma", "Leon", "Mia" };
    private final String[] lastNames = { "Müller", "Schmidt", "Schneider", "Fischer", "Weber", "Meyer", "Wagner", "Becker", "Hofmann", "Schäfer" };

    private static final Random random = new Random();

    public User generateRandomUser(int id) {
        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        String email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@example.com";
        String phoneNumber = "+49" + (random.nextInt(900000000) + 100000000);
        Account account = new Account(id, generateGermanIban(), random.nextInt(9000) + 1000, generateRandomDoubleInRange(1000, 10000));
        return new User(id, firstName, lastName, email, phoneNumber, account);
    }

    public List<User> generateRandomUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            users.add(generateRandomUser(i));
        }
        return users;
    }

    private double generateRandomDoubleInRange(double min, double max) {
        return Math.round((min + (random.nextDouble() * (max - min))) * 100.0) / 100.0;
    }

    private String generateGermanIban() {
        String countryCode = "DE";
        String bankCode = String.format("%08d", random.nextInt(100000000));
        String accountNumber = String.format("%010d", random.nextInt(1000000000));
        String bban = bankCode + accountNumber;
        String tempIban = "131400" + bban;
        int checkDigits = 98 - mod97(tempIban);
        return countryCode + String.format("%02d", checkDigits) + bban;
    }

    private int mod97(String input) {
        StringBuilder digits = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                digits.append(ch);
            } else {
                digits.append((int) ch - 55);
            }
        }
        int result = 0;
        for (int i = 0; i < digits.length(); i++) {
            result = (result * 10 + (digits.charAt(i) - '0')) % 97;
        }
        return result;
    }
}
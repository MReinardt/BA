package test;

import datastructures.Account;
import datastructures.Transaction;
import datastructures.TransactionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test: Account")
public class TestManuelAccount {

    private Account account;
    private Transaction transaction;

    @BeforeEach
    public void setUp() {
        account = new Account(1, "test", 1234, 10000);
        transaction = new Transaction(1, TransactionType.TRANSFER, 1000, "test");
    }

    @Test
    @DisplayName("Test Account >> constructor and getters")
    public void testConstructorAndGetters() {
        assertEquals(1, account.getAccountId());
        assertEquals("test", account.getCardNumber());
        assertEquals(1234, account.getPinNumber());
        assertEquals(10000, account.getBalance());
        account.addTransaction(transaction);
        assertEquals(transaction, account.getTransactions().get(0));
    }

    @Test
    @DisplayName("Test Account >> display Account Details")
    public void testGetAccountDetails() {
        String expected = "Account{Account ID: 1, Card Number: test, Pin: 1234, Balance: 10000.0}";
        assertEquals(expected, account.displayAccountDetails());
    }

    @Test
    @DisplayName("Test Account >> display Transaction Details")
    public void testGetTransactionsDetails() {
        String expected = "Transaction{Transaction ID: 1, Type: TRANSFER, Amount: 1000.0, Description: test}\n";
        account.addTransaction(transaction);
        String updatedString = account.displayTransactionHistory().replaceAll(" Date: \\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2}:\\d{2},", "");
        assertEquals(expected, updatedString);
    }

    @Test
    @DisplayName("Test Account >> toString for englisch")
    public void testToStringEnglisch() {
        Locale.setDefault(Locale.forLanguageTag("en-US"));
        services.LanguageService.setLanguage("en", "US");
        String expectedEnglisch = "Account{Account ID: 1, Card Number: test, Pin: 1234, Balance: 10000.0}";
        assertEquals(expectedEnglisch, account.toString());
    }

    @Test
    @DisplayName("Test Account >> toString for german")
    public void testToStringGerman() {
        Locale.setDefault(Locale.forLanguageTag("de-DE"));
        services.LanguageService.setLanguage("de", "DE");
        String expectedGerman = "Account{Konto ID: 1, Kartennummer: test, PIN: 1234, Kontostand: 10000.0}";
        assertEquals(expectedGerman, account.toString());
    }

    @Test
    @DisplayName("Test Account >> toString for french")
    public void testToStringFrench() {
        Locale.setDefault(Locale.forLanguageTag("fr-FR"));
        services.LanguageService.setLanguage("fr", "FR");
        String expectedFrench = "Account{ID de compte: 1, Numéro de carte: test, Code PIN: 1234, Solde: 10000.0}";
        assertEquals(expectedFrench, account.toString());
    }
}

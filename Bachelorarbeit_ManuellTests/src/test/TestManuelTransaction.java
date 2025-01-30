package test;

import datastructures.Transaction;
import datastructures.TransactionType;
import services.LanguageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test: Transaction")
public class TestManuelTransaction {

    private Transaction transaction;
    private DateTimeFormatter formatter;

    @BeforeEach
    public void setUp() {
        formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        transaction = new Transaction(1, TransactionType.TRANSFER, 1000, "test");
    }

    @Test
    @DisplayName("Test Transaction >> constructor and getters")
    public void testConstructorAndGetters() {
        assertEquals(1, transaction.getTransactionId());
        assertEquals(1000, transaction.getAmount());
        assertEquals(TransactionType.TRANSFER, transaction.getType());
        assertEquals(formatter.format(LocalDateTime.now()), transaction.getTimestamp());
        assertEquals("test", transaction.getDescription());
    }

    @Test
    @DisplayName("Test Transaction >> toString for englisch")
    public void testToStringEnglisch() {
        Locale.setDefault(Locale.forLanguageTag("en-US"));
        LanguageService.setLanguage("en", "US");
        String expectedEnglisch = "Transaction{Transaction ID: 1, Type: TRANSFER, Amount: 1000.0, Date: "+ formatter.format(LocalDateTime.now()) + ", Description: test}";
        assertEquals(expectedEnglisch, transaction.toString());
    }

    @Test
    @DisplayName("Test Transaction >> toString for german")
    public void testToStringGerman() {
        Locale.setDefault(Locale.forLanguageTag("de-DE"));
        LanguageService.setLanguage("de", "DE");
        String expectedGerman = "Transaction{Transaktion ID: 1, Typ: TRANSFER, Betrag: 1000.0, Datum: "+ formatter.format(LocalDateTime.now()) + ", Beschreibung: test}";
        assertEquals(expectedGerman, transaction.toString());
    }

    @Test
    @DisplayName("Test Transaction >> toString for french")
    public void testToStringFrench() {
        Locale.setDefault(Locale.forLanguageTag("fr-FR"));
        LanguageService.setLanguage("fr", "FR");
        String expectedFrench = "Transaction{ID de transaction: 1, Type: TRANSFER, Montant: 1000.0, Date: "+ formatter.format(LocalDateTime.now()) + ", Description: test}";
        assertEquals(expectedFrench, transaction.toString());
    }
}

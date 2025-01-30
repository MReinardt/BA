package test;

import datastructures.TransactionType;
import datastructures.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    private Transaction transaction;

    @BeforeEach
    void setUp() {
        transaction = new Transaction(1, TransactionType.DEPOSIT, 500.0, "Initial deposit");
    }

    @Test
    void getTransactionIdReturnsCorrectId() {
        assertEquals(1, transaction.getTransactionId());
    }

    @Test
    void getTypeReturnsCorrectType() {
        assertEquals(TransactionType.DEPOSIT, transaction.getType());
    }

    @Test
    void getAmountReturnsCorrectAmount() {
        assertEquals(500.0, transaction.getAmount());
    }

    @Test
    void getTimestampReturnsFormattedTimestamp() {
        String expectedFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss").format(LocalDateTime.now());
        assertTrue(transaction.getTimestamp().startsWith(expectedFormat.substring(0, 10)));
    }

    @Test
    void getDescriptionReturnsCorrectDescription() {
        assertEquals("Initial deposit", transaction.getDescription());
    }

    @Test
    void toStringReturnsCorrectString() {
        String expected = "Transaction{TransactionID 1, TransactionType DEPOSIT, TransactionAmount 500.0, TransactionDate " + transaction.getTimestamp() + ", TransactionDescription Initial deposit}";
        assertEquals(expected, transaction.toString());
    }

    @Test
    void constructorWithTimestampSetsCorrectValues() {
        LocalDateTime customTimestamp = LocalDateTime.of(2023, 10, 1, 12, 0);
        Transaction customTransaction = new Transaction(2, TransactionType.WITHDRAWAL, 200.0, "ATM withdrawal", customTimestamp);
        assertEquals(2, customTransaction.getTransactionId());
        assertEquals(TransactionType.WITHDRAWAL, customTransaction.getType());
        assertEquals(200.0, customTransaction.getAmount());
        assertEquals("ATM withdrawal", customTransaction.getDescription());
        assertEquals("01.10.2023 12:00:00", customTransaction.getTimestamp());
    }
}
package test.java.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;


import datastructures.Transaction;
import datastructures.TransactionType;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TransactionDiffblueTest {
    /**
     * Test {@link Transaction#getTimestamp()}.
     * <p>
     * Method under test: {@link Transaction#getTimestamp()}
     */
    @Test
    @DisplayName("Test getTimestamp()")
    @Disabled("TODO: Complete this test")
    void testGetTimestamp() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests that are time-sensitive.
        //   The assertions don't pass when run at an alternate date, time, and
        //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
        //   that the time can be parameterized during testing.
        //   See Working with code R031 (https://diff.blue/R031) for details.

        // Arrange and Act
        (new Transaction(1, TransactionType.DEPOSIT, 10.0d, "The characteristics of someone or something")).getTimestamp();
    }

    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Transaction#toString()}
     *   <li>{@link Transaction#getAmount()}
     *   <li>{@link Transaction#getDescription()}
     *   <li>{@link Transaction#getTransactionId()}
     *   <li>{@link Transaction#getType()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    void testGettersAndSetters() {
        // Arrange
        Transaction transaction = new Transaction(1, TransactionType.DEPOSIT, 10.0d,
                "The characteristics of someone or something");

        // Act
        transaction.toString();
        double actualAmount = transaction.getAmount();
        String actualDescription = transaction.getDescription();
        int actualTransactionId = transaction.getTransactionId();

        // Assert
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals(1, actualTransactionId);
        assertEquals(10.0d, actualAmount);
        assertEquals(TransactionType.DEPOSIT, transaction.getType());
    }

    /**
     * Test
     * {@link Transaction#Transaction(int, TransactionType, double, String, LocalDateTime)}.
     * <p>
     * Method under test:
     * {@link Transaction#Transaction(int, TransactionType, double, String, LocalDateTime)}
     */
    @Test
    @DisplayName("Test new Transaction(int, TransactionType, double, String, LocalDateTime)")
    void testNewTransaction2() {
        // Arrange and Act
        Transaction actualTransaction = new Transaction(1, TransactionType.DEPOSIT, 10.0d,
                "The characteristics of someone or something", LocalDate.of(1970, 1, 1).atStartOfDay());

        // Assert
        assertEquals("01.01.1970 00:00:00", actualTransaction.getTimestamp());
        assertEquals("The characteristics of someone or something", actualTransaction.getDescription());
        assertEquals(1, actualTransaction.getTransactionId());
        assertEquals(10.0d, actualTransaction.getAmount());
        assertEquals(TransactionType.DEPOSIT, actualTransaction.getType());
    }

    /**
     * Test {@link Transaction#Transaction(int, TransactionType, double, String)}.
     * <p>
     * Method under test:
     * {@link Transaction#Transaction(int, TransactionType, double, String)}
     */
    @Test
    @DisplayName("Test new Transaction(int, TransactionType, double, String)")
    void testNewTransaction() {
        // Arrange and Act
        Transaction actualTransaction = new Transaction(1, TransactionType.DEPOSIT, 10.0d,
                "The characteristics of someone or something");

        // Assert
        assertEquals("The characteristics of someone or something", actualTransaction.getDescription());
        assertEquals(1, actualTransaction.getTransactionId());
        assertEquals(10.0d, actualTransaction.getAmount());
        assertEquals(TransactionType.DEPOSIT, actualTransaction.getType());
    }
}

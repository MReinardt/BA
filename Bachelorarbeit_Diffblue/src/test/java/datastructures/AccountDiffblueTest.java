package test.java.datastructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import datastructures.Account;
import datastructures.Transaction;
import datastructures.TransactionType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountDiffblueTest {
    /**
     * Test {@link Account#addTransaction(Transaction)}.
     * <p>
     * Method under test: {@link Account#addTransaction(Transaction)}
     */
    @Test
    @DisplayName("Test addTransaction(Transaction)")
    void testAddTransaction() {
        // Arrange
        Account account = new Account(1, "42", 10, 10.0d);
        Transaction transaction = new Transaction(1, TransactionType.DEPOSIT, 10.0d,
                "The characteristics of someone or something");

        // Act
        account.addTransaction(transaction);

        // Assert
        List<Transaction> transactions = account.getTransactions();
        assertEquals(1, transactions.size());
        assertSame(transaction, transactions.get(0));
    }

    /**
     * Test {@link Account#displayAccountDetails()}.
     * <p>
     * Method under test: {@link Account#displayAccountDetails()}
     */
    @Test
    @DisplayName("Test displayAccountDetails()")
    void testDisplayAccountDetails() {
        // Arrange, Act and Assert
        assertEquals("Account{Konto ID: 1, Kartennummer: 42, PIN: 10, Kontostand: 10.0}",
                (new Account(1, "42", 10, 10.0d)).displayAccountDetails());
    }

    /**
     * Test {@link Account#displayTransactionHistory()}.
     * <p>
     * Method under test: {@link Account#displayTransactionHistory()}
     */
    @Test
    @DisplayName("Test displayTransactionHistory()")
    @Disabled("TODO: Complete this test")
    void testDisplayTransactionHistory() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests that are time-sensitive.
        //   The assertions don't pass when run at an alternate date, time, and
        //   timezone. Try refactoring the method to take a 'java.time.Clock' instance so
        //   that the time can be parameterized during testing.
        //   See Working with code R031 (https://diff.blue/R031) for details.

        // Arrange
        Account account = new Account(1, "42", 10, 10.0d);
        account.addTransaction(
                new Transaction(1, TransactionType.DEPOSIT, 10.0d, "The characteristics of someone or something"));

        // Act
        account.displayTransactionHistory();
    }

    /**
     * Test {@link Account#displayTransactionHistory()}.
     * <p>
     * Method under test: {@link Account#displayTransactionHistory()}
     */
    @Test
    @DisplayName("Test displayTransactionHistory()")
    @Disabled("TODO: Complete this test")
    void testDisplayTransactionHistory2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "datastructures.Transaction.toString()" because "transaction" is null
        //       at datastructures.Account.displayTransactionHistory(Account.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Account account = new Account(1, "42", 10, 10.0d);
        account.addTransaction(null);

        // Act
        account.displayTransactionHistory();
    }

    /**
     * Test {@link Account#displayTransactionHistory()}.
     * <ul>
     *   <li>Then return empty string.</li>
     * </ul>
     * <p>
     * Method under test: {@link Account#displayTransactionHistory()}
     */
    @Test
    @DisplayName("Test displayTransactionHistory(); then return empty string")
    void testDisplayTransactionHistory_thenReturnEmptyString() {
        // Arrange, Act and Assert
        assertEquals("", (new Account(1, "42", 10, 10.0d)).displayTransactionHistory());
    }

    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Account#Account(int, String, int, double)}
     *   <li>{@link Account#setBalance(double)}
     *   <li>{@link Account#toString()}
     *   <li>{@link Account#getAccountId()}
     *   <li>{@link Account#getBalance()}
     *   <li>{@link Account#getCardNumber()}
     *   <li>{@link Account#getPinNumber()}
     *   <li>{@link Account#getTransactions()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    void testGettersAndSetters() {
        // Arrange and Act
        Account actualAccount = new Account(1, "42", 10, 10.0d);
        actualAccount.setBalance(10.0d);
        String actualToStringResult = actualAccount.toString();
        int actualAccountId = actualAccount.getAccountId();
        double actualBalance = actualAccount.getBalance();
        String actualCardNumber = actualAccount.getCardNumber();
        int actualPinNumber = actualAccount.getPinNumber();

        // Assert that nothing has changed
        assertEquals("42", actualCardNumber);
        assertEquals("Account{Konto ID: 1, Kartennummer: 42, PIN: 10, Kontostand: 10.0}", actualToStringResult);
        assertEquals(1, actualAccountId);
        assertEquals(10, actualPinNumber);
        assertEquals(10.0d, actualBalance);
        assertTrue(actualAccount.getTransactions().isEmpty());
    }
}

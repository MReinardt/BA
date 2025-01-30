package test;

import datastructures.Account;
import datastructures.Transaction;
import datastructures.TransactionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(1, "1234567890123456", 1234, 1000.0);
    }

    @Test
    void getAccountIdReturnsCorrectId() {
        assertEquals(1, account.getAccountId());
    }

    @Test
    void getCardNumberReturnsCorrectCardNumber() {
        assertEquals("1234567890123456", account.getCardNumber());
    }

    @Test
    void getPinNumberReturnsCorrectPinNumber() {
        assertEquals(1234, account.getPinNumber());
    }

    @Test
    void getBalanceReturnsCorrectBalance() {
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void setBalanceUpdatesBalanceCorrectly() {
        account.setBalance(2000.0);
        assertEquals(2000.0, account.getBalance());
    }

    @Test
    void addTransactionAddsTransactionToList() {
        Transaction transaction = new Transaction(1, TransactionType.DEPOSIT, 500.0, "Deposit");
        account.addTransaction(transaction);
        List<Transaction> transactions = account.getTransactions();
        assertEquals(1, transactions.size());
        assertEquals(transaction, transactions.get(0));
    }

    @Test
    void displayAccountDetailsReturnsCorrectString() {
        String expected = "Account{AccountID 1, AccountCardNumber 1234567890123456, AccountPin 1234, AccountBalance 1000.0}";
        assertEquals(expected, account.displayAccountDetails());
    }

    @Test
    void displayTransactionHistoryReturnsCorrectString() {
        Transaction transaction1 = new Transaction(1, TransactionType.DEPOSIT, 500.0, "Deposit");
        Transaction transaction2 = new Transaction(2, TransactionType.WITHDRAWAL, 200.0, "Withdrawal");
        account.addTransaction(transaction1);
        account.addTransaction(transaction2);
        String expected = transaction1.toString() + "\n" + transaction2.toString() + "\n";
        assertEquals(expected, account.displayTransactionHistory());
    }

    @Test
    void displayTransactionHistoryReturnsEmptyStringWhenNoTransactions() {
        assertEquals("", account.displayTransactionHistory());
    }
}
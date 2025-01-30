package datastructures;

import services.LanguageService;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final int accountId;
    private final String cardNumber;
    private final int pinNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(int accountId, String cardNumber, int pinNumber, double initialBalance) {
        this.accountId = accountId;
        this.cardNumber = cardNumber;
        this.pinNumber = pinNumber;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public int getAccountId() { return accountId; }
    public String getCardNumber() { return cardNumber; }
    public int getPinNumber() { return pinNumber; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public List<Transaction> getTransactions() { return transactions; }
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public String displayAccountDetails() {
        return toString();
    }

    public String displayTransactionHistory() {
        StringBuilder transactionHistory = new StringBuilder();
        for (Transaction transaction : transactions) {
            transactionHistory.append(transaction.toString()).append("\n");
        }
        return transactionHistory.toString();
    }

    @Override
    public String toString() {
        return "Account{" +
                LanguageService.getValue("AccountID") + " " + accountId + ", " +
                LanguageService.getValue("AccountCardNumber") + " " + cardNumber + ", " +
                LanguageService.getValue("AccountPin") + " " + pinNumber + ", " +
                LanguageService.getValue("AccountBalance") + " " + balance +
                '}';
    }
}
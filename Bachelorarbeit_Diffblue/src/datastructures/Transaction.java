package datastructures;
import services.LanguageService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private final int transactionId;
    private final TransactionType type;
    private final double amount;
    private final LocalDateTime timestamp;
    private final String description;
    private final DateTimeFormatter simpleDateFormat;

    public Transaction(int transactionId, TransactionType type, double amount, String description) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.description = description;
        this.simpleDateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    }

    public Transaction(int transactionId, TransactionType type, double amount, String description, LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.description = description;
        this.simpleDateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    }

    public int getTransactionId() { return transactionId; }

    public TransactionType getType() { return type; }

    public double getAmount() { return amount; }

    public String getTimestamp() { return simpleDateFormat.format(timestamp); }

    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "Transaction{" +
                LanguageService.getValue("TransactionID") + " " + transactionId + ", " +
                LanguageService.getValue("TransactionType") + " " + type + ", " +
                LanguageService.getValue("TransactionAmount") + " " + amount + ", " +
                LanguageService.getValue("TransactionDate") + " " + simpleDateFormat.format(timestamp) + ", " +
                LanguageService.getValue("TransactionDescription") + " " + description +
                '}';
    }
}
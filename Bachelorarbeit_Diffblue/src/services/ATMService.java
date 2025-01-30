package services;

import datastructures.TransactionType;
import exceptions.AuthenticationException;
import exceptions.CardException;
import exceptions.InsufficientFundsException;
import datastructures.User;
import datastructures.Account;
import datastructures.Transaction;

import java.util.Objects;

public class ATMService {

    public enum State {
        IDLE, CARD_INSERTED, AUTHENTICATED, DISPENSING, ERROR
    }

    private State currentState = State.IDLE;
    private User currentUser;

    public boolean insertCard(User user) throws CardException {
        if (currentState == State.IDLE && ValidationService.isGermanIbanValid(user.getAccount().getCardNumber())) {
            currentUser = user;
            currentState = State.CARD_INSERTED;
            System.out.println("Card accepted. Please enter PIN.");
            return true;
        } else {
            currentState = State.ERROR;
            throw new CardException("Error: Card cannot be accepted.");
        }
    }

    public boolean enterPin(Integer pin) throws AuthenticationException {
        if (currentState == State.CARD_INSERTED) {
            if (Objects.equals(pin, currentUser.getAccount().getPinNumber())) {
                currentState = State.AUTHENTICATED;
                System.out.println("PIN correct.");
                return true;
            } else {
                throw new AuthenticationException("Incorrect PIN.");
            }
        } else {
            throw new AuthenticationException("Error: PIN cannot be entered.");
        }
    }

    public double checkBalance() throws AuthenticationException {
        if (currentState == State.AUTHENTICATED) {
            double balance = currentUser.getAccount().getBalance();
            System.out.println("Account balance: " + balance + " EUR");
            return balance;
        } else {
            throw new AuthenticationException("Error: Not authenticated.");
        }
    }

    public boolean withdrawMoney(double amount) throws AuthenticationException, InsufficientFundsException {
        if (currentState == State.AUTHENTICATED) {
            Account account = currentUser.getAccount();
            if (amount <= account.getBalance()) {
                account.setBalance(account.getBalance() - amount);
                account.addTransaction(createTransaction(TransactionType.WITHDRAWAL, amount, "ATM withdrawal"));
                currentState = State.DISPENSING;
                System.out.println(amount + " EUR is being dispensed.");
                currentState = State.AUTHENTICATED;
                return true;
            } else {
                throw new InsufficientFundsException("Error: Insufficient funds.");
            }
        } else {
            throw new AuthenticationException("Error: Not authenticated.");
        }
    }

    public boolean depositMoney(double amount) throws AuthenticationException {
        if (currentState == State.AUTHENTICATED) {
            Account account = currentUser.getAccount();
            account.setBalance(account.getBalance() - amount);
            account.addTransaction(createTransaction(TransactionType.DEPOSIT, amount, "ATM deposit"));
            System.out.println(amount + " EUR has been deposited.");
            return true;
        } else {
            throw new AuthenticationException("Error: Not authenticated.");
        }
    }

    public boolean transferMoney(User recipient, double amount) throws AuthenticationException, InsufficientFundsException {
        if (currentState == State.AUTHENTICATED) {
            Account senderAccount = currentUser.getAccount();
            Account recipientAccount = recipient.getAccount();
            if (amount <= senderAccount.getBalance()) {
                senderAccount.setBalance(senderAccount.getBalance() - amount);
                recipientAccount.setBalance(recipientAccount.getBalance() + amount);
                senderAccount.addTransaction(createTransaction(TransactionType.TRANSFER, amount, "Transfer to " + recipient.getId()));
                recipientAccount.addTransaction(createTransaction(TransactionType.TRANSFER, amount, "Transfer from " + currentUser.getId()));
                System.out.println(amount + " EUR has been transferred to user " + recipient.getId());
                return true;
            } else {
                throw new InsufficientFundsException("Error: Insufficient funds.");
            }
        } else {
            throw new AuthenticationException("Error: Not authenticated.");
        }
    }

    private Transaction createTransaction(TransactionType type, double amount, String description) {
        return new Transaction(
                currentUser.getAccount().getTransactions().size() + 1,
                type,
                amount,
                description
        );
    }

    public void ejectCard() throws CardException {
        if (currentState != State.IDLE) {
            System.out.println("Card is being ejected.");
            currentState = State.IDLE;
            currentUser = null;
        } else {
            throw new CardException("Error: No card to eject.");
        }
    }

    public State getCurrentState() {
        return currentState;
    }
}
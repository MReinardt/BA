package test;

import datastructures.Account;
import datastructures.TransactionType;
import datastructures.User;
import exceptions.AuthenticationException;
import exceptions.CardException;
import exceptions.InsufficientFundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.ATMService;

import static org.junit.jupiter.api.Assertions.*;

class ATMServiceTest {

    private ATMService atmService;
    private User user;
    private Account account;

    @BeforeEach
    void setUp() {
        atmService = new ATMService();
        account = new Account(1, "DE89370400440532013000", 1234, 1000.0);
        user = new User(1, "John", "Doe", "john.doe@example.com", "1234567890", account);
    }

    @Test
    void insertCardAcceptsValidCard() throws CardException {
        assertTrue(atmService.insertCard(user));
        assertEquals(ATMService.State.CARD_INSERTED, atmService.getCurrentState());
    }

    @Test
    void insertCardRejectsInvalidCard() {
        //user.getAccount().setCardNumber("INVALID");
        assertThrows(CardException.class, () -> atmService.insertCard(user));
        assertEquals(ATMService.State.ERROR, atmService.getCurrentState());
    }

    @Test
    void enterPinAuthenticatesWithCorrectPin() throws CardException, AuthenticationException {
        atmService.insertCard(user);
        assertTrue(atmService.enterPin(1234));
        assertEquals(ATMService.State.AUTHENTICATED, atmService.getCurrentState());
    }

    @Test
    void enterPinRejectsIncorrectPin() throws CardException {
        atmService.insertCard(user);
        assertThrows(AuthenticationException.class, () -> atmService.enterPin(4321));
    }

    @Test
    void checkBalanceReturnsCorrectBalance() throws CardException, AuthenticationException {
        atmService.insertCard(user);
        atmService.enterPin(1234);
        assertEquals(1000.0, atmService.checkBalance());
    }

    @Test
    void checkBalanceThrowsExceptionWhenNotAuthenticated() {
        assertThrows(AuthenticationException.class, () -> atmService.checkBalance());
    }

    @Test
    void withdrawMoneyDispensesCorrectAmount() throws CardException, AuthenticationException, InsufficientFundsException {
        atmService.insertCard(user);
        atmService.enterPin(1234);
        assertTrue(atmService.withdrawMoney(500.0));
        assertEquals(500.0, user.getAccount().getBalance());
    }

    @Test
    void withdrawMoneyThrowsExceptionForInsufficientFunds() throws CardException, AuthenticationException {
        atmService.insertCard(user);
        atmService.enterPin(1234);
        assertThrows(InsufficientFundsException.class, () -> atmService.withdrawMoney(1500.0));
    }

    @Test
    void depositMoneyIncreasesBalance() throws CardException, AuthenticationException {
        atmService.insertCard(user);
        atmService.enterPin(1234);
        assertTrue(atmService.depositMoney(500.0));
        assertEquals(1500.0, user.getAccount().getBalance());
    }

    @Test
    void transferMoneyTransfersAmountToRecipient() throws CardException, AuthenticationException, InsufficientFundsException {
        User recipient = new User(2, "Jane", "Doe", "jane.doe@example.com", "0987654321", new Account(2, "DE89370400440532013001", 4321, 500.0));
        atmService.insertCard(user);
        atmService.enterPin(1234);
        assertTrue(atmService.transferMoney(recipient, 500.0));
        assertEquals(500.0, user.getAccount().getBalance());
        assertEquals(1000.0, recipient.getAccount().getBalance());
    }

    @Test
    void transferMoneyThrowsExceptionForInsufficientFunds() throws CardException, AuthenticationException {
        User recipient = new User(2, "Jane", "Doe", "jane.doe@example.com", "0987654321", new Account(2, "DE89370400440532013001", 4321, 500.0));
        atmService.insertCard(user);
        atmService.enterPin(1234);
        assertThrows(InsufficientFundsException.class, () -> atmService.transferMoney(recipient, 1500.0));
    }

    @Test
    void ejectCardResetsStateToIdle() throws CardException, AuthenticationException {
        atmService.insertCard(user);
        atmService.enterPin(1234);
        atmService.ejectCard();
        assertEquals(ATMService.State.IDLE, atmService.getCurrentState());
    }

    @Test
    void ejectCardThrowsExceptionWhenNoCardInserted() {
        assertThrows(CardException.class, () -> atmService.ejectCard());
    }
}
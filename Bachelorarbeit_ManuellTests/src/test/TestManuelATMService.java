package test;

import datastructures.Account;
import datastructures.User;
import exceptions.AuthenticationException;
import exceptions.CardException;
import exceptions.InsufficientFundsException;
import services.ATMService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test: ATMService")
public class TestManuelATMService {

    private User user_1;
    private User user_2;
    private ATMService atm;

    @BeforeEach
    void setUp() {
        Account accountGerman = new Account(1, "DE12345678901234567890", 1234, 10000);
        Account accountFrench = new Account(1, "FR12345678901234567890", 1234, 10000);
        user_1 = new User(1, "Max", "Mustermann", "maxmustermann@gmail.com", "+491234567890", accountGerman);
        user_2 = new User(1, "Maik", "Mustermann", "maikmustermann@gmail.com", "+491234567890", accountFrench);
        atm = new ATMService();
    }

    @Test
    @DisplayName("Test ATMService >> full walkthrough")
    void test_ATMService() throws CardException {

        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertTrue(atm.insertCard(user_1));
        assertEquals(ATMService.State.CARD_INSERTED, atm.getCurrentState());
        assertTrue(atm.enterPin(1234));
        assertEquals(ATMService.State.AUTHENTICATED, atm.getCurrentState());
        assertEquals(10000, atm.checkBalance());
        assertTrue(atm.withdrawMoney(500));
        assertEquals(ATMService.State.AUTHENTICATED, atm.getCurrentState());
        atm.ejectCard();
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
    }

    @Test
    @DisplayName("Test ATMService >> wrong card number")
    void test_ATMServiceWrongCardNumber() throws CardException {
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertThrowsExactly(CardException.class, () -> atm.insertCard(user_2));
        assertEquals(ATMService.State.ERROR, atm.getCurrentState());
        atm.ejectCard();
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
    }

    @Test
    @DisplayName("Test ATMService >> full walkthrough but not enough money")
    void test_ATMServiceWithNotEnoughMoney() throws CardException {
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertTrue(atm.insertCard(user_1));
        assertEquals(ATMService.State.CARD_INSERTED, atm.getCurrentState());
        assertTrue(atm.enterPin(user_1.getAccount().getPinNumber()));
        assertEquals(ATMService.State.AUTHENTICATED, atm.getCurrentState());
        assertEquals(10000, atm.checkBalance());
        assertThrowsExactly(InsufficientFundsException.class, () -> atm.withdrawMoney(10001));
        assertEquals(ATMService.State.AUTHENTICATED, atm.getCurrentState());
        atm.ejectCard();
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
    }

    @Test
    @DisplayName("Test ATMService >> exception when no card inserted")
    void test_ATMServiceExceptionHandling() throws CardException {
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertThrowsExactly(AuthenticationException.class, () -> atm.enterPin(4321));
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertThrowsExactly(AuthenticationException.class, () -> atm.withdrawMoney(1000));
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertThrowsExactly(AuthenticationException.class, () -> atm.checkBalance());
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertThrowsExactly(AuthenticationException.class, () -> atm.depositMoney(1000));
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertThrowsExactly(AuthenticationException.class, () -> atm.transferMoney(user_2, 1000));
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertThrowsExactly(CardException.class, () -> atm.ejectCard());
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
    }

    @Test
    @DisplayName("Test ATMService >> wrong Pin")
    void test_ATMServiceWithDoubleWrongPin() throws CardException {
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertTrue(atm.insertCard(user_1));
        assertEquals(ATMService.State.CARD_INSERTED, atm.getCurrentState());
        assertThrowsExactly(AuthenticationException.class, () -> atm.enterPin(4321));
        assertEquals(ATMService.State.CARD_INSERTED, atm.getCurrentState());
        assertTrue(atm.enterPin(user_1.getAccount().getPinNumber()));
        assertEquals(ATMService.State.AUTHENTICATED, atm.getCurrentState());
        atm.ejectCard();
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
    }

    @Test
    @DisplayName("Test ATMService >> wrong Pin check Balance")
    void test_ATMServiceWithWrongPinCheckBalance() throws CardException {
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertTrue(atm.insertCard(user_1));
        assertEquals(ATMService.State.CARD_INSERTED, atm.getCurrentState());
        assertThrowsExactly(AuthenticationException.class, () -> atm.enterPin(4321));
        assertEquals(ATMService.State.CARD_INSERTED, atm.getCurrentState());
        assertThrowsExactly(AuthenticationException.class, () -> atm.checkBalance());
        atm.ejectCard();
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
    }

    @Test
    @DisplayName("Test ATMService >> wrong Pin withdrawMoney")
    void test_ATMServiceWrongPinWithdrawMoney() throws CardException {
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertTrue(atm.insertCard(user_1));
        assertEquals(ATMService.State.CARD_INSERTED, atm.getCurrentState());
        assertTrue(atm.enterPin(user_1.getAccount().getPinNumber()));
        assertEquals(ATMService.State.AUTHENTICATED, atm.getCurrentState());
        assertEquals(10000, atm.checkBalance());
        assertTrue(atm.withdrawMoney(100));
        assertEquals(9900, atm.checkBalance());
        atm.ejectCard();
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
    }

    @Test
    @DisplayName("Test ATMService >> transfer money")
    void test_ATMServiceTransferMoney() throws CardException {
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertTrue(atm.insertCard(user_1));
        assertEquals(ATMService.State.CARD_INSERTED, atm.getCurrentState());
        assertTrue(atm.enterPin(user_1.getAccount().getPinNumber()));
        assertEquals(ATMService.State.AUTHENTICATED, atm.getCurrentState());
        assertEquals(10000, atm.checkBalance());
        assertTrue(atm.transferMoney(user_2, 1000));
        assertEquals(9000, atm.checkBalance());
        assertEquals(11000, user_2.getAccount().getBalance());
        atm.ejectCard();
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
    }

    @Test
    @DisplayName("Test ATMService >> transfer money with insufficient funds")
    void test_ATMServiceTransferMoneyWithInsufficientMoney() throws CardException {
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertTrue(atm.insertCard(user_1));
        assertEquals(ATMService.State.CARD_INSERTED, atm.getCurrentState());
        assertTrue(atm.enterPin(user_1.getAccount().getPinNumber()));
        assertEquals(ATMService.State.AUTHENTICATED, atm.getCurrentState());
        assertEquals(10000, atm.checkBalance());
        assertThrowsExactly(InsufficientFundsException.class, () -> atm.transferMoney(user_2, 10001));
        assertEquals(10000, atm.checkBalance());
        assertEquals(10000, user_2.getAccount().getBalance());
        atm.ejectCard();
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
    }


    @Test
    @DisplayName("Test ATMService >> deposit money")
    void test_ATMServiceDepositMoney() throws CardException {
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
        assertTrue(atm.insertCard(user_1));
        assertEquals(ATMService.State.CARD_INSERTED, atm.getCurrentState());
        assertTrue(atm.enterPin(user_1.getAccount().getPinNumber()));
        assertEquals(ATMService.State.AUTHENTICATED, atm.getCurrentState());
        assertEquals(10000, atm.checkBalance());
        assertTrue(atm.depositMoney(545.32));
        assertEquals(10545.32, atm.checkBalance());
        atm.ejectCard();
        assertEquals(ATMService.State.IDLE, atm.getCurrentState());
    }
}
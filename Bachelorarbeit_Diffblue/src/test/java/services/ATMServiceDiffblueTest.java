package test.java.services;

import datastructures.Account;
import datastructures.User;
import exceptions.AuthenticationException;
import exceptions.CardException;
import exceptions.InsufficientFundsException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.ATMService;

import static org.junit.jupiter.api.Assertions.*;

class ATMServiceDiffblueTest {
    /**
     * Test {@link ATMService#insertCard(User)}.
     * <p>
     * Method under test: {@link ATMService#insertCard(User)}
     */
    @Test
    @DisplayName("Test insertCard(User)")
    @Disabled("TODO: Complete this test")
    void testInsertCard() throws CardException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "main.datastructures.Account.getCardNumber()" because the return value of "main.datastructures.User.getAccount()" is null
        //       at main.services.ATMService.insertCard(ATMService.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        ATMService atmService = new ATMService();

        // Act
        atmService.insertCard(new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", null));
    }

    /**
     * Test {@link ATMService#insertCard(User)}.
     * <ul>
     *   <li>Then {@link ATMService} (default constructor) CurrentState is
     * {@code CARD_INSERTED}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ATMService#insertCard(User)}
     */
    @Test
    @DisplayName("Test insertCard(User); then ATMService (default constructor) CurrentState is 'CARD_INSERTED'")
    void testInsertCard_thenATMServiceCurrentStateIsCardInserted() throws CardException {
        // Arrange
        ATMService atmService = new ATMService();

        // Act
        boolean actualInsertCardResult = atmService.insertCard(new User(1, "Jane", "Doe", "jane.doe@example.org",
                "6625550144", new Account(1, "DE99999999999999999999", 10, 10.0d)));

        // Assert
        assertEquals(ATMService.State.CARD_INSERTED, atmService.getCurrentState());
        assertTrue(actualInsertCardResult);
    }

    /**
     * Test {@link ATMService#insertCard(User)}.
     * <ul>
     *   <li>Then throw {@link CardException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ATMService#insertCard(User)}
     */
    @Test
    @DisplayName("Test insertCard(User); then throw CardException")
    void testInsertCard_thenThrowCardException() throws CardException {
        // Arrange
        ATMService atmService = new ATMService();

        // Act and Assert
        assertThrows(CardException.class, () -> atmService
                .insertCard(new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d))));
    }

    /**
     * Test {@link ATMService#insertCard(User)}.
     * <ul>
     *   <li>When {@code null}.</li>
     * </ul>
     * <p>
     * Method under test: {@link ATMService#insertCard(User)}
     */
    @Test
    @DisplayName("Test insertCard(User); when 'null'")
    @Disabled("TODO: Complete this test")
    void testInsertCard_whenNull() throws CardException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "main.datastructures.User.getAccount()" because "user" is null
        //       at main.services.ATMService.insertCard(ATMService.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new ATMService()).insertCard(null);
    }

    /**
     * Test {@link ATMService#enterPin(Integer)}.
     * <p>
     * Method under test: {@link ATMService#enterPin(Integer)}
     */
    @Test
    @DisplayName("Test enterPin(Integer)")
    void testEnterPin() throws AuthenticationException {
        // Arrange, Act and Assert
        assertThrows(AuthenticationException.class, () -> (new ATMService()).enterPin(1));
    }

    /**
     * Test {@link ATMService#checkBalance()}.
     * <p>
     * Method under test: {@link ATMService#checkBalance()}
     */
    @Test
    @DisplayName("Test checkBalance()")
    void testCheckBalance() throws AuthenticationException {
        // Arrange, Act and Assert
        assertThrows(AuthenticationException.class, () -> (new ATMService()).checkBalance());
    }

    /**
     * Test {@link ATMService#withdrawMoney(double)}.
     * <p>
     * Method under test: {@link ATMService#withdrawMoney(double)}
     */
    @Test
    @DisplayName("Test withdrawMoney(double)")
    void testWithdrawMoney() throws AuthenticationException, InsufficientFundsException {
        // Arrange, Act and Assert
        assertThrows(AuthenticationException.class, () -> (new ATMService()).withdrawMoney(10.0d));
    }

    /**
     * Test {@link ATMService#depositMoney(double)}.
     * <p>
     * Method under test: {@link ATMService#depositMoney(double)}
     */
    @Test
    @DisplayName("Test depositMoney(double)")
    void testDepositMoney() throws AuthenticationException {
        // Arrange, Act and Assert
        assertThrows(AuthenticationException.class, () -> (new ATMService()).depositMoney(10.0d));
    }

    /**
     * Test {@link ATMService#transferMoney(User, double)}.
     * <p>
     * Method under test: {@link ATMService#transferMoney(User, double)}
     */
    @Test
    @DisplayName("Test transferMoney(User, double)")
    void testTransferMoney() throws AuthenticationException, InsufficientFundsException {
        // Arrange
        ATMService atmService = new ATMService();

        // Act and Assert
        assertThrows(AuthenticationException.class, () -> atmService.transferMoney(
                new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d)), 10.0d));
    }

    /**
     * Test {@link ATMService#ejectCard()}.
     * <p>
     * Method under test: {@link ATMService#ejectCard()}
     */
    @Test
    @DisplayName("Test ejectCard()")
    void testEjectCard() throws CardException {
        // Arrange, Act and Assert
        assertThrows(CardException.class, () -> (new ATMService()).ejectCard());
    }

    /**
     * Test {@link ATMService#getCurrentState()}.
     * <p>
     * Method under test: {@link ATMService#getCurrentState()}
     */
    @Test
    @DisplayName("Test getCurrentState()")
    void testGetCurrentState() {
        // Arrange, Act and Assert
        assertEquals(ATMService.State.IDLE, (new ATMService()).getCurrentState());
    }
}

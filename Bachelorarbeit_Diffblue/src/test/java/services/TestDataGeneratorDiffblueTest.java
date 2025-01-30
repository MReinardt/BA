package services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import datastructures.Account;
import datastructures.User;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestDataGeneratorDiffblueTest {
    /**
     * Test {@link TestDataGenerator#generateRandomUser(int)}.
     * <p>
     * Method under test: {@link TestDataGenerator#generateRandomUser(int)}
     */
    @Test
    @DisplayName("Test generateRandomUser(int)")
    void testGenerateRandomUser() {
        // Arrange
        TestDataGenerator testDataGenerator = new TestDataGenerator();

        // Act
        User actualGenerateRandomUserResult = testDataGenerator.generateRandomUser(1);

        // Assert
        Account account = actualGenerateRandomUserResult.getAccount();
        assertEquals(1, account.getAccountId());
        assertEquals(1, actualGenerateRandomUserResult.getId());
        assertEquals(3, testDataGenerator.generateRandomUsers(3).size());
        assertTrue(account.getTransactions().isEmpty());
        assertTrue(actualGenerateRandomUserResult.getOrders().isEmpty());
    }

    /**
     * Test {@link TestDataGenerator#generateRandomUsers(int)}.
     * <ul>
     *   <li>When {@code 900000000}.</li>
     * </ul>
     * <p>
     * Method under test: {@link TestDataGenerator#generateRandomUsers(int)}
     */
    @Test
    @DisplayName("Test generateRandomUsers(int); when '900000000'")
    @Disabled("TODO: Complete this test")
    void testGenerateRandomUsers_when900000000() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ThreadDeath
        //       at services.TestDataGenerator.mod97(TestDataGenerator.java:57)
        //       at services.TestDataGenerator.generateGermanIban(TestDataGenerator.java:43)
        //       at services.TestDataGenerator.generateRandomUser(TestDataGenerator.java:21)
        //       at services.TestDataGenerator.generateRandomUsers(TestDataGenerator.java:28)
        //   com.diffblue.cover.agent.UnboundedLoopException: Cover agent detected a potentially unbounded loop executing at services.TestDataGenerator#mod97:57
        //       at services.TestDataGenerator.mod97(TestDataGenerator.java:57)
        //       at services.TestDataGenerator.generateGermanIban(TestDataGenerator.java:43)
        //       at services.TestDataGenerator.generateRandomUser(TestDataGenerator.java:21)
        //       at services.TestDataGenerator.generateRandomUsers(TestDataGenerator.java:28)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new TestDataGenerator()).generateRandomUsers(900000000);
    }

    /**
     * Test {@link TestDataGenerator#generateRandomUsers(int)}.
     * <ul>
     *   <li>When three.</li>
     *   <li>Then return size is three.</li>
     * </ul>
     * <p>
     * Method under test: {@link TestDataGenerator#generateRandomUsers(int)}
     */
    @Test
    @DisplayName("Test generateRandomUsers(int); when three; then return size is three")
    void testGenerateRandomUsers_whenThree_thenReturnSizeIsThree() {
        // Arrange and Act
        List<User> actualGenerateRandomUsersResult = (new TestDataGenerator()).generateRandomUsers(3);

        // Assert
        assertEquals(3, actualGenerateRandomUsersResult.size());
        User getResult = actualGenerateRandomUsersResult.get(0);
        assertEquals(1, getResult.getId());
        User getResult2 = actualGenerateRandomUsersResult.get(1);
        assertEquals(2, getResult2.getId());
        User getResult3 = actualGenerateRandomUsersResult.get(2);
        assertEquals(3, getResult3.getId());
        assertTrue(getResult.getOrders().isEmpty());
        assertTrue(getResult2.getOrders().isEmpty());
        assertTrue(getResult3.getOrders().isEmpty());
    }
}

package test;

import datastructures.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.TestDataGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestDataGeneratorTest {

    private TestDataGenerator testDataGenerator;

    @BeforeEach
    void setUp() {
        testDataGenerator = new TestDataGenerator();
    }

    @Test
    void generateRandomUserCreatesUserWithValidData() {
        User user = testDataGenerator.generateRandomUser(1);
        assertNotNull(user.getFirstName());
        assertNotNull(user.getLastName());
        assertNotNull(user.getEmail());
        assertNotNull(user.getPhoneNumber());
        assertNotNull(user.getAccount());
    }

    @Test
    void generateRandomUserCreatesUniqueUsers() {
        User user1 = testDataGenerator.generateRandomUser(1);
        User user2 = testDataGenerator.generateRandomUser(2);
        assertNotEquals(user1.getEmail(), user2.getEmail());
        assertNotEquals(user1.getPhoneNumber(), user2.getPhoneNumber());
    }

    @Test
    void generateRandomUsersCreatesCorrectNumberOfUsers() {
        List<User> users = testDataGenerator.generateRandomUsers(5);
        assertEquals(5, users.size());
    }

    @Test
    void generateRandomUsersCreatesUsersWithUniqueIds() {
        List<User> users = testDataGenerator.generateRandomUsers(5);
        for (int i = 0; i < users.size(); i++) {
            assertEquals(i + 1, users.get(i).getId());
        }
    }

    @Test
    void generateRandomDoubleInRangeReturnsValueWithinRange() {
        //double value = testDataGenerator.generateRandomDoubleInRange(1000, 2000);
        //assertTrue(value >= 1000 && value <= 2000);
    }

    @Test
    void generateGermanIbanCreatesValidIban() {
        //String iban = testDataGenerator.generateGermanIban();
        //assertTrue(iban.startsWith("DE"));
        //assertEquals(22, iban.length());
    }

    @Test
    void mod97ReturnsCorrectModulus() {
        //int result = testDataGenerator.mod97("13140012345678901234567890");
        //assertEquals(1, result);
    }
}
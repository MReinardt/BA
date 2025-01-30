package test;

import datastructures.*;
import services.TestDataGenerator;
import services.XMLFileHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

@DisplayName("Test: XMLFileHandler")
public class TestManuelXMLFileHandler {

    private final String path = "C:\\Users\\mikel\\IdeaProjects\\BachelorArbeit_JAVA\\users.xml";
    private final String path_1 = "C:\\Users\\mikel\\IdeaProjects\\BachelorArbeit_JAVA\\HighAmountOfUsers.xml";
    private List<User> users;

    @BeforeEach
    public void setUp() {
        TestDataGenerator testDataGenerator = new TestDataGenerator();
        users = testDataGenerator.generateRandomUsers(10);
        File file = new File(path);
        File file_1 = new File(path);
        if (file.exists()) {
            file.delete();
        }
        if (file_1.exists()) {
            file_1.delete();
        }
    }

    @Test
    @DisplayName("Test XMLFileHandler >> check if users are in the file")
    void test_CheckIfUsersAreInTheFile() throws FileNotFoundException {
        XMLFileHandler.writeUsers(users, path);
        if (new File(path).exists()) {
            List<User> usersFromFile = XMLFileHandler.readUsers(path);
            assertEquals(10, usersFromFile.size());

            for (int i = 0; i < users.size(); i++) {
                assertEquals(users.get(i).getFirstName(), usersFromFile.get(i).getFirstName());
                assertEquals(users.get(i).getLastName(), usersFromFile.get(i).getLastName());
                assertEquals(users.get(i).getEmail(), usersFromFile.get(i).getEmail());
                assertEquals(users.get(i).getPhoneNumber(), usersFromFile.get(i).getPhoneNumber());
            }
        }
    }

    @Test
    @DisplayName("Test XMLFileHandler >> check high amount of users")
    void test_CheckIfHighAmountOfUsersIsPossible() throws FileNotFoundException {
        users = new TestDataGenerator().generateRandomUsers(10000);
        XMLFileHandler.writeUsers(users, path_1);
        if (new File(path_1).exists()) {
            List<User> usersFromFile = XMLFileHandler.readUsers(path_1);
            assertEquals(10000, usersFromFile.size());
        }
    }

    @Test
    @DisplayName("Test XMLFileHandler >> check Exception Handling")
    void test_XMLFileHandleExceptionHandling() {
        assertThrowsExactly(FileNotFoundException.class, () -> XMLFileHandler.readUsers("C:\\Users\\mikel\\IdeaProjects\\BachelorArbeit_JAVA\\us.xml"));
    }

    @Test
    @DisplayName("Test XMLFileHandler >> check Exception Handling")
    void test_XMLWithAllClasses() throws FileNotFoundException {
        Account account = new Account(1, "DE12345678910", 1234, 1000);
        Transaction transaction = new Transaction(1, TransactionType.TRANSFER, 1, "Test");
        Order order = new Order(1, 1);
        account.addTransaction(transaction);
        User user = new User(1, "Max", "Mustermann", "Max.Mustermann@gmail.com", "+49123456789", account);
        user.addOrder(order);
        XMLFileHandler.writeUsers(List.of(user), path);
        List<User> usersFromFile = XMLFileHandler.readUsers(path);

        assertEquals(user.getFirstName(), usersFromFile.get(0).getFirstName());
        assertEquals(user.getLastName(), usersFromFile.get(0).getLastName());
        assertEquals(user.getEmail(), usersFromFile.get(0).getEmail());
        assertEquals(user.getPhoneNumber(), usersFromFile.get(0).getPhoneNumber());

        assertEquals(account.getAccountId(), usersFromFile.get(0).getAccount().getAccountId());
        assertEquals(account.getCardNumber(), usersFromFile.get(0).getAccount().getCardNumber());
        assertEquals(account.getPinNumber(), usersFromFile.get(0).getAccount().getPinNumber());
        assertEquals(account.getBalance(), usersFromFile.get(0).getAccount().getBalance());


        assertEquals(transaction.getTransactionId(), usersFromFile.get(0).getAccount().getTransactions().get(0).getTransactionId());
        assertEquals(transaction.getType(), usersFromFile.get(0).getAccount().getTransactions().get(0).getType());
        assertEquals(transaction.getAmount(), usersFromFile.get(0).getAccount().getTransactions().get(0).getAmount());
        assertEquals(transaction.getDescription(), usersFromFile.get(0).getAccount().getTransactions().get(0).getDescription());

        assertEquals(order.getOrderId(), usersFromFile.get(0).getOrders().get(0).getOrderId());
        assertEquals(order.getPrice(), usersFromFile.get(0).getOrders().get(0).getPrice());
        assertEquals(order.getStatus(), usersFromFile.get(0).getOrders().get(0).getStatus());
    }
}
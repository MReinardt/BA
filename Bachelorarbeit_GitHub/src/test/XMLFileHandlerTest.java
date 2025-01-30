package test;

import datastructures.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import services.XMLFileHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XMLFileHandlerTest {

    private List<User> users;
    private String filePath;

    @BeforeEach
    void setUp() {
        users = new ArrayList<>();
        Account account = new Account(1, "1234567890123456", 1234, 1000.0);
        User user = new User(1, "John", "Doe", "john.doe@example.com", "1234567890", account);
        Order order = new Order(1, 100);
        order.setStatus("PAID");
        user.addOrder(order);
        users.add(user);
        filePath = "test_users.xml";
    }

    @Test
    void writeUsersCreatesXMLFile() {
        XMLFileHandler.writeUsers(users, filePath);
        File file = new File(filePath);
        assertTrue(file.exists());
    }

    @Test
    void writeUsersCreatesCorrectXMLStructure() throws Exception {
        XMLFileHandler.writeUsers(users, filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(filePath));

        Element root = doc.getDocumentElement();
        assertEquals("users", root.getNodeName());

        Element userElement = (Element) root.getElementsByTagName("user").item(0);
        assertEquals("1", userElement.getElementsByTagName("id").item(0).getTextContent());
        assertEquals("John", userElement.getElementsByTagName("firstName").item(0).getTextContent());
        assertEquals("Doe", userElement.getElementsByTagName("lastName").item(0).getTextContent());
        assertEquals("john.doe@example.com", userElement.getElementsByTagName("email").item(0).getTextContent());
        assertEquals("1234567890", userElement.getElementsByTagName("phoneNumber").item(0).getTextContent());

        Element accountElement = (Element) userElement.getElementsByTagName("account").item(0);
        assertEquals("1", accountElement.getElementsByTagName("accountId").item(0).getTextContent());
        assertEquals("1234567890123456", accountElement.getElementsByTagName("cardNumber").item(0).getTextContent());
        assertEquals("1234", accountElement.getElementsByTagName("pinNumber").item(0).getTextContent());
        assertEquals("1000.0", accountElement.getElementsByTagName("balance").item(0).getTextContent());

        Element orderElement = (Element) userElement.getElementsByTagName("order").item(0);
        assertEquals("1", orderElement.getElementsByTagName("orderId").item(0).getTextContent());
        assertEquals("PAID", orderElement.getElementsByTagName("status").item(0).getTextContent());
        assertEquals("100", orderElement.getElementsByTagName("price").item(0).getTextContent());
    }

    @Test
    void readUsersReturnsCorrectUserList() throws FileNotFoundException {
        XMLFileHandler.writeUsers(users, filePath);
        List<User> readUsers = XMLFileHandler.readUsers(filePath);
        assertEquals(1, readUsers.size());
        User user = readUsers.get(0);
        assertEquals(1, user.getId());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("john.doe@example.com", user.getEmail());
        assertEquals("1234567890", user.getPhoneNumber());
        assertEquals(1, user.getOrders().size());
        assertEquals("PAID", user.getOrders().get(0).getStatus());
    }

    @Test
    void readUsersThrowsExceptionForNonExistingFile() {
        assertThrows(FileNotFoundException.class, () -> XMLFileHandler.readUsers("non_existing_file.xml"));
    }

    @Test
    void readUsersParsesAccountCorrectly() throws FileNotFoundException {
        XMLFileHandler.writeUsers(users, filePath);
        List<User> readUsers = XMLFileHandler.readUsers(filePath);
        Account account = readUsers.get(0).getAccount();
        assertEquals(1, account.getAccountId());
        assertEquals("1234567890123456", account.getCardNumber());
        assertEquals(1234, account.getPinNumber());
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void readUsersParsesOrdersCorrectly() throws FileNotFoundException {
        XMLFileHandler.writeUsers(users, filePath);
        List<User> readUsers = XMLFileHandler.readUsers(filePath);
        List<Order> orders = readUsers.get(0).getOrders();
        assertEquals(1, orders.size());
        Order order = orders.get(0);
        assertEquals(1, order.getOrderId());
        assertEquals("PAID", order.getStatus());
        assertEquals(100, order.getPrice());
    }

//    @Test
//    void readUsersParsesTransactionsCorrectly() throws FileNotFoundException {
//        Account account = users.get(0).getAccount();
//        Transaction transaction = new Transaction(1, TransactionType.DEPOSIT, 500.0, "Initial deposit", "01.01.2023 12:00:00");
//        account.addTransaction(transaction);
//        XMLFileHandler.writeUsers(users, filePath);
//        List<User> readUsers = XMLFileHandler.readUsers(filePath);
//        List<Transaction> transactions = readUsers.get(0).getAccount().getTransactions();
//        assertEquals(1, transactions.size());
//        Transaction readTransaction = transactions.get(0);
//        assertEquals(1, readTransaction.getTransactionId());
//        assertEquals(TransactionType.DEPOSIT, readTransaction.getType());
//        assertEquals(500.0, readTransaction.getAmount());
//        assertEquals("Initial deposit", readTransaction.getDescription());
//        assertEquals("01.01.2023 12:00:00", readTransaction.getTimestamp());
//    }
}
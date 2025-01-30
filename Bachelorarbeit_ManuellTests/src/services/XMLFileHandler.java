package services;

import datastructures.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class XMLFileHandler {

    public static void writeUsers(List<User> users, String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("users");
            doc.appendChild(root);

            for (User user : users) {
                Element userElement = doc.createElement("user");

                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(String.valueOf(user.getId())));

                Element firstName = doc.createElement("firstName");
                firstName.appendChild(doc.createTextNode(user.getFirstName()));

                Element lastName = doc.createElement("lastName");
                lastName.appendChild(doc.createTextNode(user.getLastName()));

                Element email = doc.createElement("email");
                email.appendChild(doc.createTextNode(user.getEmail()));

                Element phoneNumber = doc.createElement("phoneNumber");
                phoneNumber.appendChild(doc.createTextNode(user.getPhoneNumber()));

                Element accountElement = createAccountElement(doc, user.getAccount());

                Element ordersElement = doc.createElement("orders");
                for (Order order : user.getOrders()) {
                    Element orderElement = createOrderElement(doc, order);
                    ordersElement.appendChild(orderElement);
                }

                userElement.appendChild(id);
                userElement.appendChild(firstName);
                userElement.appendChild(lastName);
                userElement.appendChild(email);
                userElement.appendChild(phoneNumber);
                userElement.appendChild(accountElement);
                userElement.appendChild(ordersElement);

                root.appendChild(userElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Element createAccountElement(Document doc, Account account) {
        Element accountElement = doc.createElement("account");

        Element accountId = doc.createElement("accountId");
        accountId.appendChild(doc.createTextNode(String.valueOf(account.getAccountId())));

        Element cardNumber = doc.createElement("cardNumber");
        cardNumber.appendChild(doc.createTextNode(account.getCardNumber()));

        Element pinNumber = doc.createElement("pinNumber");
        pinNumber.appendChild(doc.createTextNode(String.valueOf(account.getPinNumber())));

        Element balance = doc.createElement("balance");
        balance.appendChild(doc.createTextNode(String.valueOf(account.getBalance())));

        Element transactionsElement = doc.createElement("transactions");
        for (Transaction transaction : account.getTransactions()) {
            Element transactionElement = createTransactionElement(doc, transaction);
            transactionsElement.appendChild(transactionElement);
        }

        accountElement.appendChild(accountId);
        accountElement.appendChild(cardNumber);
        accountElement.appendChild(pinNumber);
        accountElement.appendChild(balance);
        accountElement.appendChild(transactionsElement);

        return accountElement;
    }

    private static Element createOrderElement(Document doc, Order order) {
        Element orderElement = doc.createElement("order");

        Element orderId = doc.createElement("orderId");
        orderId.appendChild(doc.createTextNode(String.valueOf(order.getOrderId())));

        Element status = doc.createElement("status");
        status.appendChild(doc.createTextNode(order.getStatus()));

        Element price = doc.createElement("price");
        price.appendChild(doc.createTextNode(String.valueOf(order.getPrice())));

        orderElement.appendChild(orderId);
        orderElement.appendChild(status);
        orderElement.appendChild(price);

        return orderElement;
    }

    private static Element createTransactionElement(Document doc, Transaction transaction) {
        Element transactionElement = doc.createElement("transaction");

        Element transactionId = doc.createElement("transactionId");
        transactionId.appendChild(doc.createTextNode(String.valueOf(transaction.getTransactionId())));

        Element type = doc.createElement("type");
        type.appendChild(doc.createTextNode(transaction.getType().toString()));

        Element amount = doc.createElement("amount");
        amount.appendChild(doc.createTextNode(String.valueOf(transaction.getAmount())));

        Element timestamp = doc.createElement("timestamp");
        timestamp.appendChild(doc.createTextNode(transaction.getTimestamp()));

        Element description = doc.createElement("description");
        description.appendChild(doc.createTextNode(transaction.getDescription()));

        transactionElement.appendChild(transactionId);
        transactionElement.appendChild(type);
        transactionElement.appendChild(amount);
        transactionElement.appendChild(timestamp);
        transactionElement.appendChild(description);

        return transactionElement;
    }

    public static List<User> readUsers(String filePath) throws FileNotFoundException {
        List<User> users = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);

            NodeList userList = doc.getElementsByTagName("user");
            for (int i = 0; i < userList.getLength(); i++) {
                Element userElement = (Element) userList.item(i);

                int id = Integer.parseInt(userElement.getElementsByTagName("id").item(0).getTextContent());
                String firstName = userElement.getElementsByTagName("firstName").item(0).getTextContent();
                String lastName = userElement.getElementsByTagName("lastName").item(0).getTextContent();
                String email = userElement.getElementsByTagName("email").item(0).getTextContent();
                String phoneNumber = userElement.getElementsByTagName("phoneNumber").item(0).getTextContent();

                Element accountElement = (Element) userElement.getElementsByTagName("account").item(0);
                Account account = readAccount(accountElement);

                NodeList orderList = userElement.getElementsByTagName("order");
                List<Order> orders = new ArrayList<>();
                for (int j = 0; j < orderList.getLength(); j++) {
                    Element orderElement = (Element) orderList.item(j);
                    orders.add(readOrder(orderElement));
                }

                User user = new User(id, firstName, lastName, email, phoneNumber, account);
                for (Order order : orders) {
                    user.addOrder(order);
                }

                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    private static Account readAccount(Element accountElement) {
        int accountId = Integer.parseInt(accountElement.getElementsByTagName("accountId").item(0).getTextContent());
        String cardNumber = accountElement.getElementsByTagName("cardNumber").item(0).getTextContent();
        int pinNumber = Integer.parseInt(accountElement.getElementsByTagName("pinNumber").item(0).getTextContent());
        double balance = Double.parseDouble(accountElement.getElementsByTagName("balance").item(0).getTextContent());

        Account account = new Account(accountId, cardNumber, pinNumber, balance);

        NodeList transactionList = accountElement.getElementsByTagName("transaction");
        for (int i = 0; i < transactionList.getLength(); i++) {
            Element transactionElement = (Element) transactionList.item(i);
            account.addTransaction(readTransaction(transactionElement));
        }

        return account;
    }

    private static Order readOrder(Element orderElement) {
        int orderId = Integer.parseInt(orderElement.getElementsByTagName("orderId").item(0).getTextContent());
        String status = orderElement.getElementsByTagName("status").item(0).getTextContent();
        int price = Integer.parseInt(orderElement.getElementsByTagName("price").item(0).getTextContent());

        Order order = new Order(orderId, price);
        order.setStatus(status);

        return order;
    }

    private static Transaction readTransaction(Element transactionElement) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        int transactionId = Integer.parseInt(transactionElement.getElementsByTagName("transactionId").item(0).getTextContent());
        TransactionType type = TransactionType.valueOf(transactionElement.getElementsByTagName("type").item(0).getTextContent());
        double amount = Double.parseDouble(transactionElement.getElementsByTagName("amount").item(0).getTextContent());
        String timestamp = transactionElement.getElementsByTagName("timestamp").item(0).getTextContent();
        String description = transactionElement.getElementsByTagName("description").item(0).getTextContent();

        return new Transaction(transactionId, type, amount, description, LocalDateTime.parse(timestamp, formatter));
    }
}
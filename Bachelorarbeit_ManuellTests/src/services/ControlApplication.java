package services;

import datastructures.Account;
import datastructures.User;
import exceptions.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ControlApplication {


    private UserService userService;
    private ATMService atmService;
    private OrderService orderService;
    private final Scanner scanner = new Scanner(System.in);


    public ControlApplication() {
        LanguageService.setLanguage("en", "US");
        this.userService = new UserService();
        this.atmService = new ATMService();
        this.orderService = new OrderService();
    }

    public String getStringInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public int getIntInput(String prompt) {
        int result;
        while (true) {
            System.out.println(prompt);
            try {
                result = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe. Bitte eine gültige Ganzzahl eingeben.");
            }
        }
        return result;
    }

    public void start() {
        while (true) {
            System.out.println("Welcome to the User Application!");
            System.out.println("Please select an option:");
            System.out.println("1. Change language");
            System.out.println("2. Test Data Generator");
            System.out.println("3. Load Users from XML");
            System.out.println("4. User Management");
            System.out.println("5. ATM Management");
            System.out.println("6. Order Management");
            System.out.println("7. Exit");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    String languageCode = getStringInput("Please enter the language code (en, de, fr):");
                    String countryCode = getStringInput("Please enter the country code (US, DE, FR):");
                    LanguageService.setLanguage(languageCode, countryCode);
                    break;
                case 2:
                    TestDataGenerator testDataGenerator = new TestDataGenerator();
                    int numberOfUsers = getIntInput("Please enter the number of users to generate:");
                    userService.setUsers(testDataGenerator.generateRandomUsers(numberOfUsers));
                    break;
                case 3:
                    String path = getStringInput("Please enter the path to the XML file:");
                    try {
                        userService.setUsers(XMLFileHandler.readUsers(path));
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found!");
                    }
                    break;
                case 4:
                    manageUsers();
                    break;
                case 5:
                    manageATMService();
                    break;
                case 6:
                    manageOrderService();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    public void manageUsers() {
        UserService userService = new UserService();
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Create User");
            System.out.println("2. Update User");
            System.out.println("3. Delete User");
            System.out.println("4. Show User");
            System.out.println("5. Back");
            int option = scanner.nextInt();
            scanner.nextLine();
            int userId;
            User user;
            switch (option) {
                case 1:
                    user = getUserInformationFromScanner(userService.getLastUserId());
                    try {
                        userService.createUser(user);
                    } catch (UserAlreadyExistsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    userId = getIntInput("Please enter the user ID:");
                    user = getUserInformationFromScanner(userService.getLastUserId());

                    try {
                        userService.updateUser(userId, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), user.getAccount());
                    } catch (UserNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    userId = getIntInput("Please enter the user ID:");
                    try {
                        userService.deleteUser(userId);
                    } catch (UserNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    userService.getUsers().forEach( listUser -> {
                        System.out.println(listUser.toString());
                        System.out.println(listUser.getAccount().displayAccountDetails());
                    });

                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    public void manageATMService() {
        ATMService atmService = new ATMService();
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Withdraw money");
            System.out.println("2. Deposit money");
            System.out.println("3. Transfer money");
            System.out.println("4. Show account balance");
            System.out.println("5. Back");
            int option = scanner.nextInt();
            scanner.nextLine();
            int userId;
            switch (option) {
                case 1:
                    userId = getIntInput("Please enter the user ID:");
                    int amount = getIntInput("Please enter the amount to withdraw:");
                    try {
                        atmService.insertCard(userService.getUserById(userId));
                        atmService.withdrawMoney(amount);
                    } catch (UserNotFoundException | CardException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    userId = getIntInput("Please enter the user ID:");
                    amount = getIntInput("Please enter the amount to deposit:");
                    try {
                        atmService.insertCard(userService.getUserById(userId));
                        atmService.depositMoney(amount);
                    } catch (UserNotFoundException | CardException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    int senderId = getIntInput("Please enter the sender ID:");
                    int receiverId = getIntInput("Please enter the receiver ID:");
                    amount = getIntInput("Please enter the amount to transfer:");
                    try {
                        atmService.insertCard(userService.getUserById(senderId));
                        atmService.transferMoney(userService.getUserById(receiverId), amount);
                    } catch (UserNotFoundException | CardException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    userId = getIntInput("Please enter the user ID:");
                    try {
                        atmService.insertCard(userService.getUserById(userId));
                        atmService.checkBalance();
                    } catch (UserNotFoundException | CardException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
    public void manageOrderService() {
        OrderService orderService = new OrderService();
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1. Create Order");
            System.out.println("2. Pay Order");
            System.out.println("3. Ship Order");
            System.out.println("4. Deliver Order");
            System.out.println("5. Back");
            int option = scanner.nextInt();
            scanner.nextLine();
            int userId;
            int orderId;
            switch (option) {
                case 1:
                    userId = getIntInput("Please enter the user ID:");
                    int orderPrice = getIntInput("Please enter the order price:");
                    try {
                        orderService.createOrder(userService.getUserById(userId), orderPrice);
                    } catch (UserNotFoundException | InvalidOrderException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    userId = getIntInput("Please enter the user ID:");
                    orderId = getIntInput("Please enter the order ID:");
                    try {
                        orderService.payOrder(userService.getUserById(userId), orderId);
                    } catch (UserNotFoundException | InvalidOrderException | OrderNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    userId = getIntInput("Please enter the user ID:");
                    orderId = getIntInput("Please enter the order ID:");
                    try {
                        orderService.shipOrder(userService.getUserById(userId), orderId);
                    } catch (UserNotFoundException | InvalidOrderException | OrderNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    userId = getIntInput("Please enter the user ID:");
                    orderId = getIntInput("Please enter the order ID:");
                    try {
                        orderService.deliverOrder(userService.getUserById(userId), orderId);
                    } catch (UserNotFoundException | InvalidOrderException | OrderNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    public User getUserInformationFromScanner(int id) {
        String firstName = getStringInput("Please enter the first name:");
        String lastName = getStringInput("Please enter the last name:");
        String email = getStringInput("Please enter the email:");
        String phoneNumber = getStringInput("Please enter the phone number:");

        String accountCardNumber = getStringInput("Please enter the account card number:");
        int accountPin = getIntInput("Please enter the account PIN (1000):");
        int accountBalance = getIntInput("Please enter the account balance:");
        Account account = new Account(id + 1, accountCardNumber,accountPin,accountBalance);
        return new User(id + 1, firstName, lastName, email, phoneNumber, account);
    }
}
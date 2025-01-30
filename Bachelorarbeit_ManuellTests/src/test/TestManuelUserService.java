package test;

import datastructures.User;
import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import services.TestDataGenerator;
import services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test: UserService")
public class TestManuelUserService {

    private UserService userService;
    private List<User> users;

    @BeforeEach
    public void setUp() {
        TestDataGenerator testDataGenerator = new TestDataGenerator();
        users = testDataGenerator.generateRandomUsers(10);
        userService = new UserService();
        userService.setUsers(users);
    }

    @Test
    @DisplayName("Test UserService >> Create User")
    void test_UserServiceCreateUser() {
        assertEquals(10, users.size());
        userService.createUser(new User(11, "Max", "Mustermann", "", "", null));
        assertEquals(11, users.size());
    }

    @Test
    @DisplayName("Test UserService >> Exception Handling Create User")
    void test_UserServiceCreateUserExceptionHandling() {
        assertThrowsExactly(UserAlreadyExistsException.class, () -> userService.createUser(new User(1, "Max", "Mustermann", "", "", null)));
    }

    @Test
    @DisplayName("Test UserService >> Get User by ID")
    void test_UserServiceGetUserByID() {
        for (User user : users) {
            assertEquals(user, userService.getUserById(user.getId()));
        }
    }

    @Test
    @DisplayName("Test UserService >> ExceptionHandling Get User by non existing ID")
    void test_UserServiceExceptionHandlingGetUserById() {
        assertThrowsExactly(UserNotFoundException.class, () -> userService.getUserById(100));
    }

    @Test
    @DisplayName("Test UserService >> Update User")
    void test_UserServiceUpdateUser() {
        assertNotEquals("Johann", userService.getUserById(1).getFirstName());
        assertNotEquals("Mustermann", userService.getUserById(1).getLastName());
        assertNotEquals("johannmustermann@gmail.com", userService.getUserById(1).getEmail());
        assertNotEquals(null, userService.getUserById(1).getAccount());

        userService.updateUser(1, "Johann", "Mustermann", "johannmustermann@gmail.com", "+491234567890", null);

        assertEquals("Johann", userService.getUserById(1).getFirstName());
        assertEquals("Mustermann", userService.getUserById(1).getLastName());
        assertEquals("johannmustermann@gmail.com", userService.getUserById(1).getEmail());
        assertEquals(null, userService.getUserById(1).getAccount());
    }

    @Test
    @DisplayName("Test UserService >> Update User with invalid email and invalid phone number")
    void test_UserServiceUpdateUserWithWrongEmailandPhoneNumber() {
        assertNotEquals("Johann", userService.getUserById(1).getFirstName());
        assertNotEquals("Mustermann", userService.getUserById(1).getLastName());
        assertNotEquals("johannmustermanngmailcom", userService.getUserById(1).getEmail());
        assertNotEquals("+501234567890", userService.getUserById(1).getPhoneNumber());

        userService.updateUser(1, "Johann", "Mustermann", "johannmustermanngmailcom", "+501234567890", null);

        assertEquals("Johann", userService.getUserById(1).getFirstName());
        assertEquals("Mustermann", userService.getUserById(1).getLastName());
        assertNotEquals("johannmustermanngmailcom", userService.getUserById(1).getEmail());
        assertNotEquals("+501234567890", userService.getUserById(1).getPhoneNumber());
    }

    @Test
    @DisplayName("Test UserService >> ExceptionHandling Update User")
    void test_UserServiceExceptionHandlingUpdateUser() {
        assertThrowsExactly(UserNotFoundException.class, () -> userService.updateUser(100, "Hello", "World", "helloworld@gmail.com", "+491234567890", null));
    }

    @Test
    @DisplayName("Test UserService >> Delete User")
    void test_UserServiceDeleteUser() {
        assertNotNull(userService.getUserById(1));
        assertNotNull(userService.getUserById(1).getFirstName());
        assertNotNull(userService.getUserById(1).getLastName());
        assertNotNull(userService.getUserById(1).getEmail());

        userService.deleteUser(1);
        assertThrowsExactly(UserNotFoundException.class, () -> userService.getUserById(1));
    }

    @Test
    @DisplayName("Test UserService >> ExceptionHandling Delete User")
    void test_UserServiceExceptionHandlingDeleteUser() {
        assertThrowsExactly(UserNotFoundException.class, () -> userService.deleteUser(100));
    }
}
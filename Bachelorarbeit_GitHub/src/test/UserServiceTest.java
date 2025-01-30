package test;

import datastructures.Account;
import datastructures.User;
import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
        userService.setUsers(new ArrayList<>());
    }

    @Test
    void createUserAddsUserToList() throws UserAlreadyExistsException {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "1234567890", new Account(1, "1234567890123456", 1234, 1000.0));
        userService.createUser(user);
        assertEquals(1, userService.getUsers().size());
        assertEquals(user, userService.getUsers().get(0));
    }

    @Test
    void createUserThrowsExceptionForDuplicateId() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "1234567890", new Account(1, "1234567890123456", 1234, 1000.0));
        userService.getUsers().add(user);
        assertThrows(UserAlreadyExistsException.class, () -> userService.createUser(user));
    }

    @Test
    void getUserByIdReturnsCorrectUser() throws UserNotFoundException {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "1234567890", new Account(1, "1234567890123456", 1234, 1000.0));
        userService.getUsers().add(user);
        User foundUser = userService.getUserById(1);
        assertEquals(user, foundUser);
    }

    @Test
    void getUserByIdThrowsExceptionForNonExistingId() {
        assertThrows(UserNotFoundException.class, () -> userService.getUserById(1));
    }

    @Test
    void updateUserUpdatesUserDetails() throws UserNotFoundException {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "1234567890", new Account(1, "1234567890123456", 1234, 1000.0));
        userService.getUsers().add(user);
        userService.updateUser(1, "Jane", "Doe", "jane.doe@example.com", "0987654321", new Account(1, "1234567890123456", 1234, 2000.0));
        User updatedUser = userService.getUserById(1);
        assertEquals("Jane", updatedUser.getFirstName());
        assertEquals("jane.doe@example.com", updatedUser.getEmail());
    }

    @Test
    void deleteUserRemovesUserFromList() throws UserNotFoundException {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "1234567890", new Account(1, "1234567890123456", 1234, 1000.0));
        userService.getUsers().add(user);
        userService.deleteUser(1);
        assertTrue(userService.getUsers().isEmpty());
    }

    @Test
    void deleteUserThrowsExceptionForNonExistingId() {
        assertThrows(UserNotFoundException.class, () -> userService.deleteUser(1));
    }

    @Test
    void getLastUserIdReturnsCorrectId() {
        User user1 = new User(1, "John", "Doe", "john.doe@example.com", "1234567890", new Account(1, "1234567890123456", 1234, 1000.0));
        User user2 = new User(2, "Jane", "Doe", "jane.doe@example.com", "0987654321", new Account(2, "1234567890123457", 1234, 2000.0));
        userService.getUsers().add(user1);
        userService.getUsers().add(user2);
        assertEquals(2, userService.getLastUserId());
    }
}
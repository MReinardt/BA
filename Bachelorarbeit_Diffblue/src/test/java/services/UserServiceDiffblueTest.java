package test.java.services;

import static org.junit.jupiter.api.Assertions.assertNull;

import datastructures.Account;
import datastructures.User;
import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;

import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.UserService;

class UserServiceDiffblueTest {
    /**
     * Test {@link UserService#createUser(User)}.
     * <p>
     * Method under test: {@link UserService#createUser(User)}
     */
    @Test
    @DisplayName("Test createUser(User)")
    @Disabled("TODO: Complete this test")
    void testCreateUser() throws UserAlreadyExistsException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Collection.stream()" because "that" is null
        //       at services.UserService.createUser(UserService.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        UserService userService = new UserService();

        // Act
        userService
                .createUser(new User(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d)));
    }

    /**
     * Test {@link UserService#getUserById(int)}.
     * <p>
     * Method under test: {@link UserService#getUserById(int)}
     */
    @Test
    @DisplayName("Test getUserById(int)")
    @Disabled("TODO: Complete this test")
    void testGetUserById() throws UserNotFoundException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Collection.stream()" because "that" is null
        //       at services.UserService.getUserById(UserService.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new UserService()).getUserById(1);
    }

    /**
     * Test
     * {@link UserService#updateUser(int, String, String, String, String, Account)}.
     * <p>
     * Method under test:
     * {@link UserService#updateUser(int, String, String, String, String, Account)}
     */
    @Test
    @DisplayName("Test updateUser(int, String, String, String, String, Account)")
    @Disabled("TODO: Complete this test")
    void testUpdateUser() throws UserNotFoundException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Collection.stream()" because "that" is null
        //       at services.UserService.getUserById(UserService.java:31)
        //       at services.UserService.updateUser(UserService.java:39)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        UserService userService = new UserService();

        // Act
        userService.updateUser(1, "Jane", "Doe", "jane.doe@example.org", "6625550144", new Account(1, "42", 10, 10.0d));
    }

    /**
     * Test {@link UserService#deleteUser(int)}.
     * <p>
     * Method under test: {@link UserService#deleteUser(int)}
     */
    @Test
    @DisplayName("Test deleteUser(int)")
    @Disabled("TODO: Complete this test")
    void testDeleteUser() throws UserNotFoundException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Collection.stream()" because "that" is null
        //       at services.UserService.getUserById(UserService.java:31)
        //       at services.UserService.deleteUser(UserService.java:55)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new UserService()).deleteUser(1);
    }

    /**
     * Test {@link UserService#getLastUserId()}.
     * <p>
     * Method under test: {@link UserService#getLastUserId()}
     */
    @Test
    @DisplayName("Test getLastUserId()")
    @Disabled("TODO: Complete this test")
    void testGetLastUserId() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Collection.size()" because "that" is null
        //       at services.UserService.getLastUserId(UserService.java:62)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        (new UserService()).getLastUserId();
    }

    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link UserService#setUsers(List)}
     *   <li>{@link UserService#getUsers()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    void testGettersAndSetters() {
        // Arrange
        UserService userService = new UserService();

        // Act
        userService.setUsers(null);

        // Assert
        assertNull(userService.getUsers());
    }
}

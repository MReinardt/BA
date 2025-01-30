package services;

import datastructures.Account;
import datastructures.User;
import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;

import java.util.List;

public class UserService {
    private List<User> users;

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    // CREATE: Einen neuen User hinzufügen
    public void createUser(User user) throws UserAlreadyExistsException {
        if (users.stream().anyMatch(u -> u.getId() == user.getId())) {
            throw new UserAlreadyExistsException("User already exists with ID: " + user.getId());
        }
        users.add(user);
    }

    // READ: Einen User nach ID abrufen
    public User getUserById(int userId) throws UserNotFoundException {
        return users.stream()
                .filter(user -> user.getId() == userId)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));
    }

    // UPDATE: Daten eines Users aktualisieren
    public boolean updateUser(int userId, String firstName, String lastName, String email, String phoneNumber, Account account) throws UserNotFoundException {
        User user = getUserById(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        if(ValidationService.isEmailValid(email)) {
            user.setEmail(email);
        }
        if(ValidationService.isPhoneNumberValid(phoneNumber)) {
            user.setPhoneNumber(phoneNumber);
        }
        //user.setAccount(account);
        System.out.println("User updated: " + user);
        return true;
    }

    // DELETE: Einen User nach ID löschen
    public boolean deleteUser(int userId) throws UserNotFoundException {
        User user = getUserById(userId);
        users.remove(user);
        System.out.println("User deleted with ID: " + userId);
        return true;
    }

    public int getLastUserId() {
        return users.get(users.size() - 1).getId();
    }
}
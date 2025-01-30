package test.java.services;

import datastructures.User;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.XMLFileHandler;

class XMLFileHandlerDiffblueTest {
    /**
     * Test {@link XMLFileHandler#writeUsers(List, String)}.
     * <p>
     * Method under test: {@link XMLFileHandler#writeUsers(List, String)}
     */
    @Test
    @DisplayName("Test writeUsers(List, String)")
    @Disabled("TODO: Complete this test")
    void testWriteUsers() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        List<User> users = null;
        String filePath = "";

        // Act
        XMLFileHandler.writeUsers(users, filePath);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Test {@link XMLFileHandler#readUsers(String)}.
     * <p>
     * Method under test: {@link XMLFileHandler#readUsers(String)}
     */
    @Test
    @DisplayName("Test readUsers(String)")
    @Disabled("TODO: Complete this test")
    void testReadUsers() throws FileNotFoundException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.io.FileNotFoundException: File not found: 42order42
        //       at services.XMLFileHandler.readUsers(XMLFileHandler.java:154)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        String filePath = "";

        // Act
        List<User> actualReadUsersResult = XMLFileHandler.readUsers(filePath);

        // Assert
        // TODO: Add assertions on result
    }
}

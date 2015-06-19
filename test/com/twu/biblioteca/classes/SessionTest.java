package com.twu.biblioteca.classes;

import com.twu.biblioteca.models.User;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class SessionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void canAuthenticateUser() {
        User user = new User("1246789", "Bob Jones", "bobjones@gmail.com", "111-222-3333");
        Session.addUser(user);

        assertTrue(Session.authenticate(user.getLibraryNumber(), user.getPassword()));
    }

    @Test
    public void displayCurrentUserInformation() {
        User user = new User("1246789", "Bob Jones", "bobjones@gmail.com", "111-222-3333");
        Session.addUser(user);

        String userInfo = "User Information\n\n";
        userInfo += "Name: " + user.getName() + "\n";
        userInfo += "Email Address: " + user.getEmail() + "\n";
        userInfo += "Phone Number: " + user.getPhone() + "\n\n";

        Session.setCurrentUser(user);
        Session.showCurrentUserInformation();

        assertEquals(userInfo, outContent.toString());
    }
}
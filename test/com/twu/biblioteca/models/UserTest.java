package com.twu.biblioteca.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {


    @Test
    public void testConstructorTakesLibraryNumberPasswordNameEmailPhone() {
        String libraryNumber = "123-4567";
        String password = "123456789";
        String name = "Bob Jones";
        String email = "bobjones@gmail.com";
        String phone = "111-222-3333";

        User myUser = new User(libraryNumber, password, name, email, phone);

        assertEquals(myUser.getLibraryNumber(), libraryNumber);
        assertEquals(myUser.getPassword(), password);
        assertEquals(myUser.getName(), name);
        assertEquals(myUser.getEmail(), email);
        assertEquals(myUser.getPhone(), phone);
    }

    @Test
    public void testConstructorTakesPasswordNameEmailPhone() {
        String password = "123456789";
        String name = "Bob Jones";
        String email = "bobjones@gmail.com";
        String phone = "111-222-3333";

        User myUser = new User(password, name, email, phone);

        assertEquals(myUser.getPassword(), password);
        assertEquals(myUser.getName(), name);
        assertEquals(myUser.getEmail(), email);
        assertEquals(myUser.getPhone(), phone);
    }

    @Test
    public void testConstructorGeneratesLibraryNumber() {
        String password = "123456789";
        String name = "Bob Jones";
        String email = "bobjones@gmail.com";
        String phone = "111-222-3333";

        User myUser = new User(password, name, email, phone);

        assertTrue(myUser.getLibraryNumber().matches("[0-9]{3}-*[0-9]{4}"));
    }

}
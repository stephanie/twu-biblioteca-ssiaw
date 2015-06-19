package com.twu.biblioteca.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testConstructorTakesPasswordNameEmailPhone() {
        String password = "123456789";
        int name = "Bob Jones";
        String email = "bobjones@gmail.com";
        int phone = "111-222-3333";

        User myUser = new User(password, name, email, phone);

        assertEquals(myMovie.getPassword(), password);
        assertEquals(myMovie.getName(), name);
        assertEquals(myMovie.getEmail(), email);
        assertEquals(myMovie.getPhone(), phone);
    }

    @Test
    public void testConstructorGeneratesLibraryNumber() {
        String password = "123456789";
        int name = "Bob Jones";
        String email = "bobjones@gmail.com";
        int phone = "111-222-3333";

        User myUser = new User(password, name, email, phone);

        assertTrue(myUser.getLibraryNumber().matches("^\\d{4}$-^\\d{4}$"))
    }

}
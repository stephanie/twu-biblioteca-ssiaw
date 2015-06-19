package com.twu.biblioteca.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class SessionTest {

    @Test
    public void testConstructorTakesUserLibraryNumber() {
        String userLibraryNumber = "123456789";

        Session mySession = new Session(userLibraryNumber);

        assertEquals(mySession.getUserLibraryNumber(), userLibraryNumber);
    }

}
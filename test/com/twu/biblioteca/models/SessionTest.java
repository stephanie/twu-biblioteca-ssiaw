package com.twu.biblioteca.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class SessionTest {

    @Test
    public void testConstructorTakesUserLibraryNumber() {
        String libraryNumber = "123456789";

        Session mySession = new Session(libraryNumber);

        assertEquals(mySession.getLibraryNumber(), libraryNumber);
    }

}
package com.twu.biblioteca.classes;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class MenuTest {

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
    public void canSeeAllMenuOptions() {
        StringBuilder menuOptions = new StringBuilder();
        menuOptions.append("Please select from the options below:\n");
        menuOptions.append("1. List Available Books\n");
        menuOptions.append("2. Return Book\n");
        menuOptions.append("3. Quit\n");

        Menu.printMenuOptions();

        assertEquals(menuOptions, outContent.toString());
    }

    @Test
    public void canSelectMenuOption() {

    }

    @Test
    public void returnsErrorIfMenuOptionInvalid() {

    }

    @Test
    public void canSeeAllAvailableBooksInList() {

    }

    @Test
    public void canSeeBookDetails() {

    }

}
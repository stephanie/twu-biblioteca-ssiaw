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
    public void canSeeFullMenu() {
        String menu = "Please select from the options below:\n";
        menu += "1. List Available Books\n";
        menu += "2. Return Book\n";
        menu += "3. Quit\n";

        Menu.printOptions();

        assertEquals(menu, outContent.toString());
    }

    @Test
    public void returnsErrorIfMenuOptionInvalid() {
        String invalidOptionMessage = "Invalid option. Please select a valid option.\n";

        Menu.selectMenuOption(23);
        assertEquals(invalidOptionMessage, outContent.toString());
    }

    @Test
    public void canSelectOptionToSeeAvailableBookList() {

    }

    @Test
    public void canQuit() {

    }

}
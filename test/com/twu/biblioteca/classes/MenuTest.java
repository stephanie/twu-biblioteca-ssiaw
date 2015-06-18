package com.twu.biblioteca.classes;

import com.twu.biblioteca.models.Book;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Rule;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.lang.management.MemoryNotificationInfo;

import static org.junit.Assert.*;

public class MenuTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

//    @Rule
//    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

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
    public void canReturnAllAvailableBooks() {
        Menu.addBookToMenu("Grapes of Ruby", "Coder McGee", 1987);
        Menu.addBookToMenu("Little Java Women", "Coder McGee", 1877);
        //Menu.addBookToMenu("Who broke the code?", "Coder McGee", 2007);
        //Book.checkoutBook("Little Java Women");

        assertEquals(2, Menu.returnAvailableBooks().size());
    }

//    TODO: Get exit test working
//    @Test
//    public void canSelectOptionToExitSystem() {
//        Menu.selectMenuOption(3);
//        exit.expectSystemExitWithStatus(0);
//    }

}
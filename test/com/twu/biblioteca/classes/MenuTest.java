package com.twu.biblioteca.classes;

import com.twu.biblioteca.models.Book;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Rule;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

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
        String menu = "Main Menu\nPlease select from the options below by inputting the number:\n\n";
        menu += "1. List Available Books\n";
        menu += "2. Return Book\n";
        menu += "3. Quit\n";

        Menu.showMainMenuOptions();

        assertEquals(menu, outContent.toString());
    }

    @Test
    public void returnsErrorIfMenuOptionInvalid() {
        String invalidOptionMessage = "Invalid option. Please select a valid option.\n";
        Menu.selectMainMenuOption(23);
        assertEquals(invalidOptionMessage, outContent.toString());
    }

    @Test
    public void canSeeAllAvailableBooks() {
        Book book1 = new Book("Grapes of Ruby", "Coder McGee II", 1987);
        Book book2 = new Book("Little Java Women", "Coder McGee", 1877);
        Book book3 = new Book("Who broke the code?", "Coder McGee III", 2007);

        Menu.addBookToMenu(book1);
        Menu.addBookToMenu(book2);
        Menu.addBookToMenu(book3);

        book1.setIsCheckedOut(true);

        assertEquals(2, Menu.getAvailableBooks().size());
    }

//    TODO: Get exit test working
//    @Test
//    public void canSelectOptionToExitSystem() {
//        Menu.selectMenuOption(3);
//        exit.expectSystemExitWithStatus(0);
//    }

}
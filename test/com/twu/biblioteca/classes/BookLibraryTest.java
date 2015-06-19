package com.twu.biblioteca.classes;

import com.twu.biblioteca.models.Book;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class BookLibraryTest {

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
    public void canSeeAllAvailableBooks() {
        Book book1 = new Book("Grapes of Ruby", "Coder McGee II", 1987);
        Book book2 = new Book("Little Java Women", "Coder McGee", 1877);
        Book book3 = new Book("Who broke the code?", "Coder McGee III", 2007);

        BookLibrary.addBook(book1);
        BookLibrary.addBook(book2);
        BookLibrary.addBook(book3);

        book1.setIsCheckedOut(true);

        assertEquals(2, BookLibrary.getAvailableBooks().size());
    }

    @Test
    public void successMsgIfCanCheckoutBook() {
        Book book1 = new Book("Grapes of Ruby", "Coder McGee II", 1987);
        BookLibrary.addBook(book1);

        BookLibrary.selectBookListOption(1);
        String successCheckoutMsg = "Thank you! Enjoy the book!\n\n";

        assertEquals(successCheckoutMsg, outContent.toString());
    }

    @Test
    public void canReturnBook() {
        Book book1 = new Book("Grapes of Ruby", "Coder McGee II", 1987);
        BookLibrary.addBook(book1);

        book1.setIsCheckedOut(true);
        String name = book1.getName();

        assertTrue(BookLibrary.returnBook(name));
        assertFalse(book1.getIsCheckedOut());
    }
}
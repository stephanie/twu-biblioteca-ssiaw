package com.twu.biblioteca.classes;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.User;

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
    public void canCheckoutBook() {
        Book book1 = new Book("Grapes of Ruby", "Coder McGee II", 1987);
        BookLibrary.addBook(book1);

        BookLibrary.checkoutBook(book1);

        assertTrue(book1.getIsCheckedOut());
    }

    @Test
    public void canSeeUserLibraryNumberOfCheckedOutBook() {
        Book book1 = new Book("Grapes of Ruby", "Coder McGee II", 1987);
        BookLibrary.addBook(book1);

        User user = new User("1246789", "Bob Jones", "bobjones@gmail.com", "111-222-3333");
        Session.addUser(user);
        Session.setCurrentUser(user);

        BookLibrary.checkoutBook(book1);

        assertEquals(book1.getUserLibraryNumber(), user.getLibraryNumber());
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

    @Test
    public void userLibraryNumberOfReturnedBookisNull() {
        Book book1 = new Book("Grapes of Ruby", "Coder McGee II", 1987);
        BookLibrary.addBook(book1);

        User user = new User("1246789", "Bob Jones", "bobjones@gmail.com", "111-222-3333");
        Session.addUser(user);
        Session.setCurrentUser(user);

        BookLibrary.checkoutBook(book1);
        BookLibrary.returnBook("Grapes of Ruby");

        assertEquals(book1.getUserLibraryNumber(), null);
    }
}
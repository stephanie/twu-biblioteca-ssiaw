package com.twu.biblioteca.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testConstructorTakesNameAuthorYearPublished() {
        //TODO: remove duplication myBook construction, use mock object? Before block?
        String name = "The Great Codesby";
        String author = "Coder McGee";
        int yearPublished = 1975;

        Book myBook = new Book(name, author, yearPublished);

        assertEquals(myBook.getName(), name);
        assertEquals(myBook.getAuthor(), author);
        assertEquals(myBook.getYearPublished(), yearPublished);
    }

    @Test
    public void canCheckoutBook() {
        String name = "The Great Codesby";
        String author = "Coder McGee";
        int yearPublished = 1975;

        Book myBook = new Book(name, author, yearPublished);

        myBook.setIsCheckedOut(true);
        assertTrue(myBook.getIsCheckedOut());
    }

    @Test
    public void canReturnBook() {
        String name = "The Great Codesby";
        String author = "Coder McGee";
        int yearPublished = 1975;

        Book myBook = new Book(name, author, yearPublished);

        myBook.setIsCheckedOut(true);
        myBook.returnBook(name);

        assertFalse(myBook.getIsCheckedOut());
    }

}
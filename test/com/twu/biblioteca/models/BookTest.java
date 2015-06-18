package com.twu.biblioteca.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testConstructorTakesNameAuthorYearPublished() {
        String name = "The Great Codesby";
        String author = "Coder McGee";
        int yearPublished = 1975;

        Book myBook = new Book(name, author, yearPublished);

        assertEquals(myBook.getName(), name);
        assertEquals(myBook.getAuthor(), author);
        assertEquals(myBook.getYearPublished(), yearPublished);
    }

    @Test
    public void canSeeBookDetails() {

    }

    @Test
    public void canCheckoutBook() {

    }

    @Test
    public void cannotCheckoutBookIfAlreadyCheckedOut() {

    }

    @Test
    public void canReturnBook() {

    }
}
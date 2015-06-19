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
   public void canSetUserLibraryNumber() {
       String name = "The Great Codesby";
       int year = 2015;
       String director = "Director Coder";
       int rating = 8;
       Movie myMovie = new Movie(name, year, director, rating);

       String userLibraryNumber = "123456789";
       myMovie.setUserLibraryNumber(userLibraryNumber);

       assertEquals(myMovie.getUserLibraryNumber(), userLibraryNumber);
   }

}
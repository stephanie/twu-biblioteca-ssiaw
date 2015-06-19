package com.twu.biblioteca.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void testConstructorTakesNameYearDirectorRating() {
        String name = "The Great Codesby";
        int year = 2015;
        String director = "Director Coder";
        int rating = 8;

        Movie myMovie = new Movie(name, year, director, rating);

        assertEquals(myMovie.getName(), name);
        assertEquals(myMovie.getYear(), year);
        assertEquals(myMovie.getDirector(), director);
        assertEquals(myMovie.getRating(), rating);
    }

    @Test
    public void canCheckoutMovie() {
        String name = "The Great Codesby";
        int year = 2015;
        String director = "Director Coder";
        int rating = 8;

        Movie myMovie = new Movie(name, year, director, rating);

        myMovie.setIsCheckedOut(true);
        assertTrue(myMovie.getIsCheckedOut());
    }

    @Test
    public void canSetLibraryNumber() {
        String name = "The Great Codesby";
        int year = 2015;
        String director = "Director Coder";
        int rating = 8;

        Movie myMovie = new Movie(name, year, director, rating);

        String libraryNumber = "123456789";

        myMovie.setLibraryNumber(libraryNumber);

        assertEquals(myMovie.getLibraryNumber(), libraryNumber);
    }
    

}
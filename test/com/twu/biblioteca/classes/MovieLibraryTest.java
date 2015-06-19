package com.twu.biblioteca.classes;

import com.twu.biblioteca.models.Movie;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

public class MovieLibraryTest {

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

    public void canSeeAllAvailableMovies() {
        Movie movie1 = new Movie("Code Avengers III", 2011, "Bob Jones", 9);
        Movie movie2 = new Movie("The Hackathon", 2007, "Judge Judy", 6);
        Movie movie3 = new Movie("Into the Code", 1990, "Dee Bugger", 10);

        MovieLibrary.addMovie(movie1);
        MovieLibrary.addMovie(movie2);
        MovieLibrary.addMovie(movie3);

        movie1.setIsCheckedOut(true);

        assertEquals(2, MovieLibrary.getAvailableMovies().size());
    }

    @Test
    public void successMsgIfCanCheckoutMovie() {
        Movie movie1 = new Movie("Code Avengers III", 2011, "Bob Jones", 9);
        MovieLibrary.addMovie(movie1);

        MovieLibrary.selectMovieListOption(1);
        String successCheckoutMsg = "Thank you! Enjoy the movie!\n\n";

        assertEquals(successCheckoutMsg, outContent.toString());
    }

    @Test
    public void canReturnMovie() {
        Movie movie1 = new Movie("Code Avengers III", 2011, "Bob Jones", 9);
        MovieLibrary.addMovie(movie1);

        movie1.setIsCheckedOut(true);
        String name = movie1.getName();

        assertTrue(MovieLibrary.returnMovie(name));
        assertFalse(movie1.getIsCheckedOut());
    }

}
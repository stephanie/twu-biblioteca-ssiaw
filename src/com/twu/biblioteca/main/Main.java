package com.twu.biblioteca.main;

import com.twu.biblioteca.classes.MovieLibrary;
import com.twu.biblioteca.classes.BookLibrary;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.classes.Menu;

public class Main {

    public static void main(String[] args) {
        printWelcomeMessage();

        BookLibrary.addBook(new Book("Grapes of Ruby", "Coder McGee II", 1987));
        BookLibrary.addBook(new Book("Little Java Women", "Coder McGee", 1877));
        BookLibrary.addBook(new Book("Who broke the code?", "Coder McGee III", 2007));

        MovieLibrary.addMovie(new Movie("Code Avengers III", 2011, "Bob Jones", 9));
        MovieLibrary.addMovie(new Movie("The Hackathon", 2007, "Judge Judy", 6));
        MovieLibrary.addMovie(new Movie("Into the Code", 1990, "Dee Bugger", 10));

        Menu.addMainOptions();
        Menu.showMainOptions(); Menu.getUserMainOptionSelection();
    }

    public static void printWelcomeMessage(){
        System.out.println("Welcome to Biblioteca! Loading library...\n");
    }
}

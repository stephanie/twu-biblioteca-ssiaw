package com.twu.biblioteca.main;

import com.twu.biblioteca.classes.MovieLibrary;
import com.twu.biblioteca.classes.BookLibrary;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.User;
import com.twu.biblioteca.classes.Session;

public class Main {

    public static void main(String[] args) {
        printWelcomeMessage();

        BookLibrary.addBook(new Book("Grapes of Ruby", "Coder McGee II", 1987));
        BookLibrary.addBook(new Book("Little Java Women", "Coder McGee", 1877));
        BookLibrary.addBook(new Book("Who broke the code?", "Coder McGee III", 2007));

        MovieLibrary.addMovie(new Movie("Code Avengers III", 2011, "Bob Jones", 9));
        MovieLibrary.addMovie(new Movie("The Hackathon", 2007, "Judge Judy", 6));
        MovieLibrary.addMovie(new Movie("Into the Code", 1990, "Dee Bugger", 10));

        Session.addUser(new User("1246789", "Bob Jones", "bobjones@gmail.com", "111-222-3333"));
        Session.addUser(new User("1246789", "Sally Cheng", "sallycheng@gmail.com", "131-232-3333"));

        Session.login();
    }

    public static void printWelcomeMessage(){
        System.out.println("Welcome to Biblioteca! Loading library...\n");
    }
}

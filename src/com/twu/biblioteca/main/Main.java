package com.twu.biblioteca.main;

import com.twu.biblioteca.classes.Library;
import com.twu.biblioteca.classes.Menu;
import com.twu.biblioteca.models.Book;

public class Main {

    public static void main(String[] args) {
        printWelcomeMessage();

        Library.addBook(new Book("Grapes of Ruby", "Coder McGee II", 1987));
        Library.addBook(new Book("Little Java Women", "Coder McGee", 1877));
        Library.addBook(new Book("Who broke the code?", "Coder McGee III", 2007));

        Menu.addMainOptions();
        Menu.mainOptionsAndUserSelection();

    }

    public static void printWelcomeMessage(){
        System.out.println("Welcome to Biblioteca! Loading library...\n");
    }
}

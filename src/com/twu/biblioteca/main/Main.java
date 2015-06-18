package com.twu.biblioteca.main;

import com.twu.biblioteca.classes.Menu;
import com.twu.biblioteca.models.Book;

public class Main {

    public static void main(String[] args) {
        printWelcomeMessage();

        Menu.addBookToMenu(new Book("Grapes of Ruby", "Coder McGee II", 1987));
        Menu.addBookToMenu(new Book("Little Java Women", "Coder McGee", 1877));
        Menu.addBookToMenu(new Book("Who broke the code?", "Coder McGee III", 2007));

        Menu.addMainMenuOptions();

        Menu.showMainMenuOptions();

    }

    public static void printWelcomeMessage(){
        System.out.println("Welcome to Biblioteca! Loading library...\n");
    }
}

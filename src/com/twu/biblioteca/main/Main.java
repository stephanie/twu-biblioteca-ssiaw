package com.twu.biblioteca.main;

import com.twu.biblioteca.classes.Menu;

public class Main {

    public static void main(String[] args) {
        printWelcomeMessage();
        Menu.printOptions();
    }

    public static void printWelcomeMessage(){
        System.out.println("Welcome to Biblioteca!");
    }
}

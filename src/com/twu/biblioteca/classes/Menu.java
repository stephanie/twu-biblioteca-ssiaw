package com.twu.biblioteca.classes;

import com.twu.biblioteca.models.Book;
import java.util.ArrayList;

public class Menu {

    public static ArrayList<String> menuOptions = new ArrayList<String> ();
    private static ArrayList<Book> books = new ArrayList<Book>();

    public static void addOptions(){
        menuOptions.add("List Available Books");
        menuOptions.add("Return Book");
        menuOptions.add("Quit");
    }

    public static void printOptions(){
        String menu = "Please select from the options below:";
        addOptions();
        for(String option : menuOptions){
            String menuOption = "\n" + (menuOptions.indexOf(option)+1) + ". " + option;
            menu += menuOption;
        }

        System.out.println(menu);
    }

    public static void invalidOptionMessage() {
        System.out.println("Invalid option. Please select a valid option.");
    }

    public static void selectMenuOption(int optionNumber) {
        try {
            if (optionNumber <= 0 || optionNumber > menuOptions.size()) {
                invalidOptionMessage();
            } else {

                //TODO: Find another more flexible method to switch menu options later
                switch (optionNumber) {
                    case 1:
                        //printBookListMenuOption();
                        break;
                    case 2:
                        //returnBookMenuOption();
                        break;
                    case 3:
                        System.out.println("Thank you for using Biblioteca! Exiting system...");
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            invalidOptionMessage();
        }
    }

    public static void addBookToMenu(String name, String author, int yearPublished) {
        Book book = new Book(name, author, yearPublished);
        Menu.books.add(book);
    }

    public static ArrayList<Book> returnAvailableBooks() {
        return books;
    }

}

package com.twu.biblioteca.classes;

import com.twu.biblioteca.models.Book;
import java.util.ArrayList;

import java.util.Scanner;

public class Menu {

    public static ArrayList<String> menuOptions = new ArrayList<String> ();
    private static ArrayList<Book> books = new ArrayList<Book>();

    public static void addMainMenuOptions(){
        menuOptions.add("List Available Books");
        menuOptions.add("Return Book");
        menuOptions.add("Quit");
    }

    public static void showMainMenuOptions(){
        String menu = "Main Menu\nPlease select from the options below by inputting the number:\n";

        for(String option : menuOptions){
            String menuOption = "\n" + (menuOptions.indexOf(option)+1) + ". " + option;
            menu += menuOption;
        }

        System.out.println(menu);

        Scanner scan = new Scanner(System.in);
        int userMenuOptionSelection = scan.nextInt();

        selectMainMenuOption(userMenuOptionSelection);
    }

    public static void invalidOptionMessage() {
        System.out.println("Invalid option. Please select a valid option.");
        showMainMenuOptions();
    }

    public static void selectMainMenuOption(int optionNumber) {
        try {
            if (optionNumber <= 0 || optionNumber > menuOptions.size()) {
                invalidOptionMessage();
            } else {

                //TODO: Find another more flexible method to switch menu options later
                switch (optionNumber) {
                    case 1:
                        showAvailableBookList();
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

    public static void addBookToMenu(Book book) {
        Menu.books.add(book);
    }

    public static ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> availableBookList = new ArrayList<Book>();
        for(Book book : books) {
            if (!book.getIsCheckedOut()) {
                availableBookList.add(book);
            }
        }
        return availableBookList;
    }

    public static void showAvailableBookList(){
        String bookList = "Books Available\nCheckout a book below by inputting the number:\n";

        ArrayList<Book> availableBooks = getAvailableBooks();

        for(Book book : availableBooks){
            int index = availableBooks.indexOf(book)+1;
            String name = book.getName();
            String author = book.getAuthor();
            int yearPublished = book.getYearPublished();

            String bookEntry = "\n" + index + ". " + name + ", " + author + ", " + yearPublished;
            bookList += bookEntry;
        }

        bookList += "\n" + (availableBooks.size()+1) + ". Return to Main Menu";

        System.out.println(bookList);

        Scanner scan = new Scanner(System.in);
        int userMenuOptionSelection = scan.nextInt();

        selectBookListOption(userMenuOptionSelection);
    }


    public static void selectBookListOption(int optionNumber) {
        try {

            ArrayList<Book> availableBooks = getAvailableBooks();

            if (optionNumber <= 0 || optionNumber > availableBooks.size() + 1) {
                invalidOptionMessage();
            } else if (optionNumber > 0 && optionNumber <= availableBooks.size()) {
                int bookIndex = optionNumber - 1;
                Book selectedBook = availableBooks.get(bookIndex);
                selectedBook.setIsCheckedOut(true);
                showAvailableBookList();
            } else if (optionNumber == availableBooks.size() + 1) {
                showMainMenuOptions();
            }
        } catch (Exception e) {
            invalidOptionMessage();
        }
    }

}

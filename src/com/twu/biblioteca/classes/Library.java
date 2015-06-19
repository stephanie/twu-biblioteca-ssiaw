package com.twu.biblioteca.classes;

import com.twu.biblioteca.models.Book;
import java.util.ArrayList;

import java.util.Scanner;

public class Library {

    public static ArrayList<Book> books = new ArrayList<Book>();

    public static void addBook(Book book) {
        Library.books.add(book);
    }

    public static ArrayList<Book> getAvailableBooks() {
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        for(Book book : books) {
            if (!book.getIsCheckedOut()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public static void showAvailableBookList() {
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
    }

    public static void getUserBookSelection() {
        Scanner scan = new Scanner(System.in);
        int userSelection = scan.nextInt();

        selectBookListOption(userSelection);
    }

    public static void availableBookListAndUserSelection() {
        showAvailableBookList();
        getUserBookSelection();
    }

    public static void selectBookListOption(int optionNumber) {
        ArrayList<Book> availableBooks = getAvailableBooks();

        try {
            if (optionNumber <= 0 || optionNumber > availableBooks.size() + 1) {
                Menu.invalidOptionMessage();
                availableBookListAndUserSelection();

            //Checkout book
            } else if (optionNumber > 0 && optionNumber <= availableBooks.size()) {
                int bookIndex = optionNumber - 1;
                Book selectedBook = availableBooks.get(bookIndex);
                selectedBook.setIsCheckedOut(true);
                System.out.println("Thank you! Enjoy the book!\n");
                availableBookListAndUserSelection();
                
            //Return to main menu
            } else if (optionNumber == availableBooks.size() + 1) {
                Menu.mainOptionsAndUserSelection();
            }
        } catch (Exception e) {
            Menu.invalidOptionMessage();
            availableBookListAndUserSelection();
        }
    }

    public static boolean returnBook(String name) {
        boolean bookFound = false;
        for(Book book : books) {
            if (book.getName().equals(name) && book.getIsCheckedOut()) {
                book.setIsCheckedOut(false);
                bookFound = true;
                break;
            }
        }
        return bookFound;
    }

    public static void printReturnBookMessages(boolean success) {
        if (success) {
            System.out.println("Thank you for returning the book.\n");
            Menu.mainOptionsAndUserSelection();
        } else {
            System.out.println("That is not a valid book to return. Please try again.\n");
            returnBookOptionAndUserInput();
        }
    }

    public static void returnBookOptionAndUserInput() {
        returnBookMenuOption();
        getUserReturnBookInput();
    }

    public static void returnBookMenuOption(){
        System.out.println("Return Book\nReturn your book by inputting its name:");
    }

    public static void getUserReturnBookInput() {
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();

        printReturnBookMessages(returnBook(userInput));
    }

}

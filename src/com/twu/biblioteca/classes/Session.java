package com.twu.biblioteca.classes;

import com.twu.biblioteca.models.User;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import java.util.ArrayList;

import java.util.Scanner;

public class Session {

    public static ArrayList<User> users = new ArrayList<User>();
    public static User currentUser = null; 
    private static Scanner scan = new Scanner(System.in);

    public static void addUser(User user) {
        Session.users.add(user);
    }

    public static boolean authenticate(String libraryNumber, String password) {
        for (User user : users) {
            if (user.getLibraryNumber().equals(libraryNumber) && user.getPassword().equals(password)) {
                setCurrentUser(user);
                return true;
            }
        }
        return false;
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void showCurrentUserInformation() {
        String userInfo = "User Information\n\n";
        userInfo += "Name: " + currentUser.getName() + "\n";
        userInfo += "Email Address: " + currentUser.getEmail() + "\n";
        userInfo += "Phone Number: " + currentUser.getPhone() + "\n";

//      TODO: Get book and movie checkout list to work
//        String checkedOutBooks = "Books checked out:\n";
//        for (Book book : BookLibrary.books) {
//            if (book.getUserLibraryNumber().equals(currentUser.getLibraryNumber())) {
//                checkedOutBooks += "\n" + book.getName() + ", " + book.getAuthor() + ", " + book.getYearPublished() + "\n";
//            }
//        }
//
//        String checkedOutMovies = "Movies checked out:\n";
//        for (Movie movie : MovieLibrary.movies) {
//            if (movie.getUserLibraryNumber().equals(currentUser.getLibraryNumber())) {
//                checkedOutMovies += movie.getName() + ", " + movie.getYear() + ", " + movie.getDirector() + ", Rating: " + movie.getRating() + "\n";
//            }
//        }
//
//        userInfo += checkedOutBooks += checkedOutMovies;

        System.out.println(userInfo);
    }

    public static void checkUserInputToReturnToMainMenu() {
        System.out.println("Press q to return to Main Menu...");
        String userInput = scan.nextLine();

        if (userInput.equals("q")) {
            Menu.showMainOptions();
            Menu.getUserMainOptionSelection();
        }
    }

    public static String getUserLibraryNumberInput() {
        System.out.print("Input library number: ");
        return scan.nextLine();
    }

    public static String getUserPasswordInput() {
        System.out.print("Input password: ");
        return scan.nextLine();
    }

    public static void login() {
        System.out.print("Please login to continue.\n\n");

        if (authenticate(getUserLibraryNumberInput(), getUserPasswordInput())) {
            System.out.println("Login success!\n");
            Menu.addMainOptions();
            Menu.showMainOptions(); 
            Menu.getUserMainOptionSelection();
        } else {
            System.out.println("Login incorrect! Please try again.\n");
            login();
        }
    }

}

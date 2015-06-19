package com.twu.biblioteca.classes;

import java.util.ArrayList;

import java.util.Scanner;

public class Menu {

    public static ArrayList<String> mainOptions = new ArrayList<String> ();
    private static Scanner scan = new Scanner(System.in);

    public static void addMainOptions() {
        mainOptions.add("List Available Books");
        mainOptions.add("Return Book");
        mainOptions.add("List Available Movies");
        mainOptions.add("Return Movie");
        mainOptions.add("User Information");
        mainOptions.add("Logout");
    }

    public static void showMainOptions() {
        String menu = "Main Menu\nPlease select from the options below by inputting the number:\n";

        for(String option : mainOptions){
            String menuOption = "\n" + (mainOptions.indexOf(option)+1) + ". " + option;
            menu += menuOption;
        }

        System.out.println(menu);
    }

    public static void getUserMainOptionSelection() {
        int userSelection = scan.nextInt();
        selectMainOption(userSelection);
    }

    public static void invalidOptionMessage() {
        System.out.println("Invalid option. Please select a valid option.\n");
    }

    public static void selectMainOption(int optionNumber) {
        try {
            if (optionNumber <= 0 || optionNumber > mainOptions.size()) {
                invalidOptionMessage();
                showMainOptions(); getUserMainOptionSelection();

            } else {
                //TODO: Find another more flexible method to switch menu options later
                switch (optionNumber) {
                    case 1:
                        BookLibrary.showAvailableBookList(); BookLibrary.getUserBookSelection();
                        break;
                    case 2:
                        BookLibrary.returnBookMenuOption(); BookLibrary.getUserReturnBookInput();
                        break;
                    case 3:
                        MovieLibrary.showAvailableMovieList(); MovieLibrary.getUserMovieSelection();
                        break;
                    case 4:
                        MovieLibrary.returnMovieMenuOption(); MovieLibrary.getUserReturnMovieInput();
                        break;
                    case 5:
                        Session.showCurrentUserInformation();
                        Session.checkUserInputToReturnToMainMenu();
                        break;
                    case 6:
                        System.out.println("Thank you for using Biblioteca! Exiting system...");
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            invalidOptionMessage();
            showMainOptions(); getUserMainOptionSelection();

        }
    }

}

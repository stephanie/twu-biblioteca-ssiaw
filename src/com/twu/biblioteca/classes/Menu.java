package com.twu.biblioteca.classes;

import java.util.ArrayList;

import java.util.Scanner;

public class Menu {

    public static ArrayList<String> mainOptions = new ArrayList<String> ();

    public static void addMainOptions() {
        mainOptions.add("List Available Books");
        mainOptions.add("Return Book");
        mainOptions.add("Quit");
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
        Scanner scan = new Scanner(System.in);
        int userSelection = scan.nextInt();

        selectMainOption(userSelection);
    }

    public static void mainOptionsAndUserSelection() {
        showMainOptions();
        getUserMainOptionSelection();
    }

    public static void invalidOptionMessage() {
        System.out.println("Invalid option. Please select a valid option.\n");
        mainOptionsAndUserSelection();
    }

    public static void selectMainOption(int optionNumber) {
        try {
            if (optionNumber <= 0 || optionNumber > mainOptions.size()) {
                invalidOptionMessage();
            } else {

                //TODO: Find another more flexible method to switch menu options later
                switch (optionNumber) {
                    case 1:
                        Library.availableBookListAndUserSelection();
                        break;
                    case 2:
                        Library.returnBookOptionAndUserInput();
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

}

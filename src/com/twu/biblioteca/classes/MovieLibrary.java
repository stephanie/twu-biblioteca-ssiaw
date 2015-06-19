package com.twu.biblioteca.classes;

import com.twu.biblioteca.models.Movie;
import java.util.ArrayList;

import java.util.Scanner;

public class MovieLibrary {

    public static ArrayList<Movie> movies = new ArrayList<Movie>();

    public static void addMovie(Movie movie) {
        MovieLibrary.movies.add(movie);
    }

    public static ArrayList<Movie> getAvailableMovies() {
        ArrayList<Movie> availableMovies = new ArrayList<Movie>();
        for(Movie movie : movies) {
            if (!movie.getIsCheckedOut()) {
                availableMovies.add(movie);
            }
        }
        return availableMovies;
    }

    public static void showAvailableMovieList() {
        String movieList = "Movies Available\nCheckout a movie below by inputting the number:\n";

        ArrayList<Movie> availableMovies = getAvailableMovies();

        for(Movie movie : availableMovies){
            int index = availableMovies.indexOf(movie)+1;
            String name = movie.getName();
            int year = movie.getYear();
            String director = movie.getDirector();
            int rating = movie.getRating();

            String movieEntry = "\n" + index + ". " + name + ", " + year + ", " + director + ", Rating: " + rating;
            movieList += movieEntry;
        }

        movieList += "\n" + (availableMovies.size()+1) + ". Return to Main Menu";

        System.out.println(movieList);
    }

    public static void getUserMovieSelection() {
        Scanner scan = new Scanner(System.in);
        int userSelection = scan.nextInt();

        selectMovieListOption(userSelection);
    }


    public static void checkoutMovie(Movie selectedMovie) {
        selectedMovie.setIsCheckedOut(true);
        System.out.println("Thank you! Enjoy the movie!\n");
    }

    public static void selectMovieListOption(int optionNumber) {
        ArrayList<Movie> availableMovies = getAvailableMovies();

        try {
            if (optionNumber <= 0 || optionNumber > availableMovies.size() + 1) {
                Menu.invalidOptionMessage();
                showAvailableMovieList(); getUserMovieSelection();

            //Checkout movie
            } else if (optionNumber > 0 && optionNumber <= availableMovies.size()) {
                int movieIndex = optionNumber - 1;
                Movie selectedMovie = availableMovies.get(movieIndex);
                checkoutMovie(selectedMovie);
                showAvailableMovieList(); getUserMovieSelection();
                
            //Return to main menu
            } else if (optionNumber == availableMovies.size() + 1) {
                Menu.showMainOptions(); Menu.getUserMainOptionSelection();
            }
        } catch (Exception e) {
            Menu.invalidOptionMessage();
            showAvailableMovieList(); getUserMovieSelection();
        }
    }

    public static boolean returnMovie(String name) {
        boolean movieFound = false;
        for(Movie movie : movies) {
            if (movie.getName().equals(name) && movie.getIsCheckedOut()) {
                movie.setIsCheckedOut(false);
                movieFound = true;
                break;
            }
        }
        return movieFound;
    }

    public static void printReturnMovieMessages(boolean success) {
        if (success) {
            System.out.println("Thank you for returning the movie.\n");
            Menu.showMainOptions(); Menu.getUserMainOptionSelection();
        } else {
            System.out.println("That is not a valid movie to return. Please try again.\n");
            returnMovieMenuOption(); getUserReturnMovieInput();
        }
    }

    public static void returnMovieMenuOption(){
        System.out.println("Return Movie\nReturn your movie by inputting its name:");
    }

    public static void getUserReturnMovieInput() {
        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();

        printReturnMovieMessages(returnMovie(userInput));
    }

}

package com.twu.biblioteca.models;

public class Movie {
    private String name;
    private int year;
    private String director;
    private int rating;
    private boolean isCheckedOut;
    private String userLibraryNumber;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.isCheckedOut = false;
        this.userLibraryNumber = null;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    //TODO: Add validation that rating is between 1-10
    public int getRating() {
        return rating;
    }

    public void setIsCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public void setUserLibraryNumber(String userLibraryNumber) {
        this.userLibraryNumber = userLibraryNumber;
    }

    public String getUserLibraryNumber() {
        return userLibraryNumber;
    }

}

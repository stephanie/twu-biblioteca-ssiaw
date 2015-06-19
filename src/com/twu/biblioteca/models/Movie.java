package com.twu.biblioteca.models;

public class Movie {
    private String name;
    private int year;
    private String director;
    private int rating;
    private boolean isCheckedOut;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.isCheckedOut = false;
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

    public int getRating() {
        return rating;
    }

    public void setIsCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

}

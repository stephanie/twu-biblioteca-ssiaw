package com.twu.biblioteca.models;

public class Book {
    private String name;
    private String author;
    private int yearPublished;
    private boolean isCheckedOut;
    private String userLibraryNumber;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isCheckedOut = false;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
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

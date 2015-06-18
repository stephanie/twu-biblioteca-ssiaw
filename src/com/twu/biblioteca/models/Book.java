package com.twu.biblioteca.models;

public class Book {
    private String name;
    private String author;
    private int yearPublished;
    private boolean isCheckedOut;

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
        System.out.println("Thank you! Enjoy the book!\n");
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

}

package com.twu.biblioteca.models;

public class Session {
    private String userLibraryNumber;

    public Session(String userLibraryNumber) {
        this.userLibraryNumber = userLibraryNumber;
    }

    public String getUserLibraryNumber() {
        return userLibraryNumber;
    }

}

package com.twu.biblioteca.models;

import java.util.Random;

public class User {
    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String phone;

    public User(String password, String name, String email, String phone) {
        this.libraryNumber = generateLibraryNumber();
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public static String generateLibraryNumber() {
        Random rnd = new Random();

        return generateString(rnd, "123456789", 3) + "-" + generateString(rnd, "123456789", 4);
    }

    public static String generateString(Random rnd, String characters, int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rnd.nextInt(characters.length()));
        }
        return new String(text);
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

}

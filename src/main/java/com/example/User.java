package com.example;

public class User {

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isCorrectPassword(String password) {
        return this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }
}

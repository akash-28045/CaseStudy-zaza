package com.zaza.model;

public abstract class User {
    private final int userId;
    private final String username;
    private final long contactNo;

    public User(int userId, String username, long contactNo) {
        this.userId = userId;
        this.username = username;
        this.contactNo = contactNo;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public long getContactNo() {
        return contactNo;
    }

    @Override
    public String toString() {
        return String.format("User[ID: %d, Name: %s, Contact: %d]", userId, username, contactNo);
    }
}

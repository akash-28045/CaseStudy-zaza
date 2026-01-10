package com.zaza.model;

public class Customer extends User {
    private final Cart cart;

    public Customer(int userId, String username, long contactNo) {
        super(userId, username, contactNo);
        this.cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    @Override
    public String toString() {
        return String.format("Customer[%s, Contact: %d]", getUsername(), getContactNo());
    }
}

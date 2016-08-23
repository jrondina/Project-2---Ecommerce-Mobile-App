package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jamesrondina on 7/28/16.
 */
public class Cart {

    ArrayList<Item> cart;

    private static Cart ourInstance = new Cart();

    public static Cart getInstance() {
        if (ourInstance == null) {
            ourInstance = new Cart();
        }
        return ourInstance;
    }

    private Cart() {
        this.cart = new ArrayList<Item>();
    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public void addItem(Item item) {
        cart.add(item);
    }

    public void removeItem(Item item) {
        cart.remove(item);
    }

    public void clearCart() {
        cart.clear();
    }
}

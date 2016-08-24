package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import com.example.jamesrondina.project_2___ecommerce_mobile_app.models.Item;

import java.util.ArrayList;

/**
 * Created by jamesrondina on 7/28/16.
 */
public class Cart {

    ArrayList<Item> cartList;

    private static Cart ourInstance = new Cart();

    public static Cart getInstance() {
        if (ourInstance == null) {
            ourInstance = new Cart();
        }
        return ourInstance;
    }

    private Cart() {
        this.cartList = new ArrayList<Item>();
    }

    public ArrayList<Item> getCart() {
        return cartList;
    }

    public void addItem(Item item) {
        cartList.add(item);
    }

    public void removeItem(Item item) {
        cartList.remove(item);
    }

    public void clearCart() {
        cartList.clear();
    }
}

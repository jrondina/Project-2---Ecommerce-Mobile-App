package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import com.example.jamesrondina.project_2___ecommerce_mobile_app.models.Item;

import java.util.ArrayList;

/**
 * Created by jamesrondina on 7/29/16.
 */

public class ShopItems {

    ArrayList<Item> mItems;

    private static ShopItems shopInstance = new ShopItems();

    public static ShopItems getInstance() {
        if (shopInstance == null) {
            shopInstance = new ShopItems();
        }
        return shopInstance;
    }
}

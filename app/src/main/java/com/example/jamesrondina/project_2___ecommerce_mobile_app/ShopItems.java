package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import java.util.List;

/**
 * Created by jamesrondina on 7/29/16.
 */

public class ShopItems {

    List<Item> mItems;

    private static ShopItems shopInstance = new ShopItems();


    public static ShopItems getInstance() {
        if (shopInstance == null) {
            shopInstance = new ShopItems();
        }
        return shopInstance;
    }




}

package com.example.jamesrondina.project_2___ecommerce_mobile_app;

/**
 * Created by jamesrondina on 7/28/16.

 This class is for the object that goes into the cart

 */


public class Item {

    String mName;
    int mPrice;

    public Item(String mName, String mDesc, int mPrice) {
        this.mName = mName;
        this.mPrice = mPrice;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }
}

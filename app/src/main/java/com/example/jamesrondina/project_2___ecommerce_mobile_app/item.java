package com.example.jamesrondina.project_2___ecommerce_mobile_app;

/**
 * Created by jamesrondina on 7/28/16.
 */
public class item {

    String mName;
    int mPrice;

    public item(String mName, String mDesc, int mPrice) {
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
package com.example.jamesrondina.project_2___ecommerce_mobile_app.models;

/**
 * Created by jamesrondina on 7/28/16.

 This is an item object, it can go in the cart or the shop

 */


public abstract class Item {

    private String mName, mDesc;
    private int mPrice, mPic;

    public Item(String mName, String mDesc, int mPrice, int mPic) {
        this.mName = mName;
        this.mDesc = mDesc;
        this.mPrice = mPrice;
        this.mPic = mPic;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public int getmPic() {
        return mPic;
    }

    public void setmPic(int mPic) {
        this.mPic = mPic;
    }
}

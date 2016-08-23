package com.example.jamesrondina.project_2___ecommerce_mobile_app;

/**
 * Created by jamesrondina on 7/28/16.

 This is an item object, it can go in the cart or the shop

 */


public class Item {

    String mName;
    String mDesc;
    int mPic;
    int mPrice;
    int mQuantity;

    public Item(String name, String desc, int price, int pic, int qty) {
        this.mName = name;
        this.mDesc = desc;
        this.mPrice = price;
        this.mPrice = pic;
        this.mQuantity = qty;
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

    public int getmPic() {
        return mPic;
    }

    public void setmPic(int mPic) {
        this.mPic = mPic;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public int getmQuantity() {
        return mQuantity;
    }

    public void setmQuantity(int mQuantity) {
        this.mQuantity = mQuantity;
    }
}

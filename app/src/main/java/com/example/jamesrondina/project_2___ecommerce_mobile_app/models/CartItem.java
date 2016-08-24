package com.example.jamesrondina.project_2___ecommerce_mobile_app.models;

/**
 * Created by jamesrondina on 8/23/16.
 */
public class CartItem extends Item {

    private String mName, mDesc;
    private int mPrice, mQty, mPic;

    public CartItem(String mName, String mDesc, int mPrice, int mPic,
                    String mName1, String mDesc1, int mPrice1, int mQty, int mPic1) {
        super(mName, mDesc, mPrice, mPic);
        mName = mName1;
        mDesc = mDesc1;
        mPrice = mPrice1;
        this.mQty = mQty;
        mPic = mPic1;
    }

    @Override
    public String getmName() {
        return mName;
    }

    @Override
    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public String getmDesc() {
        return mDesc;
    }

    @Override
    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    @Override
    public int getmPrice() {
        return mPrice;
    }

    @Override
    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public int getmQty() {
        return mQty;
    }

    public void setmQty(int mQty) {
        this.mQty = mQty;
    }

    @Override
    public int getmPic() {
        return mPic;
    }

    @Override
    public void setmPic(int mPic) {
        this.mPic = mPic;
    }
}

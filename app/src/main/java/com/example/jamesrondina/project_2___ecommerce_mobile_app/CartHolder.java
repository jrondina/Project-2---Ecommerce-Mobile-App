package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.media.Image;
import android.support.annotation.StringDef;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jamesrondina on 7/29/16.
 */
public class CartHolder extends RecyclerView.ViewHolder {

    TextView mName, mPrice;
    ImageView mPic;
    EditText mQty;


    public CartHolder(View itemView) {
        super(itemView);

        mName = (TextView) itemView.findViewById(R.id.cartItemName);
        mPrice = (TextView) itemView.findViewById(R.id.cartItemPrice);
        mPic = (ImageView) itemView.findViewById(R.id.cartItemPic);
        mQty = (EditText) itemView.findViewById(R.id.cartEditQuantity);

    }

    public void setCartItemName(String name){
        mName.setText(name);
    }

    public void setCartItemPrice(int price){
        mPrice.setText(String.valueOf(price));
    }

    public void setCartItemPic(int resID) {
        mPic.setImageResource(resID);
    }

}

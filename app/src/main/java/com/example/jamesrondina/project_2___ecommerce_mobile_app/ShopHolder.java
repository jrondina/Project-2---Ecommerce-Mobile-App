package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jamesrondina on 7/28/16.
 */

public class ShopHolder extends RecyclerView.ViewHolder {

    ImageView mPic;
    TextView mName, mPrice;

    public ShopHolder(View itemView) {
        super(itemView);

        mPic = (ImageView) itemView.findViewById(R.id.itemPic);
        mName = (TextView) itemView.findViewById(R.id.itemName);
        mPrice = (TextView) itemView.findViewById(R.id.itemPrice);
    }

    public void setItemPic(int resId) {
        mPic.setImageResource(resId);
    }

    public void setItemName(String name) {
        mName.setText(name);
    }

    public void setItemPrice(int price) {
        mPrice.setText(String.valueOf(price));
    }
}
package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jamesrondina on 7/29/16.
 */
public class CartHolder extends RecyclerView.ViewHolder {

    TextView mName;
    TextView mPrice;


    public CartHolder(View itemView) {
        super(itemView);

        mName = (TextView) itemView.findViewById(R.id.cart_itemName);
        mPrice = (TextView) itemView.findViewById(R.id.cart_itemPrice);

    }
}

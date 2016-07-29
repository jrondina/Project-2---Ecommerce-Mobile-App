package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jamesrondina on 7/27/16.
 */
public class itemHolder {

    ImageView mItemPic;
    TextView mItemName;
    TextView mItemPrice;

    public itemHolder(View itemView) {

        mItemPic = (ImageView) itemView.findViewById(R.id.itemPic);
        mItemName = (TextView) itemView.findViewById(R.id.itemName);
        mItemPrice = (TextView) itemView.findViewById(R.id.itemPrice);
    }

}

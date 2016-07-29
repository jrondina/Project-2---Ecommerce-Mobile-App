package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jamesrondina on 7/28/16.
 */

public class itemsHolder extends RecyclerView.ViewHolder {

    View mView;
    TextView mitemName;
    TextView mitemPrice;

    public itemsHolder(View view) {
        super(view);
        mView = view;
    }
}
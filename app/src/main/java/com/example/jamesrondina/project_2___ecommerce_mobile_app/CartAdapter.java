package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jamesrondina on 7/28/16.
 */
public class CartAdapter extends RecyclerView.Adapter<CartHolder> {

    List<Item> mCartItems;

    public CartAdapter(List<Item> items){
        this.mCartItems = items;
    }

    @Override
    public CartHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View parentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items,
                parent, false);

        CartHolder cartHolder = new CartHolder(parentView);

        return cartHolder;

    }

    @Override
    public void onBindViewHolder(CartHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

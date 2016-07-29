package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jamesrondina on 7/28/16.
 */



public class itemAdapter extends RecyclerView.Adapter<itemHolder> {

    List<Item> mItems;

    public itemAdapter(List<Item> mItems) {
        this.mItems = mItems;
    }

    @Override
    public itemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View parentView = inflater.inflate(R.layout.cart_items, parent, false);

        itemHolder viewHolder = new itemHolder(parentView);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(itemHolder holder, int position) {
        final int pos = position;
        final Item item = mItems.get(pos);
        holder.mItemName.setText(item.getmName());
        holder.mItemPrice.setText(item.getmPrice());


    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}

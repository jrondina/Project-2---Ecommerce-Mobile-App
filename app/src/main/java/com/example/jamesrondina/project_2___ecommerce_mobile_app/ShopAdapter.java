package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jamesrondina.project_2___ecommerce_mobile_app.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jamesrondina on 7/28/16.
 */
public class ShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_HEADER = 0;
    private static final int VIEW_NORMAL = 1;

    View headerView;
    View gridItem;
    Cart cart;
    private int datasetSize;
    List<Item> shopItems;

    //Set up Header on top of shop
    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    public ShopAdapter(int size) {
        this.datasetSize = size;
    }

    public void setHeader(View view) {
        this.headerView = view;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? VIEW_HEADER : VIEW_NORMAL;
    }

    @Override
    public int getItemCount() {
        return datasetSize + 1;
    }

    //checks if element is a header or an item in order to show the appropriate layout
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_HEADER) {
            return new HeaderViewHolder(headerView);

        } else {
            gridItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout, parent, false);
            return new ShopHolder(gridItem);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        if (position == 0) return;

        //Item item = shopItems.get(position);

        ShopHolder holder = (ShopHolder) viewHolder;

        //TODO: setup attributes of item, either switch case here or make helper method
        /*holder.setItemPic(item.getmPic());
        holder.setItemName(item.getmName());
        holder.setItemPrice(item.getmPrice());*/

        //TODO: clicklistener to launch details dialog
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Launch Details Dialog", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                //launchItemDetail(item, view).show();
            }
        });


    }

    /*
    private AlertDialog launchItemDetail(final Item item, View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

        LayoutInflater inflater = LayoutInflater.from(view.getContext());
        final View dialogView = inflater.inflate(R.layout.dialog, null);

        builder.setView(dialogView)
                .setTitle("Item Details")
                .setPositiveButton("Add to Cart", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(dialogView.getRootView().getContext(),
                                item.getmName() + " added to Cart!", Toast.LENGTH_SHORT).show();

                        cart.addItem(item);

                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        return builder.create();
    }
    */

}


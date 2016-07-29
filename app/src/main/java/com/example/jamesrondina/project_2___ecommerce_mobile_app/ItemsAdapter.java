package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by jamesrondina on 7/28/16.
 */
public class ItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_HEADER = 0;
    private static final int VIEW_NORMAL = 1;

    View headerView;
    View gridItem;
    Cart cart;
    private int datasetSize;

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    public ItemsAdapter(int size) {
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

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_HEADER) {
            return new HeaderViewHolder(headerView);

        } else {
            gridItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout, parent, false);
            return new itemsHolder(gridItem);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        if (position == 0) return;

        itemsHolder holder = (itemsHolder) viewHolder;

        //TODO: setup attributes of item, either switch case here or make helper method

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

    private int getDrawableValue(String icon){
        switch(icon){
            case "20 Pokeballs":
                return android.R.drawable.ic_menu_search;
            case "100 Pokeballs":
                return android.R.drawable.ic_menu_add;
            case "200 Pokeballs":
                return android.R.drawable.ic_menu_upload;
            case "Incense":
                return android.R.drawable.ic_media_play;
            default:
                return 0;
        }
    }
}



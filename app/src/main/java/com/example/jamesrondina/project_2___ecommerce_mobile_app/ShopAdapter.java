package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jamesrondina.project_2___ecommerce_mobile_app.models.Item;

import java.util.List;

/**
 * Created by jamesrondina on 7/28/16.
 */
public class ShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_HEADER = 0;
    private static final int VIEW_NORMAL = 1;

    View headerView;
    View gridItem;
    private int datasetSize;
    List<Item> shopItems;

    //Set up Header on top of shop
    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    public ShopAdapter(int size, List<Item> itemList) {
        this.datasetSize = size;
        shopItems = itemList;
    }

    public void setDatasetSize(int datasetSize) {
        this.datasetSize = datasetSize;
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
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int position) {

        if (position == 0) return;

        ShopHolder holder = (ShopHolder) viewHolder;
        try{
            Item currentItem = shopItems.get(position - 1);

            holder.setItemPic(currentItem.getmPic());
            holder.setItemName(currentItem.getmName());
            holder.setItemPrice(currentItem.getmPrice());
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();

        }



        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Launch Details Dialog", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                DetailsDialog dialog = new DetailsDialog();

                dialog.launchItemDetail(view.getContext(), position, shopItems);

            }
        });


    }

}



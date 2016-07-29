package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jamesrondina on 7/28/16.
 */
public class ItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_HEADER = 0;
    private static final int VIEW_NORMAL = 1;

    View headerView;
    View gridItem;
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

    }
}



package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jamesrondina.project_2___ecommerce_mobile_app.models.CartItem;
import com.example.jamesrondina.project_2___ecommerce_mobile_app.models.Item;

import java.util.List;

/**
 * Created by jamesrondina on 7/28/16.
 */
public class CartAdapter extends RecyclerView.Adapter<CartHolder> {

    List<CartItem> mCartItems;

    public CartAdapter(List<CartItem> items){
        this.mCartItems = Cart.getInstance().getCart();
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

        //fill out appropriate item data

        CartItem currentItem = mCartItems.get(position);
        holder.setCartItemPic(currentItem.getmPic());
        holder.setCartItemName(currentItem.getmName());
        holder.setCartItemPrice(currentItem.getmPrice());

    }

    @Override
    public int getItemCount() {
        return mCartItems.size();
    }
}

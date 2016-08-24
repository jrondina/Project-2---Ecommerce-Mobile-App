package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jamesrondina.project_2___ecommerce_mobile_app.models.CartItem;
import com.example.jamesrondina.project_2___ecommerce_mobile_app.models.Item;

import java.util.List;

/**
 * Created by jamesrondina on 7/28/16.
 */
public class CartAdapter extends RecyclerView.Adapter<CartHolder> {

    List<CartItem> mCartItems;
    ImageButton delete;

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
    public void onBindViewHolder(final CartHolder holder, int position) {

        //fill out appropriate item data

        final CartItem currentItem = mCartItems.get(position);
        holder.setCartItemPic(currentItem.getmPic());
        holder.setCartItemName(currentItem.getmName());
        holder.setCartItemPrice(currentItem.getmPrice());

        //delete item

        delete = (ImageButton) holder.itemView.findViewById(R.id.remove);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCartItems.remove(currentItem);
                Toast.makeText(view.getContext(), "Item Removed", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();

            }
        };
        delete.setOnClickListener(listener);




    }

    @Override
    public int getItemCount() {
        return mCartItems.size();
    }
}

package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by jamesrondina on 7/28/16.
 */
public class CartActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    Cart mCart;
    itemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        //TODO: adapter for items in cart
        adapter = new itemAdapter(mCart.getCart());
        mRecyclerView.setAdapter(adapter);

        Button checkout = (Button) findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //buy items, and empty the cart
                Toast.makeText(CartActivity.this, "You bought the stuff!", Toast.LENGTH_SHORT).show();
                mCart.clearCart();
            }
        });
    }

}

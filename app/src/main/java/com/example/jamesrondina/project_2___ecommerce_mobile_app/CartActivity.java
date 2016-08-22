package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by jamesrondina on 7/28/16.
 */
public class CartActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    Cart mCart;

    Button mClear, mCheckout;

    itemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        mCart = Cart.getInstance();

        mClear = (Button) findViewById(R.id.clear);
        mCheckout = (Button) findViewById(R.id.checkout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.clear:
                        mCart.clearCart();
                        Toast.makeText(CartActivity.this, "Cart cleared", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.checkout:
                        //subtract quantity from inventory
                        //subtract money from wallet/account
                        mCart.clearCart();
                        Toast.makeText(CartActivity.this, "Items purchased!", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }

            }
        };

        mClear.setOnClickListener(listener);
        mCheckout.setOnClickListener(listener);


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);


        adapter = new itemAdapter(mCart.getCart());
        mRecyclerView.setAdapter(adapter);




    }

}

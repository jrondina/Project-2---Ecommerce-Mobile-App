package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jamesrondina.project_2___ecommerce_mobile_app.models.CartItem;

/**
 * Created by jamesrondina on 7/28/16.
 */
public class CartActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    Cart mCart;

    Button mClear, mCheckout, mBack;

    CartAdapter adapter;

    private int gold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        final Intent intent = getIntent();
        gold = intent.getIntExtra("wallet",1000);

        mCart = Cart.getInstance();

        mClear = (Button) findViewById(R.id.clear);
        mCheckout = (Button) findViewById(R.id.checkout);
        mBack = (Button) findViewById(R.id.Back);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.Back:
                        //back to the shop with updated wallet
                        final Intent returnIntent = new Intent();
                        returnIntent.putExtra("wallet",gold);
                        setResult(RESULT_OK, returnIntent);
                        finish();
                        break;
                    case R.id.clear:
                        mCart.clearCart();
                        Toast.makeText(CartActivity.this, "Cart cleared", Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.checkout:
                        //subtract money from wallet/account
                        int checkoutTotal = 0;
                        for (CartItem item:Cart.getInstance().getCart()
                             ) {
                            checkoutTotal += item.getmPrice();
                        }

                        //check that you have enough money, then notify data is changed to update cart

                        if(gold > checkoutTotal ) {
                            gold -= gold;
                            mCart.clearCart();
                            Toast.makeText(CartActivity.this, "Items purchased!", Toast.LENGTH_SHORT).show();
                            adapter.notifyDataSetChanged();
                        }
                        else{
                            Toast.makeText(CartActivity.this, "Need more money!", Toast.LENGTH_SHORT).show();
                        }
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


        adapter = new CartAdapter(mCart.getCart());
        mRecyclerView.setAdapter(adapter);




    }

}

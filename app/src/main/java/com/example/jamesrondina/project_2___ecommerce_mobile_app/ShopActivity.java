package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jamesrondina.project_2___ecommerce_mobile_app.models.Item;

import java.util.List;


public class ShopActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private View header;
    private int columns = 3;
    public List<Item> itemList;

    private TextView walletText;
    private int gold = 1000;

    private EditText searchEdit;
    public String searchQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        //set up gridLayout

        final GridLayoutManager grid = new GridLayoutManager(this, 3);
        grid.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position == 0 ? columns : 1;
            }
        });

        recyclerView.setLayoutManager(grid);

        //set up header
        header = LayoutInflater.from(this).inflate(R.layout.shoptop, recyclerView, false);
        walletText = (TextView) header.findViewById(R.id.shopwallet);
        walletText.setText(String.valueOf(gold));
        searchEdit = (EditText) header.findViewById(R.id.search);
        searchQuery = searchEdit.getText().toString();

        //set up items adapter

        ShopAdapter shopAdapter = new ShopAdapter(12); //TODO: change int to get number of items in list
        shopAdapter.setHeader(header);
        recyclerView.setAdapter(shopAdapter);

        //TODO: set up alert dialog for Item details

        //set up floating action button for shopping cart
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Launch Shopping Cart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                intent.putExtra("wallet",gold);
                startActivity(intent);
            }
        });


    }

}

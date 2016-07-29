package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    View header;
    int columns = 3;

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

        //set up items adapter

        ItemsAdapter itemsAdapter = new ItemsAdapter(12); //TODO: change int to get number of items in list
                                                          //cursor.getCount()
        itemsAdapter.setHeader(header);

        recyclerView.setAdapter(itemsAdapter);

        //TODO: set up alert dialog for Item details

        //set up floating action button for shopping cart
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Launch Shopping Cart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                //TODO: Launch shopping cart
                Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(intent);
            }
        });


    }

}

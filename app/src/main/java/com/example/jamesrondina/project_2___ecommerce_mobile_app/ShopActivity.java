package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jamesrondina.project_2___ecommerce_mobile_app.models.Item;

import java.util.ArrayList;
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

        DBHelper helper = DBHelper.getInstance(this);

        /*TODO: TEST CODE
        Cursor cursor = helper.getItemList();

        Log.i("DATABASE", "onCreate: " + cursor.getCount());

        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            Log.d("DBDEBUG", "DB result " + cursor.getString(0)+" "+cursor.getString(1));

            cursor.moveToNext();
        }

        cursor.close();
        END TEST CODE*/

        //TODO: build list of items to show by getting from dbhelper
        itemList = new ArrayList<Item>();
        debugList();

        //TODO: search changes the list of items by inserting query string into query and builds a new list


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

        ShopAdapter shopAdapter = new ShopAdapter(itemList.size(), itemList); //TODO: change int to get number of items in list
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
                startActivityForResult(intent,0);
            }
        });


    }

    public void debugList() {
        Item pokeball20 = new Item("pokeball","throw it", 100, R.mipmap.pokeballs20);
        Item pokeball100 = new Item("pokeball100","throw it", 400, R.mipmap.pokeballs100);
        Item pokeball200 = new Item("pokeball200","throw it 100", 800, R.mipmap.pokeballs200);
        Item incense = new Item("incense","use this",100, R.mipmap.incense);
        Item incense8 = new Item("8 incense","use this",100, R.mipmap.incense8);
        Item incense25 = new Item("25 incense","use this",100, R.mipmap.incense25);
        Item luckyegg = new Item("luckegg","use this",100, R.mipmap.luckyegg);
        Item luckyegg8 = new Item("8 Lucky Egg","use this",100, R.mipmap.luckyeggs8);
        Item luckyegg25 = new Item("25 Lucky Egg","use this",100, R.mipmap.luckyeggs25);
        Item lure = new Item("incense","use this",100, R.mipmap.luremodule);
        Item lure8 = new Item("incense","use this",100, R.mipmap.luremodules8);
        Item incub = new Item("Incubator","hatch eggs",500,R.mipmap.eggincubator);

        itemList.add(pokeball20);
        itemList.add(pokeball100);
        itemList.add(pokeball200);
        itemList.add(incense);
        itemList.add(incense8);
        itemList.add(incense25);
        itemList.add(luckyegg);
        itemList.add(luckyegg8);
        itemList.add(luckyegg25);
        itemList.add(lure);
        itemList.add(lure8);
        itemList.add(incub);
    }

    public void dbGrab(){

    }

}

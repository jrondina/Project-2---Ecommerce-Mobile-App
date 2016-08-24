package com.example.jamesrondina.project_2___ecommerce_mobile_app;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
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

        //TODO: build list of items to show by getting from dbhelper
        itemList = new ArrayList<Item>();
        debugList();
        searchQuery = "*";
        //itemList = helper.getShopListFromDB(searchQuery);

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

        searchEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //get query from edit text and then query database to filter results
                searchQuery = searchEdit.getText().toString();

                //TODO: db query

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

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

    //for debugging only, comment out at the top later

    public void debugList() {
        Item pokeball20 = new Item("20 Pokeballs","throw it", 100, R.mipmap.pokeballs20);
        Item pokeball100 = new Item("100 Pokeball","throw it", 400, R.mipmap.pokeballs100);
        Item pokeball200 = new Item("200 Pokeball","throw it 100", 800, R.mipmap.pokeballs200);
        Item incense = new Item("Incense","use this to attract pokemon",100, R.mipmap.incense);
        Item incense8 = new Item("8 incense","use this to attract pokemon",300, R.mipmap.incense8);
        Item incense25 = new Item("25 incense","use this to attract pokemon",900, R.mipmap.incense25);
        Item luckyegg = new Item("Lucky Egg","use this",100, R.mipmap.luckyegg);
        Item luckyegg8 = new Item("8 Lucky Egg","use this",600, R.mipmap.luckyeggs8);
        Item luckyegg25 = new Item("25 Lucky Egg","use this",1900, R.mipmap.luckyeggs25);
        Item lure = new Item("Lure Module","use this on pokestops",100, R.mipmap.luremodule);
        Item lure8 = new Item("8 Lures","use this on pokestops",100, R.mipmap.luremodules8);
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

}

package com.example.jamesrondina.project_2___ecommerce_mobile_app;

/**
 * Created by jamesrondina on 7/28/16.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jamesrondina.project_2___ecommerce_mobile_app.models.Item;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    
    private static final String TAG = DBHelper.class.getCanonicalName();

    private static final int DATABASE_VERSION = 9;
    public static final String DATABASE_NAME = "shop.db";
    public static final String ITEM_LIST_TABLE_NAME = "ITEM_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_ITEM_DESC = "ITEM_DESC";
    public static final String COL_ITEM_PRICE = "ITEM_PRICE";
    public static final String COL_ITEM_USE = "ITEM_TYPE";
    public static final String COL_ITEM_CONSUMABLE = "ITEM_CONSUMABLE";
    public static final String COL_ITEM_PIC = "ITEM_PIC";


    public static final String[] ITEM_COLUMNS =
            {COL_ID,COL_ITEM_NAME,COL_ITEM_DESC,COL_ITEM_PRICE,COL_ITEM_USE,COL_ITEM_CONSUMABLE,COL_ITEM_PIC};

    private static final String CREATE_ITEM_LIST_TABLE =
            "CREATE TABLE " + ITEM_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_ITEM_NAME + " TEXT " +
                    COL_ITEM_DESC + " TEXT " +
                    COL_ITEM_PRICE + " INT" +
                    COL_ITEM_USE + " TEXT " +
                    COL_ITEM_CONSUMABLE + " INT " +
                    COL_ITEM_PIC + " INT )";

    private static DBHelper instance;

    public static DBHelper getInstance(Context context){
        if(instance == null){
            instance = new DBHelper(context);
        }
        return instance;
    }

    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_ITEM_LIST_TABLE);
        buildTable(db); //putting values in table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ITEM_LIST_TABLE_NAME);
        this.onCreate(db);
    }

    public Cursor getItemList(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ITEM_LIST_TABLE_NAME, // a. table
                ITEM_COLUMNS, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }

    private void buildTable(SQLiteDatabase db) {

        //entering data into table
        String[] names = new String[]{"20 Pokeballs", "100 Pokeballs", "200 Pokeballs",
                "Incense", "8 Incense", "25 Incense", "Lucky Egg", "8 Lucky Eggs", "25 Lucky Eggs",
                "Lure Module", "8 Lure Modules", "Egg Incubator"};

        String[] descs = new String[]{"Balls for catching Pokemon", "100 Balls for catching Pokemon",
                "100 of balls for catching Pokemon", "Use to attract Pokemon", "Use to attract Pokemon",
                "Use to double EXP", "Use to double EXP", "Use to double EXP", "Use on Pokestop to attract Pokemon",
                "Use on Pokestop to attract Pokemon", "Use to hatch eggs by walking"};

        int[] prices = new int[]{100, 460, 800, 80, 500, 1250, 80, 500, 1250, 100, 680, 150};

        String[] uses = new String[]{"Catch", "Catch", "Catch", "Bait", "Bait", "Bait", "EXP", "EXP",
        "EXP", "Bait", "Bait", "Hatch"};

        int[] consume = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0};

        int[] pics = new int[]{R.mipmap.pokeballs20, R.mipmap.pokeballs100, R.mipmap.pokeballs200, R.mipmap.incense,
                R.mipmap.incense8, R.mipmap.incense25, R.mipmap.luckyegg, R.mipmap.luckyeggs8, R.mipmap.luckyeggs25,
                R.mipmap.luremodule, R.mipmap.luremodules8, R.mipmap.eggincubator};

        //db.execSQL("CREATE TABLE IF NOT EXISTS ITEM_LIST (name VARCHAR, desc VARCHAR, price VARCHAR, price VARCHAR, use VARCHAR, consume VARCHAR, pic VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + ITEM_LIST_TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_ITEM_NAME + " TEXT " +
                COL_ITEM_DESC + " TEXT " +
                COL_ITEM_PRICE + " INT" +
                COL_ITEM_USE + " TEXT " +
                COL_ITEM_CONSUMABLE + " INT " +
                COL_ITEM_PIC + " INT )");


        for (int i = 0; i < names.length; i++) {
            db.execSQL("INSERT INTO ITEM_LIST Values ('" + names[i] + "', '" + descs[i] + "', '" + prices[i] +
                    "', '" + uses[i] + "', '" + consume[i] + "', '" + pics[i] + "');");
        }
    }

    public List<Item> getShopListFromDB(String query){
        //Go through database, create an Item for each row, place in list

        List<Item> shopList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        //searchquery checks name, desc and use, thus fulfilling the at least 3 product criteria requirement
        String searchQuery = "SELECT * FROM " +
                ITEM_LIST_TABLE_NAME + "WHERE " + COL_ITEM_NAME + " LIKE " + "%" + query + "%" +
                " OR " + "WHERE " + COL_ITEM_DESC + " LIKE " + "%" + query + "%" +
                " OR " + "WHERE " + COL_ITEM_USE + " LIKE " + "%" + query + "%";
        Cursor cursor = db.rawQuery(searchQuery, null);

        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()) {
                Item item = new Item("Name","Desc",0,R.mipmap.pokeballs20);
                dbItemAttributes(cursor,item);

                cursor.moveToNext();

            }
            cursor.close();
        }

        return shopList;

    }

    private void dbItemAttributes(Cursor cursor, Item item){

        //sets item attributes for item taken from db to be put into list for use in the ShopAdapter

        item.setmName(cursor.getString(cursor.getColumnIndex(COL_ITEM_NAME)));
        item.setmDesc(cursor.getString(cursor.getColumnIndex(COL_ITEM_DESC)));
        item.setmPrice(cursor.getInt(cursor.getColumnIndex(COL_ITEM_PRICE)));
        item.setmPic(cursor.getInt(cursor.getColumnIndex(COL_ITEM_PIC)));
    }

}

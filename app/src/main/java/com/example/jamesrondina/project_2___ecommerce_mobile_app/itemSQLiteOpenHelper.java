package com.example.jamesrondina.project_2___ecommerce_mobile_app;

/**
 * Created by jamesrondina on 7/28/16.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ItemSQLiteOpenHelper extends SQLiteOpenHelper {
    
    private static final String TAG = ItemSQLiteOpenHelper.class.getCanonicalName();

    private static final int DATABASE_VERSION = 9;
    public static final String DATABASE_NAME = "shop.db";
    public static final String ITEM_LIST_TABLE_NAME = "ITEM_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_ITEM_DESC = "ITEM_DESC";
    public static final String COL_ITEM_PRICE ="ITEM_PRICE";

    public static final String[] ITEM_COLUMNS = {COL_ID,COL_ITEM_NAME,COL_ITEM_DESC,COL_ITEM_PRICE};

    private static final String CREATE_ITEM_LIST_TABLE =
            "CREATE TABLE " + ITEM_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_ITEM_NAME + " TEXT " +
                    COL_ITEM_DESC + " TEXT " +
                    COL_ITEM_PRICE + " INT )";


    private static ItemSQLiteOpenHelper instance;

    public static ItemSQLiteOpenHelper getInstance(Context context){
        if(instance == null){
            instance = new ItemSQLiteOpenHelper(context);
        }
        return instance;
    }

    private ItemSQLiteOpenHelper(Context context) {
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

        String[] names = new String[]{"20 Pokeballs", "100 Pokeballs", "200 Pokeballs",
                "Incense", "8 Incense", "25 Incense", "Lucky Egg", "8 Lucky Eggs", "25 Lucky Eggs",
                "Lure Module", "8 Lure Modules", "Egg Incubator"};

        String[] descs = new String[]{"Balls for catching Pokemon", "More Balls for catching Pokemon",
                "A lot of balls for catching Pokemon", "Use to attract Pokemon", "Use to attract Pokemon",
                "Use to double EXP", "Use to double EXP", "Use to double EXP", "Use on Pokestop to attract Pokemon",
                "Use on Pokestop to attract Pokemon", "Use to hatch eggs by walking"};

        int[] prices = new int[]{100, 460, 800, 80, 500, 1250, 80, 500, 1250, 100, 680, 150};
        db.execSQL("CREATE TABLE IF NOT EXISTS ITEM_LIST (name VARCHAR, desc VARCHAR, price VARCHAR);");
        for (int i = 0; i < names.length; i++) {
            db.execSQL("INSERT INTO ITEM_LIST Values ('" + names[i] + "', '" + descs[i] + "', '" + prices[i] + "');");

        }
    }
}

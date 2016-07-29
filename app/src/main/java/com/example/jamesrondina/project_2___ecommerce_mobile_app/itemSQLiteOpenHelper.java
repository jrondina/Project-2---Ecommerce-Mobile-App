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
    public static final String DATABASE_NAME = "TEST_DB";
    public static final String ITEM_LIST_TABLE_NAME = "ITEM_LIST";

    public static final String COL_ID = "_id";
    public static final String COL_ITEM_NAME = "ITEM_NAME";
    public static final String COL_ITEM_QUANT = "ITEM_QUANT";

    public static final String[] ITEM_COLUMNS = {COL_ID,COL_ITEM_NAME};

    private static final String CREATE_ITEM_LIST_TABLE =
            "CREATE TABLE " + ITEM_LIST_TABLE_NAME +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_ITEM_NAME + " TEXT " +
                    COL_ITEM_QUANT + " INT )";


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
}

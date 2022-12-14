package com.example.boutique;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {
    //Declaration :
    private Context context;
    private static final String DATABASE_NAME = "ShooseBag.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "my_bag";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SHOOSENAME = "shoose_name";
    private static final String COLUMN_SHOOSEPRICE = "shoose_price";
    private static final String COLUMN_SHOOSEIMAGE = "shoose_image";


    public MyDataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String DBC = "CREATE TABLE " + TABLE_NAME +
                " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SHOOSENAME + " TEXT, " + COLUMN_SHOOSEPRICE + " TEXT, " + COLUMN_SHOOSEIMAGE + " INTEGER)";
        db.execSQL(DBC);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);
    }
    void addtobag(String shoosename,String shooseprice,int shooseimage){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_SHOOSENAME,shoosename);
        cv.put(COLUMN_SHOOSEPRICE,shooseprice);
        cv.put(COLUMN_SHOOSEIMAGE,shooseimage);

        long result = db.insert(TABLE_NAME,null,cv);
        if(result == -1){
            Toast.makeText(context,"FAILED TO INSERT DATA!",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context,"SUCCESSFULL INSERTION",Toast.LENGTH_LONG).show();
        }


    }
    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null ;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME," shoose_name=? ",new String[]{row_id});
        if(result == -1){
            Toast.makeText(context,"FAILED TO DELETE !",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context,"SUCCESSFULLY DELETED !",Toast.LENGTH_LONG).show();
        }
    }
    void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+ TABLE_NAME);
    }

}

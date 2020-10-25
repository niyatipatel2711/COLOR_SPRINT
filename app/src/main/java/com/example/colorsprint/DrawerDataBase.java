package com.example.colorsprint;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DrawerDataBase extends SQLiteOpenHelper{

    String Db_name = "ColorData",Tab_name="Colors";

    public DrawerDataBase(Context context) {
        super(context,"ColorData",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+Tab_name+"(COLOR INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+Tab_name);
    }

    public void insertColor(int color){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("COLOR",color);
        db.insert(Tab_name,null,contentValues);
    }

    public Cursor getColorData(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+Tab_name,null);
        return cursor;
    }

}

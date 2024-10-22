package com.example.mycontacts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    public static final String dbName = "contact.db";
    public static final int version = 1;

    public static final String tblName = "tblContact";
    public static final String id = "id";
    public static final String imgID = "imageID";
    public static final String Name = "name";
    public static final String Phone = "phone";

    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + tblName + " ( " + id + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                imgID + " INTEGER," + Name + " Text," + Phone + " Text);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + tblName);
        onCreate(db);
    }


}

package com.example.cafeterita;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("create table bebidas (code int primary key, name text, price int)");
        BaseDeDatos.execSQL("create table comidas (code int primary key, name text, price int)");
        BaseDeDatos.execSQL("create table snacks (code int primary key, name text, price int)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getAllItems(String tableName) {
        SQLiteDatabase BaseDeDatos = this.getReadableDatabase();
        return BaseDeDatos.rawQuery("SELECT * FROM " + tableName, null);
    }
}

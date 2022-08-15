package com.example.bike_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
  public static final String DATABASE_NAME = "BicycleShop.db";
  public static final String TABLE_NAME = "Bicycles";
    public static final String COL_1 = "Brand";
    public static final String COL_2 = "Model";
    public static final String COL_3 = "Category";
    public static final String COL_4 = "Price";
  
  
  public DatabaseHelper(Context context){
    super(context, DATABASE_NAME, null, 1);
  }
  
  

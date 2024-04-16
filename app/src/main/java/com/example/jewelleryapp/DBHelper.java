package com.example.jewelleryapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "jewellery_user_data.db";
    private static final String TABLE_NAME = "user_info";

    private static final String USER_NAME = "name";
    private static final String USER_PHONE = "phone";
    private static final String USER_PASSWORD = "password";
    private static final int DATABASE_VERSION = 1;


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_table = "CREATE TABLE user_info(phone text primary key,name text,password text)";
        db.execSQL(create_table);
        Log.d("TAG", "onCreate: "+"table_created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user_info ");
    }
    public void addData(String phone,String name,String password){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues cv = new ContentValues();


        cv.put(USER_PHONE,phone);
        cv.put(USER_NAME,name);
        cv.put(USER_PASSWORD,password);

        database.insert(TABLE_NAME,null,cv);
    }
    @SuppressLint("Range")
    public String fetch_password(String phone){
        if (phone == null) {
            // Handle the case where the input parameter is null
            return "";
        }
        SQLiteDatabase database = this.getReadableDatabase();

        String Q = "SELECT * FROM user_info WHERE phone = ?";

        String[] selectionArgs = { phone };


        @SuppressLint("Recycle") Cursor cursor=database.rawQuery(Q,selectionArgs);

        String val = ""; // Initialize password variable

        if (cursor != null && cursor.moveToFirst()) {
            val = cursor.getString(cursor.getColumnIndex("password"));
            cursor.close(); // Close the cursor after retrieving data
        } else {
            // Cursor is empty, handle this case (e.g., show an error message)
            return "";
        }
        return val;
    }
}
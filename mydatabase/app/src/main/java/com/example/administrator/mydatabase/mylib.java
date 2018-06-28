package com.example.administrator.mydatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class mylib {

    static void myopen(Context c,MainActivity m){
        m.path = "/data/data/"+ c.getPackageName()+"/youaremonkey.db";
        m.mydb = SQLiteDatabase.openOrCreateDatabase(m.path,null);
        Toast.makeText(c, "HIHI", Toast.LENGTH_SHORT).show();
    }

    static void mycreatetable(Context c,MainActivity m){
        m.sql ="CREATE TABLE IF NOT EXISTS " + m.table_name +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, email TEXT);";
        m.mydb.execSQL(m.sql);
        Toast.makeText(c, "baba", Toast.LENGTH_SHORT).show();
    }

    static void add(Context c,MainActivity m){
        Toast.makeText(c, "HIHIH", Toast.LENGTH_SHORT).show();
        m.table_name = "nnnnnm";
    }
}

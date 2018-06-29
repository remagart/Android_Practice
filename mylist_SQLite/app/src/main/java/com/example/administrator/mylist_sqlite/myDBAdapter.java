package com.example.administrator.mylist_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class myDBAdapter {
    final static String KEY_MYNAME = "name";
    final static String KEY_MYID = "_id";
    final static String KEY_MYTEL = "tel";
    final static String KEY_MYEMAIL = "email";
    final static String KEY_MYDBNAME = "youaremonkey";
    final static String KEY_MYTABLE = "mytable";

    myDBhelper mmyDBhelper;
    SQLiteDatabase myDBSQLite;
    Context my_Context;
    ContentValues my_values;

    myDBAdapter(Context c){
        my_Context = c;
        open();
    }

    void open(){
        mmyDBhelper = new myDBhelper(my_Context);
        myDBSQLite = mmyDBhelper.getWritableDatabase();
    }
    void close(){
        if(mmyDBhelper!=null){
            mmyDBhelper.close();
        }
    }







}

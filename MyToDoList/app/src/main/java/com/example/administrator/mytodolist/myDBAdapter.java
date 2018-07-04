package com.example.administrator.mytodolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class myDBAdapter {
    final static String KEY_myname_of_table = "thisisToDoListTable";
    final static String KEY_myid = "_id";
    final static String KEY_mydate = "date";
    final static String KEY_mytitle = "title";
    final static String KEY_mycontent = "content";

    SQLiteDatabase mySQLiteDB;
    myDBHelper mmyDBHelper;
    Context mycontext;
    ContentValues myvalies;

    myDBAdapter(Context c){
        mycontext = c;
        open();
    }

    public void open(){
        mmyDBHelper = new myDBHelper(mycontext);
        mySQLiteDB = mmyDBHelper.getWritableDatabase();
    }
    public void close(){
        if(mmyDBHelper != null){
            mySQLiteDB.close();
        }
    }


}

package com.example.administrator.mytodolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDBHelper extends SQLiteOpenHelper{
//myToDoList_v6:要加static才能被建構子call
    final static String KEY_myname_of_DB = "thisisToDoListDB";
    final static String KEY_myname_of_table = "thisisToDoListTable";
    final static String KEY_myid = "_id";
    final static String KEY_mydate = "date";
    final static String KEY_mytitle = "title";
    final static String KEY_mycontent = "content";
    final static int DBversion = 1;

    myDBHelper(Context c){
        super(c,KEY_myname_of_DB,null,DBversion);
    }

    public myDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + KEY_myname_of_table
                + " ( "
                + KEY_myid
                + " INTEGER PRIMARY KEY NOT NULL, "
                + KEY_mytitle
                + " , "
                + KEY_mydate
                + " DATETIME NOT NULL, "
                + KEY_mycontent
                + ")"
                ;
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTs " + KEY_myname_of_table;
        db.execSQL(sql);
        onCreate(db);
    }
}

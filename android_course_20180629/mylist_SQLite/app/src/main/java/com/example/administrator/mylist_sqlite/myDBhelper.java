package com.example.administrator.mylist_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class myDBhelper extends SQLiteOpenHelper {

    final static String KEY_MYNAME = "name";
    final static String KEY_MYID = "_id";
    final static String KEY_MYTEL = "tel";
    final static String KEY_MYEMAIL = "email";
    final static String KEY_MYDBNAME = "youaremonkey2";
    final static String KEY_MYTABLE = "mytable2";
    final static int KEY_MYDBVERSION = 1;

    public myDBhelper(Context context){
        super(context, KEY_MYDBNAME, null, KEY_MYDBVERSION);
    }

    public myDBhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String MYTABLE_CREATE;
        MYTABLE_CREATE = "CREATE TABLE IF NOT EXISTS "+KEY_MYTABLE
                + " ("
                + KEY_MYID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_MYNAME + ","
                + KEY_MYTEL + ","
                + KEY_MYEMAIL + ");";
        db.execSQL(MYTABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF exists "+KEY_MYTABLE);
        onCreate(db);
    }
}

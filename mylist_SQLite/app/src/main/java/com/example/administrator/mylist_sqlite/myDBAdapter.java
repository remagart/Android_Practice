package com.example.administrator.mylist_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class myDBAdapter {
    final static String KEY_MYNAME = "name";
    final static String KEY_MYID = "_id";
    final static String KEY_MYTEL = "tel";
    final static String KEY_MYEMAIL = "email";
    final static String KEY_MYDBNAME = "youaremonkey2";
    final static String KEY_MYTABLE = "mytable2";

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

    Cursor makecursor(){
        String[] columns = new String[]{KEY_MYID,KEY_MYNAME,KEY_MYTEL,KEY_MYEMAIL};
        Cursor mycursor;
        mycursor = myDBSQLite.query(KEY_MYTABLE,columns,null,null,null,null,null);
        if(mycursor != null){
            mycursor.moveToFirst();
        }
        return mycursor;

    }

    long add(String temp_name,String temp_tel,String temp_email){
        my_values = new ContentValues();
        my_values.put(KEY_MYNAME,temp_name);
        my_values.put(KEY_MYTEL,temp_tel);
        my_values.put(KEY_MYEMAIL,temp_email);

        return myDBSQLite.insert(KEY_MYTABLE,null,my_values);
    }

    Cursor querybyid(int myid){
        String[] columns = new String[]{KEY_MYID,KEY_MYNAME,KEY_MYTEL,KEY_MYEMAIL};
        Cursor mycursor;
        mycursor = myDBSQLite.query(
                KEY_MYTABLE,
                columns,
                KEY_MYID +" == "+ myid,
                null,
                null,
                null,
                null
        );
        if(mycursor != null){
            mycursor.moveToFirst();
        }
        return mycursor;
    }





}

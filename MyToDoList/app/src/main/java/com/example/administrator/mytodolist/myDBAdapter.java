package com.example.administrator.mytodolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class myDBAdapter {
    final static String KEY_myname_of_table = "thisisToDoListTable";
    final static String KEY_myid = "_id";
    final static String KEY_mydate = "date";
    final static String KEY_mytitle = "title";
    final static String KEY_mycontent = "content";

    String[] columns;

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
        columns = new String[]{KEY_myid,KEY_mytitle,KEY_mydate,KEY_mycontent};
    }
    public void close(){
        if(mmyDBHelper != null){
            mySQLiteDB.close();
        }
    }
//MyToDoList_v9:製造查詢後的結果得到Cursor物件
    Cursor makecursor(){
        Cursor mycursor;
        mycursor = mySQLiteDB.query(KEY_myname_of_table,
                                    columns,
                                    null,
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

    long add(String title,String content,String date){
        myvalies = new ContentValues();
        myvalies.put(KEY_mytitle,title);
        myvalies.put(KEY_mycontent,content);
        myvalies.put(KEY_mydate,date);

        return mySQLiteDB.insert(KEY_myname_of_table,null,myvalies);
    }
    Cursor querybyid(int id){
        Cursor mycursor = mySQLiteDB.query(KEY_myname_of_table,
                                            columns,
                                            KEY_myid + " == " + id,
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

    long update(String title,String content,String date,int id){
        myvalies = new ContentValues();
        myvalies.put(KEY_mytitle,title);
        myvalies.put(KEY_mycontent,content);
        myvalies.put(KEY_mydate,date);
        return mySQLiteDB.update(KEY_myname_of_table,
                                 myvalies,
                                 KEY_myid + " == " + id,
                                 null
                                );
    }
    long delete(int id){

        return mySQLiteDB.delete(KEY_myname_of_table,
                                KEY_myid + " == " + id,
                                null
                                );
    }

}

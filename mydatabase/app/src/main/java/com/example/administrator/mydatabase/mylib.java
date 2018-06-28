package com.example.administrator.mydatabase;

import android.content.Context;
import android.database.Cursor;
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
        String name,tel,email;
        name = m.editName.getText().toString();
        tel = m.editTel.getText().toString();
        email = m.editEmail.getText().toString();

        m.sql = "INSERT INTO "+m.table_name+"(name, phone, email)VALUES(?,?,?)";
        m.mydb.execSQL(m.sql,new Object[]{name,tel,email});
        Toast.makeText(c, "新增成功", Toast.LENGTH_SHORT).show();
        m.editName.setText("");
        m.editTel.setText("");
        m.editEmail.setText("");
    }

    static void search(Context c,MainActivity m){
        String query;
        int id;
        query = m.editQuery.getText().toString();
        m.sql = "SELECT * FROM " + m.table_name + " where name =?";
        Cursor cursor = m.mydb.rawQuery(m.sql,new String[]{query});
        if(cursor.getCount()>0){
            while(cursor.moveToNext()){
                id = cursor.getInt(0);
                m.editName.setText(cursor.getString(1));
                m.editTel.setText(cursor.getString(2));
                m.editEmail.setText(cursor.getString(3));
                m.txtName.setText(cursor.getString(1));
                m.txtTel.setText(cursor.getString(2));
                m.txtEmail.setText(cursor.getString(3));
            }
        }

    }
}

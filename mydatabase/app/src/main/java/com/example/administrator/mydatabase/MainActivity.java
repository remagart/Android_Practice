package com.example.administrator.mydatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCreate, btnUpdate, btnDelete, btnQuery;
    EditText editTel,editName,editEmail,editQuery;
    TextView txtTel, txtName, txtEmail;
    Context thisactivity;

    SQLiteDatabase mydb;
    String table_name="mytable";
    String sql;
    String path;
    int id;
    MainActivity m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;

        m = new MainActivity();

        myinit();
        mylib.myopen(thisactivity,m);
        mylib.mycreatetable(thisactivity,m);

    }
//    public void myopen(){
//        path = "/data/data/"+ getPackageName()+"/youaremonkey.db";
//        mydb = SQLiteDatabase.openOrCreateDatabase(path,null);
//        Toast.makeText(thisactivity, "HIHI", Toast.LENGTH_SHORT).show();
//    }
//
//    public void mycreatetable(){
//        sql ="CREATE TABLE IF NOT EXISTS " + table_name +"(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, email TEXT);";
//        mydb.execSQL(sql);
//        Toast.makeText(thisactivity, "baba", Toast.LENGTH_SHORT).show();
//    }

    public void myinit(){
        m.btnCreate = (Button)findViewById(R.id.myb1);
        m.btnUpdate = (Button)findViewById(R.id.myb2);
        m.btnDelete = (Button)findViewById(R.id.myb3);
        m.btnQuery = (Button)findViewById(R.id.myb4);

        m.editName = (EditText)findViewById(R.id.myeditText1);
        m.editTel = (EditText)findViewById(R.id.myeditText2);
        m.editEmail = (EditText)findViewById(R.id.myeditText3);
        m.editQuery = (EditText)findViewById(R.id.myeditText4);

        m.txtName = (TextView)findViewById(R.id.mytxt1);
        m.txtTel = (TextView)findViewById(R.id.mytxt2);
        m.txtEmail = (TextView)findViewById(R.id.mytxt3);

        m.btnCreate.setOnClickListener(myevent);
        m.btnUpdate.setOnClickListener(myevent);
        m.btnDelete.setOnClickListener(myevent);
        m.btnQuery.setOnClickListener(myevent);

    }

    View.OnClickListener myevent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.myb1:
                    //新增
                    mylib.add(thisactivity,m);
                    break;
                case R.id.myb2:
                    //修改
                    mylib.edit(thisactivity,m);
                    mylib.search(thisactivity,m);
                    break;
                case R.id.myb3:
                    //刪除
                    break;
                case R.id.myb4:
                    //查詢
                    mylib.search(thisactivity,m);
                    break;
                default:
            }
        }
    };


}

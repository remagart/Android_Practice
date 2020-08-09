package com.example.administrator.mytodolist;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class all_content extends AppCompatActivity {
    Context thisactivity;
    ListView mylist;
    Toolbar toolbar;
    FloatingActionButton fab;
    myDBAdapter mmyDBAdapter;
    SimpleCursorAdapter mySimpleCursorAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_content);
        thisactivity = this;
        init();
        mmyDBAdapter = new myDBAdapter(thisactivity);
        fab.setOnClickListener(myevent);
        mydisplaylistview();

    }

    void init(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        mylist = (ListView)findViewById(R.id.allcontentxml_listview);
    }

    void mydisplaylistview(){

        Cursor mycursor = mmyDBAdapter.makecursor();
        String[] from = new String[]{
                mmyDBAdapter.KEY_mytitle,
                mmyDBAdapter.KEY_mydate,
                mmyDBAdapter.KEY_mycontent
        };
        int[] to = new int[]{
                R.id.listdetailxml_textview_title,
                R.id.listdetailxml_textview_date,
                R.id.listdetailxml_textview_content
        };

        mySimpleCursorAdapter = new SimpleCursorAdapter(thisactivity,
                                                        R.layout.list_detail,
                                                        mycursor,
                                                        from,
                                                        to,
                                                        0
                                                        );
        mylist.setAdapter(mySimpleCursorAdapter);
        //MyToDoList_v11:點擊item事件處理　
        mylist.setOnItemClickListener(myitemevent);
    }



    View.OnClickListener myevent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent();
            switch(v.getId()){
                case R.id.fab:
                    i.putExtra("type","add");
                    i.setClass(thisactivity,MainActivity.class);
                    startActivity(i);
                    break;
                default:
            }

        }
    };
//MyToDoList_v11:點擊item事件處理
    AdapterView.OnItemClickListener myitemevent = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor itemcursor = (Cursor) mylist.getItemAtPosition(position);
            if(itemcursor.getColumnIndex("_id") == -1){
                Toast.makeText(thisactivity, "沒有資料", Toast.LENGTH_SHORT).show();
            }
            int temp_id = itemcursor.getInt(itemcursor.getColumnIndex("_id"));
            Intent i = new Intent();
            i.putExtra("type","update");
            i.putExtra("_id",temp_id);
            i.setClass(thisactivity,MainActivity.class);
            startActivity(i);
        }
    };

}

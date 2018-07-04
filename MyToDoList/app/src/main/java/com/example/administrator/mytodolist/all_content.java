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
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

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
    }



    View.OnClickListener myevent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent();
            switch(v.getId()){
                case R.id.fab:
                    i.setClass(thisactivity,MainActivity.class);
                    startActivity(i);
                    break;
                default:
            }

        }
    };

}

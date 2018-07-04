package com.example.administrator.mytodolist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class all_content extends AppCompatActivity {
    Context thisactivity;
    Toolbar toolbar;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_content);
        thisactivity = this;
        init();
        fab.setOnClickListener(myevent);


    }

    void init(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
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

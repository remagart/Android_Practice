package com.example.administrator.myspinner_for_sandboxtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner myspinner;
    ArrayAdapter<CharSequence> myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        myAdapter = ArrayAdapter.createFromResource(this,R.array.colorr,android.R.layout.simple_spinner_item);
        myspinner.setAdapter(myAdapter);

    }

    void init(){
        myspinner = (Spinner)findViewById(R.id.myspinner);
    }
}

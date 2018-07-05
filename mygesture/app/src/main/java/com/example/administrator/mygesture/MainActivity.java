package com.example.administrator.mygesture;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView myimg;
    Context thisactivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;
        init();

    }
    void init(){
        myimg = (ImageView)findViewById(R.id.mainxml_imgview_myimg);
    }
}

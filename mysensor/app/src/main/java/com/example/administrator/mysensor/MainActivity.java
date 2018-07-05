package com.example.administrator.mysensor;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Context thisactivity;
    ImageView myimg;
    TextView mytitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;
        init();
        

    }

    void init(){
        myimg = (ImageView)findViewById(R.id.mainxml_imgview_myimg);
        mytitle = (TextView)findViewById(R.id.mainxml_title);

    }

}

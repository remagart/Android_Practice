package com.example.administrator.myphpsqltest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    Context thisactivity;
    ArrayList<mycontact> myallcontact;
    mycontactAdapter mmycontactAdapter;
    ListView mylist;
    TextView nodata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;
        init();

        myallcontact = new ArrayList<mycontact>();
        myallcontact.add(new mycontact("aaa","bbb","ccc","ddd"));

        mmycontactAdapter = new mycontactAdapter(thisactivity,myallcontact);
        mylist.setAdapter(mmycontactAdapter);
        if(mmycontactAdapter.getCount()==0){
            mylist.setVisibility(View.INVISIBLE);
            nodata.setVisibility(View.VISIBLE);
        }
        else{
            mylist.setVisibility(View.VISIBLE);
            nodata.setVisibility(View.INVISIBLE);
        }


    }

    void init(){
        mylist = (ListView)findViewById(R.id.mainxml_listview_mylist);
        nodata = (TextView)findViewById(R.id.mainxml_textview_nodata);
    }

}

package com.example.administrator.myphpsqltest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    Context thisactivity;
    ArrayList<mycontact> myallcontact;
    mycontactAdapter mmycontactAdapter;
    ListView mylist;
    TextView nodata;
    myconnect mmyconnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;
        init();
        mmyconnect = new myconnect(thisactivity);
        //myallcontact = new ArrayList<mycontact>();

        try {
            myallcontact = mmyconnect.execute("https://empurpled-nomenclat.000webhostapp.com/php/db_connect.php").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        // myallcontact.add(new mycontact("aaa","bbb","ccc","ddd"));

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater myinflater = getMenuInflater();
        myinflater.inflate(R.menu.mytoadd,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent();
        i.setClass(thisactivity,edit.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }
}

package com.example.jfmamjjasond.myphptestsql;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private Context thisactivity;
    private ArrayList<basic_info> list_info;
    private dbconnect myconnect;
    private  list_adapter myadapter;
    private ListView mylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;
        mylistview = (ListView)findViewById(R.id.mylist);

        myconnect = new dbconnect(thisactivity);
        try {
            list_info = myconnect.execute("https://empurpled-nomenclat.000webhostapp.com/myapp/dbconnect.php").get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        myadapter = new list_adapter(thisactivity,list_info);
        mylistview.setAdapter(myadapter);

    }

    //覆寫方法，因為要將menu放進來
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menu_inflater = getMenuInflater();
        menu_inflater.inflate(R.menu.add,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //覆寫方法，因為要將menu放進來
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent();
        i.setClass(thisactivity,addcontact.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }
}

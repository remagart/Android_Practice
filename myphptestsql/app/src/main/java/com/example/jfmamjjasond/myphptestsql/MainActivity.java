package com.example.jfmamjjasond.myphptestsql;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}

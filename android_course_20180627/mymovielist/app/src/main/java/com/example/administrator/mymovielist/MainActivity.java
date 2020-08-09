package com.example.administrator.mymovielist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ListView mylist;
    public mymovieadapter myadapter = null;
    public ArrayList<mymovie> allmovie = null;
    Context thisactivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        thisactivity = this;

        mylist = (ListView)findViewById(R.id.mylist);
        allmovie = new ArrayList<mymovie>();
        allmovie.add(new mymovie(R.mipmap.summer,"夏日1993","2018/6/29","★ 代表西班牙角逐2018奧斯卡最佳外語片..."));

        myadapter = new mymovieadapter(this,allmovie);

        mylist.setAdapter(myadapter);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(thisactivity, allmovie.get(position).getMyname(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}

package com.example.administrator.mymovielist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mylist;
    public mymovieadapter myadapter = null;
    public ArrayList<mymovie> allmovie = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        mylist = (ListView)findViewById(R.id.mylist);
        allmovie = new ArrayList<mymovie>();
        allmovie.add(new mymovie(R.mipmap.summer,"夏日1993","2018/6/29","★ 代表西班牙角逐2018奧斯卡最佳外語片..."));

        myadapter = new mymovieadapter(this,allmovie);
        mylist.setAdapter(myadapter);

    }
}

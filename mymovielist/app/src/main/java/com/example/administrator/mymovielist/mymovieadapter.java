package com.example.administrator.mymovielist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class mymovieadapter extends BaseAdapter{
    private LayoutInflater myinflater;
    private ArrayList<mymovie> myeachmovie;

    public mymovieadapter(){

    }
    public mymovieadapter(Context c,ArrayList<mymovie> mmm){
        myinflater = (LayoutInflater)c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
        this.myeachmovie = mmm;
    }

    @Override
    public int getCount() {
        return myeachmovie.size();
    }

    @Override
    public Object getItem(int position) {
        return myeachmovie.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myeachmovie.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mymovie m = (mymovie)getItem(position);
        ImageView img2;
        TextView name2,date2,intro2;

        View v = myinflater.inflate(R.layout.activity_main,null);

        img2 = (ImageView)v.findViewById(R.id.myimageview1);
        name2 = (TextView)v.findViewById(R.id.mytextView1);
        date2 = (TextView)v.findViewById(R.id.mytextView2);
        intro2 = (TextView)v.findViewById(R.id.mytextView3);

        img2.setImageResource(m.getImgg());
        name2.setText(m.getMyname());
        date2.setText(m.getMydate());
        intro2.setText(m.getMyintro());


        return v;
    }
}

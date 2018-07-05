package com.example.administrator.myspinner_for_sandboxtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class mybaseadapter extends BaseAdapter {
    LayoutInflater myinflater;
    ArrayList<mybasecolor> myeachcolor;

    mybaseadapter(){}
    mybaseadapter(Context c,ArrayList<mybasecolor> my){
        myinflater = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
        this.myeachcolor = my;
    }


    @Override
    public int getCount() {
        return myeachcolor.size();
    }

    @Override
    public Object getItem(int position) {
        return myeachcolor.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myeachcolor.indexOf(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mybasecolor color = (mybasecolor) getItem(position);
        ImageView myimage;
        TextView mytxt;

        View v = myinflater.inflate(R.layout.listdetail,null);

        myimage = (ImageView)v.findViewById(R.id.listdetailxml_imgview_mycolor);
        mytxt = (TextView)v.findViewById(R.id.listdetailxml_txtview_mytext);

        mytxt.setText(color.getName());
        myimage.setImageResource(color.getColor());


        return v;
    }
}

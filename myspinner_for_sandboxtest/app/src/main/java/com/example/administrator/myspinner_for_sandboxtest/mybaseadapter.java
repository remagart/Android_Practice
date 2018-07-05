package com.example.administrator.myspinner_for_sandboxtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

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
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}

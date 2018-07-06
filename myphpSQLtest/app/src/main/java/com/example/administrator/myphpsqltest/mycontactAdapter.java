package com.example.administrator.myphpsqltest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class mycontactAdapter extends BaseAdapter {

    ArrayList<mycontact> mylist;
    LayoutInflater myinflater;

    mycontactAdapter(){}
    mycontactAdapter(Context c,ArrayList<mycontact> m){
        mylist = m;
        myinflater = (LayoutInflater)c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mylist.indexOf(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mycontact myeachcontact = (mycontact) getItem(position);
        View v = myinflater.inflate(R.layout.listview_detail,null);

        ImageView eachimg;
        TextView eachname,eachtel,eachemail,eachbirth;

        eachimg = (ImageView)v.findViewById(R.id.detail_img);
        eachname = (TextView)v.findViewById(R.id.detail_name);
        eachtel = (TextView)v.findViewById(R.id.detail_tel);
        eachemail = (TextView)v.findViewById(R.id.detail_email);
        eachbirth = (TextView)v.findViewById(R.id.detail_birth);

        eachimg.setImageBitmap(myeachcontact.getMyimg());
        eachname.setText(myeachcontact.getMyname());
        eachtel.setText(myeachcontact.getMytel());
        eachemail.setText(myeachcontact.getMyemail());
        eachbirth.setText(myeachcontact.getMybirth());

        return v;
    }
}

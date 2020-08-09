package com.example.jfmamjjasond.myphptestsql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class list_adapter extends BaseAdapter {

    private ArrayList<basic_info> list_info;
    private LayoutInflater myinflater;

    public list_adapter() {
    }
    public list_adapter(Context c,ArrayList<basic_info> list) {
        list_info = list;
        myinflater = LayoutInflater.from(c);
    }

    //因為是實作抽象類別，所以以下四個方法需覆寫
    //因為BaseAdapter實作Adapter interface不完全
    //所以這邊覆寫的是Adapter interface的方法
    @Override
    public int getCount() {
        return list_info.size();
    }

    @Override
    public Object getItem(int position) {
        return list_info.get(position);
    }

    //public int indexOf (Object o)
    //所以參數要放入Object
    @Override
    public long getItemId(int position) {
        return list_info.indexOf(position);
    }

    public static class viewholder{
        TextView txt_name;
        TextView txt_tel;
        TextView txt_mail;
    }

    //搭配viewholder和convertView來優化listview
    //目標是listview不會一直call inflate
    //使用convertView是用暫存的view減少inflate
    //使用viewholder是將finviewbyid只做一次就好
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewholder holder;
        basic_info each = (basic_info) getItem(position);
        if(convertView == null){
            convertView = myinflater.inflate(R.layout.each_of_list,null);
            holder = new viewholder();
            holder.txt_name = (TextView) convertView.findViewById(R.id.eachname);
            holder.txt_tel = (TextView) convertView.findViewById(R.id.eachtel);
            holder.txt_mail = (TextView) convertView.findViewById(R.id.eachmail);
            convertView.setTag(holder);
        }
        else{
            holder = (viewholder) convertView.getTag();
        }

        holder.txt_name.setText(each.getBasic_name());
        holder.txt_tel.setText(each.getBasic_tel());
        holder.txt_mail.setText(each.getBasic_mail());

        return convertView;
    }
}

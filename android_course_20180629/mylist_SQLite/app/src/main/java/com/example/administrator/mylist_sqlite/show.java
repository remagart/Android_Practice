package com.example.administrator.mylist_sqlite;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class show extends AppCompatActivity {

    TextView showxml_name,showxml_tel,show_email;
    Bundle bdata;
    myDBAdapter mmyDBAdapter;
    Context thisactivity;
    int myid;
    Cursor mycursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        thisactivity = this;
        init();
        mmyDBAdapter = new myDBAdapter(thisactivity);
        bdata = this.getIntent().getExtras();
        myid = bdata.getInt("tempitemid");
        //Toast.makeText(thisactivity, String.valueOf(myid)+"哩哩", Toast.LENGTH_SHORT).show();

        mycursor = mmyDBAdapter.querybyid(myid);
        showxml_name.setText(mycursor.getString(1));
        showxml_tel.setText(mycursor.getString(2));
        show_email.setText(mycursor.getString(3));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //這是由下往上的懸浮
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent i = new Intent();
                i.putExtra("type","edit");
                i.putExtra("tempitemid",myid);
                i.setClass(show.this,edit.class);
                startActivity(i);
            }
        });
    }

    void init(){
        showxml_name = (TextView)findViewById(R.id.showxml_name);
        showxml_tel = (TextView)findViewById(R.id.showxml_tel);
        show_email = (TextView)findViewById(R.id.showxml_email);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater myinflater = getMenuInflater();
        myinflater.inflate(R.menu.edit,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i = new Intent();
        switch (item.getItemId()){
            case R.id.menudelete:
                mmyDBAdapter.delete(showxml_name.toString(),showxml_tel.toString(),show_email.toString(),myid);
                i.setClass(show.this,MainActivity.class);
                startActivity(i);
                break;

            default:

        }

        return super.onOptionsItemSelected(item);
    }
}

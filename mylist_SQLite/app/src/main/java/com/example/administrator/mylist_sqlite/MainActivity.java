package com.example.administrator.mylist_sqlite;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    Context thisactivity;
    ListView mylistview;
    myDBAdapter mmyDBAdapter;
    SimpleCursorAdapter mySimpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;

        mylistview = findViewById(R.id.mylistview);
        mmyDBAdapter = new myDBAdapter(thisactivity);


        mydisplaylistview();


    }

    void mydisplaylistview(){
        Cursor mycursor = mmyDBAdapter.makecursor();
        String[] from = new String[]{
            mmyDBAdapter.KEY_MYNAME,
            mmyDBAdapter.KEY_MYTEL,
            mmyDBAdapter.KEY_MYEMAIL
        };
        int[] to = new int[]{
            R.id.listviewdetail_name,
            R.id.listviewdetail_tel,
            R.id.listviewdetail_email
        };

        mySimpleCursorAdapter = new SimpleCursorAdapter(thisactivity,R.layout.listviewdetail,mycursor,from,to,0);
        mylistview.setAdapter(mySimpleCursorAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater myinflater = getMenuInflater();
        myinflater.inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent();
        switch (item.getItemId()){
            case R.id.menuadd:
                i.putExtra("type","add");
                i.setClass(MainActivity.this,edit.class);
                startActivity(i);
                break;
            default:

        }
        return super.onOptionsItemSelected(item);
    }
}

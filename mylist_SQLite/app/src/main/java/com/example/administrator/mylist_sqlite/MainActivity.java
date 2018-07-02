package com.example.administrator.mylist_sqlite;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    Context thisactivity;
    ListView mylistview;
    myDBAdapter 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;

        mylistview = new ListView(this);
        mylistview = findViewById(R.id.mylistview);

        mydisplaylistview();


    }

    void mydisplaylistview(){
        String[] from = new String[]{

        };

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

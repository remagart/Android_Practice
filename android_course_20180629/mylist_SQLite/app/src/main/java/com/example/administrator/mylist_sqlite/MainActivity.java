package com.example.administrator.mylist_sqlite;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

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
        //SQLite 須使用 SimpleCursorAdapter做為Adapter
        mySimpleCursorAdapter = new SimpleCursorAdapter(thisactivity,R.layout.listviewdetail,mycursor,from,to,0);
        mylistview.setAdapter(mySimpleCursorAdapter);
        //做listview每個項目的點擊處理
        mylistview.setOnItemClickListener(myevent);

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

    AdapterView.OnItemClickListener myevent = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(thisactivity, String.valueOf(position+1), Toast.LENGTH_SHORT).show();
            Cursor item_cursor = (Cursor)mylistview.getItemAtPosition(position);
            //不確定用法是不是這樣
            if(item_cursor.getColumnIndex("name") == -1){
                Toast.makeText(thisactivity, "此欄位不存在", Toast.LENGTH_SHORT).show();
            }
            int item_id = item_cursor.getInt(item_cursor.getColumnIndex("_id"));
            Toast.makeText(thisactivity, "安安"+item_id, Toast.LENGTH_SHORT).show();

            Intent i = new Intent();
            i.putExtra("tempitemid",item_id);
            i.setClass(thisactivity,show.class);
            startActivity(i);

        }
    };


}

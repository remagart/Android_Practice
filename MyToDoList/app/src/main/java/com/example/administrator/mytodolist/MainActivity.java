package com.example.administrator.mytodolist;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Context thisactivity;
    Button mybutton_add;
    TextView mypagetitle;
    EditText mytitle,mycontent;
    String mytitle_s,mycontent_s,mydate_s;
    myDBAdapter mmyDBAdapter;
    Calendar mycalendar;
    Bundle mydata;
    static public boolean firstopencheck = true; //MyToDoList_v12:因為一開app就要判斷Extra的值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;
        init();
        mmyDBAdapter = new myDBAdapter(thisactivity);
        if(firstopencheck == false) {
            if (mydata.get("type").equals("update")) {
                mypagetitle.setText("修改變條");
                mybutton_add.setText("修改變條");
                int tempid;
                tempid = mydata.getInt("_id");
                Cursor mycursor = mmyDBAdapter.querybyid(tempid);

                mytitle.setText(mycursor.getString(1));
                mycontent.setText(mycursor.getString(3));
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater myinflater = getMenuInflater();
        myinflater.inflate(R.menu.check,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = new Intent();
        i.setClass(thisactivity,all_content.class);
        startActivity(i);
        return super.onOptionsItemSelected(item);
    }

    void init(){
        mypagetitle = (TextView)findViewById(R.id.mainxml_pagetitle);
        mybutton_add = (Button)findViewById(R.id.mainxml_button_add);
        mytitle = (EditText)findViewById(R.id.mainxml_editview_title);
        mycontent = (EditText)findViewById(R.id.mainxml_editview_content);
        //MyToDoList_v12:沒辦法用我設定的thisactivity，可能是Context類別沒有getIntent()的方法
        mydata = MainActivity.this.getIntent().getExtras();

        mybutton_add.setOnClickListener(myevent);
    }

    View.OnClickListener myevent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent();
            switch(v.getId()){
                case R.id.mainxml_button_add:
                    mytitle_s = mytitle.getText().toString();
                    mycontent_s = mycontent.getText().toString();
                    mycalendar = Calendar.getInstance();
                    mydate_s = String.valueOf(mycalendar.get(Calendar.YEAR))
                            + "-" + String.valueOf(mycalendar.get(Calendar.MONTH)+1)
                            + "-" + String.valueOf(mycalendar.get(Calendar.DATE));
                    if(firstopencheck == true){
                        mmyDBAdapter.add(mytitle_s,mycontent_s,mydate_s);
                        Toast.makeText(thisactivity, "已新增喔~", Toast.LENGTH_SHORT).show();
                    }
                    else{
                         if(mydata.get("type").equals("add")) {
                             mmyDBAdapter.add(mytitle_s, mycontent_s, mydate_s);
                             Toast.makeText(thisactivity, "已新增喔~", Toast.LENGTH_SHORT).show();
                         }
                         else if(mydata.get("type").equals("update")) {
                            mmyDBAdapter.update(mytitle_s, mycontent_s, mydate_s, mydata.getInt("_id"));
                            Toast.makeText(thisactivity, "已修改喔~", Toast.LENGTH_SHORT).show();
                        }
                    }
                    i.setClass(thisactivity,all_content.class);
                    startActivity(i);

                    break;
                default:

            }
            //MyToDoList_v14:因為button這邊也會做到extra的判斷，所以放到這裡，按完button後才會改
            firstopencheck = false;
        }
    };

}

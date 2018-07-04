package com.example.administrator.mytodolist;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Context thisactivity;
    Button mybutton_add;
    EditText mytitle,mycontent;
    String mytitle_s,mycontent_s,mydate_s;
    myDBAdapter mmyDBAdapter;
    Calendar mycalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;
        init();
        mmyDBAdapter = new myDBAdapter(thisactivity);



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
        mybutton_add = (Button)findViewById(R.id.mainxml_button_add);
        mytitle = (EditText)findViewById(R.id.mainxml_editview_title);
        mycontent = (EditText)findViewById(R.id.mainxml_editview_content);

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
                    mmyDBAdapter.add(mytitle_s,mycontent_s,mydate_s);
                    Toast.makeText(thisactivity, "已新增喔~", Toast.LENGTH_SHORT).show();
                    i.setClass(thisactivity,all_content.class);
                    startActivity(i);

                    break;
                default:

            }
        }
    };

}

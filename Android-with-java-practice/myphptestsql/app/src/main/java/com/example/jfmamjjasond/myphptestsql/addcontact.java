package com.example.jfmamjjasond.myphptestsql;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class addcontact extends AppCompatActivity {

    private Context thisactivity;
    private Button btn_send,btn_back;
    private EditText edit_name,edit_tel,edit_mail;
    // name,tel,mail
    private String[] data = new String[3];
    private dbinsert myinsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);
        thisactivity = this;
        init();

        btn_send.setOnClickListener(myclickevent);
        btn_back.setOnClickListener(myclickevent);


    }

    protected void init(){
        btn_send = (Button)findViewById(R.id.addcontact_send);
        btn_back = (Button)findViewById(R.id.addcontact_back);
        edit_name = (EditText)findViewById(R.id.addname);
        edit_tel = (EditText)findViewById(R.id.addtel);
        edit_mail = (EditText)findViewById(R.id.addmail);
    }

    protected void input() {
        data[0] = edit_name.getText().toString();
        data[1] = edit_tel.getText().toString();
        data[2] = edit_mail.getText().toString();
    }

    View.OnClickListener myclickevent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent();
            switch (v.getId()){
                case R.id.addcontact_send:
                    input();
                    send_to_SQL();
                    i.setClass(thisactivity,MainActivity.class);
                    startActivity(i);
                    break;
                case  R.id.addcontact_back:
                    i.setClass(thisactivity,MainActivity.class);
                    startActivity(i);
                    break;
                default:

            }
        }
    };

    protected void send_to_SQL(){
        myinsert = new dbinsert(thisactivity,data);
        try {
            myinsert.execute("https://empurpled-nomenclat.000webhostapp.com/myapp/dbinsert.php").get();

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}

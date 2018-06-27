package com.example.administrator.mydialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b4,b8;
    Context thisactivity;
    String[] woman = {"nana","lili","lulu","Amy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thisactivity = this;
        b1 = (Button)findViewById(R.id.myb1);
        b4 = (Button)findViewById(R.id.myb4);
        b8 = (Button)findViewById(R.id.myb8);
        b1.setOnClickListener(myevent);
        b4.setOnClickListener(myevent);
        b8.setOnClickListener(myevent);
    }

    View.OnClickListener myevent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.myb1){
                AlertDialog.Builder builder = new AlertDialog.Builder(thisactivity);
                builder.setTitle("1.雙鍵式對話框");
                builder.setIcon(R.mipmap.woman);
                builder.setMessage("這是內容");
                builder.setPositiveButton("狠心離開", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent();
                        i.setClass(thisactivity,Main2Activity.class);
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("留在本頁", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            }
            else if(v.getId() == R.id.myb4){
                AlertDialog.Builder builder = new AlertDialog.Builder(thisactivity);
                builder.setTitle("4.單選行對話框");
                builder.setIcon(R.mipmap.woman);
                builder.setSingleChoiceItems(woman, 2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(thisactivity, "你想要.."+woman[which], Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setPositiveButton("確定嗎", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent();
                        i.setClass(thisactivity,Main2Activity.class);
                        startActivity(i);
                    }
                });

                builder.create().show();
            }
            else if(v.getId() == R.id.myb8){
                final ProgressDialog aa = new ProgressDialog(thisactivity);
                aa.setCancelable(true);
                aa.setTitle("進度呢");
                aa.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                aa.show(thisactivity,"讀取中", "請等待3秒...",true,true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            Thread.sleep(3000);
                        }catch(Exception e){
                            e.printStackTrace();
                        }finally {
                            aa.dismiss();
                        }
                    }
                }).start();
            }
        }
    };

}

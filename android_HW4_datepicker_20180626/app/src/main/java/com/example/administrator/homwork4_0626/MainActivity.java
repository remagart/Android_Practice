package com.example.administrator.homwork4_0626;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Context thisactivity;
    Button b1;
    ProgressDialog builder;
    Handler handle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;

        b1 = (Button)findViewById(R.id.myb1);
        //handle要在查察
        handle = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                builder.incrementProgressBy(5);
            }
        };
        b1.setOnClickListener(myevent);

    }

    View.OnClickListener myevent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            builder = new ProgressDialog(thisactivity);
            builder.setTitle("ProgressDialog");
            builder.setMax(100);
            builder.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            builder.show();
            Thread t1;
            t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while(builder.getProgress()<=builder.getMax()){
                            Thread.sleep(100);
                            handle.sendMessage(handle.obtainMessage());
                            if(builder.getProgress()==builder.getMax()){
                                builder.dismiss();
                            }
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
            t1.start();



        }

    };

}

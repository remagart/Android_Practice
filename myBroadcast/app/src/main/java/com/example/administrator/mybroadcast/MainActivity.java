package com.example.administrator.mybroadcast;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Context thisactivity;
    Button b1;
    private final String mymsg = "zzzz";
    private final String mymsg2 = "zzzz2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;

        b1 = (Button)findViewById(R.id.myb1);
        b1.setOnClickListener(myevent);

    }

    View.OnClickListener myevent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mybroadcastreceiver receiver = new mybroadcastreceiver();
            registerReceiver(receiver, new IntentFilter(mymsg));
            Intent i = new Intent();
            Intent i2 = new Intent();
//            i.setAction(mymsg);
//            sendBroadcast(i);
            i2.setAction(mymsg2);
            sendBroadcast(i2);
        }
    };

}

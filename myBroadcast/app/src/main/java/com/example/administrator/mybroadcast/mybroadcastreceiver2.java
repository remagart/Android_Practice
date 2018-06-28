package com.example.administrator.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class mybroadcastreceiver2 extends BroadcastReceiver implements Runnable{
    Context thisactivity;
    @Override
    public void onReceive(Context context, Intent intent) {
        thisactivity = context;
        if(intent.getAction().equals("zzzz2")){
            Thread t1 = new Thread(this);
            t1.run();
            Toast.makeText(context, "hihi,this is 2", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

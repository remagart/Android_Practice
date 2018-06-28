package com.example.administrator.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class mybroadcastreceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("abc")){
            Toast.makeText(context, "HIHI", Toast.LENGTH_SHORT).show();
        }
    }
}

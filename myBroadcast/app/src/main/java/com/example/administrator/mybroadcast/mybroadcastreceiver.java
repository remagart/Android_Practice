package com.example.administrator.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class mybroadcastreceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("zzzz")){
            Toast.makeText(context, "HIHI,this is 1", Toast.LENGTH_SHORT).show();
        }
    }
}

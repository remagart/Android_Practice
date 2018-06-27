package com.example.jfmamjjasond.homework1_0626;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Context thisactivity;
    LayoutInflater myinflater;
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
            myinflater = getLayoutInflater();
            AlertDialog.Builder mybuilder = new AlertDialog.Builder(thisactivity);
            mybuilder.setTitle("Login");
            mybuilder.setView(myinflater.inflate(R.layout.mydialog,null));
            mybuilder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            mybuilder.setNegativeButton("Login", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            mybuilder.show();


        }
    };

}

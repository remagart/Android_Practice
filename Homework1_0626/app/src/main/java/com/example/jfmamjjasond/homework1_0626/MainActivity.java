package com.example.jfmamjjasond.homework1_0626;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Context thisactivity;
    LayoutInflater myinflater;
    EditText e1,e2;
    String account,password;
    View myview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;

        b1 = (Button)findViewById(R.id.myb1);
        //e1 = (EditText)ViewById(R.id.myeditText1);
        //e2 = (EditText)findViewById(R.id.myeditText2);


        b1.setOnClickListener(myevent);


    }

    View.OnClickListener myevent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            myinflater = getLayoutInflater();
            myview = myinflater.inflate(R.layout.mydialog,null);
            AlertDialog.Builder mybuilder = new AlertDialog.Builder(thisactivity);
            mybuilder.setTitle("Login");
            mybuilder.setView(myview);
            mybuilder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   }
            });
            mybuilder.setNegativeButton("Login", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    e1 = (EditText)myview.findViewById(R.id.myeditText1);
                    e2 = (EditText)myview.findViewById(R.id.myeditText2);

                    account = e1.getText().toString();
                    password = e2.getText().toString();
                    Toast.makeText(thisactivity, "帳號是"+account, Toast.LENGTH_SHORT).show();
                    Toast.makeText(thisactivity, "密碼是"+password, Toast.LENGTH_SHORT).show();
                }
            });

            mybuilder.show();


        }
    };

}

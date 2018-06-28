package com.example.administrator.mydatabase;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnCreate, btnUpdate, btnDelete, btnQuery;
    EditText editTel,editName,editEmail,editQuery;
    TextView txtTel, txtName, txtEmail;
    Context thisactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;

        myinit();

    }

    public void myinit(){
        btnCreate = (Button)findViewById(R.id.myb1);
        btnUpdate = (Button)findViewById(R.id.myb2);
        btnDelete = (Button)findViewById(R.id.myb3);
        btnQuery = (Button)findViewById(R.id.myb4);

        editName = (EditText)findViewById(R.id.myeditText1);
        editTel = (EditText)findViewById(R.id.myeditText2);
        editEmail = (EditText)findViewById(R.id.myeditText3);
        editQuery = (EditText)findViewById(R.id.myeditText4);

        txtName = (TextView)findViewById(R.id.mytxt1);
        txtTel = (TextView)findViewById(R.id.mytxt2);
        txtEmail = (TextView)findViewById(R.id.mytxt3);

        btnCreate.setOnClickListener(myevent);
        btnUpdate.setOnClickListener(myevent);
        btnDelete.setOnClickListener(myevent);
        btnQuery.setOnClickListener(myevent);

    }

    View.OnClickListener myevent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.myb1:
                    break;
                case R.id.myb2:
                    break;
                case R.id.myb3:
                    break;
                case R.id.myb4:
                    break;
                default:
            }
        }
    };


}

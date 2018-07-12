package com.example.administrator.myphpsqltest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class edit extends AppCompatActivity {

    Context thisactivity;
    EditText newname,newtel,newbirth,newmail;
    Button btn_OK;
    String[] all;
    myinsert mmyinsert;
    Bundle bdata;
    String queryname,type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        thisactivity = this;

        init();

        //針對編輯做處理
        bdata = this.getIntent().getExtras();
        this.setTitle(bdata.getString("title"));
        queryname = bdata.getString("name");
        type = bdata.getString("type");


        all = new String[4];

        btn_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all[0]= newname.getText().toString();
                all[1] = newtel.getText().toString();
                all[2] = newmail.getText().toString();
                all[3] = newbirth.getText().toString();
                mmyinsert = new myinsert(thisactivity,all);
                mmyinsert.execute("https://empurpled-nomenclat.000webhostapp.com/php/insert.php");
            }
        });



    }
    void init(){
        newname = (EditText)findViewById(R.id.editxml_name);
        newtel = (EditText)findViewById(R.id.editxml_tel);
        newbirth = (EditText)findViewById(R.id.editxml_birth);
        newmail = (EditText)findViewById(R.id.editxml_mail);
        btn_OK = (Button)findViewById(R.id.editxml_btn_confirm);


    }
}

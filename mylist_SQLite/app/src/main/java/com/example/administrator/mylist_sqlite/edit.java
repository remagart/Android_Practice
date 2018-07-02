package com.example.administrator.mylist_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class edit extends AppCompatActivity {

    Button editxml_button_OK,editxml_button_back;
    EditText editxml_name,editxml_tel,editxml_email;
    String new_name,new_tel,new_email;
    TextView title;
    Bundle bdata;
    myDBAdapter mmyDBAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        edit_init();
        bdata = this.getIntent().getExtras();
        mmyDBAdapter = new myDBAdapter(this);

        if (bdata.getString("type").equals("edit") ){
            Toast.makeText(this, "HIHI this is if edit true", Toast.LENGTH_SHORT).show();
        }
        editxml_button_OK.setOnClickListener(myevent);


    }

    void edit_init(){
        editxml_button_OK = findViewById(R.id.editxml_button_OK);
        editxml_button_back = findViewById(R.id.editxml_button_back);

        editxml_name = findViewById(R.id.editxml_name);
        editxml_tel = findViewById(R.id.editxml_tel);
        editxml_email = findViewById(R.id.editxml_email);

        title = findViewById(R.id.editxml_title);

        editxml_name.setOnClickListener(myevent);
        editxml_tel.setOnClickListener(myevent);
        editxml_email.setOnClickListener(myevent);
        Toast.makeText(edit.this, "完成初始化", Toast.LENGTH_SHORT).show();

    }

    View.OnClickListener myevent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.editxml_name:
                    break;
                case R.id.editxml_tel:
                    break;
                case R.id.editxml_email:
                    break;
                case R.id.editxml_button_OK:
                    Toast.makeText(edit.this, "This is OK", Toast.LENGTH_SHORT).show();
                    new_name = editxml_name.getText().toString();
                    new_tel = editxml_tel.getText().toString();
                    new_email = editxml_email.getText().toString();
                    if(bdata.getString("type").equals("add")){
                        mmyDBAdapter.add(new_name,new_tel,new_email);
                        Intent i = new Intent();
                        i.setClass(edit.this,MainActivity.class);
                        startActivity(i);
                    }




                    break;
                default:

            }
        }
    };



}

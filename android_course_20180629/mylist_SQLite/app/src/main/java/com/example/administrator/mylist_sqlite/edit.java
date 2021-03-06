package com.example.administrator.mylist_sqlite;

import android.content.Intent;
import android.database.Cursor;
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
    Cursor mycursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        edit_init();
        bdata = this.getIntent().getExtras();
        mmyDBAdapter = new myDBAdapter(this);

        if (bdata.getString("type").equals("edit") ){
            title.setText("修改連絡人");
            editxml_button_OK.setText("修改");
            mycursor = mmyDBAdapter.querybyid(bdata.getInt("tempitemid"));
            editxml_name.setText(mycursor.getString(1));
            editxml_tel.setText(mycursor.getString(2));
            editxml_email.setText(mycursor.getString(3));

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
                    new_name = editxml_name.getText().toString();
                    new_tel = editxml_tel.getText().toString();
                    new_email = editxml_email.getText().toString();
                    if(bdata.getString("type").equals("add")){
                        mmyDBAdapter.add(new_name,new_tel,new_email);
                        Intent i = new Intent();
                        i.setClass(edit.this,MainActivity.class);
                        startActivity(i);
                    }
                    else if(bdata.getString("type").equals("edit")){
                        mmyDBAdapter.update(new_name,new_tel,new_email,bdata.getInt("tempitemid"));
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

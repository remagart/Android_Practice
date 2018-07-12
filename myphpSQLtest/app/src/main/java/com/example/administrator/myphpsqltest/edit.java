package com.example.administrator.myphpsqltest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class edit extends AppCompatActivity {

    Context thisactivity;
    EditText newname,newtel,newbirth,newmail;
    Button btn_OK;
    String[] all;
    myinsert mmyinsert;
    Bundle bdata;
    String queryname,type;
    load_and_editdata mmyeditdata;
    String[] old_data = new String[4];
    updatedata mmyupdatedata;

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

        // 因為新增和修改在同一頁，所以才有這判斷式
        if(type.equals("edit")){
            mmyeditdata = new load_and_editdata(thisactivity,null,queryname);
            // 連query.php囉
            try {
                old_data = mmyeditdata.execute("https://empurpled-nomenclat.000webhostapp.com/php/query.php").get();
                newname.setText(old_data[1]);
                newtel.setText(old_data[2]);
                newmail.setText(old_data[3]);
                newbirth.setText(old_data[4]);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        all = new String[4];

        btn_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("add")){
                    all[0]= newname.getText().toString();
                    all[1] = newtel.getText().toString();
                    all[2] = newmail.getText().toString();
                    all[3] = newbirth.getText().toString();
                    mmyinsert = new myinsert(thisactivity,all);
                    mmyinsert.execute("https://empurpled-nomenclat.000webhostapp.com/php/insert.php");
                }
                else if(type.equals("edit")){
                    old_data[1] = newname.getText().toString();
                    old_data[2] = newtel.getText().toString();
                    old_data[3] = newmail.getText().toString();
                    old_data[4] = newbirth.getText().toString();
                    mmyupdatedata = new updatedata(thisactivity,old_data);
                    mmyupdatedata.execute("https://empurpled-nomenclat.000webhostapp.com/php/update.php");
                }

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

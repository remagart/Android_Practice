package com.example.administrator.myphpsqltest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class edit extends AppCompatActivity {

    Context thisactivity;
    EditText newname,newtel,newbirth,newmail;
    Button btn_OK,btn_select;
    String[] all;
    myinsert mmyinsert;
    Bundle bdata;
    String queryname,type;
    load_and_editdata mmyeditdata;
    String[] old_data = new String[4];
    updatedata mmyupdatedata;

    final static int PICK_IMAGE = 1;
    String picturepath;
    Bitmap mybitmap;
    ImageView myimage;


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
                Intent i = new Intent();

                if(type.equals("add")){
                    all[0]= newname.getText().toString();
                    all[1] = newtel.getText().toString();
                    all[2] = newmail.getText().toString();
                    all[3] = newbirth.getText().toString();

                    mmyinsert = new myinsert(thisactivity,all,picturepath);
                    mmyinsert.execute("https://empurpled-nomenclat.000webhostapp.com/php/insert.php");
                    i.setClass(thisactivity,MainActivity.class);
                    startActivity(i);


                }
                else if(type.equals("edit")){
                    old_data[1] = newname.getText().toString();
                    old_data[2] = newtel.getText().toString();
                    old_data[3] = newmail.getText().toString();
                    old_data[4] = newbirth.getText().toString();
                    mmyupdatedata = new updatedata(thisactivity,old_data);
                    mmyupdatedata.execute("https://empurpled-nomenclat.000webhostapp.com/php/update.php");

                    i.setClass(thisactivity,MainActivity.class);
                    startActivity(i);

                }

            }
        });

        btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myselectfromgallery();
            }
        });


    }
    void init(){
        newname = (EditText)findViewById(R.id.editxml_name);
        newtel = (EditText)findViewById(R.id.editxml_tel);
        newbirth = (EditText)findViewById(R.id.editxml_birth);
        newmail = (EditText)findViewById(R.id.editxml_mail);
        btn_OK = (Button)findViewById(R.id.editxml_btn_confirm);
        btn_select = (Button)findViewById(R.id.my_btn_select);
        myimage = (ImageView)findViewById(R.id.myimg);

    }

    void myselectfromgallery(){
        if(Build.VERSION.SDK_INT < 19){

        }
        else{
            Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            i.addCategory(Intent.CATEGORY_OPENABLE);
            i.setType("image/*");
            startActivityForResult(i,PICK_IMAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode != Activity.RESULT_OK)
                return;
        if(requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null){
            Uri selectimage = data.getData();
            String myid = selectimage.getLastPathSegment().split(":")[1];
            String[] imagecolumn = {MediaStore.Images.Media.DATA};
            String imagebyorder = null;

            Uri u = getUri();
            picturepath = "path";
            Cursor imagecur = getContentResolver().query(u,imagecolumn,
                    MediaStore.Images.Media._ID+" = "+myid,
                    null,
                    imagebyorder);

            if(imagecur.moveToFirst()){
                picturepath = imagecur.getString(imagecur.getColumnIndex(MediaStore.Images.Media.DATA));
            }

            decodeFile(picturepath);
        }

    }
    Uri getUri(){
        String state = Environment.getExternalStorageState();
        if(!state.equalsIgnoreCase(Environment.MEDIA_MOUNTED)){
            return MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        }
        return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    void decodeFile(String filepath){
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        o.inSampleSize = 1;
        int Roundsize = 1024;
        int tmp_width = o.outWidth;
        int tmp_height = o.outHeight;
        int scale = 1;
        while(true){
            if(tmp_width < Roundsize && tmp_height < Roundsize){
                break;
            }
            tmp_height /= 2;
            tmp_width /= 2;
            scale *= 2;
        }
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        mybitmap = BitmapFactory.decodeFile(filepath,o2);

        myimage.setImageBitmap(mybitmap);


    }

}

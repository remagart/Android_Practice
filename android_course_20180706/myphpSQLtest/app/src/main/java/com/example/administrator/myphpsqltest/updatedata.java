package com.example.administrator.myphpsqltest;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class updatedata extends AsyncTask<String,Void,String> {

    String crlf = "\r\n";
    String twoHyphens = "--";
    String boundary =  "*****";
    Context thisactivity;
    ProgressDialog mydialog;
    String[] newdata;

    updatedata(Context c,String[] data){
        thisactivity = c;
        newdata = data;
        mydialog = new ProgressDialog(c);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mydialog.setMessage("連線中");
        mydialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mydialog.dismiss();
        int isSuccess= 0;
        isSuccess = s.indexOf("edit Success");
        if(isSuccess != -1)
            Toast.makeText(thisactivity,"成功更新一筆資料",Toast.LENGTH_LONG).show();
        Intent i = new Intent(thisactivity, MainActivity.class);
        thisactivity.startActivity(i);
    }

    @Override
    protected String doInBackground(String... temps) {

        try {
            URL u = new URL(temps[0]);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Cache-Control", "no-cache");
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + this.boundary);
            conn.setRequestProperty("Charset", "UTF-8");
            DataOutputStream request = new DataOutputStream(conn.getOutputStream());

            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            /*Contact ID*/
            request.writeBytes("Content-Disposition: form-data; name=\"ContactID\"" + "\"" + this.crlf);
            request.writeBytes(this.crlf);
            request.writeBytes(newdata[0]);
            request.writeBytes(this.crlf);
            /*Name*/
            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"Name\"" + "\"" + this.crlf);
            request.writeBytes(this.crlf);
            request.write(newdata[1].getBytes());
            request.writeBytes(this.crlf);
            /*Phone*/
            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"Phone\"" + "\"" + this.crlf);
            request.writeBytes(this.crlf);
            request.writeBytes(newdata[2]);
            request.writeBytes(this.crlf);
            /*Email*/
            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"Email\"" + "\"" + this.crlf);
            request.writeBytes(this.crlf);
            request.writeBytes(newdata[3]);
            request.writeBytes(this.crlf);
            /*Birthday*/
            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"Birthday\"" + "\"" + this.crlf);
            request.writeBytes(this.crlf);
            request.writeBytes(newdata[4]);
            request.writeBytes(this.crlf);
            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes(this.crlf);
            request.flush();
            request.close();

            conn.connect();

            InputStream is = conn.getInputStream();
            byte[] b = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (is.read(b) != -1){
                baos.write(b);
            }

            String response = new String(baos.toByteArray());
            Log.e("嘿嘿", response);
            return response;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}

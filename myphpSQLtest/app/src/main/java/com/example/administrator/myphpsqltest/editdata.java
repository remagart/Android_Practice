package com.example.administrator.myphpsqltest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class editdata extends AsyncTask<String,Void,String> {

    ProgressDialog mydialog;
    Context thisactivity;
    String crlf = "\r\n";
    String twoHyphens = "--";
    String boundary =  "*****";
    String queryname;
    String name;
    String[] getdata;

    editdata(Context c,String[] data,String queryname){
        thisactivity = c;
        getdata = data;
        this.queryname = queryname;
        mydialog = new ProgressDialog(c);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... temps) {
        try {
            URL u = new URL(temps[0]);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            // Name就是POST的變數，要告訴PHP是哪個變數
            name = "Name=" + URLEncoder.encode(queryname,"UTF-8");
            // 連接資料流
            OutputStream os = conn.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
            // 將要查詢的字寫入資料傳給PHP
            bw.write(name);
            bw.flush();
            bw.close();
            conn.connect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}

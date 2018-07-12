package com.example.administrator.myphpsqltest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class load_and_editdata extends AsyncTask<String,Void,String[]> {

    ProgressDialog mydialog;
    Context thisactivity;
    String crlf = "\r\n";
    String twoHyphens = "--";
    String boundary =  "*****";
    String queryname;
    String name;
    String[] getdata;

    load_and_editdata(Context c, String[] data, String queryname){
        thisactivity = c;
        getdata = data;
        this.queryname = queryname;
        mydialog = new ProgressDialog(c);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mydialog.setMessage("連線中");
        mydialog.show();
    }

    @Override
    protected void onPostExecute(String[] s) {
        super.onPostExecute(s);
        mydialog.dismiss();
    }

    @Override
    protected String[] doInBackground(String... temps) {
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
            //接收來自PHP的資料並存成String
            InputStream is = conn.getInputStream();
            byte[] b = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while(is.read(b) != -1){
                baos.write(b);
            }
            String Resp = new String(baos.toByteArray());
            Log.e("安安", Resp );

            conn.connect();

            // 將JSON物件轉為String陣列並傳回
            JSONObject arr = new JSONObject(Resp);
            String[] old_data = convert(arr);
            return old_data;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
    // 將JSON物件轉為String陣列並傳回
    String[] convert(JSONObject jobj) throws JSONException {
        String name,tel,email,birth;
        name = jobj.getString("Name");
        tel = jobj.getString("Phone");
        email = jobj.getString("Email");
        birth = jobj.getString("Birthday");

        String[] old_data = new String[]{name,tel,email,birth};

        return old_data;
    }
}

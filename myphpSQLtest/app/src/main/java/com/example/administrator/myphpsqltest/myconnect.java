package com.example.administrator.myphpsqltest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class myconnect extends AsyncTask<String,Void,ArrayList<mycontact>> {
    ProgressDialog mydialog;
    Context thisactivity;

    myconnect(Context c){
        thisactivity = c;
        mydialog = new ProgressDialog(c);
    }

    @Override
    protected ArrayList<mycontact> doInBackground(String... temp) {
        ArrayList<mycontact> all = new ArrayList<mycontact>();
        URL u;
        try {
            u = new URL(temp[0]);
            HttpURLConnection con = (HttpURLConnection) u.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            InputStream in = con.getInputStream();
            byte[] b = new byte[1024];
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            while(in.read(b) != -1){
                out.write(b);
            }
            String JSONResponse = new String(out.toByteArray());
            Toast.makeText(thisactivity, JSONResponse, Toast.LENGTH_SHORT).show();
//            JSONArray address = new JSONArray(JSONResponse);
//            for(int i=0;i<address.length();i++){
//                if(address.getJSONObject(i)!=null){
//                    all.add();
//                }
//            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } //catch (JSONException e) {
            //e.printStackTrace();
      //  }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mydialog.setTitle("下載資料中...");
        mydialog.show();
    }

    @Override
    protected void onPostExecute(ArrayList<mycontact> mycontacts) {
        super.onPostExecute(mycontacts);
        mydialog.dismiss();

    }
}
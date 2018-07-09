package com.example.administrator.myphpsqltest;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class myinsert extends AsyncTask<String,Void,String> {

    Context thisactivity;

    public myinsert(Context c) {
        thisactivity = c;
    }

    @Override
    protected String doInBackground(String... temp) {
        URL u = null;
        try {
            u = new URL(temp[0]);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod("POST");
            conn.connect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

package com.example.administrator.myphpsqltest;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class myinsert extends AsyncTask<String,Void,String> {

    Context thisactivity;
    String crlf = "\r\n";
    String twoHyphens = "--";
    String boundary =  "*****";
    int index;
    String[] data;

    public myinsert(Context c,String[] temp_data) {
        thisactivity = c;
        data = temp_data;
    }

    @Override
    protected String doInBackground(String... temp) {
        URL u = null;
        try {
            u = new URL(temp[0]);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod("POST");
            //conn.connect();
            conn.setDoOutput(true);

            DataOutputStream request = new DataOutputStream(conn.getOutputStream());
////////////////////////////////////////////////
            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"ContactID\"" + "\"" + this.crlf);
            request.writeBytes(this.crlf);
            Log.i("index=====>",String.valueOf(index));
            request.writeBytes(String.valueOf(index));
            request.writeBytes(this.crlf);

            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"Name\"" + "\"" + this.crlf);
            request.writeBytes(this.crlf);
            request.writeBytes(data[1]);
            request.writeBytes(this.crlf);
            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"Phone\"" + "\"" + this.crlf);
            request.writeBytes(this.crlf);
            request.writeBytes(data[2]);
            request.writeBytes(this.crlf);
            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"Email\"" + "\"" + this.crlf);
            request.writeBytes(this.crlf);
            request.writeBytes(data[3]);
            request.writeBytes(this.crlf);
            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"Birthday\"" + "\"" + this.crlf);
            request.writeBytes(this.crlf);
            request.writeBytes(data[4]);
            request.writeBytes(this.crlf);
            request.writeBytes(this.twoHyphens + this.boundary + this.twoHyphens + this.crlf);

            request.flush();
            request.close();

            conn.connect();

            

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

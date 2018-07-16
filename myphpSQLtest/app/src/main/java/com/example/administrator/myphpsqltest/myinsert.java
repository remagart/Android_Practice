package com.example.administrator.myphpsqltest;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class myinsert extends AsyncTask<String,Void,String> {

    Context thisactivity;
    String crlf = "\r\n";
    String twoHyphens = "--";
    String boundary =  "*****";
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
            conn.setDoInput(true);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Cache-Control", "no-cache");
            conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + this.boundary);
            conn.setRequestProperty("Charset", "UTF-8");
            DataOutputStream request = new DataOutputStream(conn.getOutputStream());
////////////////////////////////////////////////
            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"Name\"" + "\"" + this.crlf);
            request.writeBytes(this.crlf);
            request.write(data[0].getBytes());
            request.writeBytes(this.crlf);
            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"Phone\"" + "\"" + this.crlf);
            request.writeBytes(this.crlf);
            request.writeBytes(data[1]);
            request.writeBytes(this.crlf);
            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"Email\"" + "\"" + this.crlf);
            request.writeBytes(this.crlf);
            request.writeBytes(data[2]);
            request.writeBytes(this.crlf);
            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes("Content-Disposition: form-data; name=\"Birthday\"" + "\"" + this.crlf);
            request.writeBytes(this.crlf);
            request.writeBytes(data[3]);
            request.writeBytes(this.crlf);
            request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
            request.writeBytes(this.crlf);
            request.flush();
            request.close();

            conn.connect();
/////////////////////////////////////
            InputStream is = conn.getInputStream();
            // Read the stream
            byte[] b = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while (is.read(b) != -1)
                baos.write(b);

            String response = new String(baos.toByteArray());
            Log.e("response=", response);
            return response;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}

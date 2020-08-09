package com.example.jfmamjjasond.myphptestsql;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class dbinsert extends AsyncTask<String,Void,Void> {

    private Context thisactivity;
    private String[] alldata = new String[3];
    private ProgressDialog mydialog;
    final private String TWOHYPHENS = "--";
    final private String BOUNDARY = "magicboy";
    final private String CRLF = "\r\n";
    final private String CONTENT_BODY = "Content-Disposition: form-data; name=";

    public dbinsert(){}
    public dbinsert(Context c, String[] data){
        thisactivity = c;
        alldata = data;
        mydialog = new ProgressDialog(thisactivity);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mydialog.setMessage("新增中...");
        mydialog.show();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mydialog.dismiss();
    }

    @Override
    protected Void doInBackground(String... temps) {
        URL myurl;
        try {
            //連線
            myurl = new URL(temps[0]);
            HttpURLConnection myconn = (HttpURLConnection)myurl.openConnection();
            myconn.setRequestMethod("POST");
            myconn.setDoInput(true);
            myconn.setDoOutput(true);
            myconn.setRequestProperty("Connection", "Keep-Alive");
            myconn.setRequestProperty("Cache-Control", "no-cache");
            myconn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);
            myconn.setRequestProperty("Charset", "UTF-8");
            // 將資料寫入內存緩衝區
            DataOutputStream request = new DataOutputStream(myconn.getOutputStream());
            request.writeBytes(TWOHYPHENS + BOUNDARY + CRLF);
            request.writeBytes(CONTENT_BODY + "\"NAME\"" + CRLF);
            request.writeBytes(CRLF);
            request.writeBytes(alldata[0]);
            request.writeBytes(CRLF);

            request.writeBytes(TWOHYPHENS + BOUNDARY + CRLF);
            request.writeBytes(CONTENT_BODY + "\"TEL\"" + CRLF);
            request.writeBytes(CRLF);
            request.writeBytes(alldata[1]);
            request.writeBytes(CRLF);

            request.writeBytes(TWOHYPHENS + BOUNDARY + CRLF);
            request.writeBytes(CONTENT_BODY + "\"MAIL\"" + CRLF);
            request.writeBytes(CRLF);
            request.writeBytes(alldata[2] + CRLF);

            request.writeBytes(TWOHYPHENS + BOUNDARY + TWOHYPHENS);

            //迫使資料緩衝區的資料寫道輸出流
            request.flush();
            request.close();

            //建立與server的tcp連線
            myconn.connect();

            //發送http請求
            InputStream input = myconn.getInputStream();
            // 讀取資料流
//            byte[] b = new byte[1024];
//            ByteArrayOutputStream output = new ByteArrayOutputStream();
//            while (input.read(b) != -1){
//                output.write(b);
//            }
//
//            String response = new String(output.toByteArray());
//            Log.e("response",response);
//
//            Log.e("boundary",BOUNDARY);
//            Log.e("CONTENT_BODY",CONTENT_BODY + "\"NAME\"" + CRLF);
//            Log.e("reference","Content-Disposition: form-data; name=\"Name\"" + "\"" + CRLF);
//            Log.e("alldata[0]",alldata[0]);
//            Log.e("alldata[1]",alldata[1]);
//            Log.e("alldata[2]",alldata[2]);


        } catch (MalformedURLException e) {     // URL的try/catch
            e.printStackTrace();
        } catch (IOException e) {       //http連線的try / catch
            e.printStackTrace();
        }

        return null;
    }

}

package com.example.administrator.myphpsqltest;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
    String attachment;
    int bytesRead, bytesAvailable, bufferSize;
    byte[] buffer;
    int maxBufferSize = 1 * 1024 * 1024;

    public myinsert(Context c,String[] temp_data,String path) {
        thisactivity = c;
        data = temp_data;
        attachment = path;
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
            if(this.attachment != null) {
                File sourceFile = new File(attachment);
                FileInputStream fileInputStream = new FileInputStream(sourceFile);
                request.writeBytes(this.twoHyphens + this.boundary + this.crlf);
                request.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\";filename=\"" + this.attachment + "\"" + this.crlf);
                request.writeBytes(this.crlf);

                bytesAvailable = fileInputStream.available();
                //比較圖檔大小是否大於1024*1024，選擇較小圖檔上傳
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                buffer = new byte[bufferSize];
                ///雖然下載下來但沒有這段下載的圖就沒有解析 >>/
                // 讀取檔案
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
                //寫入串流
                while (bytesRead > 0) {

                    request.write(buffer, 0, bufferSize);
                    bytesAvailable = fileInputStream.available();
                    bufferSize = Math.min(bytesAvailable, maxBufferSize);
                    bytesRead = fileInputStream.read(buffer, 0, bufferSize);

                }
                ///雖然下載下來但沒有這段下載的圖就沒有解析 <</
                request.write(buffer);
                request.writeBytes(this.crlf); //與下一個欄位分隔的斷行
            }
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

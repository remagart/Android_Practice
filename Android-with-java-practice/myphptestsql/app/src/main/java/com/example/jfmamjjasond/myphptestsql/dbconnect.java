package com.example.jfmamjjasond.myphptestsql;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class dbconnect extends AsyncTask<String,Void,ArrayList<basic_info>>{

    private ProgressDialog mydialog;
    private Context thiscontext;

    public dbconnect() {
    }
    public dbconnect(Context c){
        thiscontext = c;
        mydialog = new ProgressDialog(thiscontext);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mydialog.setMessage("下載資料中...");
        mydialog.show();
    }

    @Override
    protected void onPostExecute(ArrayList<basic_info> basic_infos) {
        super.onPostExecute(basic_infos);
        mydialog.dismiss();
    }

    @Override
    protected ArrayList<basic_info> doInBackground(String... temp) {
        ArrayList<basic_info> all_list = new ArrayList<basic_info>();
        URL myurl = null;

        try {
            // 連線
            myurl = new URL(temp[0]);
            HttpURLConnection myconn = (HttpURLConnection)myurl.openConnection();
            myconn.setRequestMethod("GET");
            myconn.connect();
            // 資料流
            InputStream myinput = myconn.getInputStream();
            ByteArrayOutputStream myout = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            while(myinput.read(b) != -1){
                myout.write(b);
            }
            // 將資料轉成JSON形式並丟進Arraylist
            String JSONResponse = new String(myout.toByteArray());
            JSONArray myjson = new JSONArray(JSONResponse);
            for(int i=0;i < myjson.length();i++){
                if(myjson.getJSONObject(i) != null){
                    all_list.add(convert(myjson.getJSONObject(i)));
                }
            }



        } catch (MalformedURLException e) {     //這是URL的try/catch
            e.printStackTrace();
        } catch (IOException e) {       //這是HttpURLConnection的try/catch
            e.printStackTrace();
        } catch (JSONException e) {     //這是JSONArray的try/catch
            e.printStackTrace();
        }


        return all_list;
    }

    public basic_info convert(JSONObject obj_of_json) throws JSONException {
        String name,tel,mail;
        name = obj_of_json.getString("NAME");
        tel = obj_of_json.getString("TEL");
        mail = obj_of_json.getString("MAIL");

        return new basic_info(name,tel,mail);
    }

}

package com.example.administrator.mysensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    Context thisactivity;
    ImageView myimg;
    TextView mytitle;
    //mysensor_v3:SensorManager lets you access the device's sensors.
    SensorManager mySensorManger;
    //mysensor_v3:TYPE_ACCELEROMETER,TYPE_MAGNETIC_FIELD
    Sensor my_acc_Sensor,my_mag_Sensor;

    float mycurrentdegree = 0f;
    float[] my_acc_Values = new float[3];
    float[] my_mag_Values = new float[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;
        init();


    }

    void init(){
        myimg = (ImageView)findViewById(R.id.mainxml_imgview_myimg);
        mytitle = (TextView)findViewById(R.id.mainxml_title);
        //mysensor_v3:在Context類別下SENSOR_SERVICE:
        //Use with "Object getSystemService(String)" to retrieve a SensorManager for accessing sensors.
        mySensorManger = (SensorManager)getSystemService(SENSOR_SERVICE);
        //mysensor_v3:Sensor getDefaultSensor(int type)
        //Use this method to get the default sensor for a given type.
        my_acc_Sensor = mySensorManger.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        my_mag_Sensor = mySensorManger.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mySensorManger.registerListener(this,my_acc_Sensor,mySensorManger.SENSOR_DELAY_NORMAL);
        mySensorManger.registerListener(this,my_mag_Sensor,mySensorManger.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mySensorManger.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

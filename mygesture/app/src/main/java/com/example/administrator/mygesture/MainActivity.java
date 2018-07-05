package com.example.administrator.mygesture;

import android.content.Context;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView myimg;
    Context thisactivity;
    ScaleGestureDetector SGD;
    private Matrix matrix = new Matrix();
    private float scale = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thisactivity = this;
        init();

    }
    void init(){
        myimg = (ImageView)findViewById(R.id.mainxml_imgview_myimg);
        SGD =  new ScaleGestureDetector(this,new myScaleListener());
    }

    class myScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            scale = Math.max(0.1f, Math.min(scale, 5.0f));
            matrix.setScale(scale, scale);
            //myimg.setImageMatrix(matrix);
            return super.onScale(detector);
        }
    }
}

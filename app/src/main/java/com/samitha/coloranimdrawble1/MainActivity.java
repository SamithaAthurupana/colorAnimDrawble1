package com.samitha.coloranimdrawble1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Double> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }

    public class MyView extends View{
        public MyView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            //Build Canvas
            super.onDraw(canvas);
            //Give the size
            int x = getWidth();
            int y = getHeight();
            int radius = 500;

            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);

            // Add Values to ArrayList
            values = new ArrayList<>();
            values.add(111.1);
            values.add(111.9);
            values.add(111.3);
            values.add(111.4);
            values.add(110.5);
            values.add(111.6);
            values.add(111.7);

            //Generate Mean
            double sum = 0.0;
            for (double n : values){
                sum+= n;
            }

            try {
                double mean = sum/values.size();

                //Set Colors on Values
                if (mean <=50.0){
                    paint.setColor(Color.parseColor("#001a1a"));
                    canvas.drawCircle(x/2,y/2,radius,paint);
                    //Status show Toast
                    Toast toast = Toast.makeText(MainActivity.this, "Wrong Input", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(Color.parseColor("#001a1a"));
                    toast.show();
                    Toast toast2 = Toast.makeText(MainActivity.this, "Please check about Values", Toast.LENGTH_LONG);
                    toast2.getView().setBackgroundColor(Color.parseColor("#001a1a"));
                    toast2.show();
                }
                else if (mean <=80.0){
                    paint.setColor(Color.parseColor("#87CEEB"));
                    canvas.drawCircle(x/2,y/2,radius,paint);
                    //Status show Toast
                    Toast toast = Toast.makeText(MainActivity.this, "Hart rate is Low", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(Color.parseColor("#87CEEB"));
                    toast.show();
                }
                else if(mean <=100.0){
                    paint.setColor(Color.parseColor("#B2BEB5"));
                    canvas.drawCircle(x/2,y/2,radius,paint);
                    //Status show Toast
                    Toast toast = Toast.makeText(MainActivity.this, "Hart rate is Normal", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(Color.parseColor("#B2BEB5"));
                    toast.show();
                }
                else if(mean<=140.0){
                    paint.setColor(Color.parseColor("#CD5C5C"));
                    canvas.drawCircle(x/2,y/2,radius,paint);
                    //Status show Toast
                    Toast toast = Toast.makeText(MainActivity.this, "Hart rate is Very High", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(Color.parseColor("#CD5C5C"));
                    toast.show();

                }else{
                    paint.setColor(Color.parseColor("#001a1a"));
                    canvas.drawCircle(x/2,y/2,radius,paint);

                    Toast toast = Toast.makeText(MainActivity.this, "Wrong Input", Toast.LENGTH_LONG);
                    toast.getView().setBackgroundColor(Color.parseColor("#001a1a"));
                    toast.show();
                    Toast toast2 = Toast.makeText(MainActivity.this, "Please check about Values", Toast.LENGTH_LONG);
                    toast2.getView().setBackgroundColor(Color.parseColor("#001a1a"));
                    toast2.show();

                }
            }catch (Exception e){
                Toast.makeText(MainActivity.this, "Please check Values", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
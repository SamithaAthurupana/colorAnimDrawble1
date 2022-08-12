package com.samitha.coloranimdrawble1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.muddz.styleabletoast.StyleableToast;

public class canvasView extends AppCompatActivity {

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
            int radius = 300;


            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);

            // Add Values to ArrayList
            values = new ArrayList<>();
            values.add(130.1);
            values.add(131.9);
            values.add(131.3);
            values.add(131.4);
            values.add(130.5);
            values.add(131.6);
            values.add(131.7);

            //Generate Mean
            double sumOfValues = 0.0;
            for (double n : values){
                sumOfValues+= n;
            }

            try {
                double meanOfValues = sumOfValues/values.size();

                //Set Colors on Values
                if (meanOfValues <=50.0){
                    paint.setColor(Color.parseColor("#FF8E8E8E"));
                    canvas.drawCircle(x/2,y/2,radius,paint);
                    //Status show Toast
                    Toast.makeText(canvasView.this, "Wrong Input", Toast.LENGTH_LONG).show();
                    Toast.makeText(canvasView.this, "Please check about Values", Toast.LENGTH_LONG).show();
                }
                else if (meanOfValues <=80.0){
                    paint.setColor(Color.parseColor("#FFC0A0E8"));
                    canvas.drawCircle(x/2,y/2,radius,paint);
                    //Status show Toast
                    Toast.makeText(canvasView.this, "Hart rate is Low", Toast.LENGTH_LONG).show();
                }
                else if(meanOfValues <=100.0){
                    paint.setColor(Color.parseColor("#FF03A9F4"));
                    canvas.drawCircle(x/2,y/2,radius,paint);
                    //Status show Toast
                    Toast.makeText(canvasView.this, "Hart rate is Normal", Toast.LENGTH_LONG).show();
                }
                else if(meanOfValues<=140.0){
                    paint.setColor(Color.parseColor("#FF018786"));
                    canvas.drawCircle(x/2,y/2,radius,paint);
                    //Status show Toast
                   Toast.makeText(canvasView.this, "Hart rate is Very High", Toast.LENGTH_SHORT).show();



                }else{
                    paint.setColor(Color.parseColor("#FF8E8E8E"));
                    canvas.drawCircle(x/2,y/2,radius,paint);

                    Toast.makeText(canvasView.this, "Wrong Input", Toast.LENGTH_LONG).show();
                    Toast.makeText(canvasView.this, "Please check about Values", Toast.LENGTH_LONG).show();

                }
            }catch (Exception e){
                Toast.makeText(canvasView.this, "Please check Values", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
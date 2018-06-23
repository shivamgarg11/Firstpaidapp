package com.shivam.multitouch;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Boolean flag=false;
    Boolean flag2=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button1,button2,button3,button4;
        final TextView text;

        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);

text=findViewById(R.id.TEXT);



//~~~~~~~~~~~~~~~~~~~~~~~~~NORMAL BUTTON CALL~~~~~~~~~~~~~~~~~~~~~~
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(flag){
                   text.setText("1+3");
                   flag=false;
               }
                else if(flag2){
                   text.setText("2+3");
                   flag2=false;
               }else{
                   text.setText("3");
               }

            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    text.setText("1+4");
                    flag=false;
                }
                else if(flag2){
                    text.setText("2+4");
                    flag2=false;
                }else{
                    text.setText("4");
                }
            }
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ USING ON TOUCH LISTENER~~~~~~~~~~~~~~~~~~~~~

        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){
                   // longpress1=true;
                    flag=true;
                    return false;
                }

                if (event.getAction()==MotionEvent.ACTION_UP){
                    if(flag){
                        text.setText("1");
                        flag=false;
                    }
                }
                return false;

            }
        });


        button2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction()==MotionEvent.ACTION_DOWN){
                    // longpress1=true;
                    flag2=true;
                    return false;
                }

                if (event.getAction()==MotionEvent.ACTION_UP){
                    if(flag2){
                        text.setText("2");
                        flag2=false;
                    }
                }
                return false;

            }
        });
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }
}

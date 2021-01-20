package com.weekenddevelopers.tamilaptitude;

import android.content.Intent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        splashlogo sl=new splashlogo();
        sl.start();


    }
    private ImageView weekenddev;
    private ImageView tirukural;
    private ImageView splahs;
    private TextView textViewone;
    private TextView title;


    private class splashlogo extends Thread{


        public void run() {
            try {
                weekenddev=findViewById(R.id.weekendlogo);
                tirukural=findViewById(R.id.thirukural);
                splahs=findViewById(R.id.splash_logo);
                textViewone=findViewById(R.id.textview_one);
                title=findViewById(R.id.title);
                sleep(1500);
                tirukural.animate().alpha(0f).setDuration(800);

                weekenddev.animate().alpha(1f).setDuration(1500);
                splahs.animate().alpha(1f).setDuration(1500);
                textViewone.animate().alpha(1f).setDuration(1500);
                title.animate().alpha(1f).setDuration(1500);
                weekenddev.animate().alpha(1f).setDuration(1500);


                sleep(2000);





            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent in =new Intent(Splash_Screen.this,MainActivity.class);
            startActivity(in);

            Splash_Screen.this.finish();
        }
    }
}

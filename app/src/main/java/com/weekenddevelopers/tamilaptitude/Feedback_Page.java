package com.weekenddevelopers.tamilaptitude;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Feedback_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback__page);
    }

    public void onclickplaysotre(View view){
        final String appPackageName = getApplicationContext().getPackageName();
        String likeus="";
        try{
            likeus="https://play.google.com/store/apps/details?id="+appPackageName;
        }catch (android.content.ActivityNotFoundException e){
            likeus="https://play.google.com/store/apps/details?id="+appPackageName;
        }
        Uri uri=Uri.parse(likeus);
        Intent in= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(in);

    }

    public void onclickfacebook(View view){
        Uri uri = Uri.parse("https://www.facebook.com/weekenddevelopers01");
        Intent in = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(in);
    }
}

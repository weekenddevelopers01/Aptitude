package com.weekenddevelopers.tamilaptitude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Practice_Home_Page extends AppCompatActivity {



    public static final String EXTRA_CATEGORY="extraCategory";

    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice__home__page2);
        MobileAds.initialize(this,"ca-app-pub-5376812679381678/1065768227");

        adView =findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);




    }
    public  void  onnumberclick(View view){
        String category="numbers";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);
    }
    public void onlcmhcfclick(View view){
        String category="lcmhcf";
        Intent in =new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);
    }
    public void ondecimalfractionclick(View view){
        String category="decimal";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);

    }
    public void onsimplificationclick(View view){
        String category="simplification";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);

    }

    public void onaverageclick(View view){
        String category="average";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);
    }

    public void onpercentageclick(View view){
        String category="percentage";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);
    }

    public void onclickprofitloss(View view){
        String category="profitloss";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);
    }

    public void onclicktimedistance(View view){
        String category="timedistance";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);
    }

    public void onclicktimework(View view){
        String category="timework";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);
    }

    public void onclicksimpleinterest(View view){
        String category="simpleinterest";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);
    }
}

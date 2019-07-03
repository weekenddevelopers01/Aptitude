package com.weekenddevelopers.tamilaptitude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Formula_Home_Page extends AppCompatActivity {
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula__home__page2);
        MobileAds.initialize(this,"ca-app-pub-5376812679381678/1065768227");

        adView =findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }


    public  void  onnumberclick(View view){
        Intent in=new Intent(this,Formula_Number_Page.class);
        startActivity(in);
    }
    public void onlcmhcfclick(View view){
        Intent in =new Intent(this,Formula_LcmHcf_Page.class);
        startActivity(in);
    }
    public void ondecimalfractionclick(View view){
        Intent in=new Intent(this,Formula_DecimalFraction_Page.class);
        startActivity(in);

    }
    public void onsimplificationclick(View view){
        Intent in=new Intent(this,Formula_Simplification.class);
        startActivity(in);

    }

    public void onaverageclick(View view){
        Intent in=new Intent(this,Formula_Average_Page.class);
        startActivity(in);
    }

    public void onpercentageclick(View view){
        Intent in=new Intent(this,Formula_Percentage_Page.class);
        startActivity(in);
    }

    public void onclickprofitloss(View view){
        Intent in=new Intent(this,Formula_ProfitLoss_Page.class);
        startActivity(in);
    }

    public void onclicktimedistance(View view){
        Intent in=new Intent(this,Formula_TimeDistance_Page.class);
        startActivity(in);
    }

    public void onclicktimework(View view){
        Intent in=new Intent(this,Formula_TimeWork_Page.class);
        startActivity(in);
    }

    public void onclicksimpleinterest(View view){
        Intent in=new Intent(this,Formula_SimpleInterest_Page.class);
        startActivity(in);
    }

}
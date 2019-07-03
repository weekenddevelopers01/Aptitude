package com.weekenddevelopers.tamilaptitude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Result_Page extends AppCompatActivity {

    private TextView textView_total;
    private TextView textView_right;
    private TextView textView_wrong;

    private int total;
    private int right;
    private int wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result__page);
        textView_total=findViewById(R.id.text_view_total_score);
        textView_right=findViewById(R.id.text_view_right);
        textView_wrong=findViewById(R.id.text_view_wrong);
        Intent in=getIntent();

        this.total= in.getIntExtra("total",0);
        this.right= in.getIntExtra("score",0);
        wrong=total-right;

        textView_total.setText("Total  : "+total);
        textView_right.setText("Right  : "+right);
        textView_wrong.setText("Wrong  : "+wrong);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-5376812679381678/7565640113");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd.setAdListener(new AdListener() {
                                         @Override
                                         public void onAdLoaded() {

                                             if (interstitialAd.isLoaded()) {
                                                 interstitialAd.show();
                                             }

                                         }});

    }

    InterstitialAd interstitialAd;

    @Override
    public void onBackPressed() {

        finish();

    }
}

package com.weekenddevelopers.tamilaptitude;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Hint_PopUP_Page extends AppCompatActivity {

    private TextView textView_hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint__pop_up__page);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-5376812679381678/7565640113");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {

                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                }

            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                finish();

            }
        });
        Intent intent=getIntent();
        String hint=intent.getStringExtra(Practice_Quiz_Page.EXTRA_HINT);
        textView_hint=findViewById(R.id.text_view_hint);

        textView_hint.setText(hint);

        DisplayMetrics dm= new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.widthPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.9  ));
    }
    InterstitialAd interstitialAd;


}

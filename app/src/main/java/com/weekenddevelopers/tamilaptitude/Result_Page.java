package com.weekenddevelopers.tamilaptitude;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.weekenddevelopers.tamilaptitude.BroadcastReciver.Initialize_InterstitialAd;


public class Result_Page extends AppCompatActivity implements MoPubInterstitial.InterstitialAdListener   {

    private TextView textView_total;
    private TextView textView_right;
    private TextView textView_wrong;

    private int total;
    private int right;
    private int wrong;

    private MoPubInterstitial mInterstitial;

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

        mInterstitial = new MoPubInterstitial(this,"15e8b06031d4497daf8d5b5f0099ffef");
        mInterstitial.setInterstitialAdListener(this);
        Initialize_InterstitialAd interstitialAd = new Initialize_InterstitialAd(this);
        interstitialAd.initializeSDK();


    }

    @Override
    protected void onStop() {
        super.onStop();
        mInterstitial.load();
    }

    @Override
    public void onBackPressed() {

        finish();

    }

    @Override
    public void onInterstitialLoaded(MoPubInterstitial interstitial) {
        yourAppsShowInterstitialMethod();
    }

    @Override
    public void onInterstitialFailed(MoPubInterstitial interstitial, MoPubErrorCode errorCode) {

    }

    @Override
    public void onInterstitialShown(MoPubInterstitial interstitial) {

    }

    @Override
    public void onInterstitialClicked(MoPubInterstitial interstitial) {

    }

    @Override
    public void onInterstitialDismissed(MoPubInterstitial interstitial) {

    }

    void yourAppsShowInterstitialMethod() {
        if (mInterstitial.isReady()) {
            mInterstitial.show();
        } else {
            Toast.makeText(this, "NOt ready", Toast.LENGTH_SHORT).show();
            // Caching is likely already in progress if `isReady()` is false.
            // Avoid calling `load()` here and instead rely on the callbacks as suggested below.
        }
    }
}

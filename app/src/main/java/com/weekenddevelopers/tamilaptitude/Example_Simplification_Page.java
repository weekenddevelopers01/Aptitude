package com.weekenddevelopers.tamilaptitude;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubView;
import com.weekenddevelopers.tamilaptitude.BroadcastReciver.Initialize_BannerAd;
import com.weekenddevelopers.tamilaptitude.BroadcastReciver.Initialize_InterstitialAd;


public class Example_Simplification_Page extends AppCompatActivity implements MoPubInterstitial.InterstitialAdListener  {

//    AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example__simplification__page);
        moPubView =  findViewById(R.id.banner_Ad);
        moPubView.setAdUnitId("621c3f8064bb41ca8196e0b8583f81b3");
        Initialize_BannerAd bannerAd =  new Initialize_BannerAd(this,moPubView);
        timmer= System.currentTimeMillis();
        bannerAd.initializeSDK();

        mInterstitial = new MoPubInterstitial(this,"15e8b06031d4497daf8d5b5f0099ffef");
        mInterstitial.setInterstitialAdListener(this);
        Initialize_InterstitialAd interstitialAd = new Initialize_InterstitialAd(this);
        interstitialAd.initializeSDK();
    }

    private MoPubView moPubView;

    @Override
    protected void onDestroy() {
        moPubView.destroy();
        super.onDestroy();
    }

    private MoPubInterstitial mInterstitial;

    long timmer;

@Override
    protected void onPause() {
        if(timmer+100000<System.currentTimeMillis()){
        mInterstitial.load();}
        else {
            mInterstitial.destroy();
        }
        super.onPause();
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

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



}

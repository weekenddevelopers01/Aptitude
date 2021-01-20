package com.weekenddevelopers.tamilaptitude.BroadcastReciver;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class Initialize_BannerAd extends AppCompatActivity implements MoPubView.BannerAdListener  {

    Context context;
    MoPubView moPubView;

    public Initialize_BannerAd(Context context, MoPubView moPubView){
        this.context = context;
        this.moPubView = moPubView;
    }


    public void initializeSDK(){
        // configurations required to initialize
        Map<String, String> mediatedNetworkConfiguration1 = new HashMap<>();
        mediatedNetworkConfiguration1.put("<custom-adapter-class-data-key>", "<custom-adapter-class-data-value>");
        Map<String, String> mediatedNetworkConfiguration2 = new HashMap<>();
        mediatedNetworkConfiguration2.put("<custom-adapter-class-data-key>", "<custom-adapter-class-data-value>");

        SdkConfiguration sdkConfiguration = new SdkConfiguration.Builder("621c3f8064bb41ca8196e0b8583f81b3")
                .withLegitimateInterestAllowed(false)
                .build();


        MoPub.initializeSdk(context, sdkConfiguration, initSdkListener());

    }

    private SdkInitializationListener initSdkListener() {

        return new SdkInitializationListener() {
            @Override
            public void onInitializationFinished() {

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("5555555555555555555");
                        moPubView.loadAd();
                    }
                },1000);


            }
        };
    }

    @Override
    public void onBannerLoaded(@NonNull MoPubView banner) {
        Toast.makeText(context, " ads loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBannerFailed(MoPubView banner, MoPubErrorCode errorCode) {
        Toast.makeText(context, " ads onBannerFailed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBannerClicked(MoPubView banner) {
        Toast.makeText(context, " ads onBannerClicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBannerExpanded(MoPubView banner) {
        Toast.makeText(context, " ads onBannerExpanded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBannerCollapsed(MoPubView banner) {
        Toast.makeText(context, " ads onBannerCollapsed", Toast.LENGTH_SHORT).show();
    }
}

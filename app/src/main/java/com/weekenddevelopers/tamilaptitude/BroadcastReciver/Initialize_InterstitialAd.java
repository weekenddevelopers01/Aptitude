package com.weekenddevelopers.tamilaptitude.BroadcastReciver;

import android.content.Context;
import android.widget.Toast;

import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubView;

import java.util.HashMap;
import java.util.Map;

public class Initialize_InterstitialAd {

    Context context;
//    MoPubView moPubView;

 public Initialize_InterstitialAd(Context context){
        this.context = context;
//        this.moPubView = moPubView;
    }

    public void initializeSDK(){
        // configurations required to initialize
        Map<String, String> mediatedNetworkConfiguration1 = new HashMap<>();
        mediatedNetworkConfiguration1.put("<custom-adapter-class-data-key>", "<custom-adapter-class-data-value>");
        Map<String, String> mediatedNetworkConfiguration2 = new HashMap<>();
        mediatedNetworkConfiguration2.put("<custom-adapter-class-data-key>", "<custom-adapter-class-data-value>");

        SdkConfiguration sdkConfiguration = new SdkConfiguration.Builder("15e8b06031d4497daf8d5b5f0099ffef")
                .withLegitimateInterestAllowed(false)
                .build();

        MoPub.initializeSdk(context, sdkConfiguration, initSdkListener());
    }

    private SdkInitializationListener initSdkListener() {
        return new SdkInitializationListener() {
            @Override
            public void onInitializationFinished() {
//
            }

        };
    }



}

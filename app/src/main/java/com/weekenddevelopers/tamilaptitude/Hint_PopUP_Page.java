package com.weekenddevelopers.tamilaptitude;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;
import android.widget.Toast;

import com.mopub.common.MoPub;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;

//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.InterstitialAd;

public class Hint_PopUP_Page extends AppCompatActivity  {

    private TextView textView_hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint__pop_up__page);



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








}

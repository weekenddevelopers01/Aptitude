package com.weekenddevelopers.tamilaptitude;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mopub.mobileads.MoPubView;
import com.weekenddevelopers.tamilaptitude.BroadcastReciver.Initialize_BannerAd;
import com.weekenddevelopers.tamilaptitude.BroadcastReciver.Network_Check;


public class Practice_Home_Page extends AppCompatActivity {



    public static final String EXTRA_CATEGORY="extraCategory";
    private MoPubView moPubView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice__home__page2);
        moPubView = (MoPubView) findViewById(R.id.banner_Ad);
        moPubView.setAdUnitId("621c3f8064bb41ca8196e0b8583f81b3");
        Initialize_BannerAd bannerAd =  new Initialize_BannerAd(this,moPubView);

        bannerAd.initializeSDK();



    }
    public  void  onnumberclick(View view){
        if(check()){
        String category="numbers";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
        Network_Check.isNetworkconnected(this);
    }
    }
    public void onlcmhcfclick(View view){
        if(check()){
        String category="lcmhcf";
        Intent in =new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }
    public void ondecimalfractionclick(View view){
        if(check()){
        String category="decimal";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
        Network_Check.isNetworkconnected(this);
    }

    }
    public void onsimplificationclick(View view){
        if(check()){
        String category="simplification";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }

    public void onaverageclick(View view){
        if(check()){
        String category="average";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
        Network_Check.isNetworkconnected(this);
    }
    }

    public void onpercentageclick(View view){
        if(check()){
        String category="percentage";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickprofitloss(View view){
        if(check()){
        String category="profitloss";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclicktimedistance(View view){
        if(check()){
        String category="timedistance";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclicktimework(View view){
        if(check()){
        String category="timework";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclicksimpleinterest(View view){
        if(check()){
        String category="simpleinterest";
        Intent in=new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickages(View view){
        if(check()){
        String category="problemonages";
        Intent in = new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }
    public void onclickratio(View view){
        if(check()){
        String category="ratio";
        Intent in = new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }

    public void onclickpipe(View view){
        if(check()){
        String category="pipe";
        Intent in = new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }
    public void onclicktrain(View view){
        if(check()){
        String category="problemontrain";
        Intent in = new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }

    public void onclickboat(View view){
        if(check()){
        String category="boat";
        Intent in = new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }
    public void onclickMix(View view){
        if(check()){
        String category="mixture";
        Intent in = new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }

    public void onclickcompound(View view){
        if(check()){
        String category="compoundinterest";
        Intent in = new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }
    public void onclickarea(View view){
        if(check()){
        String category="area";
        Intent in = new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
        Network_Check.isNetworkconnected(this);
    }

    }

    public void onclickvolume(View view){
        if(check()){
        String category="volumes";
        Intent in = new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }
    public void onclickcalender(View view){
        if(check()){
        String category="calender";
        Intent in = new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }

    public void onclickheightdistance(View view){
        if(check()){
        String category="heightanddistance";
        Intent in = new Intent(this,Practice_Quiz_Page.class);
        in.putExtra(EXTRA_CATEGORY,category);
        startActivity(in);}
        else{
        Network_Check.isNetworkconnected(this);
    }

    }

    private boolean check(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        return ni != null && ni.isConnected();


    }
    @Override
    protected void onDestroy() {
        moPubView.destroy();
        super.onDestroy();
    }
}

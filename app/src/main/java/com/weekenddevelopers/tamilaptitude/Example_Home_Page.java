package com.weekenddevelopers.tamilaptitude;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubView;
import com.weekenddevelopers.tamilaptitude.BroadcastReciver.Initialize_BannerAd;
import com.weekenddevelopers.tamilaptitude.BroadcastReciver.Network_Check;


public class Example_Home_Page extends AppCompatActivity{

    private MoPubView moPubView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example__home__page2);
        moPubView = (MoPubView) findViewById(R.id.banner_Ad);
        moPubView.setAdUnitId("621c3f8064bb41ca8196e0b8583f81b3");
        Initialize_BannerAd bannerAd =  new Initialize_BannerAd(this,moPubView);

        bannerAd.initializeSDK();
    }
    private boolean check(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        return ni != null && ni.isConnected();
    }


    public void onnumberclick(View view){
        if(check()){
        Intent in =new Intent(this,Example_Number_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }

    public void onlcmhcfclick(View view){
        if(check()){
        Intent in =new Intent(this,Example_LcmHcf_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }

    public void ondecimalfractionclick(View view){
        if(check()){
        Intent in =new Intent(this,Example_Decimal_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }
    public void onsimplificationclick(View view){
        if(check()){
        Intent in =new Intent(this,Example_Simplification_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }

    public void onaverageclick(View view){
        if(check()){
        Intent in =new Intent(this,Example_Average_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }
    public void onpercentageclick(View view){
        if(check()){
        Intent in =new Intent(this,Example_Percentage_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }
    public void onclickprofitloss(View view){
        if(check()){
        Intent in =new Intent(this,Example_ProfitLoss_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }
    public void onclicktimedistance(View view){
        if(check()){
        Intent in =new Intent(this,Example_TimeDistance_Page.class);
        startActivity(in);
        }
        else{
            Network_Check.isNetworkconnected(this);
        }

    }
    public void onclicktimework(View view){
        if(check()){
        Intent in =new Intent(this,Example_TimeWork_Page.class);
        startActivity(in);}
        else{
        Network_Check.isNetworkconnected(this);
    }

    }
    public void onclicksimpleinterest(View view){
        if(check()){
        Intent in =new Intent(this,Example_SimpleInterest_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }

    public void onclickages(View view) {
        if(check()){
        Intent in =new Intent(this,Example_ProblemOnAges_Page.class);
        startActivity(in);}
        else{
        Network_Check.isNetworkconnected(this);
    }
    }

    public void onclickratio(View view) {
        if(check()){
        Intent in =new Intent(this,Example_Ratio_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickpipe(View view) {
        if(check()){
        Intent in =new Intent(this,Example_Pipe_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclicktrain(View view) {
        if(check()){
        Intent in =new Intent(this,Example_Train_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickboat(View view) {
        if(check()){
        Intent in =new Intent(this,Example_Boat_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickMix(View view) {
        if(check()){
        Intent in =new Intent(this,Example_Mix_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickcompound(View view) {
        if(check()){
        Intent in =new Intent(this, Example_Comp_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickarea(View view) {
        if(check()){
        Intent in =new Intent(this, Example_Area_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }

    public void onclickvolume(View view) {
        if(check()){
        Intent in =new Intent(this, Example_Volume_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickcalender(View view) {
        if(check()){
        Intent in =new Intent(this, Example_Calender_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickheightdistance(View view) {
        if(check()){
        Intent in =new Intent(this, Example_HeightDistance_Page.class);
        startActivity(in);
        }
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    @Override
    protected void onDestroy() {
        moPubView.destroy();
        super.onDestroy();
    }
}

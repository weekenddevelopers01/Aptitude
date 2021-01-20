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


public class Formula_Home_Page extends AppCompatActivity {
//    AdView adView;
    private MoPubView moPubView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula__home__page2);
        moPubView =  findViewById(R.id.banner_Ad);
        moPubView.setAdUnitId("621c3f8064bb41ca8196e0b8583f81b3");
        Initialize_BannerAd bannerAd =  new Initialize_BannerAd(this,moPubView);

        bannerAd.initializeSDK();
    }


    public  void  onnumberclick(View view){
        if(check()){
        Intent in=new Intent(this,Formula_Number_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }
    public void onlcmhcfclick(View view){
        if(check()){
        Intent in =new Intent(this,Formula_LcmHcf_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }
    public void ondecimalfractionclick(View view){
        if(check()){
        Intent in=new Intent(this,Formula_DecimalFraction_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }
    public void onsimplificationclick(View view){
        if(check()){
        Intent in=new Intent(this,Formula_Simplification.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }

    }

    public void onaverageclick(View view){
        if(check()){
        Intent in=new Intent(this,Formula_Average_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onpercentageclick(View view){
        if(check()){
        Intent in=new Intent(this,Formula_Percentage_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickprofitloss(View view){
        if(check()){
        Intent in=new Intent(this,Formula_ProfitLoss_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclicktimedistance(View view){
        if(check()){
        Intent in=new Intent(this,Formula_TimeDistance_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclicktimework(View view){
        if(check()){
        Intent in=new Intent(this,Formula_TimeWork_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclicksimpleinterest(View view){
        if(check()){
        Intent in=new Intent(this,Formula_SimpleInterest_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickages(View view) {
        if(check()){
        Intent in=new Intent(this,Formula_ProblemOnAges_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickratio(View view) {
        if(check()){
        Intent in=new Intent(this,Formula_Ratio_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickpipe(View view) {
        if(check()){
        Intent in=new Intent(this,Formula_Pipe_page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclicktrain(View view) {
        if(check()){
        Intent in=new Intent(this,Formula_Train_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickboat(View view) {
        if(check()){
        Intent in=new Intent(this,Formula_Boat_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickMix(View view) {
        if(check()){
        Intent in=new Intent(this,Formula_Mix_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickcompound(View view) {
        if(check()){
        Intent in=new Intent(this,Formula_Compound_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickarea(View view) {
        if(check()){
        Intent in=new Intent(this,Formula_Area_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickvolume(View view) {
            if(check()){
        Intent in=new Intent(this,Formula_Volume_Page.class);
        startActivity(in);}
            else{
                Network_Check.isNetworkconnected(this);
            }
    }

    public void onclickcalender(View view) {
        if(check()){
        Intent in=new Intent(this,Formula_Calender_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

    public void onclickheightdistance(View view) {
        if(check()){
        Intent in=new Intent(this,Formula_HeightDistance_Page.class);
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

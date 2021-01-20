package com.weekenddevelopers.tamilaptitude;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.mopub.mobileads.MoPubView;
import com.weekenddevelopers.tamilaptitude.BroadcastReciver.AlarmReciver;
import com.weekenddevelopers.tamilaptitude.BroadcastReciver.Initialize_BannerAd;
import com.weekenddevelopers.tamilaptitude.BroadcastReciver.Network_Check;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private MoPubView moPubView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moPubView = (MoPubView) findViewById(R.id.banner_Ad);
        moPubView.setAdUnitId("621c3f8064bb41ca8196e0b8583f81b3");
        Initialize_BannerAd bannerAd =  new Initialize_BannerAd(this,moPubView);

        bannerAd.initializeSDK();



        createnotification();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        registerAlarm1();
//        MobileAds.initialize(this,"ca-app-pub-5376812679381678/1065768227");
//
//        adView =findViewById(R.id.adView);
//        AdRequest adRequest=new AdRequest.Builder().build();
//        adView.loadAd(adRequest);

//        isNetworkAvailable(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

    private void registerAlarm1() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 12);


        Intent in =new Intent(this, AlarmReciver.class);
        PendingIntent pendingIntent= PendingIntent.getBroadcast(MainActivity.this,0,in,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am= (AlarmManager)this.getSystemService(this.ALARM_SERVICE);
        am.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);

    }

    public void createnotification(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "Test_Channel";
            String describtion = "This is the describtion";

            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notification1",name,importance);
            channel.setDescription(describtion);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void isNetworkAvailable(Context sContext) {
        try {
            ConnectivityManager connectivity = (ConnectivityManager) sContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                NetworkInfo[] info = connectivity.getAllNetworkInfo();
                if (info != null)
                    for (int i = 0; i < info.length; i++)
                        if (info[i].getState() == NetworkInfo.State.DISCONNECTED) {
                            finish();
                        }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //exit the app

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Would You Like to Rate Us")
                        .setPositiveButton("Rate", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                rateUs();
                            }
                        });
            alertDialog.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });

            AlertDialog alertDialogs = alertDialog.create();
            alertDialogs.show();
//            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about_us) {
            Intent in = new Intent(this,About_Page.class);
            startActivity(in);
        } else if (id == R.id.nav_feedback) {
            Intent in = new Intent(this,Feedback_Page.class);
            startActivity(in);

        } else if (id == R.id.nav_policy) {
            Intent in = new Intent(this,Policy_Page.class);
            startActivity(in);

        } else if (id==R.id.nav_Share){
            Intent send = new Intent(Intent.ACTION_SEND);

            final String appPackageName = getApplicationContext().getPackageName();
            String strApplink="";

            try{
                strApplink="https://play.google.com/store/apps/details?id="+ appPackageName;
            }catch (android.content.ActivityNotFoundException e){
                strApplink="https://play.google.com/store/apps/details?id="+ appPackageName;
            }
            send.setType("text/link");
            String shareto ="Tamil Aptitude\nShare this Aptitude app with your friends to help them to improve their maths skill"+"\n"+strApplink;
            String shareSub = "app name";

            send.putExtra(Intent.EXTRA_SUBJECT,shareSub);
            send.putExtra(Intent.EXTRA_TEXT,shareto);
            startActivity(Intent.createChooser(send,"share using"));

        } else if(id==R.id.nav_like){
            rateUs();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void rateUs(){
        final String appPackageName = getApplicationContext().getPackageName();

        String likeus="";
        try{
            likeus="https://play.google.com/store/apps/details?id="+appPackageName;
        }catch (android.content.ActivityNotFoundException e){
            likeus="https://play.google.com/store/apps/details?id="+appPackageName;
        }
        Uri uri=Uri.parse(likeus);
        Intent in= new Intent(Intent.ACTION_VIEW,uri);
        startActivity(in);
    }

    public void onformulahome(View view){
        if(check()){
        Intent in= new Intent(this,Formula_Home_Page.class);
        startActivity(in);}
        else {
            Network_Check.isNetworkconnected(this);
        }
    }
    public void onexamplehome(View view){
        if(check()){
        Intent in= new Intent(this,Example_Home_Page.class);
        startActivity(in);}
        else {
            Network_Check.isNetworkconnected(this);
        }

    }
    public void onpracticehome(View view){
        if(check()){
        Intent in= new Intent(this,Practice_Home_Page.class);
        startActivity(in);}
        else {
            Network_Check.isNetworkconnected(this);
        }
    }
    public void ontesthome(View view){
        if(check()){
        Intent in= new Intent(this,Test_Home_Page.class);
        startActivity(in);}
        else{
            Network_Check.isNetworkconnected(this);
        }
    }

//    public void onexitclick(View view){
//        finish();
//    }

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

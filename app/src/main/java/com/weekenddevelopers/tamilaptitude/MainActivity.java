package com.weekenddevelopers.tamilaptitude;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.weekenddevelopers.tamilaptitude.BroadcastReciver.AlarmReciver;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        registerAlarm1();
        MobileAds.initialize(this,"ca-app-pub-5376812679381678/1065768227");

        adView =findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);



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
        calendar.set(Calendar.HOUR_OF_DAY, 10);

        Intent in =new Intent(this, AlarmReciver.class);
        PendingIntent pendingIntent= PendingIntent.getBroadcast(MainActivity.this,0,in,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am= (AlarmManager)this.getSystemService(this.ALARM_SERVICE);
        am.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onformulahome(View view){
        Intent in= new Intent(this,Formula_Home_Page.class);
        startActivity(in);
    }
    public void onexamplehome(View view){
        Intent in= new Intent(this,Example_Home_Page.class);
        startActivity(in);
    }
    public void onpracticehome(View view){
        Intent in= new Intent(this,Practice_Home_Page.class);
        startActivity(in);
    }
    public void ontesthome(View view){
        Intent in= new Intent(this,Test_Home_Page.class);
        startActivity(in);
    }

//    public void onexitclick(View view){
//        finish();
//    }
}

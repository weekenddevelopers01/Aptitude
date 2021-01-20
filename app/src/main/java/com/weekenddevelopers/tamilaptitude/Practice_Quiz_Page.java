package com.weekenddevelopers.tamilaptitude;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import com.mopub.mobileads.MoPubView;
import com.weekenddevelopers.tamilaptitude.BroadcastReciver.Initialize_BannerAd;
import com.weekenddevelopers.tamilaptitude.BroadcastReciver.Initialize_InterstitialAd;
import com.weekenddevelopers.tamilaptitude.BroadcastReciver.Network_Check;

import java.util.Collections;
import java.util.List;

public class Practice_Quiz_Page extends AppCompatActivity implements MoPubInterstitial.InterstitialAdListener {


    private TextView textView_english_question;
    private TextView textView_tamil_question;
    private TextView textView_score;
    private TextView textView_question_count;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private String hint;
    private Button btn_confirm_next;
    private ColorStateList textColorDefaultRb;
    private MoPubInterstitial mInterstitial;

    private List<Practice_Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Practice_Question currentQuestion;
    private boolean answered;

    private String category;
    static int total;
    static int right;
//    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice__quiz__page);

        textView_english_question=findViewById(R.id.text_view_english_question);
        textView_tamil_question=findViewById(R.id.text_view_tamil_question);
        textView_score=findViewById(R.id.text_view_score);
        textView_question_count=findViewById(R.id.text_view_question_count);
        rbGroup=findViewById(R.id.radio_group_option);
        rb1=findViewById(R.id.rb_option1);
        rb2=findViewById(R.id.rb_option2);
        rb3=findViewById(R.id.rb_option3);
        rb4=findViewById(R.id.rb_option4);
        btn_confirm_next=findViewById(R.id.btn_confirm_next);
        textColorDefaultRb=rb1.getTextColors();

        moPubView =  findViewById(R.id.banner_Ad);
        moPubView.setAdUnitId("621c3f8064bb41ca8196e0b8583f81b3");
        Initialize_BannerAd bannerAd =  new Initialize_BannerAd(this,moPubView);

        bannerAd.initializeSDK();
        Intent intent= getIntent();
         category=intent.getStringExtra(Practice_Home_Page.EXTRA_CATEGORY);


        Practice_QuizDbHelper dbHelper=new Practice_QuizDbHelper(this);
        questionList=dbHelper.getAllQuestions(category);
        questionCountTotal=questionList.size();
        Log.d("questionCountTotal", String.valueOf(questionCountTotal));
        Collections.shuffle(questionList);
        showNextQuestion();
        btn_confirm_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(check()) {
                    if (!answered) {
                        if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                            checkAnswer();
                        } else {
                            Toast.makeText(Practice_Quiz_Page.this, "Select answer", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        showNextQuestion();
                    }
                }
                else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                }
            }
        });

    }

    private boolean check(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        return ni != null && ni.isConnected();


    }

    private MoPubView moPubView;

    @Override
    protected void onDestroy() {
        moPubView.destroy();
//        mInterstitial.destroy();
        super.onDestroy();
    }

    private int score;

    private void checkAnswer(){
        answered=true;
        RadioButton rbSelected=findViewById(rbGroup.getCheckedRadioButtonId());
        int answerNr=rbGroup.indexOfChild(rbSelected)+1;

        if(answerNr==currentQuestion.getAnswerNr()){
            score++;
            textView_score.setText("Score :"+score);

        }
        showSolution();
    }

    private void showSolution(){
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNr()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
        }

        if (questionCounter<questionCountTotal){
            btn_confirm_next.setText("Next-->>>");
        }
        else {
            btn_confirm_next.setText("-->>> Finish <<<--");
        }
    }


    private void showNextQuestion(){
        rb1.setTextColor(textColorDefaultRb);
        rb2.setTextColor(textColorDefaultRb);
        rb3.setTextColor(textColorDefaultRb);
        rb4.setTextColor(textColorDefaultRb);
        rbGroup.clearCheck();

        if (questionCounter<questionCountTotal){

            currentQuestion=questionList.get(questionCounter);
            textView_tamil_question.setText(currentQuestion.getQuestion_tamil());
            textView_english_question.setText(currentQuestion.getQuestion_english());
            rb1.setText(currentQuestion.getOption1());
            rb2.setText(currentQuestion.getOption2());
            rb3.setText(currentQuestion.getOption3());
            rb4.setText(currentQuestion.getOption4());
            hint=currentQuestion.getHint();

            questionCounter++;
            textView_question_count.setText("Question :"+ questionCounter+"/"+questionCountTotal);
            answered=false;
            btn_confirm_next.setText("Confirm");

        }
        else {
            result();
        }
    }

    public static final String EXTRA_TOTAL="total";
    public static final String EXTRA_SCORE="score";

    private void result(){
        Intent in=new Intent(this,Result_Page.class);
        in.putExtra(EXTRA_TOTAL,questionCountTotal);
        in.putExtra(EXTRA_SCORE,score);

        startActivity(in);

        finishQuiz();
    }


    public static final String EXTRA_HINT="hint";
    public void onhintclick(View view){

        if(check()){
            mInterstitial = new MoPubInterstitial(this,"15e8b06031d4497daf8d5b5f0099ffef");
        mInterstitial.setInterstitialAdListener(this);
        Initialize_InterstitialAd interstitialAd = new Initialize_InterstitialAd(this);
        interstitialAd.initializeSDK();
            mInterstitial.load();
        }
        else{
            Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
        }
    }


    public void onformulclick(View view){


        switch (category){
            case "numbers":
                if (check()){
                Intent in1=new Intent(this,Formula_Number_Page.class);
                startActivity(in1);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;
                }

            case "lcmhcf":
                if(check()){
                Intent in2=new Intent(this,Formula_LcmHcf_Page.class);
                startActivity(in2);
                break;}else{
            Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
            break;
        }

            case "decimal":
                if(check()){
                Intent in3=new Intent(this,Formula_DecimalFraction_Page.class);
                startActivity(in3);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;
                }
            case "simplification":
                if(check()){
                Intent in4=new Intent(this,Formula_Simplification.class);
                startActivity(in4);
                break;}else{
            Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
            break;
        }

            case "average":
                if(check()){
                Intent in5=new Intent(this,Formula_Average_Page.class);
                startActivity(in5);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}
            case "percentage":
                if(check()){
                Intent in6=new Intent(this,Formula_Percentage_Page.class);
                startActivity(in6);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}
            case "profitloss":
                if(check()){
                Intent in7=new Intent(this,Formula_ProfitLoss_Page.class);
                startActivity(in7);
                break;}else{
            Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
            break;}
            case "timedistance":
                if(check()){
                Intent in8=new Intent(this,Formula_TimeDistance_Page.class);
                startActivity(in8);}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}
                break;
            case "timework":
                if(check()){
                Intent in9=new Intent(this,Formula_TimeWork_Page.class);
                startActivity(in9);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}
            case "simpleinterest":
                if(check()){
                Intent in10=new Intent(this,Formula_SimpleInterest_Page.class);
                startActivity(in10);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}
            case "area":
                if(check()){
                Intent in11=new Intent(this,Formula_Area_Page.class);
                startActivity(in11);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}
            case "volumes":
                if(check()){
                Intent in12=new Intent(this,Formula_Volume_Page.class);
                startActivity(in12);
                break;}else{
            Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
            break;}
            case "compoundinterest":
                if(check()){
                Intent in13=new Intent(this,Formula_Compound_Page.class);
                startActivity(in13);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}
            case "ratio":
                if(check()){
                Intent in14=new Intent(this,Formula_Ratio_Page.class);
                startActivity(in14);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}
            case "problemonages":
                if(check()){
                Intent in15=new Intent(this,Formula_ProblemOnAges_Page.class);
                startActivity(in15);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}
            case "pipe":
                if(check()){
                Intent in16=new Intent(this,Formula_Pipe_page.class);
                startActivity(in16);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}
            case "problemontrain":
                if(check()){
                Intent in17=new Intent(this,Formula_Train_Page.class);
                startActivity(in17);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}
            case "boat":
                if(check()){
                Intent in18=new Intent(this,Formula_Boat_Page.class);
                startActivity(in18);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}
            case "mixture":
                if(check()){
                Intent in19=new Intent(this,Formula_Mix_Page.class);
                startActivity(in19);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}
            case "calender":
                if(check()){
                Intent in20=new Intent(this,Formula_Calender_Page.class);
                startActivity(in20);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}
            case "heightanddistance":
                if(check()){
                Intent in21=new Intent(this,Formula_HeightDistance_Page.class);
                startActivity(in21);
                break;}else{
                    Network_Check.isNetworkconnected(Practice_Quiz_Page.this);
                    break;}




        }

    }

    public void onexitclick(View view){
        result();
    }




    private void finishQuiz(){
        finish();
    }

    private long backpressTime;


    @Override
    public void onBackPressed() {
        if (backpressTime+2000>System.currentTimeMillis()){
            result();
         finishQuiz();
        }
        else{
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
        }

        backpressTime=System.currentTimeMillis();
        System.out.println(backpressTime);

    }

    @Override
    public void onInterstitialLoaded(MoPubInterstitial interstitial) {
        yourAppsShowInterstitialMethod();
    }

    @Override
    public void onInterstitialFailed(MoPubInterstitial interstitial, MoPubErrorCode errorCode) {
        Intent in=new Intent(this,Hint_PopUP_Page.class);
        in.putExtra(EXTRA_HINT,hint);
        startActivity(in);
    }

    @Override
    public void onInterstitialShown(MoPubInterstitial interstitial) {

    }

    @Override
    public void onInterstitialClicked(MoPubInterstitial interstitial) {

    }

    @Override
    public void onInterstitialDismissed(MoPubInterstitial interstitial) {
        Intent in=new Intent(this,Hint_PopUP_Page.class);
        in.putExtra(EXTRA_HINT,hint);
        startActivity(in);
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
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

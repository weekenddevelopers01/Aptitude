package com.weekenddevelopers.tamilaptitude;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Test_Quiz_Page extends AppCompatActivity {
    public static final long COUNTDOWN_IN_MILLS=40000;

    private TextView textView_english_question;
    private TextView textView_tamil_question;
    private TextView textView_score;
    private TextView textView_question_count;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private RadioButton rb4;
    private Button btn_confirm_next;
    private TextView textView_countdown;
    private ColorStateList textColorDefaultRb;
    private ColorStateList textColorDefaultCd;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private List<Test_Question> questionList;
    private int questionCounter;
    private int questionCountTotal;
    private Test_Question currentQuestion;
    private boolean answered;

    private String category;
    static int total;
    static int right;

    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test__quiz__page);

        textView_english_question=findViewById(R.id.text_view_english_question);
        textView_tamil_question=findViewById(R.id.text_view_tamil_question);
        textView_score=findViewById(R.id.text_view_score);
        textView_question_count=findViewById(R.id.text_view_question_count);
        rbGroup=findViewById(R.id.radio_group_option);
        rb1=findViewById(R.id.rb_option1);
        rb2=findViewById(R.id.rb_option2);
        rb3=findViewById(R.id.rb_option3);
        rb4=findViewById(R.id.rb_option4);
        textView_countdown=findViewById(R.id.text_view_timmer);
        btn_confirm_next=findViewById(R.id.btn_confirm_next);
        textColorDefaultRb=rb1.getTextColors();
        textColorDefaultCd=textView_countdown.getTextColors();

        Intent intent= getIntent();
        category=intent.getStringExtra(Practice_Home_Page.EXTRA_CATEGORY);

        MobileAds.initialize(this,"ca-app-pub-5376812679381678/1065768227");
        adView =findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        Test_QuizDbHelper dbHelper=new Test_QuizDbHelper(this);
        questionList=dbHelper.getAllQuestions(category);
        questionCountTotal=questionList.size();
        Log.d("questionCountTotal", String.valueOf(questionCountTotal));
        Collections.shuffle(questionList);
        showNextQuestion();
        btn_confirm_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!answered){
                    if(rb1.isChecked()||rb2.isChecked()||rb3.isChecked()||rb4.isChecked()){
                        checkAnswer();
                    }
                    else {
                        Toast.makeText(Test_Quiz_Page.this, "Select answer", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    showNextQuestion();
                }
            }
        });
    }
    private int score;

    private void checkAnswer(){
        answered=true;
        countDownTimer.cancel();
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
            btn_confirm_next.setText("Next");
        }
        else {
            btn_confirm_next.setText("Finish");
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

            questionCounter++;
            textView_question_count.setText("Question :"+ questionCounter+"/"+questionCountTotal);
            answered=false;
            btn_confirm_next.setText("Confirm");
            timeLeftInMillis=COUNTDOWN_IN_MILLS;
            startCountDown();
        }
        else {
            result();
        }
    }

    private void startCountDown(){
        countDownTimer =new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMillis=l;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                timeLeftInMillis=0;
                updateCountDownText();
                checkAnswer();

            }
        }.start();

    }

    private void updateCountDownText(){
        int min=(int) (timeLeftInMillis/1000)/60;
        int sec=(int) (timeLeftInMillis/1000)%60;

        String timeFormatted= String.format(Locale.getDefault(),"%02d:%02d",min,sec);
        textView_countdown.setText(timeFormatted);

        if (timeLeftInMillis<10000){
            textView_countdown.setTextColor(Color.RED);
        }
        else {
            textView_countdown.setTextColor(textColorDefaultCd);
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

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
    }
}

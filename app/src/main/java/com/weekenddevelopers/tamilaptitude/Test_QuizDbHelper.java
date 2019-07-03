package com.weekenddevelopers.tamilaptitude;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.weekenddevelopers.tamilaptitude.Test_QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class Test_QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="TestQuiz.db";
    private static final int DATABASE_VERSION=1;

    private SQLiteDatabase db;

    public Test_QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        this.db= sqLiteDatabase;
        final String SQL_CREATE_TEST_QUESTION_TABLE= "CREATE TABLE "+ TestQuestionsTable.TABLE_NAME +
                "( "+ TestQuestionsTable._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                TestQuestionsTable.COLUMN_QUESTION_TAMIL+" TEXT, "+
                TestQuestionsTable.COLUMN_QUESTION_ENGLISH+" TEXT, "+
                TestQuestionsTable.COLUMN_OPTION1+" TEXT, "+
                TestQuestionsTable.COLUMN_OPTION2+" TEXT, "+
                TestQuestionsTable.COLUMN_OPTION3+" TEXT, "+
                TestQuestionsTable.COLUMN_OPTION4+" TEXT, "+
                TestQuestionsTable.COLUMN_ANSWER_NR+" INTEGER,"+
                TestQuestionsTable.COLUMN_CATEGORY+" TEXT "+
                " )";

        db.execSQL(SQL_CREATE_TEST_QUESTION_TABLE);

        fillQuestionTable();


    }

    private void fillQuestionTable(){
        Test_Question q1=new Test_Question("தீர்க்க 7589 - ? = 3434 ","Solve 7589 - ? = 3434 ","4242","4155","1123","11023",2, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q1);
        Test_Question q2=new Test_Question("தீர்க்க  4300731 - ? = 2535618","Solve 4300731 - ? = 2535618","1865113","1775123","1765113","1675123",2, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q2);
        Test_Question q3=new Test_Question("512#324 என்ற எண் முழுமையாக 3 ஆல் வகுப்படுமாயின் #ன் மிகச்சிறிய எண்ணை கண்டறி","If the number 512#324 is completely divisible by 3, then the smallest whole number in place of # will be:","0","1","2","none of these",3, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q3);
        Test_Question q4=new Test_Question("97215#7 என்ற எண் முழுமையாக 11 ஆல் வகுப்படுமாயின் #ன் மிகச்சிறிய எண்ணை கண்டறி ","If the number 97215#7 is completely divisible by 11 then the smallest whole number in place of # will be","3","2","1","5",1, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q4);
        Test_Question q5=new Test_Question("பின்வரும் எண்களில் 11 ஆல் வகுப்படும் எண் ?","which one of the following numbers is exactly divisible by 11?","235641","245642","315624","415624",4, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q5);
        Test_Question q6=new Test_Question("பின்வரும் எண்களில் பகு எண் ?","Which of the following is not a prime number?","31","69","71","47",2, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q6);
        Test_Question q10=new Test_Question("ஒரு எண் 296 ஆல் வகுக்கும் போது மீதி =75, அதையே  37 ஆல் வகுக்கும் போது மீதி என்ன ?","A number when divided by 296, leaves, 75 as remainder.when the same number is divided by 37, the remainder will be?","1","2","8","11",1, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q10);
        Test_Question q9=new Test_Question("ஒரு எண்ணை வகுக்கும் போது மீதி =0, ஒரு மாணவன்  21ஆல் வகுப்பதற்கு பதிலாக 12-ஆல் தவறுதலாக வகுக்கும்போது ஈவு =35 கிடைக்கிறது. சரியான ஈவு என்ன ?","In a Division sum, the remainder is 0. A student mistook the divisor by 12 instead of 21 and obtained 35 as quotient, What is the correct quotient?","0","12","13","20",4, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q9);
        Test_Question q8=new Test_Question("ஒரு எண்ணை 5ஆல் வகுக்க 3 மீதியாக கிடைக்கிறது.அதே எண்ணை வர்க்கப்படுத்தி 5 ஆல் வகுத்தால்  மீதி என்ன ?","On dividing a number by 5, we get 3 as a remainder. What will be the remainder when the square of this number is divided by 5? ","4","5","6","7",4, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q8);
        Test_Question q7=new Test_Question("ஒரு எண்ணை 56 ஆல் வகுக்க 29 மீதியாக கிடைக்கிறது.அதே எண்ணை 8 ஆல் வகுக்க மீதி என்ன ?","On dividing a number by 56, we get 29 as a remainder. On dividing the same number by 8, what will be the remainder?","4","6","5","7",3, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q7);
        Test_Question q11=new Test_Question("தீர்க்க 325 + 587 + 369 - ? =3007","Solve 325 + 587 + 369 - ? =3007","1250","1300","1375","1200",4, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q11);
        Test_Question q12=new Test_Question("தீர்க்க   -84 × 29 +365 =?","Solve -84 × 29 +365 =? ","2436","2801","2801","2071",4, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q12);
        Test_Question q13=new Test_Question("தீர்க்க  1000^9 ÷ 10^24 =?","Solve   1000^9 ÷ 10^24 =?","10000","1000","100","10",2, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q13);
        Test_Question q14=new Test_Question("481#673 என்ற எண் முழுமையாக 9 ஆல் வகுப்படுமாயின் #ன் மிகச்சிறிய எண்ணை கண்டறி","If the number 481#673 is completely divisible by 9 then the smallest whole number in place of # will be ","2","5","6","7",4, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q14);
        Test_Question q15=new Test_Question("பின் வரும் எண்களில் 132 ஆல் வகுப்படும் எண்கள் எத்தனை :264, 396, 462, 792, 968, 2178, 5184, 6336 ","How may of the following numbers are divisible by 132? 264, 396, 462, 792, 968, 2178, 5184, 6336","4","5","6","7",1, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q15);
        Test_Question q16=new Test_Question("பின்வரும் எண்களில் பகா எண் ?","which of the following is a prime number?","77","95","31","39",3, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q16);
        Test_Question q17=new Test_Question("a மற்றும் b ஒற்றைப்படை எண்  எனில் ,இதில் எது ஒற்றைப்படை எண் ?","If a and b are odd numbers , then which of the following is odd?","a+b","a+b+1","ab+1","none of these",2, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q17);
        Test_Question q18=new Test_Question("ஒரு எண்ணை 357 ஆல் வகுக்க 39 மீதியாக கிடைக்கிறது.அதே எண்ணை 17ஆல் வகுக்க மீதி என்ன ?","On dividing a number by 357, we get 39 as a remainder. On dividing the same number by 17 , what will be the remainder?","0","3","5","11",3, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q18);
        Test_Question q19=new Test_Question("இரு எண்களின்  வேறுபாடு 1365. அதில் மிகப்பெரிய எண்ணை மிகச்சிறிய எண்ணால் வகுக்க ஈவு =6 ,மீதி =15 ஆக மிகச்சிறிய எண்ணை கண்டறி ?","Difference of two number is 1365. On dividing the large number by the smaller, we get 6 as quotient and 15 as remainder.what is the smaller number? ","240","270","295","360",2, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q19);
        Test_Question q20=new Test_Question("n ஒரு இயல் எண் எனில்,(6n2+6n) எவற்றால் வகுப்படும் ","If n i a natural number, then (6n2+6n) is always divisible by? ","6 only","6 and 12 both","12 only","by 18 only",2, Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q20);


        Test_Question q21=new Test_Question("252 ஐ எப்படி விரிவாக எழுதலாம்.","252 can be expressed as a product of primes as:","2x2x3x3x7","2x2x2x3x7","3x3x3x3x7 ","2x3x3x3x7",1, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q21);
        Test_Question q22=new Test_Question("எளிய வடிவில் சுருக்கு 1095/1168","1095/1168 when expressed in simplest form is ?","13/16","15/16","17/26","25/26",4, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q22);
        Test_Question q23=new Test_Question("மீ.பொ.வ காண்க :4x27x3125, 8x9x25x7 , 16x81x5x11x49","HCF of 4x27x3125, 8x9x25x7 , 16x81x5x11x49 is?","180","360","540 ","1260",1, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q23);
        Test_Question q24=new Test_Question("பின்வரும் எண்ணிற்கு மீச்சிறு பொது மடங்கு காண்க 24, 36, 40","Find the lowest common multiple of 24, 36, 40","120","240","360 ","480",3, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q24);
        Test_Question q25=new Test_Question("மீ.பொ.வ காண்க 1.08 , 0.36 and 0.9?","The G.C.D of 1.08 , 0.36 and 0.9 is?","0.03","0.9","0.18 ","0.108",3, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q25);
        Test_Question q26=new Test_Question("3240, 3600 மற்றும்  மூன்றாவது எண்ணின் மீ.பொ.வ 36, இவற்றின் மீ .சி.ம 2^4 x3^5 x5^2 x7^2 , எனில் 3வது எண் கண்டறி ?","HCF of 3240, 3600 and a third number is 36 and their LCM is 2^4x 3^5 x5^2 x7^2 the third number is ","2^2 x3^5 x7^2","2^2x5^3x7^2","2^5x5^2x7^2 ","2^3x3^5x7^2",1, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q26);
        Test_Question q27=new Test_Question("இரண்டு எண்களின் விகிதம் 3:4, இவற்றின் மீ.பொ.வ 4 எனில் அதன் மீ .சி.ம  ?","The ratio of two numbers is 3:4 and their HCF is 4. Their LCM is?","12","16","24 ","48",4, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q27);
        Test_Question q28=new Test_Question("இரு எண்களின் மீ.பொ.வ, மீ .சி.ம முறையே 84,21. இவற்றின் விகிதம் 1:4 எனில் மிகபெரிய எண்ணை கண்டறி","The HCF and LCM of two numbers are 84 and 21 respectively, if the ratio of the two numbers is 1:4, then the large of the two numbers is?","12","48","84 ","108",3, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q28);
        Test_Question q29=new Test_Question("இரு எண்களின் மீ.பொ.வ 8 எனில் பின்வருவனவற்றில் எவை மீ .சி.ம வாக கிடைக்காது ","The HCF of two numbers is 8 .Which one of the following can never be their LCM?","24","48","56","60",4, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q29);
        Test_Question q30=new Test_Question("7m, 3m 85cm, 12m 95cm ஆகிய நீளங்களை பொதுவாக அளக்கும் மிகப்பெரிய அளவினை காண்க ?","The greatest posssible length which can be used to measure exactly  the lengths 7m, 3m 85cm, 12m 95cm is ?","15cm","25cm","35cm ","42cm",3, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q30);
        Test_Question q31=new Test_Question("இவற்றில் அதிக வகுத்தி கொண்ட எண் ?","Which of the following has most number of dividors?","99","101","176 ","182",2, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q31);
        Test_Question q32=new Test_Question("எளிய வடிவில் சுருக்கு 128352/238368","Reduce 128352/238368 to its lowest terms.","3/4","5/13","7/13 ","9/13",3, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q32);
        Test_Question q33=new Test_Question("பின்வரும் எண்ணிற்கு மீப்பெரு பொது வகுத்தி காண்க 36, 84","Find the highest common factor of 36 and 84","4","6","12 ","18",3, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q33);
        Test_Question q34=new Test_Question("மீ .சி.ம காண்க 22, 54, 108, 135, 198","LCM  of 22, 54, 108, 135, 198 is ? ","330","1980","5940 ","11880",3, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q34);
        Test_Question q35=new Test_Question("மீ .சி.ம காண்க 3, 2.7, 0.09","The Lcm of 3,2.7,0.09 is? ","2.7","0.27","0.027 ","27",4, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q35);
        Test_Question q36=new Test_Question("மூன்று எண்களின் விகிதம் 1:2:3 , இவற்றின் மீ.பொ.வ 12 எனில் அந்த எண்கள் ?","Three numbers are in the ratio 1:2:3 and their HCF is 12.The numbers are?","4,8,12","5,10,15","10,20,30 ","12,24,36",4, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q36);
        Test_Question q37=new Test_Question("இரு எண்களின் பெருக்கல் பலன் 4107, இவற்றின் மீ.பொ.வ 37 எனில் பெரிய எண்ணை  கண்டறி","The product of two number is 4107. If the HCF of these number is 37 , then the greater number is ?","101","107","111 ","185",3, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q37);
        Test_Question q38=new Test_Question("இரு எண்களின் மீ .சி.ம 495,மீ.பொ.வ 5, இரு எண்களின் கூடுதல் 10 எனில் அவற்றிற்கு இடையேயான வேறுபாடு கண்டறி ?","The LCM of two numbers is 495 and their HCF is 5. If the sum of the numbers is 10 , then their difference is?","10","46","70 ","90",1, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q38);
        Test_Question q39=new Test_Question("105, 1001, 2436 என்ற எண்களை வகுக்கக்கூடிய மிகப்பெரிய எண் பின்வருவனவற்றில் எது ?","The greatest number that exactly divides 105, 1001, 2436 is?","3","7","11 ","21",2, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q39);
        Test_Question q40=new Test_Question("நிறைய மாணவர்கள் உள்ள வகுப்பில் 1001 பேனா மற்றும் 910 பென்சில் ஐ அனைவருக்கும் சரியாக பகிர்ந்தளிக்க அனைவரும் சரியான எண்ணிக்கை பெறுவதற்கான பேனா, பென்சிலின் எண்ணிக்கை ?","The maximum number of students among them 1001 pens and 910 pencils can be distributed in such a way that each student gets the same numbers of pens and same number of pencils is?","91","910","1001 ","1911",1, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q40);
        Test_Question q41=new Test_Question("43, 91, 183  என்ற எண்களை வகுக்கும் போது மீதி அனைத்திற்கும் ஒன்றாக வருமாறு வகுக்கும் எண் பின்வருவனவற்றுள் கண்டறி ?","Find the greatest number that will divide 43, 91, 183 so as to leave the same remainder in each case?","4","7","9 ","13",1, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q41);
        Test_Question q42=new Test_Question("1657, 2037  என்ற எண்களை வகுக்கும் போது மீதி 6 மற்றும் 5 வருமாறு வகுக்கும் பொது வகுத்தி காண்க","The greatest number which on dividing 1657 and 2037 leaves remainders 6 and 5 respectively is ?","123","127","235 ","305",2, Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q42);


        Test_Question q43=new Test_Question("பின்வருவனவற்றுள் எது ஏறுவரிசையில் உள்ளது ?","Which of the following has fraction in ascending order?","1/3, 2/5, 4/7, 3/5, 5/6, 6/7 ","1/3, 2/5, 3/5, 4/7, 5/6, 6/7","1/3, 2/5, 3/5, 5/6, 4/7, 6/7 ","2/5, 3/5, 1/3, 4/7, 5/6, 6/7",1, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q43);
        Test_Question q44=new Test_Question("பின்வருவனவற்றுள் எது இறங்குவரிசையில் உள்ளது ?","Which of the following are in descending order of their value?","5/9, 7/11, 8/15, 11/17 ","5/9, 8/15, 11/17, 7/11","11/17, 7/11, 8/15, 5/9","11/17, 7/11, 5/9, 8/15",4, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q44);
        Test_Question q45=new Test_Question("இவற்றுள் 3/4 விட பெரிய மற்றும் 5/6விட சிறிய எண்ணை கண்டறி ?","Which of the following fractions is greater than 3/4 and less than 5/6?","1/2 ","2/3","4/5 ","9/10",3, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q45);
        Test_Question q46=new Test_Question("தீர்க்க :617 + 6.017 + 0.617 +6.0017 =?","Solve: 617 + 6.017 + 0.617 +6.0017 =?","2963","62.965 ","629.6357 ","none of these",3, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q46);
        Test_Question q47=new Test_Question("தீர்க்க : 792.02 +101.32-306.76=?","Solve:  792.02 +101.32-306.76=?","586.58","893.34","997.11 ","1200.10",1, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q47);
        Test_Question q48=new Test_Question("தீர்க்க :0.002 x 0.5 =?","Solve: 0.002 x 0.5 =?","0.0001","0.001","0.01 ","0.1",2, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q48);
        Test_Question q49=new Test_Question("144/0.144 = 144/x எனில் x?","If 144/0.144 = 144/x then the value of x is?","0.0144","1.44","14.4 ","144",1, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q49);
        Test_Question q50=new Test_Question("0.125125....ஐ பின்னமாக்கு.","The rational numbers for the recurring decimal 0.125125..... is?","63/487","119/993","125/999 ","none of these",3, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q50);
        Test_Question q51=new Test_Question("இதில் மிக சிறிய எண்?","The least among the following is?","0.2","1÷0.2","0.2̅ ","0.2^2",4, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q51);
        Test_Question q52=new Test_Question("தீர்க்க  :(0.0̅9̅ x 7.3̅)=?","Solve : (0.0̅9̅ x 7.3̅) is equal to ?","0.6̅",".6̅5̅7̅ ",".6̅7̅ ",".65̅7̅",1, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q52);
        Test_Question q53=new Test_Question("பின்வருவனவற்றுள் எது ஏறுவரிசையில் உள்ளது ?","Which of the following has fraction in ascending order?","2/3, 3/5, 7/9, 9/11, 8/9 ","3/5, 2/3, 9/11, 7/9, 8/9","3/5, 2/3, 7/9, 9/11, 8/9 ","8/9, 9/11, 7/9, 2/3, 3/5",3, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q53);
        Test_Question q54=new Test_Question("இவற்றுள் பெரிய மற்றும் சிறிய எண்ணின் வேறுபாடு காண்க 2/3, 3/4, 4/5, 5/6 ?","What is the difference between the biggest and the smallest fraction among 2/3, 3/4, 4/5, 5/6 ?","1/6 ","1/12 ","1/20 ","1/30",1, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q54);
        Test_Question q55=new Test_Question("தீர்க்க :34.95 + 240.016 + 23.98 =?","Solve: 34.95 + 240.016 + 23.98 =?","298.0946","298.111","298.946","299.09",3, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q55);
        Test_Question q56=new Test_Question("தீர்க்க : 48.95 - 32.006 =?","Solve:  48.95 - 32.006 =?","16.089","16.35","16.89","16.944",4, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q56);
        Test_Question q57=new Test_Question("3.14 x 10^6-கு சமமான எண்ணை கண்டறி","Which of the folling is equal to 3.14 x 10^6","314","3140","3140000","none of these",3, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q57);
        Test_Question q58=new Test_Question("தீர்க்க: 16.02 x 0.001=?","Solve :16.02 x 0.001=?","0.001602","0.01602","0.1602","1.6021",2, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q58);
        Test_Question q59=new Test_Question("0.232323..... ஐ பின்னமாக்கு.","When 0.232323...... is converted into a fraction, then the result is ?","1/5","2/9","23/99","29/100",3, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q59);
        Test_Question q60=new Test_Question("0.4̅7̅ஐ பின்னமாக்கு.","When 0.4̅7̅ is converted into a fraction, the result is?","46/90","46/99","47/90","47/99",4, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q60);
        Test_Question q61=new Test_Question("2.13̅6̅ ன் மதிப்பு?","The value of 2.13̅6̅̅ is?","47/220","68/495","47/22","none of these",3, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q61);
        Test_Question q62=new Test_Question("தீர்க்க  :0.346̅7̅ + 0. 133̅3̅=?","Solve :0.346̅7̅ + 0. 133̅3̅ is equal to?","0.48̅","0.4̅8̅","0.480̅1̅","0.48",3, Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q62);


        Test_Question q63=new Test_Question("தீர்க்க  :100 + 50 x 2=?","Solve  :100 + 50 x 2=?","75","150","200","300",3, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q63);
        Test_Question q64=new Test_Question("தீர்க்க  : 5004 ÷ 139 -6 =?","Solve : 5004 ÷ 139 -6 =?","24","30","36","42",2, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q64);
        Test_Question q65=new Test_Question("ஒரு நிறுவனத்தின் வருமானம் ஒரு வருடத்திற்கு பின் இரு மடங்கிறது, அதன் முதல் வருமானம் 4 லட்சம் எனில் 5 வருடத்திற்கு பின் அதன் வருமானம்?","Income of a company doubles afer every one year. If the initial income was Rs.4 lakhs,what would be the income after 5 years?","Rs. 1.24 crores","Rs.1.28 crores","2.56 crores","none of these",2, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q65);
        Test_Question q66=new Test_Question("ஒரு ஒளியானது 13நொடி இடைவெளியில் மின்னுகிறது, அது 1hour 54min 50 secல்  முதலில் மின்னியது அது கடைசியாக 3hour 17 min 49secல் மின்னியது.அது எத்தனை முறை மினியிருக்கும்.?","6.A light was seen at interval of 13 seconds it was seen for the first time at 1 hour 54 minutes 50sec and the last time at 3 hours 17 minutes 49 seconds how many times was the light seen?","360","375","378","384",4, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q66);
        Test_Question q67=new Test_Question("டேவிட் வரலாற்றில் பெற்ற மதிப்பெண்போல்  ஆங்கிலத்தில் இரண்டரை மடங்கு மதிப்பெண் பெறுகிறான், இரு பாடங்களிலும் பெற்ற மொத்த மதிப்பெண் 140 எனில் ஆங்கிலத்தில் அவர் பெற்ற மதிப்பெண் ?","David got two and a half  times as many marks in English as in history, If his total mark in the two subjects are 140 the mark obtained by him in English are?","40","75","90","100",4, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q67);
        Test_Question q68=new Test_Question("ஒரு தொட்டியின் மூன்றில் ஒருமடங்கு கொள்ளளவு 80லிட்டர்,தொட்டியின் அரை மடங்கு கொள்ளளவு என்ன?","If one third of a tank holds 80 litre of water then the quantity of water that half the tank hold is?","80/3 liters","100liters","120 liters","240 liters",3, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q68);
        Test_Question q69=new Test_Question("ராகுலின் national savings certificateல் உள்ள மூன்றில் ஒரு மடங்கு சேமிப்பு  public provident fundல் உள்ள சேமிப்பின் பாதிக்கு சமம். அவன் மொத்தமாக  Rs.150000 சேமிப்பு வைத்திருந்தால், public provident fundன் மொத்த சேமிப்பு என்ன?","One-Third of Rugul's savings in national saving certificate is equal to one half of his savings in public provident fund if he has Rupees 150000 as total saving how much has he saved in public provident fund?","Rs.30,000","Rs.50,000","Rs.60,000","Rs.90,000",3, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q69);
        Test_Question q70=new Test_Question("ஒரு அணி அவர்கள் பெற்ற தோல்வியைவிட 3 ஆட்டங்கள் அதிகம் வெற்றி பெறுகின்றனர்.வெற்றி பெற்றால் 2 மதிப்பெண்,தோல்வி அடைந்தால் -1 மதிப்பெண் எனில், 23 மதிப்பெண் பெற அவர்கள் ஆடிய ஆடங்களின் எண்ணிக்கை?","A cricket team won 3 matches more than they lost, If a win gives them 2 points and loss(-1) point, how many matches, in all, have thet played if their score is 23?","17","20","37","40",1, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q70);
        Test_Question q71=new Test_Question("தீர்க்க  :(3080 + 6160) ÷ 28=?","Solve :(3080 + 6160) ÷ 28=?","320","440","3320","none of these",4, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q71);
        Test_Question q72=new Test_Question("தீர்க்க  :7500+ (1250 ÷ 50) =?","Solve :7500+ (1250 ÷ 50) =?","175","300","6575","7525",4, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q72);
        Test_Question q73=new Test_Question("ஒரு விளையாட்டு விழாவில்,30 குழந்தைகள் 16 வரிசையாக நிற்கின்றனர்.24 குழந்தைகள் வரிசையில் நின்றால் எத்தனை வரிசை தேவைப்படும்?","On sports day, if 30 children were made to stand in a column, then 16 columns could be formed.If 24 children were made to stand in a column, then how many columns could be formed?","20","22","29","45",1, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q73);
        Test_Question q74=new Test_Question("ஒரு அன்னாசியின் விலை Rs7, ஒரு தர்ப்பூசணியின் விலை Rs5, X என்ற ஒருவர் 38 Rs இந்த பழங்களை வாங்க செலவழிகிறார் எனில் அவர் வாங்கிய அன்னாசியில் எண்ணிக்கை ?","Pineapple costs Rs. 7 each. a watermelon costs Rs. 5 each, x spends Rs.38 on these fruits. The number of the pineapple purchased is?","2","3","4","data inacdequate",3, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q74);
        Test_Question q75=new Test_Question("ஒரு வகுப்பில் பெண்களின் எண்ணிக்கை ஆண்களை போல் 5 மடங்கு.எனில் பின்வரும் எண்களில் எது வகுப்பின் மொத்த எண்ணிக்கையாக இருக்காது?","The number of girls in a class is 5 times the number of boys which of the following cannot be the total number of children in the class?","24","30","35","42",3, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q75);
        Test_Question q76=new Test_Question("ஒரு கம்பத்தில் 1/10 சிகப்பு, 1/20 வெள்ளை, 1/30 நீலம், 1/40 கருப்பு, 1/50 ஊதா, 1/60 மஞ்சள், மீதம் உள்ளவை பச்சை நிறத்தில் உள்ளது. பச்சை நிறம் 12.08 meter நீளம் கொண்டது எனில் கம்பத்தில் நீளம் என்ன?","1/10 of the Pole is coloured Red,1/20 white, 1/30 blue,1/40 black 1/50 violet, 1/ 60 yellow and the rest is green if the length of the green proportion of the pole is 12.08 metres then the length of the pole is?","16m","18m","20m","30m",1, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q76);
        Test_Question q77=new Test_Question("60 வினாக்கள் கொண்ட ஒரு தேர்வில் சரியான விடைக்கு 4 மதிப்பெண் வழங்கப்படுகிறது, தவறான விடைக்கு 1 மதிப்பெண் கழிக்கப்படுகிறது,ஒருவன் 60 வினாக்களுக்கு விடையளித்து 130 மதிப்பெண் பெறுகிறார் எனில் அவர் சரியாக விடையளித்த வினாக்கள் எத்தனை?","In an examination, a student scores 4 mark for every correct answer and loses 1 mark for every wrong anser. If he attempts in all 60 questions and secures 130 marks, the number of questions he attempts correctly is?","35","38","40","42",2, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q77);
        Test_Question q78=new Test_Question("20 பைசா மற்றும் 25 பைசா உள்ள 324 நாணயங்களின் கூடுதல் Rs.71 எனில் எத்தனை 25 பைசா உள்ளது?","A total of 324 coins of 20 paise and 25 paise make a sum of Rs. 71. The number of 25-paise coins is?","120","124","144","200",4, Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q78);


        Test_Question q79=new Test_Question("டேவிட் ஆங்கிலம், கணிதம்,இயற்பியல், வேதியல்,உயிரியலில் 76,65,82,67,85 மதிப்பெண் பெற்றுள்ளார்.அவரின் சராசரி மதிப்பெண்?","David obtained 76,65,82,67 and 85 mark(out of 100) in english, maths, physics,chemistry,biology what are his average mark?","65","69","72","none of these",4, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q79);
        Test_Question q80=new Test_Question("6கும் 34கும் இடைப்பட்ட 5 ஆல் வகுப்படும் எண்களின் சராசரி காண்க?","Find the average of all the numbers between 6 and 34 which are divisible by 5?","18","20","24","30",2, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q80);
        Test_Question q81=new Test_Question("ஒரு மாணவன் 3,11,7,15,13,8,19,17,21,14,x ஆகியவற்றிற்கு கூட்டுசாரசரி 12 காண்கிறான்.எனில் x ?","A student was asked to find the arithmetic mean of the numbers 3,11,7,9,15,13,8,19,17,21,14 and x. He found the mean to be 12. what should be the number in place of x?","3","7","17","31",2, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q81);
        Test_Question q82=new Test_Question("ஒரு பூஜியம் இல்லாத எண்ணின் சராசரி,அதன் வர்க்கம் அந்த எண்ணைபோல் 5 மடங்கு எனில் அந்த எண் காண்க?","The average of a non-zero number and its square is 5 times the number.The number is?","9","17","29","295",1, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q82);
        Test_Question q83=new Test_Question("ஒரு நூலகம் சராசரியாக 510 வாசகர்களை ஞாயிற்றுகிழமையும், 240 வாசகர்களை மற்ற கிழமைகளிலும் பெற்றுள்ளது.முதல் நாள் ஞாயிற்றுகிழமை கொண்ட 30 நாட்கள் கொண்ட மதத்தின் ஒருநாளுக்கான சராசரி வாசகர்கள்?","A library has an average of 510 visitors on sunday and 240 on other days.the average number of visitors per day in a month of 30 days beginning with a sunday is?","250","276","280","285",4, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q83);
        Test_Question q84=new Test_Question("ஒருவர் மூன்று ஆண்டுகள் பெட்ரோலை Rs.7.50, Rs.8 and Rs.8.50 per litre என்ற விலையில் வாங்குகிறார்.அவர் ஒவ்வொரு ஆண்டுக்கும் 4000Rs செலவழிக்கிறார் எனில் ஒரு லிட்டர் பெட்ரோலின் சராசரியானா விலை என்ன?",".A car owner buys petrols at Rs.7.50, Rs.8 and Rs.8.50 per litre for three successive years.What approximately is the average cost per litre of petrol if he spends Rs.4000 each year? ","Rs.7.98","Rs.8","Rs.8.50","Rs.9",1, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q84);
        Test_Question q85=new Test_Question("35 மாணவர்களின் சராசரி வயது 16, அதில் 21 மாணவர்களின் சராசரி வயது 14 எனில், மீதமுள்ள 14 மாணவர்களின் சராசரி வயது?","The averae age of 35 students in a class is 16 years.The average age of 21 students is 14. What is the average age of remaining 14 students?","15years","17years","18years","19years",4, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q85);
        Test_Question q86=new Test_Question("P,Qன் சராசரி மாத வருமானம் 5050rs, Q,Rன் சராசரி மாத வருமானம் 6250rs , P,Rன் சராசரி மாத வருமானம் 5200rs, Pன் மாத வருமானம் என்ன?","The average montly income of P and Q is Rs.5050. The average monthly income of Q and R is Rs.6250 and the average montly income of P and R is Rs.5200. The montly income of P is?","Rs.3500","Rs.4000","Rs.4050","Rs.5000",2, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q86);
        Test_Question q87=new Test_Question("ஒரு வகுப்பில் இருக்கும் 24 மாணவர்களின் சராசரி எடை 35kg, இதில் ஆசிரியரின் எடை சேர்க்கப்பட்டால் 400g அதிகரிக்கிறது,ஆசிரியரின் எடை கண்டறி?","The average weight of a class of 24 students is 35kg . If the weight of the teacher be included, the average rised by 400g, the weight of the teacher is?","45kg","50kg","53kg","55kg",1, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q87);
        Test_Question q88=new Test_Question("20 எண்களின் சராசரி 0 எனில்,அவற்றுள் எத்தனை எண்கள் 0 மேல் மதிப்பு பெற்றிருக்கும்?","The average of 20 numbers is 0, Of them at the most , how many may be greater than zero?","0","1","10","19",1, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q88);
        Test_Question q89=new Test_Question("முதல் 5, மூன்றின் மடங்குகளின் சராசரி காண்க?","Average of the first five multiples of 3 is?","3","9","12","15",2, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q89);
        Test_Question q90=new Test_Question("தொடர்ச்சியான 5 ஒற்றைப்படை எண்களின் கூடுதல் 61எனில்,அதில் மிகப்பெரிய மற்றும் மிகச்சிறிய எண்களுக்கு இடைப்பட்ட வேறுபாடு?","The average of five consecutive odd number is 61. what is the defference between the highest and lowest numbers?","2","5","8","none of these",3, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q90);
        Test_Question q91=new Test_Question("ஒரு வகுப்பிலுள்ள ஆண்களின் சராசரி வயது 16, பெண்களின் சராசரி வயது 15, வகுப்பின் மொத்த சராசரி வயது காண்க?","The average age of the boys in a class is 16 years and that of the girls is 15 years. the average age for the whole class is?","15 years","15.5 years","16 years","cannot calculate",4, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q91);
        Test_Question q92=new Test_Question("ஒரு வகுப்பிலுள்ள 16 மாணவர்களின் சராசரி எடை 50.25,மற்ற 8மாணவர்களின் சராசரி 45.15kg.s சராசரி எடை கண்டறி?","If the average weight of 16 boys in a class is 50.25 and that of the remaining 8 boys is 45.15kgs. find the average weight of all boys in the class?","47.55kgs","48kgs","48.55kgs","49.25kgs",3, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q92);
        Test_Question q93=new Test_Question("9 பேரில் 8 பேர் உணவுக்காக ஒவொருவரும் 3Rs செலவழிகின்றனர்.9வது ஆள் 9 பேரின் சாரசரியை விட 20Rs அதிகம் செலவழிக்கிறார்,அனைவராலும் செலவழிக்கப்பட்ட பணம் ?","Out of 9 persons,8 persons spent Rs.30 each for their meals. the ninth one spent Rs.20 mor than the average expenditure of all the nine. the total money spent by all of them was?","Rs.260","Rs.290","Rs.292.50","Rs.400.50",3, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q93);
        Test_Question q94=new Test_Question("A,B,Cன் சராசரி எடை 45kg, A மற்றும் Bன் சராசரி எடை 40kg, B மற்றும் Cன் சராசரி எடை 43kg, எனில் Bன் எடை?","The average weight of A,B,C is 45 kg. If the average weight of A and B be 40kg and that of B and C be 43 kg , then the weight of B is?","17kg","20kg","26kg","31kg",4, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q94);
        Test_Question q95=new Test_Question("ஒரு நிறுவனத்தில் 20 வேலையாட்களின் சராசரி வருமானம் 1500rs, இதில் மேலாளரின் வருமானம் சேர்க்கப்பட்டால் சராசரி வருமானம் 100rs உயர்கிறது. மேலாளரின் வருமானம் என்ன?","The average montly salary of 20 employess in an organisation is Rs.1500.If the manager's salary is added, then the average salary increases by Rs.100.What is the manager's montly salary?","Rs.2000","Rs.2400","Rs.3600","Rs.4800",3, Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q95);



        Test_Question q96=new Test_Question("5:4 ஐ சதவீதம் ஆக மாற்றுக.","The ratio 5:4 expressed as a percent equals?","12.5%","40%","80%","125%",4, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q96);
        Test_Question q97=new Test_Question("88% of 370 + 24% 210 -?=118","88% of 370 + 24% 210 -?=118","256","258","268","358",2, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q97);
        Test_Question q98=new Test_Question("?% of 932 + 30= 309.6","?% of 932 + 30= 309.6","25","30","35","40",2, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q98);
        Test_Question q99=new Test_Question("ஒரு தேர்வில் 35% மாணவர்கள் தேர்வடைந்தார்கள், 455 பேர் தோல்வியடைந்தார்கள், தேர்வை எழுதியவர்கள் எத்தனை பேர்?","In an examination 35% of students passed and 455 failded. how many students appeared for the examination?","490","700","845","1300",2, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q99);
        Test_Question q100=new Test_Question("pன் p% =36,எனில் p=?","If p% of p is 36, then p is equal to ?","15","60","600","3600",2, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q100);
        Test_Question q101=new Test_Question("தானியத்தின் விலை 16% குறைகிறது,எனில் அதன் பட்ஜெட் மாறாமல் ஒரு நபரின் பயன்பாட்டை உயர்த்துவதற்கான % ?","The price of wheat falls by 16%, by what percentage a person can increase the consumption of wheat so that his overall budget does not change?","16%","18%","18.5%,","19%",4, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q101);
        Test_Question q102=new Test_Question("ஒரு நகரின் மக்கள்தொகை ஆண்டுக்கு 5% உயர்கிறது, 2001ல் அதன் மக்கள்தொகை 1,38,915 எனில் 1998ல் மக்கள் தொகை என்ன?","The population of a town increases by 5% annually, if its population in 2001 was 1,38,915, what it was in 1998?","1,00,000","1,80,000","1,10,000","1,20,000",4, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q102);
        Test_Question q103=new Test_Question("Aன் வருமானம் Bன் வருமானத்தில் 40%, Bன் வருமானம் Cன் வருமானத்தில் 25% எனில், Aன் வருமானம் Cன் வருமானத்தில் எத்தனை %?","A's salary is 40% of B's salary which is 25% of C's salary.What percentage of C's salary is A's salary?","5%","10%","15%","20%",2, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q103);
        Test_Question q104=new Test_Question("பழங்கள் 68% தண்ணீர் கொண்டுள்ளன, வறல்பழங்கள் 20% தண்ணீர் கொண்டுள்ளன.எனில் 100g பழங்களில் இருந்து எவ்வளவு வறல்பழங்கள் பெறலாம்?","Fresh fruit contains 68% water and dry fruit contains 20% water. how much dry fruit can be obtained from 100kg of fresh fruits?","32kg","40kg","52kg","80kg",2, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q104);
        Test_Question q105=new Test_Question("அரிசியின் விலை 2% குறைகிறது, குறைவதற்கு முன் 49kg அரிசிக்கு தேவையான பணத்திற்கு இப்போது எவ்வளவு kg அரிசி வாங்கலாம்?","The price of raice is reduced by 2% . How many kilograms of rice can now be bought for the money which was sufficient to buy 49 kg of rice earlier?","48kg","49kg","50kg","51kg",3, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q105);
        Test_Question q106=new Test_Question("3.5 ஐ சதவிதமாக மாற்றுக?","3.5 can be expressed in terms of percentafe as?","0.35%","3.5%","35%","350%",4, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q106);
        Test_Question q107=new Test_Question("45% of 750 - 25% 480=?","45% of 750 - 25% 480=?","216","217.50","236.50","245",2, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q107);
        Test_Question q108=new Test_Question("ஒரு எண்ணின் 35%=175, எனில் 175இல் எத்தனை சதவீதம் அந்த எண்?","If 35% of a number is 175, then what percent of 175 is that number?","35%","65%","280%","none of these",3, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q108);
        Test_Question q109=new Test_Question("ஒரு நகரின் மக்கள்தொகை 1,75,000ல் இருந்து 2,62,500 ஆகா உயர்கிறது, ஒவ்வொரு ஆண்டும் உயர்ந்த மக்கள்தொகையின் சராசரி சதவீதம் ?","The population of a town increased from 1,75,000 to 2,62,500 in a decade. the average percent increase of population per year is?","4.37%","5%","6%","8.75%",2, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q109);
        Test_Question q110=new Test_Question("ஒரு TV ன் விலை 25% குறைகிறது அதே நேரத்தில் 20% அதன் விற்பனை அதிகரிக்கிறது,எனில் அதன் வருவாய் என்ன?","The price of a T.V set is decreased by 25% as a result of which the sale increased by 20%. What will be the effect on the total revenue of the shop?","5% decrease","5% increased","10% increased","none of these",3, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q110);
        Test_Question q111=new Test_Question("ஒரு இயந்திரத்தின் தேய்மான % 20, 3 வருடங்களுக்கு பின் அதன் மதிப்பை எவ்வளவு குறைந்திருக்கும்?","Depreciation applicable to an equipment is 20% The value of the equipment 3 years from now will be less by?","45%","48.8%","51.2%","60%",2, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q111);
        Test_Question q112=new Test_Question("இரண்டு எண்கள் மூன்றாவது எண்னை விட 30%, 37% சிறியது,எனில் இரண்டாம் எண் முதலாம் எண்ணைவிட எத்தனை % சிறியது?","Two numbers are less than a third number by 30% and 37 % respectively. How much percent is the second number less than the first?","3%","4%","7%","10%",4, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q112);
        Test_Question q113=new Test_Question("பீட்டர் ,ஆல்பர்ட்ஐ விட 40% அதிகம் சம்பதிக்கிறான்.ஆல்பர்ட், மைகேல்ஐ விட 20% குறைவாக சம்பதிக்கிறான்,எனில் மைகேல்ஐ விட பீட்டர் எவ்வளவு% அதிகம் சம்பதிக்கிறான்?","peter earned 40% more money than albert. albert earned 20% less than michael. How much peter earned more than Michael by?","10%","12%","20%","25%",3, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q113);
        Test_Question q114=new Test_Question("பாலானது 5% தண்ணீர் கொண்டுள்ளது, 10 லிட்டர் பாலின் எத்தனை லிட்டர் பால் சேர்த்தால் அதில் இருக்கும் தண்ணீர் 2% ஆகா குறையும்?","Milk contains 5% water . What quantity of pure mil should be add to 10 litres of mil to reduce this to 2%?","5 liters","7liters","15 liters","none of these",3, Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q114);



        Test_Question q115=new Test_Question("33 மீட்டர் துணியை விற்கும்போது ஒருவர் 11 மீட்டர் துணி விற்பதற்கான லாபம் பெறுகிறார் எனில் லாப%?","By selling 33 metres of cloth, one gains the selling price of 11 metres find the gain percent?","20%","89%","50%","9.3%",3, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q115);
        Test_Question q116=new Test_Question("ஒருவர் குதிரை மற்றும் வண்டியை 3000rsக்கு வாங்குகிறார், குதிரையை 20% லபத்திற்கும், வண்டியை 10% நட்டத்திற்கும் விற்கிறார், மொத்தமாக 2% லாபம் கிடைக்கிறது.குதிரையின் வாங்கிய விலை?","A man bought a horse and a carriage for Rs. 3000. He sold the horse at a gain of 20% and the carriage at a loss of 10 %, there by gaining 2% on the whole. Find the cost of the horse?","Rs.1500","Rs.1236","Rs.1200","Rs.1300",3, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q116);
        Test_Question q117=new Test_Question("வாங்கிய விலை மற்றும் விற்ற விலைக்கு இடையேயான விகிதம் 4:5,எனில் அதன் லாப சதவீதம்?","The ratio of the cost price and the selling price is 4:5 the profit percent is:","10%","20%","25%","30%",3, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q117);
        Test_Question q118=new Test_Question("ஒரு புத்தகத்தை Rs.832க்கு விற்றால் கிடைக்கும் லாபம் அந்த புத்தகத்தை Rs.448 க்கு விற்றால் கிடைக்கும் நட்டத்திற்கு சமம், எனில் 50% லாபம் பெறுவதற்கான விற்பனை விலை என்ன?","The profit earned by selling an article for Rs.832 is equal to the loss incurred when the same article is sold for Rs.448 what should be the sale price for making 50% profit?","Rs.600","Rs.750","Rs.800","Noe of these",3, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q118);
        Test_Question q119=new Test_Question("ஒருவர் 18 கட்டில்களை Rs.16,800 க்கு விற்கிறார், அதில் அவர் 3 கட்டில்கள் விற்பதற்கான லாபம் அடைகிறார்,எனில் ஒரு கட்டிலின் விலை?","A man sold 18 cots for Rs.16,800,gaining thereby the cost price of 3 cost. the cost price of a cot is?","Rs.630","Rs.700","Rs.750","Rs.800",4, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q119);
        Test_Question q120=new Test_Question("ஒருவன் 2 டஜன் வாழைப்பழத்தை, டஜன் Rs.16க்கு வாங்கி, 18 வாழைப்பழங்களை டஜன் 4Rs குறைத்து 12Rs என்ற விலைக்கு விற்றால்,அவர் அடையும் நட்ட சதவீதம்?","A man buys 2 dozen bananas at Rs16 per dozen, after selling 18 bananas at the rate of Rs.12 per dozen, the shopkeeper reduced the rate to Rs.4 per Dozen. the Percent loss is?","25.2%","32.4%","36.5%","37.5%",4, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q120);
        Test_Question q121=new Test_Question("ஒருவன் 16 பழங்களை 24Rs க்கு வாங்குகிறான், அதை 8 பழங்கள் 18Rs க்கு விற்கிறான்,எனில் லாப சதவீதம் என்ன ?","A man bought some fruits at the rate of 16 for Rs 24 and sold them at the rate of 8 for Rs.18,What is the profit percent?","25%","50%","40%","60%",2, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q121);
        Test_Question q122=new Test_Question("ஒரு கடைக்காரர் 10% லாபத்தை தனது சரக்குகளில் பெறுகிறார் . 20% சரக்குகளை ஒரு திருட்டில் இழக்கிறார், அவர் அடைந்த நட்ட சதவீதம் என்ன ?","A fair price shopkeeper takes 10% profit on his goods. He lost 20% goods during theft.His loss percent is?","8","10","11","12",4, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q122);
        Test_Question q123=new Test_Question("A என்பவர் ஒரு புத்தகத்தை 10% அதன் மதிப்பு குறைவாக வாங்குகிறார்.மீண்டும் அதை  10% அதிகமா விற்கிறார்.எனில்  அவரின் லாப அல்லது நட்ட சதவீதம்?","A man buys an article for 10% less than its value and sells it for 10% more than its value.His gain or loss percent is?","no profit,no loss","20% profit","less than 20% profit","more than 20% profit",4, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q123);
        Test_Question q124=new Test_Question("ஒரு புத்தகத்தை 340Rs க்கு விற்பதற்கு பதிலாக 350Rs க்கு விற்றால் 5% லாபம் கிடைக்கிறது, எனில் அந்த புத்தகத்தின் அடக்க விலை என்ன ?","If 5% more is gained by selling an article for Rs.350 than by selling it for Rs.340, the cost of the article is?","Rs.50","Rs.160","Rs.200","Rs.225",4, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q124);
        Test_Question q125=new Test_Question("ஒருவர் ஒரு புத்தகத்தை 20% நட்டத்தில் விற்கிறார், அதுவே அவர் அதை 100rs உயர்த்தி விற்றால் 5% லாபம் கிடைக்கிறது.அந்த புத்தகத்தின் விலை?","A man sold an article at a loss of 20%.If the selling price had been increased by Rs.100, there would have been a gain of 5% . what ws the cost price of the article?","Rs.500","Rs.486","Rs.400","Rs.963",3, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q125);
        Test_Question q126=new Test_Question("பீட்டர் ஒரு இயந்திரத்தை 80,000rsக்கு வாங்கி 5000rs செலவுசெய்து மற்றும் 1000rs போக்குவரத்துக்கு செலவுசெய்து 25% லாபத்திற்கு விற்கிறான்,எனில் அவன் வாங்கிய விலை என்ன?","Peter purchased a machine for Rs.80,000 and spent Rs.5000 on repair and Rs.1000 on transport and sold it with 25% profit.At what price did he sell the machine?","Rs.1,50,100","Rs.1,06,250","Rs.1,07,500","None of these",3, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q126);
        Test_Question q127=new Test_Question("ஒருவர் ஒரு புத்தகத்தை விற்பதான் மூலம் 20% லாபம் அடைகிறார்.அவர் அதை இருமடங்கிற்கு விற்றால் லாபம் என்ன?","A man gain 20% by selling an article for a certain price. If he sells it at double the price, the percentage of profit will be?","40","100","120","140",4, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q127);
        Test_Question q128=new Test_Question("20 புத்தகங்களின் அடக்க விலை, x எண்ணிக்கை புத்தகங்களை விற்பதற்கு சமம், லாபம் 25% எனில் x ன் மதிப்பை கண்டறி?","The Cost price of 20 articles is the same as the selling price of x articles.If the profit is 25%,then the value of x is?","15","16","18","25",2, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q128);
        Test_Question q129=new Test_Question("7 பந்துகள் 720Rsக்கு விற்கப்படுகிறது.இதில் அடையும் நட்டம் 5 பந்துகளின் விலைக்கு சமம்,எனில் ஒரு பந்தின் விலை?","On selling 17 balls at Rs.720, there is a loss equal to the cost price of 5 balls. the cost price of a ball is?","Rs.45","Rs.50","Rs.55","Rs.60",4, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q129);
        Test_Question q130=new Test_Question("ஒருவர் 8 ஆப்பிள்கள் 32Rs  என்ற விலைக்கு வாங்கி அதை 12 ஆப்பிள்கள் 57Rs  விற்கிறார்,எனில்  45Rs  லாபம் பெற எத்தனை ஆப்பிள்கள் விற்க்கவேண்டும் ?","A man bought apples at the rate of 8 for Rs.34 and sold them at the rate of 12 for Rs.57. How many apples should be sold to earn a net profit of Rs.45?","90","100","135","150",1, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q130);
        Test_Question q131=new Test_Question("12 மிட்டாய்களை ஒரு ரூபாய்க்கு விற்றால் ஒருவன் 20% நட்டம் அடைகிறான், அவன் எத்தனை மிட்டாய்களை விற்றால் 20% நட்டம்  கிடைக்கும் ?","By selling 12 toffess for a Rupee,a man loses 20%. how many should he sell to get a gain of 20%?","5","8","10","15",2, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q131);
        Test_Question q132=new Test_Question("A என்பவர் B யிடம் தனது சைக்கிள்ஐ  20% லாபத்தில் விற்கிறார், B அந்த சைக்கிள்ஐ  Cயிடம் 25% லாபத்தில் விற்கிறார்,அதாவது Cஅதை 225Rs க்கு வாங்குகிறார், எனில் Aஅந்த சைக்கிள்ஐ விற்ற விலை ?","A sells a bicycle to B at a profit of 20%, B sells it to C at a profit of 25%.If C pays Rs.225 for it,the cost price of the bicycle for A is?","Rs.110","Rs.120","Rs.125","Rs.150",4, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q132);
        Test_Question q133=new Test_Question("ஒருவர் மின்விசிறியை 400Rs இல் இருந்து 380Rs க்கு  விற்கும் போது,2% நட்டம்  அடைகிறார்.எனில் அதன் அடக்க விலை ?","If a man reduces the selling price of a fan from Rs.400 to Rs.380, his loss increases by 2%. The cost price of the fan is?","Rs.480","Rs.500","Rs.600","none of these",4, Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q133);


        Test_Question q134=new Test_Question("A ஒரு  வேலையை 10 நாட்களில் முடிக்கிறார், B அதே வேலையை 15 நாட்களில் முடிக்கிறார். இருவரும் சேர்ந்து அந்த வேலையை முடிக்க ஆகும் நாட்கள் ?","A does a work in 10 days and B does the same work in 15 days.In how many days they together will do the same work?","5 days","6 days","8 days","9 days",2, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q134);
        Test_Question q135=new Test_Question("A ஒரு  வேலையை 15 நாட்களில் முடிக்கிறார், அவரின் தந்தை அந்த வேலையை முடிக்க 20 நாட்கள் எடுக்கிறார் மற்றும் அவரது மகன் 25 நாட்கள் எடுக்கிறார். அவர்கள் அனைவரும் சேர்ந்து வேலை செய்தால் எவ்வளவு நேரம் எடுத்துக்கொள்வார்கள் ?","A man can do a job in 15 days, his father takes 20 days and his son finishes it in 25 days. how long will they take to complete the job if they all work together?","less than 6 days","exactly 6 days","approximately 6.4 days","more than 10 days",3, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q135);
        Test_Question q136=new Test_Question("A மற்றும் B சேர்ந்து ஒரு வேலையை 8நாட்களில் முடிக்கின்றனர்,B மற்றும் C சேர்ந்து அதே வேலையை 12 நாட்களில் முடிகின்றனர், B மற்றும் C சேர்ந்து வேலையை 6 நாட்களில் முடிக்கின்றனர்,எனில் A மற்றும் C சேர்ந்து அந்த வேலையை முடிக்க எடுக்கும் நாள் ?","A and B can do a work in 8 days, B and C can do the same work in 12 days, A,B and C together can finish it in 6 days, A and C together will do it in?","4 days","6 days","8 days","12 days",3, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q136);
        Test_Question q137=new Test_Question("A ஒரு வேலையை முடிக்க எடுத்து கொள்ளும் நேரம், B மற்றும் C சேர்ந்து முடிக்க எடுத்து கொள்ளும் நேரத்திற்கு சமம். A  மற்றும் B சேர்ந்து 10 நாட்களில் அந்த வேலையை முடிக்கின்றனர்.C முடிக்க 50நாட்கள் ஆகிறது,எனில் B அந்த வேலையை முடிக்க எடுக்கும் காலம் ?","A can do a certain work in the same time in which B and C together can do it .If A and b together could do it in 10days and C alone in 50 days, then B alone could do it in?","15 days","20days","25 days","30 days",3, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q137);
        Test_Question q138=new Test_Question("A ஒரு வேலையை முடிக்க 15நாட்கள் ,B  20நாட்கள் எடுக்கின்றனர், இருவரும் சேர்ந்து 4 நாட்கள் வேலை செய்கின்றனர்,எனில் மீதமுள்ள வேலை எவ்வளவு ?","A can do a work in 15 days and B in 20 days. If they work on it together for 4 days, then the fraction of the work that is left is?.","1/4","1/10","7/15","8/15",4, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q138);
        Test_Question q139=new Test_Question("A மற்றும் B ஒரு வேலையை முடிக்க 45,40 நாட்கள் எடுக்கின்றனர்.இருவரும் சேர்ந்து அந்த வேலையை செய்கின்றனர் அப்போது A அதில் இருந்து விலகுகிறார், B மட்டும் அந்த வேலையை முடிக்க 23நாட்கள் ஆகிறது.எனில் A வேலையை விட்டு சென்ற நாட்கள் ?","A and B can do a piece of work in 45 days and 40 days . They began to do the work together but A leaves after some days and then B completed the remaining work in 23 days . the number of days after Which A left the Work was?","6","8","9","12",3, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q139);
        Test_Question q140=new Test_Question("A மற்றும் B சேர்ந்து ஒரு வேலையை 12 நாட்களில் முடிகின்றனர். A மட்டும் அந்த வேலையை முடிக்க 20 நாட்கள் ஆகிறது.B அந்த வேலையை ஒருநாளில் பாதி மட்டும் வேலை செய்து முடிக்கிறார்,எனில் A மற்றும் B சேர்ந்து அந்த வேலையை முடிக்க எடுக்கும் நாள் ?","A and B together can complete a work in 12 days. A alone can complete it in 20 days. If B does the work only for half a day daily, then in how many days A and B together Will complete the work?","10 days","11 days","15 days","20 days",3, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q140);
        Test_Question q141=new Test_Question("12 ஆட்கள் ஒருவேலையை 9நாட்களில் முடிக்கின்றனர், 6 நாட்கள் அவர்கள் அந்த வேலையை தெடர்ந்து பின் மேலும் 6நபர்கள் சேர்கின்றனர்,எனில் மீதமுள்ள வேலையை முடிக்க ஆகும் நாள் ?","12 man can complete a work in 9 days. After they have worked for 6 days,6 more men join them.How many days will take to complete the remaining work?","2 days","3 days","4 days","5days",1, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q141);
        Test_Question q142=new Test_Question("A ஒரு  வேலையை 18 நாட்களில் முடிக்கிறார், B அதே வேலையை A வின் நேரத்தில் பாதி  எடுக்கிறார்  இருவரும் சேர்ந்து ஒருநாளில் முடிக்கும் வேலை ?","A can finish a work in 18 days and B can do the same work in half the time taken by A, then working together, what part of the same work they can finish in a day?","1/6","1/9","2/5","2/7",1, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q142);
        Test_Question q143=new Test_Question("A என்பவர் ஒருவேலையை முடிக்க B போல் 2மடங்கு அல்லது அந்த வேலையை முடிப்பதுபோல் 3மடங்கு நேரம் எடுத்துக்கொள்கிறார்,இருவரும் சேர்ந்து அந்த வேலையை 2நாட்களில் முடிக்கின்றனர்,எனில் B அந்த வேலையை எத்தனை நாட்களில் முடிப்பார் ?","A takes twice as much time as B or thrice as much time to finish a piece of work.Working together, they can finish the work in 2 days.B can do the work alone in?","4 days","6 days","8 days","12 days",2, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q143);
        Test_Question q144=new Test_Question("A என்பவர் ஒருவேலையை முடிக்க 4 மணிநேரம் ஆகிறது, B மற்றும் C சேர்ந்து அந்த வேலையை முடிக்க 3 மணிநேரம் ஆகிறது, A  மற்றும் C சேர்ந்து அந்த வேலையை 2 மணிநேரத்தில் முடிக்கின்றனர்,எனில் அந்த வேலையை முடிக்க B எடுத்துக்கொள்ளும் நேரம்?","A can do a piece of work in 4 hours.B and C together can do it in 3 hours, While A and C together can do it in 2 hours.How long will B alone take to do it?","8 hours","10 hours","12 hours","24 hours",3, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q144);
        Test_Question q145=new Test_Question("A என்பவர் B யை விட 2மடங்கு வேகத்தில் வேலை செய்கிறார்.B 12நாட்களில் அந்த வேலையை முடிக்கிறார் எனில் A  மற்றும் B சேர்ந்து அந்த வேலையை முடிக்க எடுக்கும் நாள் ?","A works twice as fast as B.If B can complete a work in 12 days independently, the number of days in which A and B can together finish the work is?","4 days","6 days","8 days","18 days",1, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q145);
        Test_Question q146=new Test_Question("A மற்றும் B சேர்ந்து ஒரு வேலையை முடிக்க 30 நாட்கள் ஆகிறது, A 16நாட்கள் வேலை செய்கிறார், B மீதமுள்ள வேலையை 44நாட்களில் முடிக்கிறார்.எனில் B அந்த வேலையை தனியே முடிக்க எடுக்கும் நாள் ?",".A and B together can do a piece of work in 30 days. A having worked for 16 days, B finishes the remaining work alone in 44 days. In how many days shall B finish the whole work alone?","30 days","40 days","60 days","70 days",4, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q146);
        Test_Question q147=new Test_Question("கிம் 3நாட்களில் ஒரு வேலையை முடிகிறரர்,டேவிட் அதே வேலையை 2நாட்களில் முடிக்கிறார்.இருவரும் சேர்ந்து அந்த வேலையை முடித்தபின் 150Rs பெறுகின்றனர் எனில் கிம்-ன் பங்கு எவ்வளவு ?","Kim can do a work in 3 days while David can do the same work in 2 days, Both of tem finish the work together an get Rs.150 .what is the share of Kim?","Rs.30","Rs.60","Rs.70","Rs.75",2, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q147);
        Test_Question q148=new Test_Question("20 பெண்கள் ஒரு வேலையை 16நாட்களில் முடிக்கின்றனர், 16 ஆண்கள் அதே வேலையை 15நாட்களில் முடிக்கின்றனர்.எனில் ஆண் மற்றும் பெண்களின் வேலை திறன் விதம் ?",".Twenty women can do a work in 16 days ,16 men can complete the same work in fifteen days.What is the ratio between the capacity of  a man and woman?","3:4","4:3","5:3","none of these",2, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q148);
        Test_Question q149=new Test_Question("4 ஆண்கள் 6 பெண்கள் ஒரு வேலையை 8நாட்களில் முடிக்கின்றனர்.அதே வேலையை 3ஆண்கள் 7 பெண்கள் சேர்ந்து 10நாட்களில் முடிக்கின்றனர்.10 பெண்கள் சேர்ந்து எத்தனை நாட்களில் அந்த வேலையை முடிப்பார்கள்?","4 men and 6 women can complete a work in 8 days, while 3 men and 7 woment can complete it in 10 days. In how many days will 10 women complete it?","35","40","45","50",2, Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q149);


        Test_Question q150=new Test_Question("ஒருவர் கிராமத்தில் இருந்து அஞ்சலகத்திற்கு 25kmph வேகத்திலும் மீண்டும் திரும்பி 4kmph வேகத்தில் வருகிறார்,மொத்த பயணம் 5hour 48min எடுக்கிறது எனில், அஞ்சலகத்திற்கும், கிராமத்திற்கும் இடையேயான தூரம் ?","A man travelled from the village to the post-office at the rate of 25kmph and walked back at the rate of 4kmph. If the whole journey took 5 hours 48 minutes find the distance of the post-office from the village?","20km","29km","32km","45km",1, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q150);
        Test_Question q151=new Test_Question("ஒரு அதிவேக ரயில் சராசரியாக 100km/hr வேகத்தில் செல்கிறது,ஒவ்வொரு 75km  க்கும்  3நிமிடங்கள் நிற்கிறது,எனில் 600km தூரத்தை அடைய எடுத்துக்கொள்ளும் நேரம்?","The express train travelled at an average speeed of 100km/hr, stopping for 3 minutes after every 75km.how long did it take to reach its destination 600km from the starting point?","6hr 21mins","6hr 24 mins","6hr 27 mins","6hr 30 min",1, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q151);
        Test_Question q152=new Test_Question("ஒரு ரயில் 10km  தொலைவை 12mins ல் கடக்கிறது, அதன் வேகம் 5km/hr குறைகிறது,அதே தொலைவை கடக்க எடுக்கும் நேரம் ?","A train covers a distance of 10 km in 12 minutes.If its speed is decreased by 5km/hr,the time taken by it to cover the same distance will be?","10 min","11min 20sec","13min","13min 20sec",4, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q152);
        Test_Question q153=new Test_Question("ஒருவர் சமமான தொலைவை 3km/hr, 4km/hr, 5km/hr வேகத்தில் 47minல்  கடக்கின்றார்,எனில் கடந்த மொத்த தொலைவு ?","A person travels equals distance with speed of 3 km/hr, 4 km/hr and 5 km/hr and take a total time of 47 minutes. the total distance is(in km)?","2","3","4","5",2, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q153);
        Test_Question q154=new Test_Question("A என்பர் Bஐ விட வேகமானவர்,A மற்றும் B ஒவ்வொருவரும் 24km நடக்கின்றனர். அவர்களின் வேகங்களின் கூடுதல் 7km/hr மற்றும் அவர்கள் எடுத்துக்கொண்ட நேரம் 14 மணிநேரம், எனில் Aன் வேகம் ?","A is faster than B. A and B each walk 24km. The sum of their speed is 7 km/hr and the sum of times taken by them is 14 hours.then A's speed is equals to?","3 km/hr","4 km/hr","5 km/hr","7 km/hr",2, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q154);
        Test_Question q155=new Test_Question("ஒரு பையன் தனது வீட்டில் இருந்து பள்ளிக்கு 3km/hr செல்கிறான், திரும்பி வரும்போது 2km/hr வேகத்தில் வருகிறான், அவன் போய் வருவதற்கு 5மணிநேரம் ஆகிறது எனில் வீட்டிற்கும் ,பள்ளிக்கும் இடைப்பட்ட தொலைவு? ","A boy goes to his school form his house at a speed of 3 km/hr and returns at a speed of 2 km/hr.If he takes 5 hours in going and coming, the distance between his house and school is?","5km","5.5km","6km","6.5km",3, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q155);
        Test_Question q156=new Test_Question("நிறுத்தங்களை சேர்க்காமல் ஒரு பேருந்தின் வேகம் 54kmph, நிறுத்தங்களை சேர்த்தால் 45kmph,எனில் ஒருமணி நேரத்திற்கு பேருந்து எவ்வளவு நேரம் நிற்கும் ?","Excluding stoppages, the speed of a bus is 54 kmph and including stoppages, it is 45kmph. for how many minutes does the bus stop per hour?","9","10","12","20",2, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q156);
        Test_Question q157=new Test_Question("ஒருவர் 10km/hr வேகத்திற்கு பதிலாக 14km/hr வேகத்தில் நடந்தால் 20km அதிகமாக நடந்து விடுகிறார், அவர் சரியாக கடக்க வேண்டிய தொலைவு?","If a person walks at 14 km/hr instead of 10 km/hr, he would have walked 20 km more.the actual distance travelled by him is?","50 km","56 km","70 km ","80 km",1, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q157);
        Test_Question q158=new Test_Question("ஒரு ஓட்ட வீரர் 200மீட்டர்ஐ 24 sec ல் கடக்கிறார்,எனில் அவர் வேகம் ?","An athlete runs 200 meters race in 24 seconds.His speed is?","20km/hr","24km/hr","28.5km/hr","30 km/hr",1, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q158);
        Test_Question q159=new Test_Question("ஒரு காரின் வேகம் ஒவ்வொரு மணி நேரத்திற்கும் 2km அதிகரிக்கிறது, முதல் ஒரு மணிநேரத்தில் கடந்த தொலைவு 35km எனில்,12 மணி நேரத்தில் கடந்த மொத்த தொலைவு ?","The speed of a car increases by 2kms after every one hour. if the distance travelled in the first one hour was 35kms, what was the total distance travelled in 12 hours?","456kms","482ms","552kms","556kms",3, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q159);
        Test_Question q160=new Test_Question("A என்பவர் ஒரு பயணத்தை 10 மணி நேரத்தில் முடிக்கிறார், முதலில் பாதியை 21km/hr வேகத்திலும் இரண்டாம் பாதியை 24km/hr வேகத்திலும் கடக்கிறார்,அவர் கடந்த மொத்த தொலைவு?","A can complete a journey in 10 hours.He travels first half of the journey at the rate of 21km/hr and second half at the rate of 24 km/hr .find the total journey in km?","220km","224km","230km","234km",2, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q160);
        Test_Question q161=new Test_Question("ஒரு உழவர் 61km ஐ  9மணி நேரத்தில் கடக்கிறார், அவர் நடந்து 4km/hr ம் , சைக்கிள் ல்  9km/hr ம் கடக்கிறார், அவர் நடந்து சென்ற தொலைவு ?","A farmer travelled a distance of 61km in 9 hours.He travelled partly on foot at 4 km/hr and partly on bicycle at 9 km/hr .the distance travelled on foot is?","14km","15km","16km","17km",3, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q161);
        Test_Question q162=new Test_Question("ஒருவர் P என்ற இடத்தில் இருந்து Q என்ற இடத்திற்கு 40kmph வேகத்தில் செல்கின்றார்,திரும்பி வரும்போது தனது வேகத்தில் 50%  அதிகரித்து பயணிக்கிறார்,எனில் அவரின் சராசரி வேகம் ?","A person travels from P to Q at a speed of 40 kmph and returns by increasing his speed by 50%.What is his average speed for both the trips?","36 kmph","45 kmph","48 kmph","50 kmph",3, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q162);
        Test_Question q163=new Test_Question("ஒருவர் பயணத்தின் போது முதல் 160km ஐ 64km/hr வேகத்திலும் அடுத்த 160km ஐ 80 km/hr வேகத்திலும் கடக்கிறார்,எனில் முதல் 320km தொலைவுக்கான சராசரி வேகம்?","A man on tour travel first 160 km at 64 km/hr and the next 160 km at 80 km/hr .The average speed for the first 320km of the tour is?","35.55 km/hr","36 km/hr","71.11 km/hr","71 km/hr",3, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q163);
        Test_Question q164=new Test_Question("30km தொலைவை கடக்க அபி ,சமீரை விட 2மணிநேரம் அதிகம் எடுக்கிறான்.அபி தனது வேகத்தை 2மடங்கு அதிக படுத்தினால் சமீரை விட ஒரு மணிநேரம் குறைவாக எடுத்திக்கொள்வான்,எனில் அபியின் வேகம் ?",".In-covering a distance of 30km, Abi takes 2 hours more than Sameer.if abi doubles his speed, then he would take 1 hour less than sameer.Abi's speed is?","5 kmph","6kmph","6.25kmph","7.5kmph",1, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q164);
        Test_Question q165=new Test_Question("ஒரு திருடன் காரை 2:30pm க்கு திருடுகிறான்,திருட்டு 3:00pm க்கு தெரிய வருகிறது,உரிமையாளர் 75kmph வேகத்தில் வேறொரு காரில் துரத்தினால்,எப்போது திருடனை பிடிப்பார் ?","A thief steals a car at 2.30 pm. and drives it at 60 kmph.the theft is discovered at 3 pm. and the onwer set of in another car at 75 kmph.when will he overtake the thief?","4:30pm","4:45pm","5pm","5.15pm",3, Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q165);


        Test_Question q166=new Test_Question("Rs450 எப்போது வட்டி 81Rs ஐ 4.5% ஆண்டுவட்டியில் தரும் ?","How much time will it take for an amount of Rs.450 to Yield Rs.81 as interest at 4.5% per annum of simple interest?","3.5 years","4 years","4.5 year","5 years",2, Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q166);
        Test_Question q167=new Test_Question("132Rs ன் தற்போதைய மதிப்பு 2 ஆண்டுகள், 5% வட்டி விகிதத்தில்,தனிவட்டி முறையில்  காண்க ?","What is the present worth of Rs.132 due in 2 years at 5% simple interest per annum?","Rs.12","Rs.118.80","Rs.120","Rs.122",3, Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q167);
        Test_Question q168=new Test_Question("ஒரு குறிப்பிட்ட  தொகை ஒரே வட்டிவிகிதத்தில் 6 மற்றும் 9 வருடங்கள் இருந்தால்,அதன் தனிவட்டி விகிதம் என்ன ?","What will be the ratio of simple interest earned by certain amount at the same rate of interest for 6 years and ther for 9 years?","1:3","1:4","2:3","None of these",3, Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q168);
        Test_Question q169=new Test_Question("5 வருடங்களில் தனிவட்டி கூடுதல் Rs.9800,அதுவே 4 வருடங்களில் Rs.12005 எனில் அதன் வட்டி விகிதம் காண்க ?","A sum of money amount to Rs.9800 after 5 years and Rs.12005 after 8 years at the same rate of simple interest. the rate of interest per annum is?","12%","8%","5%","15%",1, Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q169);
        Test_Question q170=new Test_Question("ஒருவன் வங்கியில் ஆண்டுக்கு 12% தனிவட்டி முறையில் கடன் பெறுகிறார், 3வருடங்களுக்கு அந்த காலத்திற்கு  பிறகு அவர் வட்டியாக Rs.5400 செலுத்தவேண்டும்,எனில் அவர் பெற்ற கடன்தொகை என்ன ?","A Man took a loan from a bank at the rate of 12% p.a simple interest.After 3years he had to pay Rs.5400 interest only for the the period.The principal amount brrowed by him was?","Rs.2000","Rs.10,000","Rs.15,000","Rs.20,000",3, Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q170);
        Test_Question q171=new Test_Question("Rs.800 3ஆண்டுகளில் குறிப்பிட்ட தனிவட்டி விகிதத்தில் Rs.956ஆக மாறுகிறது, எனில் தனிவட்டி விகிதம் 4% ஆக உயர்கிறது என்றால், Rs.800 3ஆண்டுகளில் என்னவாக இருக்கும்?","Rs.800 becomes Rs.956 in 3years at a certain rate of simple interest. If the rate of interest is increased by 4%, What amount will Rs.800 become in 3 years?","Rs.1020.80","Rs.1025","Rs.1052","Data inadeuate",3, Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q171);
        Test_Question q172=new Test_Question("ஒரே வட்டிவிகிதத்தில் ஒரு குறிப்பிட்ட தொகை 3 மற்றும் 6 வருடங்களில் தரும் வட்டியின் விகிதம் கண்டறி ?","What will be the ratio of simple interest earned by certain amount at the same rate of interest for 3years and that for 6years?","1:2","1:4","2:3","None of these",1, Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q172);
        Test_Question q173=new Test_Question("12500Rs 4ஆண்டுகளில் 15500Rs ஆக கூடுகிறது,தனிவட்டி முறையில் அதன் வட்டி விகிதம் காண்க?","A sum of Rs.12500 amounts to Rs.15500 in 4 years at the rate of simpe interest.What is the rate of interest?","3%","4%","5%","6%",4, Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q173);
        Test_Question q174=new Test_Question("ஒரு குறிப்பிட்ட தொகை தனிவட்டியாக Rs1750 ஐ 7 வருடங்கள் கழித்து தருகிறது, அதன் வட்டி விகிதம் 2% அதிகரித்தல்,இன்னும் எவ்வளவு வட்டி அதிகம் கிடைத்திருக்கும் ?","A certain amount earns simple interest of Rs.1750 after 7 years. had the interest been 2 % more, how much more interest would it have earned?","Rs.35","Rs.245","Rs.350","Cannot be determainde",4, Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q174);
        Test_Question q175=new Test_Question("3 வருடங்களில் தனிவட்டி கூடுதல் Rs.815,அதுவே 4 வருடங்களில் Rs.845 எனில் கூடுதல் கண்டறி ?","A sum of money at simple interest amount to Rs.815 in 3 years and to Rs.845 in 4 years.The sum is?","Rs.650","Rs.690","Rs.698","Rs.700",3, Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q175);
        Test_Question q176=new Test_Question("ரீனா தனிவட்டி முறையில்,தனிவட்டி விகிதத்திற்கு நிகரான ஆண்டுகளுக்கு  Rs.1200 ஐ கடனாக பெறுகிறார், அவர் Rs.432ஐ கடன் காலம் முடியும் போது செலுத்துகிறார்,எனில் தனிவட்டி விகிதம் என்ன ?","Reena took a loan of Rs.1200 with simple interest for as many years as the rate of interest.If she paid Rs.432 as interest at the end of the loan period, What was the rate of interest?","3.6","6","18","Cannot be determined",2, Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q176);
        Test_Question q177=new Test_Question("Rs.4016.25ஐ மொத்த தனிவட்டியாக 9% ஆண்டுவட்டியில் 5ஆண்டுகளுக்கு பெற்றால் வாய்ப்பு தொகை என்ன ?","A sum fetched a total simple interest of Rs.4016.25 at the rate of 9% p.a, in 5years,what is the sum?","Rs.8925","Rs.4462.50","Rs.8032.50","None of these",1, Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q177);
        Test_Question q178=new Test_Question("In how many years, Rs.150 will produce the same interest at 8% as Rs.800 produce in 3 years at 4.5 %?","Rs.150 8% வட்டிவிகிதத்தில் எத்தனை வருடங்களில், Rs.800 3வருடங்களில் 4.5%வட்டிவிகிதத்தில் வட்டி  தருவதுபோல் வட்டியை தரும்?","6","8","9","12",3, Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q178);













    }

    private void addQuestion(Test_Question test_question){
        ContentValues cv=new ContentValues();
        cv.put(TestQuestionsTable.COLUMN_QUESTION_TAMIL,test_question.getQuestion_tamil());
        cv.put(TestQuestionsTable.COLUMN_QUESTION_ENGLISH,test_question.getQuestion_english());
        cv.put(TestQuestionsTable.COLUMN_OPTION1,test_question.getOption1());
        cv.put(TestQuestionsTable.COLUMN_OPTION2,test_question.getOption2());
        cv.put(TestQuestionsTable.COLUMN_OPTION3,test_question.getOption3());
        cv.put(TestQuestionsTable.COLUMN_OPTION4,test_question.getOption4());
        cv.put(TestQuestionsTable.COLUMN_ANSWER_NR,test_question.getAnswerNr());
        cv.put(TestQuestionsTable.COLUMN_CATEGORY,test_question.getCategory());

        db.insert(TestQuestionsTable.TABLE_NAME,null,cv);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TestQuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    public List<Test_Question> getAllQuestions(String category){
        List<Test_Question> questionsList=new ArrayList<>();
        db=getReadableDatabase();

        String[] selectionArgs= new String[]{category};
        Cursor c= db.rawQuery("SELECT * FROM "+ Test_QuizContract.TestQuestionsTable.TABLE_NAME+" WHERE "+ Test_QuizContract.TestQuestionsTable.COLUMN_CATEGORY + "= ?",selectionArgs);

        if(c.moveToFirst()){
            do {
                Test_Question test_question=new Test_Question();
                test_question.setQuestion_tamil(c.getString(c.getColumnIndex(Test_QuizContract.TestQuestionsTable.COLUMN_QUESTION_TAMIL)));
                test_question.setQuestion_english(c.getString(c.getColumnIndex(Test_QuizContract.TestQuestionsTable.COLUMN_QUESTION_ENGLISH)));
                test_question.setOption1(c.getString(c.getColumnIndex(Test_QuizContract.TestQuestionsTable.COLUMN_OPTION1)));
                test_question.setOption2(c.getString(c.getColumnIndex(Test_QuizContract.TestQuestionsTable.COLUMN_OPTION2)));
                test_question.setOption3(c.getString(c.getColumnIndex(Test_QuizContract.TestQuestionsTable.COLUMN_OPTION3)));
                test_question.setOption4(c.getString(c.getColumnIndex(Test_QuizContract.TestQuestionsTable.COLUMN_OPTION4)));
                test_question.setAnswerNr(c.getInt(c.getColumnIndex(Test_QuizContract.TestQuestionsTable.COLUMN_ANSWER_NR)));
                test_question.setCategory(c.getString(c.getColumnIndex(Test_QuizContract.TestQuestionsTable.COLUMN_CATEGORY)));
                questionsList.add(test_question);

            }
            while (c.moveToNext());

        }
        c.close();
        return questionsList;
    }
}

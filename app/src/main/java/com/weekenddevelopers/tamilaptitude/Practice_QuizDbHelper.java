package com.weekenddevelopers.tamilaptitude;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.weekenddevelopers.tamilaptitude.Practice_QuizContract.*;

import java.util.ArrayList;
import java.util.List;

public class Practice_QuizDbHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME="PracticeQuiz.db";
        private static final int DATABASE_VERSION=1;

        private SQLiteDatabase db;

    public Practice_QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        this.db=sqLiteDatabase;

        final String SQL_CREATE_PRACTICE_QUESTION_TABLE="CREATE TABLE "+QuestionsTable.TABLE_NAME +
                "( "+ QuestionsTable._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                       QuestionsTable.COLUMN_QUESTION_TAMIL+" TEXT, "+
                        QuestionsTable.COLUMN_QUESTION_ENGLISH+" TEXT, "+
                        QuestionsTable.COLUMN_OPTION1+" TEXT, "+
                        QuestionsTable.COLUMN_OPTION2+" TEXT, "+
                        QuestionsTable.COLUMN_OPTION3+" TEXT, "+
                        QuestionsTable.COLUMN_OPTION4+" TEXT, "+
                        QuestionsTable.COLUMN_ANSWER_NR+" INTEGER, "+
                        QuestionsTable.COLUMN_HINT+" TEXT, "+
                        QuestionsTable.COLUMN_CATEGORY+" TEXT "+
                ")";
        db.execSQL(SQL_CREATE_PRACTICE_QUESTION_TABLE);
        fillQuestionTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);

    }

    private void fillQuestionTable(){
        Practice_Question q1=new Practice_Question("தீர்க்க 7589 - ? = 3434 ","Solve 7589 - ? = 3434 ","4242","4155","1123","11023",2,"A & B", Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q1);
        Practice_Question q2=new Practice_Question("தீர்க்க  4300731 - ? = 2535618","Solve 4300731 - ? = 2535618","1865113","1775123","1765113","1675123",2,"B & D", Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q2);
        Practice_Question q3=new Practice_Question("512#324 என்ற எண் முழுமையாக 3 ஆல் வகுப்படுமாயின் #ன் மிகச்சிறிய எண்ணை கண்டறி","If the number 512#324 is completely divisible by 3, then the smallest whole number in place of # will be:","0","1","2","none of these",3,"A & C", Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q3);
        Practice_Question q4=new Practice_Question("97215#7 என்ற எண் முழுமையாக 11 ஆல் வகுப்படுமாயின் #ன் மிகச்சிறிய எண்ணை கண்டறி ","If the number 97215#7 is completely divisible by 11 then the smallest whole number in place of # will be","3","2","1","5",1,"A & D", Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q4);
        Practice_Question q5=new Practice_Question("பின்வரும் எண்களில் 11 ஆல் வகுப்படும் எண் ?","which one of the following numbers is exactly divisible by 11?","235641","245642","315624","415624",4,"B & D", Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q5);
        Practice_Question q6=new Practice_Question("பின்வரும் எண்களில் பகு எண் ?","Which of the following is not a prime number?","31","69","71","47",2,"B & A", Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q6);
        Practice_Question q10=new Practice_Question("ஒரு எண் 296 ஆல் வகுக்கும் போது மீதி =75, அதையே  37 ஆல் வகுக்கும் போது மீதி என்ன ?","A number when divided by 296, leaves, 75 as remainder.when the same number is divided by 37, the remainder will be?","1","2","8","11",1,"B & A", Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q10);
        Practice_Question q9=new Practice_Question("ஒரு எண்ணை வகுக்கும் போது மீதி =0, ஒரு மாணவன்  21ஆல் வகுப்பதற்கு பதிலாக 12-ஆல் தவறுதலாக வகுக்கும்போது ஈவு =35 கிடைக்கிறது. சரியான ஈவு என்ன ?","In a Division sum, the remainder is 0. A student mistook the divisor by 12 instead of 21 and obtained 35 as quotient, What is the correct quotient?","0","12","13","20",4,"A & D", Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q9);
        Practice_Question q8=new Practice_Question("ஒரு எண்ணை 5ஆல் வகுக்க 3 மீதியாக கிடைக்கிறது.அதே எண்ணை வர்க்கப்படுத்தி 5 ஆல் வகுத்தால்  மீதி என்ன ?","On dividing a number by 5, we get 3 as a remainder. What will be the remainder when the square of this number is divided by 5? ","4","5","6","7",4,"C & D", Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q8);
        Practice_Question q7=new Practice_Question("ஒரு எண்ணை 56 ஆல் வகுக்க 29 மீதியாக கிடைக்கிறது.அதே எண்ணை 8 ஆல் வகுக்க மீதி என்ன ?","On dividing a number by 56, we get 29 as a remainder. On dividing the same number by 8, what will be the remainder?","4","6","5","7",3,"A & C", Practice_Question.CATEGORY_NUMBERS);
        addQuestion(q7);


        Practice_Question q11=new Practice_Question("252 ஐ எப்படி விரிவாக எழுதலாம்.","252 can be expressed as a product of primes as:","2x2x3x3x7","2x2x2x3x7","3x3x3x3x7 ","2x3x3x3x7",1,"A & C", Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q11);
        Practice_Question q12=new Practice_Question("எளிய வடிவில் சுருக்கு 1095/1168","1095/1168 when expressed in simplest form is ?","13/16","15/16","17/26","25/26",2,"B & D", Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q12);
        Practice_Question q13=new Practice_Question("மீ.பொ.வ காண்க :4x27x3125, 8x9x25x7 , 16x81x5x11x49","HCF of 4x27x3125, 8x9x25x7 , 16x81x5x11x49 is?","180","360","540 ","1260",1,"A & C", Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q13);
        Practice_Question q14=new Practice_Question("பின்வரும் எண்ணிற்கு மீச்சிறு பொது மடங்கு காண்க 24, 36, 40","Find the lowest common multiple of 24, 36, 40","120","240","360 ","480",3,"B & C", Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q14);
        Practice_Question q15=new Practice_Question("மீ.பொ.வ காண்க 1.08 , 0.36 and 0.9?","The G.C.D of 1.08 , 0.36 and 0.9 is?","0.03","0.9","0.18 ","0.108",3,"D & C", Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q15);
        Practice_Question q16=new Practice_Question("3240, 3600 மற்றும்  மூன்றாவது எண்ணின் மீ.பொ.வ 36, இவற்றின் மீ .சி.ம 2^4 x3^5 x5^2 x7^2 , எனில் 3வது எண் கண்டறி ?","HCF of 3240, 3600 and a third number is 36 and their LCM is 2^4x 3^5 x5^2 x7^2 the third number is ","2^2 x3^5 x7^2","2^2x5^3x7^2","2^5x5^2x7^2 ","2^3x3^5x7^2",1,"A & C", Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q16);
        Practice_Question q17=new Practice_Question("இரண்டு எண்களின் விகிதம் 3:4, இவற்றின் மீ.பொ.வ 4 எனில் அதன் மீ .சி.ம  ?","The ratio of two numbers is 3:4 and their HCF is 4. Their LCM is?","12","16","24 ","48",4,"D & C", Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q17);
        Practice_Question q18=new Practice_Question("இரு எண்களின் மீ.பொ.வ, மீ .சி.ம முறையே 84,21. இவற்றின் விகிதம் 1:4 எனில் மிகபெரிய எண்ணை கண்டறி","The HCF and LCM of two numbers are 84 and 21 respectively, if the ratio of the two numbers is 1:4, then the large of the two numbers is?","12","48","84 ","108",3,"A & C", Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q18);
        Practice_Question q19=new Practice_Question("இரு எண்களின் மீ.பொ.வ 8 எனில் பின்வருவனவற்றில் எவை மீ .சி.ம வாக கிடைக்காது ","The HCF of two numbers is 8 .Which one of the following can never be their LCM?","24","48","56","60",4,"A & D", Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q19);
        Practice_Question q20=new Practice_Question("7m, 3m 85cm, 12m 95cm ஆகிய நீளங்களை பொதுவாக அளக்கும் மிகப்பெரிய அளவினை காண்க ?","The greatest posssible length which can be used to measure exactly  the lengths 7m, 3m 85cm, 12m 95cm is ?","15cm","25cm","35cm ","42cm",3,"C & B", Practice_Question.CATEGORY_LCMHCF);
        addQuestion(q20);


        Practice_Question q21=new Practice_Question("பின்வருவனவற்றுள் எது ஏறுவரிசையில் உள்ளது ?","Which of the following has fraction in ascending order?","1/3, 2/5, 4/7, 3/5, 5/6, 6/7 ","1/3, 2/5, 3/5, 4/7, 5/6, 6/7","1/3, 2/5, 3/5, 5/6, 4/7, 6/7 ","2/5, 3/5, 1/3, 4/7, 5/6, 6/7",1,"D & A", Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q21);
        Practice_Question q22=new Practice_Question("பின்வருவனவற்றுள் எது இறங்குவரிசையில் உள்ளது ?","Which of the following are in descending order of their value?","5/9, 7/11, 8/15, 11/17 ","5/9, 8/15, 11/17, 7/11","11/17, 7/11, 8/15, 5/9","11/17, 7/11, 5/9, 8/15",4,"D & C", Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q22);
        Practice_Question q23=new Practice_Question("இவற்றுள் 3/4 விட பெரிய மற்றும் 5/6விட சிறிய எண்ணை கண்டறி ?","Which of the following fractions is greater than 3/4 and less than 5/6?","1/2 ","2/3","4/5 ","9/10",3,"A & C", Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q23);
        Practice_Question q24=new Practice_Question("தீர்க்க :617 + 6.017 + 0.617 +6.0017 =?","Solve: 617 + 6.017 + 0.617 +6.0017 =?","2963","62.965 ","629.6357 ","none of these",3,"C & B", Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q24);
        Practice_Question q25=new Practice_Question("தீர்க்க : 792.02 +101.32-306.76=?","Solve:  792.02 +101.32-306.76=?","586.58","893.34","997.11 ","1200.10",1,"A & D", Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q25);
        Practice_Question q26=new Practice_Question("தீர்க்க :0.002 x 0.5 =?","Solve: 0.002 x 0.5 =?","0.0001","0.001","0.01 ","0.1",2,"D & B", Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q26);
        Practice_Question q27=new Practice_Question("144/0.144 = 144/x எனில் x?","If 144/0.144 = 144/x then the value of x is?","0.0144","1.44","14.4 ","144",1,"D & A", Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q27);
        Practice_Question q28=new Practice_Question("0.125125....ஐ பின்னமாக்கு.","The rational numbers for the recurring decimal 0.125125..... is?","63/487","119/993","125/999 ","none of these",3,"A & C", Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q28);
        Practice_Question q29=new Practice_Question("இதில் மிக சிறிய எண்?","The least among the following is?","0.2","1÷0.2","0.2̅ ","0.2^2",4,"A & D", Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q29);
        Practice_Question q30=new Practice_Question("தீர்க்க  :(0.0̅9̅ x 7.3̅)=?","Solve : (0.0̅9̅ x 7.3̅) is equal to ?","0.6̅",".6̅5̅7̅ ",".6̅7̅ ",".65̅7̅",1,"A & C", Practice_Question.CATEGORY_DECIMAL);
        addQuestion(q30);


        Practice_Question q31=new Practice_Question("தீர்க்க  :100 + 50 x 2=?","Solve  :100 + 50 x 2=?","75","150","200","300",3,"A & C", Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q31);
        Practice_Question q32=new Practice_Question("தீர்க்க  : 5004 ÷ 139 -6 =?","Solve : 5004 ÷ 139 -6 =?","24","30","36","42",2,"B & C", Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q32);
        Practice_Question q33=new Practice_Question("ஒரு நிறுவனத்தின் வருமானம் ஒரு வருடத்திற்கு பின் இரு மடங்கிறது, அதன் முதல் வருமானம் 4 லட்சம் எனில் 5 வருடத்திற்கு பின் அதன் வருமானம்?","Income of a company doubles afer every one year. If the initial income was Rs.4 lakhs,what would be the income after 5 years?","Rs. 1.24 crores","Rs.1.28 crores","2.56 crores","none of these",2,"A & B", Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q33);
        Practice_Question q34=new Practice_Question("ஒரு ஒளியானது 13நொடி இடைவெளியில் மின்னுகிறது, அது 1hour 54min 50 secல்  முதலில் மின்னியது அது கடைசியாக 3hour 17 min 49secல் மின்னியது.அது எத்தனை முறை மினியிருக்கும்.?","6.A light was seen at interval of 13 seconds it was seen for the first time at 1 hour 54 minutes 50sec and the last time at 3 hours 17 minutes 49 seconds how many times was the light seen?","360","375","378","384",4,"C & D", Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q34);
        Practice_Question q35=new Practice_Question("டேவிட் வரலாற்றில் பெற்ற மதிப்பெண்போல்  ஆங்கிலத்தில் இரண்டரை மடங்கு மதிப்பெண் பெறுகிறான், இரு பாடங்களிலும் பெற்ற மொத்த மதிப்பெண் 140 எனில் ஆங்கிலத்தில் அவர் பெற்ற மதிப்பெண் ?","David got two and a half  times as many marks in English as in history, If his total mark in the two subjects are 140 the mark obtained by him in English are?","40","75","90","100",4,"A & D", Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q35);
        Practice_Question q36=new Practice_Question("ஒரு தொட்டியின் மூன்றில் ஒருமடங்கு கொள்ளளவு 80லிட்டர்,தொட்டியின் அரை மடங்கு கொள்ளளவு என்ன?","If one third of a tank holds 80 litre of water then the quantity of water that half the tank hold is?","80/3 liters","100liters","120 liters","240 liters",3,"C & B", Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q36);
        Practice_Question q37=new Practice_Question("ராகுலின் national savings certificateல் உள்ள மூன்றில் ஒரு மடங்கு சேமிப்பு  public provident fundல் உள்ள சேமிப்பின் பாதிக்கு சமம். அவன் மொத்தமாக  Rs.150000 சேமிப்பு வைத்திருந்தால், public provident fundன் மொத்த சேமிப்பு என்ன?","One-Third of Rugul's savings in national saving certificate is equal to one half of his savings in public provident fund if he has Rupees 150000 as total saving how much has he saved in public provident fund?","Rs.30,000","Rs.50,000","Rs.60,000","Rs.90,000",3,"B & C", Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q37);
        Practice_Question q38=new Practice_Question("ஒரு அணி அவர்கள் பெற்ற தோல்வியைவிட 3 ஆட்டங்கள் அதிகம் வெற்றி பெறுகின்றனர்.வெற்றி பெற்றால் 2 மதிப்பெண்,தோல்வி அடைந்தால் -1 மதிப்பெண் எனில், 23 மதிப்பெண் பெற அவர்கள் ஆடிய ஆடங்களின் எண்ணிக்கை?","A cricket team won 3 matches more than they lost, If a win gives them 2 points and loss(-1) point, how many matches, in all, have thet played if their score is 23?","17","20","37","40",1,"D & A", Practice_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q38);


        Practice_Question q39=new Practice_Question("டேவிட் ஆங்கிலம், கணிதம்,இயற்பியல், வேதியல்,உயிரியலில் 76,65,82,67,85 மதிப்பெண் பெற்றுள்ளார்.அவரின் சராசரி மதிப்பெண்?","David obtained 76,65,82,67 and 85 mark(out of 100) in english, maths, physics,chemistry,biology what are his average mark?","65","69","72","none of these",4,"A & B", Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q39);
        Practice_Question q40=new Practice_Question("6கும் 34கும் இடைப்பட்ட 5 ஆல் வகுப்படும் எண்களின் சராசரி காண்க?","Find the average of all the numbers between 6 and 34 which are divisible by 5?","18","20","24","30",2,"C & B", Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q40);
        Practice_Question q41=new Practice_Question("ஒரு மாணவன் 3,11,7,15,13,8,19,17,21,14,x ஆகியவற்றிற்கு கூட்டுசாரசரி 12 காண்கிறான்.எனில் x ?","A student was asked to find the arithmetic mean of the numbers 3,11,7,9,15,13,8,19,17,21,14 and x. He found the mean to be 12. what should be the number in place of x?","3","7","17","31",2,"B & A", Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q41);
        Practice_Question q42=new Practice_Question("ஒரு பூஜியம் இல்லாத எண்ணின் சராசரி,அதன் வர்க்கம் அந்த எண்ணைபோல் 5 மடங்கு எனில் அந்த எண் காண்க?","The average of a non-zero number and its square is 5 times the number.The number is?","9","17","29","295",1,"A & C", Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q42);
        Practice_Question q43=new Practice_Question("ஒரு நூலகம் சராசரியாக 510 வாசகர்களை ஞாயிற்றுகிழமையும், 240 வாசகர்களை மற்ற கிழமைகளிலும் பெற்றுள்ளது.முதல் நாள் ஞாயிற்றுகிழமை கொண்ட 30 நாட்கள் கொண்ட மதத்தின் ஒருநாளுக்கான சராசரி வாசகர்கள்?","A library has an average of 510 visitors on sunday and 240 on other days.the average number of visitors per day in a month of 30 days beginning with a sunday is?","250","276","280","285",4,"C & D", Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q43);
        Practice_Question q44=new Practice_Question("ஒருவர் மூன்று ஆண்டுகள் பெட்ரோலை Rs.7.50, Rs.8 and Rs.8.50 per litre என்ற விலையில் வாங்குகிறார்.அவர் ஒவ்வொரு ஆண்டுக்கும் 4000Rs செலவழிக்கிறார் எனில் ஒரு லிட்டர் பெட்ரோலின் சராசரியானா விலை என்ன?",".A car owner buys petrols at Rs.7.50, Rs.8 and Rs.8.50 per litre for three successive years.What approximately is the average cost per litre of petrol if he spends Rs.4000 each year? ","Rs.7.98","Rs.8","Rs.8.50","Rs.9",1,"A & C", Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q44);
        Practice_Question q45=new Practice_Question("35 மாணவர்களின் சராசரி வயது 16, அதில் 21 மாணவர்களின் சராசரி வயது 14 எனில், மீதமுள்ள 14 மாணவர்களின் சராசரி வயது?","The averae age of 35 students in a class is 16 years.The average age of 21 students is 14. What is the average age of remaining 14 students?","15years","17years","18years","19years",4,"D & B", Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q45);
        Practice_Question q46=new Practice_Question("P,Qன் சராசரி மாத வருமானம் 5050rs, Q,Rன் சராசரி மாத வருமானம் 6250rs , P,Rன் சராசரி மாத வருமானம் 5200rs, Pன் மாத வருமானம் என்ன?","The average montly income of P and Q is Rs.5050. The average monthly income of Q and R is Rs.6250 and the average montly income of P and R is Rs.5200. The montly income of P is?","Rs.3500","Rs.4000","Rs.4050","Rs.5000",2,"D & B", Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q46);
        Practice_Question q47=new Practice_Question("ஒரு வகுப்பில் இருக்கும் 24 மாணவர்களின் சராசரி எடை 35kg, இதில் ஆசிரியரின் எடை சேர்க்கப்பட்டால் 400g அதிகரிக்கிறது,ஆசிரியரின் எடை கண்டறி?","The average weight of a class of 24 students is 35kg . If the weight of the teacher be included, the average rised by 400g, the weight of the teacher is?","45kg","50kg","53kg","55kg",1,"B & A", Practice_Question.CATEGORY_AVERAGE);
        addQuestion(q47);


        Practice_Question q48=new Practice_Question("5:4 ஐ சதவீதம் ஆக மாற்றுக.","The ratio 5:4 expressed as a percent equals?","12.5%","40%","80%","125%",4,"C & D", Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q48);
        Practice_Question q49=new Practice_Question("88% of 370 + 24% 210 -?=118","88% of 370 + 24% 210 -?=118","256","258","268","358",2,"C & B", Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q49);
        Practice_Question q50=new Practice_Question("?% of 932 + 30= 309.6","?% of 932 + 30= 309.6","25","30","35","40",2,"C & B", Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q50);
        Practice_Question q51=new Practice_Question("ஒரு தேர்வில் 35% மாணவர்கள் தேர்வடைந்தார்கள், 455 பேர் தோல்வியடைந்தார்கள், தேர்வை எழுதியவர்கள் எத்தனை பேர்?","In an examination 35% of students passed and 455 failded. how many students appeared for the examination?","490","700","845","1300",2,"D & B", Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q51);
        Practice_Question q52=new Practice_Question("pன் p% =36,எனில் p=?","If p% of p is 36, then p is equal to ?","15","60","600","3600",2,"B & A", Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q52);
        Practice_Question q53=new Practice_Question("தானியத்தின் விலை 16% குறைகிறது,எனில் அதன் பட்ஜெட் மாறாமல் ஒரு நபரின் பயன்பாட்டை உயர்த்துவதற்கான % ?","The price of wheat falls by 16%, by what percentage a person can increase the consumption of wheat so that his overall budget does not change?","16%","18%","18.5%,","19%",4,"D & A", Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q53);
        Practice_Question q54=new Practice_Question("ஒரு நகரின் மக்கள்தொகை ஆண்டுக்கு 5% உயர்கிறது, 2001ல் அதன் மக்கள்தொகை 1,38,915 எனில் 1998ல் மக்கள் தொகை என்ன?","The population of a town increases by 5% annually, if its population in 2001 was 1,38,915, what it was in 1998?","1,00,000","1,80,000","1,10,000","1,20,000",4,"C & D", Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q54);
        Practice_Question q55=new Practice_Question("Aன் வருமானம் Bன் வருமானத்தில் 40%, Bன் வருமானம் Cன் வருமானத்தில் 25% எனில், Aன் வருமானம் Cன் வருமானத்தில் எத்தனை %?","A's salary is 40% of B's salary which is 25% of C's salary.What percentage of C's salary is A's salary?","5%","10%","15%","20%",2,"C & B", Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q55);
        Practice_Question q56=new Practice_Question("பழங்கள் 68% தண்ணீர் கொண்டுள்ளன, வறல்பழங்கள் 20% தண்ணீர் கொண்டுள்ளன.எனில் 100g பழங்களில் இருந்து எவ்வளவு வறல்பழங்கள் பெறலாம்?","Fresh fruit contains 68% water and dry fruit contains 20% water. how much dry fruit can be obtained from 100kg of fresh fruits?","32kg","40kg","52kg","80kg",2,"B & C", Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q56);
        Practice_Question q57=new Practice_Question("அரிசியின் விலை 2% குறைகிறது, குறைவதற்கு முன் 49kg அரிசிக்கு தேவையான பணத்திற்கு இப்போது எவ்வளவு kg அரிசி வாங்கலாம்?","The price of raice is reduced by 2% . How many kilograms of rice can now be bought for the money which was sufficient to buy 49 kg of rice earlier?","48kg","49kg","50kg","51kg",3,"C & A", Practice_Question.CATEGORY_PERCENTAGE);
        addQuestion(q57);


        Practice_Question q58=new Practice_Question("33 மீட்டர் துணியை விற்கும்போது ஒருவர் 11 மீட்டர் துணி விற்பதற்கான லாபம் பெறுகிறார் எனில் லாப%?","By selling 33 metres of cloth, one gains the selling price of 11 metres find the gain percent?","20%","89%","50%","9.3%",3,"A & C", Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q58);
        Practice_Question q59=new Practice_Question("ஒருவர் குதிரை மற்றும் வண்டியை 3000rsக்கு வாங்குகிறார், குதிரையை 20% லபத்திற்கும், வண்டியை 10% நட்டத்திற்கும் விற்கிறார், மொத்தமாக 2% லாபம் கிடைக்கிறது.குதிரையின் வாங்கிய விலை?","A man bought a horse and a carriage for Rs. 3000. He sold the horse at a gain of 20% and the carriage at a loss of 10 %, there by gaining 2% on the whole. Find the cost of the horse?","Rs.1500","Rs.1236","Rs.1200","Rs.1300",3,"C & B", Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q59);
        Practice_Question q60=new Practice_Question("வாங்கிய விலை மற்றும் விற்ற விலைக்கு இடையேயான விகிதம் 4:5,எனில் அதன் லாப சதவீதம்?","The ratio of the cost price and the selling price is 4:5 the profit percent is:","10%","20%","25%","30%",3,"A & C", Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q60);
        Practice_Question q61=new Practice_Question("ஒரு புத்தகத்தை Rs.832க்கு விற்றால் கிடைக்கும் லாபம் அந்த புத்தகத்தை Rs.448 க்கு விற்றால் கிடைக்கும் நட்டத்திற்கு சமம், எனில் 50% லாபம் பெறுவதற்கான விற்பனை விலை என்ன?\n","The profit earned by selling an article for Rs.832 is equal to the loss incurred when the same article is sold for Rs.448 what should be the sale price for making 50% profit?","Rs.600","Rs.750","Rs.800","Noe of these",2,"B & C", Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q61);
        Practice_Question q62=new Practice_Question("ஒருவர் 18 கட்டில்களை Rs.16,800 க்கு விற்கிறார், அதில் அவர் 3 கட்டில்கள் விற்பதற்கான லாபம் அடைகிறார்,எனில் ஒரு கட்டிலின் விலை?","A man sold 18 cots for Rs.16,800,gaining thereby the cost price of 3 cost. the cost price of a cot is?","Rs.630","Rs.700","Rs.750","Rs.800",4,"D & A", Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q62);
        Practice_Question q63=new Practice_Question("ஒருவன் 2 டஜன் வாழைப்பழத்தை, டஜன் Rs.16க்கு வாங்கி, 18 வாழைப்பழங்களை டஜன் 4Rs குறைத்து 12Rs என்ற விலைக்கு விற்றால்,அவர் அடையும் நட்ட சதவீதம்?","A man buys 2 dozen bananas at Rs16 per dozen, after selling 18 bananas at the rate of Rs.12 per dozen, the shopkeeper reduced the rate to Rs.4 per Dozen. the Percent loss is?","25.2%","32.4%","36.5%","37.5%",4,"B & D", Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q63);
        Practice_Question q64=new Practice_Question("ஒருவன் 16 பழங்களை 24Rs க்கு வாங்குகிறான், அதை 8 பழங்கள் 18Rs க்கு விற்கிறான்,எனில் லாப சதவீதம் என்ன ?","A man bought some fruits at the rate of 16 for Rs 24 and sold them at the rate of 8 for Rs.18,What is the profit percent?","25%","50%","40%","60%",2,"D & B", Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q64);
        Practice_Question q65=new Practice_Question("ஒரு கடைக்காரர் 10% லாபத்தை தனது சரக்குகளில் பெறுகிறார் . 20% சரக்குகளை ஒரு திருட்டில் இழக்கிறார், அவர் அடைந்த நட்ட சதவீதம் என்ன ?","A fair price shopkeeper takes 10% profit on his goods. He lost 20% goods during theft.His loss percent is?","8","10","11","12",4,"A & D", Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q65);
        Practice_Question q66=new Practice_Question("A என்பவர் ஒரு புத்தகத்தை 10% அதன் மதிப்பு குறைவாக வாங்குகிறார்.மீண்டும் அதை  10% அதிகமா விற்கிறார்.எனில்  அவரின் லாப அல்லது நட்ட சதவீதம்?","A man buys an article for 10% less than its value and sells it for 10% more than its value.His gain or loss percent is?","no profit,no loss","20% profit","less than 20% profit","more than 20% profit",4,"A & D", Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q66);
        Practice_Question q67=new Practice_Question("ஒரு புத்தகத்தை 340Rs க்கு விற்பதற்கு பதிலாக 350Rs க்கு விற்றால் 5% லாபம் கிடைக்கிறது, எனில் அந்த புத்தகத்தின் அடக்க விலை என்ன ?","If 5% more is gained by selling an article for Rs.350 than by selling it for Rs.340, the cost of the article is?","Rs.50","Rs.160","Rs.200","Rs.225",4,"C & D", Practice_Question.CATEGORY_PROFITLOSS);
        addQuestion(q67);



        Practice_Question q68=new Practice_Question("A ஒரு  வேலையை 10 நாட்களில் முடிக்கிறார், B அதே வேலையை 15 நாட்களில் முடிக்கிறார். இருவரும் சேர்ந்து அந்த வேலையை முடிக்க ஆகும் நாட்கள் ?","A does a work in 10 days and B does the same work in 15 days.In how many days they together will do the same work?","5 days","6 days","8 days","9 days",2,"B & C", Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q68);
        Practice_Question q69=new Practice_Question("A ஒரு  வேலையை 15 நாட்களில் முடிக்கிறார், அவரின் தந்தை அந்த வேலையை முடிக்க 20 நாட்கள் எடுக்கிறார் மற்றும் அவரது மகன் 25 நாட்கள் எடுக்கிறார். அவர்கள் அனைவரும் சேர்ந்து வேலை செய்தால் எவ்வளவு நேரம் எடுத்துக்கொள்வார்கள் ?","A man can do a job in 15 days, his father takes 20 days and his son finishes it in 25 days. how long will they take to complete the job if they all work together?","less than 6 days","exactly 6 days","approximately 6.4 days","more than 10 days",3,"A & C", Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q69);
        Practice_Question q70=new Practice_Question("A மற்றும் B சேர்ந்து ஒரு வேலையை 8நாட்களில் முடிக்கின்றனர்,B மற்றும் C சேர்ந்து அதே வேலையை 12 நாட்களில் முடிகின்றனர், B மற்றும் C சேர்ந்து வேலையை 6 நாட்களில் முடிக்கின்றனர்,எனில் A மற்றும் C சேர்ந்து அந்த வேலையை முடிக்க எடுக்கும் நாள் ?","A and B can do a work in 8 days, B and C can do the same work in 12 days, A,B and C together can finish it in 6 days, A and C together will do it in?","4 days","6 days","8 days","12 days",3,"C & B", Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q70);
        Practice_Question q71=new Practice_Question("A ஒரு வேலையை முடிக்க எடுத்து கொள்ளும் நேரம், B மற்றும் C சேர்ந்து முடிக்க எடுத்து கொள்ளும் நேரத்திற்கு சமம். A  மற்றும் B சேர்ந்து 10 நாட்களில் அந்த வேலையை முடிக்கின்றனர்.C முடிக்க 50நாட்கள் ஆகிறது,எனில் B அந்த வேலையை முடிக்க எடுக்கும் காலம் ?","A can do a certain work in the same time in which B and C together can do it .If A and b together could do it in 10days and C alone in 50 days, then B alone could do it in?","15 days","20days","25 days","30 days",3,"C & A", Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q71);
        Practice_Question q72=new Practice_Question("A ஒரு வேலையை முடிக்க 15நாட்கள் ,B  20நாட்கள் எடுக்கின்றனர், இருவரும் சேர்ந்து 4 நாட்கள் வேலை செய்கின்றனர்,எனில் மீதமுள்ள வேலை எவ்வளவு ?","A can do a work in 15 days and B in 20 days. If they work on it together for 4 days, then the fraction of the work that is left is?.","1/4","1/10","7/15","8/15",4,"D & C", Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q72);
        Practice_Question q73=new Practice_Question("A மற்றும் B ஒரு வேலையை முடிக்க 45,40 நாட்கள் எடுக்கின்றனர்.இருவரும் சேர்ந்து அந்த வேலையை செய்கின்றனர் அப்போது A அதில் இருந்து விலகுகிறார், B மட்டும் அந்த வேலையை முடிக்க 23நாட்கள் ஆகிறது.எனில் A வேலையை விட்டு சென்ற நாட்கள் ?","A and B can do a piece of work in 45 days and 40 days . They began to do the work together but A leaves after some days and then B completed the remaining work in 23 days . the number of days after Which A left the Work was?","6","8","9","12",3,"C & B", Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q73);
        Practice_Question q74=new Practice_Question("A மற்றும் B சேர்ந்து ஒரு வேலையை 12 நாட்களில் முடிகின்றனர். A மட்டும் அந்த வேலையை முடிக்க 20 நாட்கள் ஆகிறது.B அந்த வேலையை ஒருநாளில் பாதி மட்டும் வேலை செய்து முடிக்கிறார்,எனில் A மற்றும் B சேர்ந்து அந்த வேலையை முடிக்க எடுக்கும் நாள் ?","A and B together can complete a work in 12 days. A alone can complete it in 20 days. If B does the work only for half a day daily, then in how many days A and B together Will complete the work?","10 days","11 days","15 days","20 days",3,"D & C", Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q74);
        Practice_Question q75=new Practice_Question("12 ஆட்கள் ஒருவேலையை 9நாட்களில் முடிக்கின்றனர், 6 நாட்கள் அவர்கள் அந்த வேலையை தெடர்ந்து பின் மேலும் 6நபர்கள் சேர்கின்றனர்,எனில் மீதமுள்ள வேலையை முடிக்க ஆகும் நாள் ?","12 man can complete a work in 9 days. After they have worked for 6 days,6 more men join them.How many days will take to complete the remaining work?","2 days","3 days","4 days","5days",1,"A & D", Practice_Question.CATEGORY_TIMEWORK);
        addQuestion(q75);


        Practice_Question q76=new Practice_Question("ஒருவர் கிராமத்தில் இருந்து அஞ்சலகத்திற்கு 25kmph வேகத்திலும் மீண்டும் திரும்பி 4kmph வேகத்தில் வருகிறார்,மொத்த பயணம் 5hour 48min எடுக்கிறது எனில், அஞ்சலகத்திற்கும், கிராமத்திற்கும் இடையேயான தூரம் ?","A man travelled from the village to the post-office at the rate of 25kmph and walked back at the rate of 4kmph. If the whole journey took 5 hours 48 minutes find the distance of the post-office from the village?","20km","29km","32km","45km",1,"A & C", Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q76);
        Practice_Question q77=new Practice_Question("ஒரு அதிவேக ரயில் சராசரியாக 100km/hr வேகத்தில் செல்கிறது,ஒவ்வொரு 75km  க்கும்  3நிமிடங்கள் நிற்கிறது,எனில் 600km தூரத்தை அடைய எடுத்துக்கொள்ளும் நேரம்?","The express train travelled at an average speeed of 100km/hr, stopping for 3 minutes after every 75km.how long did it take to reach its destination 600km from the starting point?","6hr 21mins","6hr 24 mins","6hr 27 mins","6hr 30 min",1,"C & A", Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q77);
        Practice_Question q78=new Practice_Question("ஒரு ரயில் 10km  தொலைவை 12mins ல் கடக்கிறது, அதன் வேகம் 5km/hr குறைகிறது,அதே தொலைவை கடக்க எடுக்கும் நேரம் ?","A train covers a distance of 10 km in 12 minutes.If its speed is decreased by 5km/hr,the time taken by it to cover the same distance will be?","10 min","11min 20sec","13min","13min 20sec",4,"C & D", Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q78);
        Practice_Question q79=new Practice_Question("ஒருவர் சமமான தொலைவை 3km/hr, 4km/hr, 5km/hr வேகத்தில் 47minல்  கடக்கின்றார்,எனில் கடந்த மொத்த தொலைவு ?","A person travels equals distance with speed of 3 km/hr, 4 km/hr and 5 km/hr and take a total time of 47 minutes. the total distance is(in km)?","2","3","4","5",2,"D & B", Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q79);
        Practice_Question q80=new Practice_Question("A என்பர் Bஐ விட வேகமானவர்,A மற்றும் B ஒவ்வொருவரும் 24km நடக்கின்றனர். அவர்களின் வேகங்களின் கூடுதல் 7km/hr மற்றும் அவர்கள் எடுத்துக்கொண்ட நேரம் 14 மணிநேரம், எனில் Aன் வேகம் ?","A is faster than B. A and B each walk 24km. The sum of their speed is 7 km/hr and the sum of times taken by them is 14 hours.then A's speed is equals to?","3 km/hr","4 km/hr","5 km/hr","7 km/hr",2,"C & B", Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q80);
        Practice_Question q81=new Practice_Question("ஒரு பையன் தனது வீட்டில் இருந்து பள்ளிக்கு 3km/hr செல்கிறான், திரும்பி வரும்போது 2km/hr வேகத்தில் வருகிறான், அவன் போய் வருவதற்கு 5மணிநேரம் ஆகிறது எனில் வீட்டிற்கும் ,பள்ளிக்கும் இடைப்பட்ட தொலைவு? ","A boy goes to his school form his house at a speed of 3 km/hr and returns at a speed of 2 km/hr.If he takes 5 hours in going and coming, the distance between his house and school is?","5km","5.5km","6km","6.5km",3,"A & C", Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q81);
        Practice_Question q82=new Practice_Question("நிறுத்தங்களை சேர்க்காமல் ஒரு பேருந்தின் வேகம் 54kmph, நிறுத்தங்களை சேர்த்தால் 45kmph,எனில் ஒருமணி நேரத்திற்கு பேருந்து எவ்வளவு நேரம் நிற்கும் ?","Excluding stoppages, the speed of a bus is 54 kmph and including stoppages, it is 45kmph. for how many minutes does the bus stop per hour?","9","10","12","20",2,"B & D", Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q82);
        Practice_Question q83=new Practice_Question("ஒருவர் 10km/hr வேகத்திற்கு பதிலாக 14km/hr வேகத்தில் நடந்தால் 20km அதிகமாக நடந்து விடுகிறார், அவர் சரியாக கடக்க வேண்டிய தொலைவு?","If a person walks at 14 km/hr instead of 10 km/hr, he would have walked 20 km more.the actual distance travelled by him is?","50 km","56 km","70 km ","80 km",1,"A & D", Practice_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q83);


        Practice_Question q84=new Practice_Question("Rs450 எப்போது வட்டி 81Rs ஐ 4.5% ஆண்டுவட்டியில் தரும் ?","How much time will it take for an amount of Rs.450 to Yield Rs.81 as interest at 4.5% per annum of simple interest?","3.5 years","4 years","4.5 year","5 years",2,"A & B", Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q84);
        Practice_Question q85=new Practice_Question("132Rs ன் தற்போதைய மதிப்பு 2 ஆண்டுகள், 5% வட்டி விகிதத்தில்,தனிவட்டி முறையில்  காண்க ?","What is the present worth of Rs.132 due in 2 years at 5% simple interest per annum?","Rs.12","Rs.118.80","Rs.120","Rs.122",3,"C & D", Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q85);
        Practice_Question q86=new Practice_Question("ஒரு குறிப்பிட்ட  தொகை ஒரே வட்டிவிகிதத்தில் 6 மற்றும் 9 வருடங்கள் இருந்தால்,அதன் தனிவட்டி விகிதம் என்ன ?","What will be the ratio of simple interest earned by certain amount at the same rate of interest for 6 years and ther for 9 years?","1:3","1:4","2:3","None of these",3,"d & C", Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q86);
        Practice_Question q87=new Practice_Question("5 வருடங்களில் தனிவட்டி கூடுதல் Rs.9800,அதுவே 4 வருடங்களில் Rs.12005 எனில் அதன் வட்டி விகிதம் காண்க ?","A sum of money amount to Rs.9800 after 5 years and Rs.12005 after 8 years at the same rate of simple interest. the rate of interest per annum is?","12%","8%","5%","15%",1,"D & A", Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q87);
        Practice_Question q88=new Practice_Question("ஒருவன் வங்கியில் ஆண்டுக்கு 12% தனிவட்டி முறையில் கடன் பெறுகிறார், 3வருடங்களுக்கு அந்த காலத்திற்கு  பிறகு அவர் வட்டியாக Rs.5400 செலுத்தவேண்டும்,எனில் அவர் பெற்ற கடன்தொகை என்ன ?","A Man took a loan from a bank at the rate of 12% p.a simple interest.After 3years he had to pay Rs.5400 interest only for the the period.The principal amount brrowed by him was?","Rs.2000","Rs.10,000","Rs.15,000","Rs.20,000",3,"A & c", Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q88);
        Practice_Question q89=new Practice_Question("Rs.800 3ஆண்டுகளில் குறிப்பிட்ட தனிவட்டி விகிதத்தில் Rs.956ஆக மாறுகிறது, எனில் தனிவட்டி விகிதம் 4% ஆக உயர்கிறது என்றால், Rs.800 3ஆண்டுகளில் என்னவாக இருக்கும்?","Rs.800 becomes Rs.956 in 3years at a certain rate of simple interest. If the rate of interest is increased by 4%, What amount will Rs.800 become in 3 years?","Rs.1020.80","Rs.1025","Rs.1052","Data inadeuate",3,"C & D", Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q89);
        Practice_Question q90=new Practice_Question("ஒரே வட்டிவிகிதத்தில் ஒரு குறிப்பிட்ட தொகை 3 மற்றும் 6 வருடங்களில் தரும் வட்டியின் விகிதம் கண்டறி ?","What will be the ratio of simple interest earned by certain amount at the same rate of interest for 3years and that for 6years?","1:2","1:4","2:3","None of these",1,"B & A", Practice_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q90);




















    }
    private void addQuestion(Practice_Question practice_question){
        ContentValues cv=new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION_TAMIL,practice_question.getQuestion_tamil());
        cv.put(QuestionsTable.COLUMN_QUESTION_ENGLISH,practice_question.getQuestion_english());
        cv.put(QuestionsTable.COLUMN_OPTION1,practice_question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2,practice_question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3,practice_question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4,practice_question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR,practice_question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_HINT,practice_question.getHint());
        cv.put(QuestionsTable.COLUMN_CATEGORY,practice_question.getCategory());
        db.insert(QuestionsTable.TABLE_NAME,null,cv);
    }

//    public List<Practice_Question> getAllQuestions(){
//        List<Practice_Question> questionsList=new ArrayList<>();
//        db=getReadableDatabase();
//        Cursor c= db.rawQuery("SELECT * FROM "+ QuestionsTable.TABLE_NAME,null);
//
//        if(c.moveToFirst()){
//            do {
//                Practice_Question practice_question=new Practice_Question();
//                practice_question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION_TAMIL)));
//                practice_question.setQuestion_english(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION_ENGLISH)));
//                practice_question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
//                practice_question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
//                practice_question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
//                practice_question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
//                practice_question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
//                practice_question.setHint(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
//                questionsList.add(practice_question);
//
//            }
//            while (c.moveToNext());
//
//        }
//        c.close();
//        return questionsList;
//    }
public List<Practice_Question> getAllQuestions(String category){
    List<Practice_Question> questionsList=new ArrayList<>();
    db=getReadableDatabase();

    String[] selectionArgs= new String[]{category};
    Cursor c= db.rawQuery("SELECT * FROM "+ QuestionsTable.TABLE_NAME+" WHERE "+QuestionsTable.COLUMN_CATEGORY + "= ?",selectionArgs);

    if(c.moveToFirst()){
        do {
            Practice_Question practice_question=new Practice_Question();
            practice_question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION_TAMIL)));
            practice_question.setQuestion_english(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION_ENGLISH)));
            practice_question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
            practice_question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
            practice_question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
            practice_question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
            practice_question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
            practice_question.setHint(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_HINT)));
            practice_question.setCategory(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY)));
            questionsList.add(practice_question);

        }
        while (c.moveToNext());

    }
    c.close();
    return questionsList;
}
}

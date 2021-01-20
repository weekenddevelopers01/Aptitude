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
    private static final int DATABASE_VERSION=2;

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
        addNumbers();
        addLcmHcf();
        addDecimal();
        addSimlification();
        addAverage();
        addPercentage();
        addProfitLoss();
        addTimeAndWork();
        addTimeAndDistance();
        addSI();
        addArea();
        addVolumes();
        addCI();
        addRatio();
        addAges();
        addPipe();
        addTrain();
        addBoat();
        addMix();
        addCalender();
        addHeightDistance();
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

    private void addHeightDistance(){
        Test_Question q1=new Test_Question("ஒரு கம்பத்தின் உயரம் 2√3 m எனில் மற்றும் அதன் நிழல் 2m தள்ளி விழுகிறது எனில் சூரிய ஒளி வீசும் கோணம் காண்க. ","If the height of a pole is 2√3 metres and the length of its shadow is 2 metres, find the angle of elevation of the sun.","45°","35°","60°","90°",3, Test_Question.CATEGORY_HEIGHTANDDISTANCE);
        addQuestion(q1);
        Test_Question q2=new Test_Question("ஒரு ஏணி சுவரின் மீது 60° கோணத்தில் சாய்த்து வைக்கப்பட்டுள்ளது. ஏணியின் நீளம் 19m எனில் சுவருக்கும் ஏணிக்கும் இடைப்பட்ட தொலைவு கண்டறி ","A ladder leaning against a wall makes an angle of 60° with the ground. If the length of the ladder is 19 m, find the distance of the foot of the ladder from the wall.","19 m","9.5 m","10 m","20 m",2, Test_Question.CATEGORY_HEIGHTANDDISTANCE);
        addQuestion(q2);
        Test_Question q3=new Test_Question("பெண் ஒருவர் ஒரு கோபுரத்தில் இருந்து 37.5m தொலைவில் நிற்கிறார், தரையில் இருந்து அவரின் பார்வை 2.5m உயரத்தில் உள்ளது, அவர் கோபுரத்தை 45 டிகிரி கோணத்தில் பார்க்கிறார் எனில் கோபுரத்தின் உயரம் என்ன? ","A girl is 37.5m away from a tower. Her eye level above the ground is 2.5m. The angle of elevation of the tower from her eyes is 45 degree. What is the height of the tower?","35 m","2.5 m","37.5 m","40 m",4, Test_Question.CATEGORY_HEIGHTANDDISTANCE);
        addQuestion(q3);
        Test_Question q4=new Test_Question("சூரிய ஒளியானது ஒரு மரத்தின் மீது விழுந்து அதன் நிழல் கீழே விழுகிறது. மரத்தின் நிழலின் நீளமானது, மரத்தின் உயரம் போல் √3 மடங்காகும். எனில் ஒளி வீசும் கோணம் என்ன ?","The angle of elevation of the sun, when the length of the shadow of a tree is √3 times the height of the tree is?","30°","45°","60°","90°",1, Test_Question.CATEGORY_HEIGHTANDDISTANCE);
        addQuestion(q4);
        Test_Question q5=new Test_Question("தரையில் p என்ற புள்ளியில் இருந்து 30° கோணத்தில் ஒரு கோபுரத்தின் உச்சியை காணமுடிகிறது, கோபுரத்தின் உயரம் 100m எனில், p என்ற புள்ளிக்கும் கோபுரத்திற்கும் இடைப்பட்ட தூரம் காண்க. ","From a point P on a level ground, the angle of elevation of the top of a tower is 30° if the tower is 100m high, the distance of point  P from the foot fo the tower is?","146 m","156 m","173 m","200 m",3, Test_Question.CATEGORY_HEIGHTANDDISTANCE);
        addQuestion(q5);
    }

    private void addCalender(){
        Test_Question q1=new Test_Question("ஒரு வேலையாள் அவரது வேலையை திங்கள் அன்று தொடங்குகிறார் 8 நாட்கள் வேலைசெய்து 9வது நாள் விடுப்பு எடுக்கிறார் எனில் அவரது 12வது விடுப்பு எந்த கிழமை வரும் ?","A workman starts his work on Monday. Work for 8 days and takes every 9 th day as his holiday. His 12 th holiday will fall on:","Monday","Wednesday","Friday","Sunday",2, Test_Question.CATEGORY_CALENDER);
        addQuestion(q1);
        Test_Question q2=new Test_Question("ஒரு பெண்ணின் 18வது பிறந்தநாள் Feb 28 (சனிக்கிழமை) வருகிறது எனில் அவரின் 25வது பிறந்தநாள் எந்த கிழமை வரும்? ","The 18th birthday of a girl is on 28th Feb. 2009(Saturday). On what day of the week will be her 25th birthday?","Sunday","Monday","Tuesday","Wednesday",1, Test_Question.CATEGORY_CALENDER);
        addQuestion(q2);
        Test_Question q3=new Test_Question("ஜூலை-16 1776ம் ஆண்டு கிழமை என்ன ?","What was the day of the week on, 16th July, 1776?","Friday","Wednesday","Monday","Tuesday",4, Test_Question.CATEGORY_CALENDER);
        addQuestion(q3);
        Test_Question q4=new Test_Question("ஆகஸ்ட்-15 1947ம் ஆண்டு கிழமை என்ன ?","What was the day of the week on, 16th August, 1776?","Wednesday","Tuesday","Friday","Monday",3, Test_Question.CATEGORY_CALENDER);
        addQuestion(q4);
        Test_Question q5=new Test_Question("மே-1 1997ம் ஆண்டு கிழமை என்ன ? ","What was the day of the week on, 1st May, 1997?","Wednesday","Tuesday","Friday","Thursday",4, Test_Question.CATEGORY_CALENDER);
        addQuestion(q5);
        Test_Question q6=new Test_Question("Dec 11 1997ம் ஆண்டு கிழமை என்ன ?","What was the day of the week on, 11th December, 1997?","Wednesday","Tuesday","Friday","Thursday",4, Test_Question.CATEGORY_CALENDER);
        addQuestion(q6);
    }

    private void addMix(){

        Test_Question q1=new Test_Question("ஒரு கிலோ Rs. 9.30 விலையுள்ள அரிசி ஒரு கிலோ Rs. 10.80 விலையுள்ள அரிசியுடன் கலந்து அந்த கலவை கிலோ Rs. 10 க்கு விற்க வேண்டும் என்றால் எந்த விகிதத்தில் அவைகள் கலக்க படவேண்டும். ","In what ratio must rice at Rs. 9.30 per kg be mixed with rice at Rs. 10.80 per kg so that the mixture be worth Rs. 10 per kg ?","8:7","7:8","4:3","3:4",1, Test_Question.CATEGORY_MIXTURE);
        addQuestion(q1);
        Test_Question q2=new Test_Question("கிலோ Rs 126 மற்றும் Rs 135 விலைகொண்ட இரு டீக்கள் கலவை மூன்றாம் வகை டீயுடன் 1 : 1 : 2 என்ற விகிதலில் கலந்து அந்த கலவை கிலோ Rs. 153 விற்கப்படுகிறது எனில் மூன்றாம் வகை டீயின் விலை என்ன ?","Tea worth Rs. 126 per kg and Rs. 135 per kg are mixed with a third variety in the ratio 1 : 1 : 2. If the mixture is worth Rs. 153 per kg, the price of the third variety per kg will be:","179 Rs","175.5 Rs","123 Rs","250 Rs",2, Test_Question.CATEGORY_MIXTURE);
        addQuestion(q2);
        Test_Question q3=new Test_Question("பாலுடன் நீர் சேர்த்து, பாலின் விற்பனை விலைக்கே 20% லாபத்தில் விற்கவேண்டும் என்றால் எந்த விகிதத்தில் கலக்கப்பட்ட வேண்டும்? ","In what ratio must water be mixed with milk to gain 20 % by selling the mixture at cost price?","1:5","5:6","1/6 : 5/6","1:1/5",3, Test_Question.CATEGORY_MIXTURE);
        addQuestion(q3);
        Test_Question q4=new Test_Question("Rs 15 மற்றும் Rs 20 விலையுள்ள இரு பருப்பு வகைகளை ஒரு மளிகை கடைக்காரர் கலந்து Rs 16.5 க்கு விற்க வேண்டும் எனில் இரு பருப்புகளும் கலக்கப்படவேண்டிய விகிதம் ?","In what ratio must a grocer mix two varieties of pulses costing Rs 15 and Rs 20 per kg respectively so as to get a mixture worth Rs.16.5 per kg?","3:7","5:7","7:3","7:5",3, Test_Question.CATEGORY_MIXTURE);
        addQuestion(q4);
        Test_Question q5=new Test_Question("கிலோ Rs 7.20 மற்றும் Rs 5.70 விலை கொண்ட இரு அரிசிகள் கலந்து கிலோ Rs 6.30 க்கு விற்க வேண்டுமானால் எந்த விகிதத்தில் கலக்கப்பட வேண்டும். ","Find the ratio in which rice at Rs 7.20 a kg be mixed with rice at Rs 5.70 a kg to produce a mixture worth Rs 6.30 a kg.","1:3","2:3","3:4","4:5",2, Test_Question.CATEGORY_MIXTURE);
        addQuestion(q5);
        Test_Question q6=new Test_Question("ஒரு வகை அரிசி கிலோ Rs 15 மற்றும் இரண்டாம் வகை அரிசி Rs 20 இவை இரண்டும் 2:3 என்ற விகிதத்தில் கலக்கப்படுகிறது எனில் புதிய கலவையின் விலை என்ன ?","The cost of Type 1 rice is Rs 15 per kg and Type 2 rice is Rs 20 per kg. If both Type1 and Type2  are mixed in the ratio of 2:3, then the price per kg of the mixed variety of rice is:","Rs 18","RS 18.50","Rs 19","Rs 19.50",1, Test_Question.CATEGORY_MIXTURE);
        addQuestion(q6);
        Test_Question q7=new Test_Question("Rs 60 மற்றும் Rs 65 விலையுள்ள இரு டீ  வகைகளை ஒரு மளிகை கடைக்காரர் கலந்து Rs 68.20 விற்கும் போது அவருக்கு 10% லாபம் கிடைக்கிறது எனில், எந்த விகிதத்தில் கலக்கப்பட வேண்டும். ","In what ratio must a grocer mix two varieties of tea worth Rs 60 a kg and Rs 65 a kg so that by selling the mixture at Rs 68.20 a kg he may gain 10%?","3:2","3:4","3:5","4:5",1, Test_Question.CATEGORY_MIXTURE);
        addQuestion(q7);
        Test_Question q8=new Test_Question("பால் மற்றும் தண்ணீரை கலந்து அந்த கலவையை விற்பதன் மூலம் அதன் அடக்க விலையில் 50/3 % லாபம் கிடைக்கிறது எனில் அவை எந்த விகிதத்தில் கலக்கப்பட்ட வேண்டும். ","In what ratio must water be mixed with milk to gain 50/3 % on selling the mixture at cost price ?","1:6","6:1","2:3","4:3",1, Test_Question.CATEGORY_MIXTURE);
        addQuestion(q8);
    }

    private void addBoat(){
        Test_Question q1=new Test_Question("ஒரு நபர் 7kmph எதிர்நிலை நிரோட்டத்திலும், 10kmph வேகத்தில் நேர்நிலை நீரோட்டத்திலும் செல்கிறார் எனில், நீரில் அவரின் வேகம் மற்றும் நீரோட்டத்தின் வேகம் காண்க. ","A man can row upstream at 7 kmph and downstream at 10kmph.find man’s rate in still water and the rate of current.","7.5km/hr, 1.5km/hr","8.5km/hr, 1.5km/hr","7.5km/hr, 2.5km/hr","7km/hr, 3km/hr",2, Test_Question.CATEGORY_BOAT);
        addQuestion(q1);
        Test_Question q2=new Test_Question("ஒரு நபர் 15km நேர்நிலை  நீரோட்டத்தை 3மணிநேரம் 45நிமிடத்திலும், 5km எதிர்நிலை நீரோட்டத்தை 2மணிநேரம் 30நிமிடங்களில் கடக்கிறார் எனில் நீரோட்டத்தின் வேகம் என்ன ?","A man takes 3 hours 45 minutes to row a boat 15 km downstream of a river and 2hours30minutes to cover a distance of 5km upstream. find the speed of the river current in km/hr.","1.5km/hr","1.25 km/hr","1km/hr","2.5km/hr",3, Test_Question.CATEGORY_BOAT);
        addQuestion(q2);
        Test_Question q3=new Test_Question("சாலையின் அருகில் ஆறு உள்ளது.இரு நண்பர்கள் A என்ற இடத்தில் B என்ற இடத்தில் உள்ள கோவிலுக்கு சென்று திரும்புகின்றனர், அதில் ஒருவர் மிதிவண்டியில் 12km/hr வேகத்தில் செல்கிறார். மற்றொருவர் படகில் 10km/hr வேகத்தில் செல்கிறார், ஆற்றில் நீரின் வேகம் 4km/hr எனில் இருவரில் யார் முதலில் A என்ற இடத்தை திருப்பி வந்தடைவர்? ","There is a road beside a river.two friends started from a place A,moved to a temple situated at another place B and then returned to A again.one of them moves on a cycle at a speed of 12 km/hr,while the other sails on a boat at a speed of 10 km/hr.if the river flows at the speed of 4 km/hr,which of the two friends will return to placeA first?","none of this","both will reach same","Boat will reach first","Cycle will reach first",4, Test_Question.CATEGORY_BOAT);
        addQuestion(q3);
        Test_Question q4=new Test_Question("ஒரு நபர் 7 ½ kmph வேகத்தில் நீரில் செல்கிறார், ஆற்றில் நீரின் வேகம் 1.5 km/hr எனில் அவர் 50நிமிடத்தில் ஒரு இடத்திற்கு சென்று வருகிறார். எனில் அந்த இடம் உள்ள தொலைவு என்ன? ","A man can row 7 ½ kmph in still water.if in a river running at 1.5 km/hr anhour,it takes him 50 minutes to row to a place and back,how far off is the place?","3km/hr","3.5km/hr","2km/hr","5km/hr",1, Test_Question.CATEGORY_BOAT);
        addQuestion(q4);
        Test_Question q5=new Test_Question("நீரோடையின் வேகம் 2kmph, ஒரு இயந்திர படகு எதிர் நிலை நீரோட்டத்தில் 6km சென்று மீண்டும் ஆரம்ப இடத்திற்கு வருகிறது எனில் இயந்திர படகின் வேகம் என்ன ","In a stream running at 2kmph,a motar boat goes 6km upstream and back again to the starting point in 33 minutes.find the speed of the motarboat in still water.","11 km/hr","22 km/hr","11/2 km/hr","12 km/hr",2, Test_Question.CATEGORY_BOAT);
        addQuestion(q5);
        Test_Question q6=new Test_Question("ஒரு மனிதர் 5 km/h வேகத்தில் நீரில் செல்கிறார். ஆற்றின் வேகம் 1km/hr, அவர் குறிப்பிட்ட இடத்தை சென்று மீண்டும் வந்தடைய 75 நிமிடம் ஆகிறது எனில், அந்த இடத்தின் தொலைவு என்ன? ","A man can row 5 km/h in still water. If the river running at 1 km/hr, it takes him 75 minutes to row to a place and back. how far is the place?","2.5 km","3 km","4 km","5 km",2, Test_Question.CATEGORY_BOAT);
        addQuestion(q6);
        Test_Question q7=new Test_Question("ஒரு மனிதன் 3km/hr வேகத்தில் நீந்துகிறார். நீரின் வேகம் 2km/hr எனில் 10km எதிர் நீரோட்டத்தில் அவர் ஒரு இடத்தை சென்று வந்தடைய ஆகும் நேரம்? ","A man can swim 3 km/h in still water. if the velocity of the steam is 2 km/hr, the time taken by him to swim to a place 10 km upstream and back is ?","8.5 hrs","9.2 hrs","10 hrs","12 hrs",4, Test_Question.CATEGORY_BOAT);
        addQuestion(q7);
    }

    private void addTrain(){
        Test_Question q1=new Test_Question("250  மீட்டர் நீளமுள்ள ஒரு ரயில் 60km/hr வேகத்தில் செல்லும்போது 350 மீட்டர் நீளமுள்ள எதிர் திசையில் வரும் ரயிலை 16 நொடிகளில் கடக்கிறது எனில் மொற்றொரு ரயிலின் வேகம் என்ன ?","A train 250 metres long running at a speed of 60 km/hr crosses a 350 metres long train coming in the opposite direction in 16 seconds. What is the speed of the other train?","37.5 km/hr","60 km/hr","72 km/hr","75 km/hr",4, Test_Question.CATEGORY_TRAINS);
        addQuestion(q1);
        Test_Question q2=new Test_Question("30 km/hr வேகத்தில் பயணிக்கும் 100மீட்டர் நீளமுள்ள ரயில், ஒரு மனிதனை கடக்க எடுக்கும் நேரம்? ","A train 100 m long is running at the speed of 30 km / hr. Find the time taken by it to pass a man standing near the railway line.","10 sec","24 sec","12 sec","1 min",3, Test_Question.CATEGORY_TRAINS);
        addQuestion(q2);
        Test_Question q3=new Test_Question("ஒரு ரயில் 132 km/hr வேகத்தில் செல்கிறது. 110m நீளமுள்ள ரயில் 165m நீளமுள்ள நடைபாதையை கடக்க எடுக்கும் நேரம் ?","A train is moving at a speed of 132 km/hr. If the length of the train is 110 metres, how long will it take to cross a railway platform 165 metres long?","7.5 sec","7 sec","8 sec","12 sec",4, Test_Question.CATEGORY_TRAINS);
        addQuestion(q3);
        Test_Question q4=new Test_Question("68kmph வேகத்தில் செல்லும் 150m உள்ள ரயில், 8kmph வேகத்தில் அதே திசையில் செல்லும் நபரை கடந்து செல்ல ஆகும் நேரம் ?","A train 150 m long is running with a speed of 68 kmph. In what time will it pass a man who is running at 8 kmph in the same direction in which the train is going?","15 sec","20 Sec","2 sec","9 sec",4, Test_Question.CATEGORY_TRAINS);
        addQuestion(q4);
        Test_Question q5=new Test_Question("137m மற்றும் 163 மீட்டர் நீளமுள்ள இரு ரயில்கள் ஒரே திசையில் 42kmph  மற்றும் 48kmph வேகத்தில் செய்கிறது, எனில் அவை இரண்டும் ஒன்றை ஒன்று சந்தித்த பிறகு எப்போது விலகி செல்லும். ","Two trains 137 metres and 163 metres in length are running towards each other on parallel lines, one at the rate of 42 kmph and another at 48 kmph. In what time will they be clear of each other from the moment they meet?","13 Sec","12 sec","11 sec","10 sec",2, Test_Question.CATEGORY_TRAINS);
        addQuestion(q5);
        Test_Question q6=new Test_Question("ஒரு நபர் 180m நீளமுள்ள ரயில் பாலத்தில் நிற்கிறார். அவர் ரயில் பலத்தை கடக்க 20 நொடிகளும், அவரை கடக்க 8 நொடிகளும் ஆகிறது என கண்டறிந்துள்ளார், எனில் ரயிலின் வேகம் மற்றும் நீளத்தை கண்டறி? ","A man is standing on a railway bridge which is 180 m long. He finds that a train crosses the bridge in 20 seconds but himself in 8 seconds. Find the length of the train and its speed?","54 km/hr","52 km/hr","40 km/hr","100 km/hr",2, Test_Question.CATEGORY_TRAINS);
        addQuestion(q6);
        Test_Question q7=new Test_Question("250  மீட்டர் நீளமுள்ள ஒரு ரயில் 72km/hr வேகத்தில் செல்கிறது. அந்த ரயில் 1 நிமிடத்தில் ஒரு சுரங்கத்தை கடக்கிறது எனில் அந்த சுரங்கத்தின் நீளம் என்ன ?","A train 700 metres long running at  72 km/hr. if it  crosses a tunnel in 1 minute the length of the tunnel is?","500 m","700 m","1200 m","1900 m",1, Test_Question.CATEGORY_TRAINS);
        addQuestion(q7);
        Test_Question q8=new Test_Question("இரு ரயில்கள் ஒரே நேரத்தில் சென்னை மற்றும் மங்களூரில் இருந்து 36kmph மற்றும் 42kmph வேகத்தில் புறப்படுகின்றன. அவை இரண்டும் ஒன்றை ஒன்று சந்திக்கும் போது, ஒரு ரயில் மட்டும் அதிகமாக பயணித்திருப்பது தெரிய வருகிறது எனில் இரு ரயில் நிலையத்திற்கும் இடைப்பட்ட தூரம் என்ன ?","Two trains start at the same time from station Chennai and Mangalore and proceed towards each other at 36kmph and 42kmph respectively. when they meet, it is found that one train has traveled 48km more than the other. the distance between the two Stations is?","624 km","363 km","544 km","460 km",1, Test_Question.CATEGORY_TRAINS);
        addQuestion(q8);
        Test_Question q9=new Test_Question("280மீட்டர் நீளமுள்ள ஒரு ரயில் 63 kmph வேகத்தில் செல்கிறது எனில் அது ஒரு மின்சார கம்பத்தை கடக்க ஆகும் நேரம் என்ன ?","A train 280m long, running with a speed of 63 kmph will pass an electric pole in ","160 sec","16 sec","18 sec","15 sec",2, Test_Question.CATEGORY_TRAINS);
        addQuestion(q9);
        Test_Question q10=new Test_Question("180m மற்றும் 220m நீளமுள்ள இரு ரயில்கள் எதிர் எதிர் திசையில் 40km/h மற்றும்  50km/h வேகத்தில் வருகின்றன எனில். இவை இரண்டும் ஒன்றை ஒன்று கடந்து செல்வதற்கு ஆகும் நேரம் என்ன? ","Two trains whose lengths are 180m and 220m respectively are running in directions opposite to one another with respective speeds of 40km/h and 50km/h. Time taken by in crossing one another will be","16 sec","17 sec","18 sec","22 sec",1, Test_Question.CATEGORY_TRAINS);
        addQuestion(q10);
        Test_Question q11=new Test_Question("100 மீட்டர் நீளமுள்ள ஒரு ரயில், ஒரு மின் கம்பத்தை 144km/hr வேகத்தில் கடந்து சென்றால் அது கடக்கும் நேரம் என்ன ?","In what time will a train 100 meter long cross an electric pole. if its speed be 144 km/hr?","2.5 sec","4.25 sec","5 sec","12.5sec",1, Test_Question.CATEGORY_TRAINS);
        addQuestion(q11);
        Test_Question q12=new Test_Question("280m நீளமுள்ள ஒரு ரயில் 63km/hr வேகத்தில் ஒரு மரத்தை கடக்கும் நேரம் ?","A train 280m long, running with a speed of 63km/hr will pass a tree in ?","15 sec","16 sec","18 sec","20 sec",2, Test_Question.CATEGORY_TRAINS);
        addQuestion(q12);
        Test_Question q13=new Test_Question("110 மீட்டர் நீளமுள்ள ரயில் 72km/hr வேகத்தில் சென்றால் 132மீட்டர் பலத்தை கடக்க ஆகும் நேரம் ?","How long does a train 110 meters long running at the speed of 72km/hr take to cross a bridge 132 meters in length?","9.8 sec","12.1 sec","12.42 sec","14.3 sec",2, Test_Question.CATEGORY_TRAINS);
        addQuestion(q13);
        Test_Question q14=new Test_Question("130மீட்டர் நீளமுள்ள ஒரு ரயில் 45km/hr  வேகத்தில் செல்லும் போது, 30 நொடிகளில் ஒரு பலத்தை கடக்கிறது எனில் பாலத்தின் நீளம் என்ன? ","The length of the bridge, which a train 130 meters long and travelling at 45km/hr can cross in 30 seconds, is?","200 m","225 m","245 m","250 m",3, Test_Question.CATEGORY_TRAINS);
        addQuestion(q14);
        Test_Question q15=new Test_Question("72kmph வேகத்தில் செல்லும் ஒரு சரக்கு ரயில், 250m  நீளமுள்ள ஒரு நடைபாதையை கடக்க 26 நொடிகள் ஆகிறது எனில் சரக்கு ரயிலின் நீளம் என்ன ?","A goods train runs at the speed of 72kmph and crosses a 250 m long platform in 26 second. what is the length of the goods train?","230 m","240 m","260 m","270 m",4, Test_Question.CATEGORY_TRAINS);
        addQuestion(q15);
    }

    private void addPipe(){
        Test_Question q1=new Test_Question("முதல் குழாய் ஒரு தொட்டியை 30 நிமிடங்களில் நிரப்பும். இரண்டாவது குழாய் அதே தொட்டியை நிரப்ப 60 நிமிடங்கள் ஆகும். மூன்றாவது குழாய் நிரப்பிய தொட்டியை காலி செய்ய 45 நிமிடம் ஆகும். தொட்டி காலியாக இருந்து இம்மூன்று குழாய்களும் ஒரே சமயத்தில் திறந்து விடப்பட்டால் , அத்தொட்டி எத்தனை நிமிடங்களில் நிரம்பும்? ","First pipe can fill a tank in 30 minutes. Second pipe can fill the same tank in 60 minutes. A third pipe can empty the same tank if it is full in 45 minutes. If the tank is empty and all three pipes are open in how many minutes will the tank fill?","30","36","42","50",2, Test_Question.CATEGORY_PIPE);
        addQuestion(q1);
        Test_Question q2=new Test_Question("ஒரு தண்ணீர் குழாய் காலியான தொட்டியை நிரப்ப 50நிமிடம் ஆகிறது.அதே சமயத்தில் மற்றொரு குழாய் தொட்டியை நிரப்ப 1 மணிநேரம் ஆகிறது எனில் இரண்டு குழாய் ஒருநேரத்தில் திறந்து விடப்பட்டால் அந்த தொட்டியை நிரப்ப எடுத்துக்கொள்ளும் குறைந்தபட்ச நேரம் என்ன ?","A water pipe can fill an empty tank in 50 minutes while another pipe can empty the filled tank in hours. How long minimum time will it take to fill the emptied tank when both pipes are opened simultaneously?","1 ½ hours","2 ¼  hours","2 ½  hours","3 hours",3, Test_Question.CATEGORY_PIPE);
        addQuestion(q2);
        Test_Question q3=new Test_Question("இரு குழாய்கள் A மற்றும் B முறையே 36, 45மணிநேரத்தில் ஒரு தொட்டியை நிரப்புகிறது. இரு குழாய்களும் திறக்கப்பட்டால் தொட்டியை நிரப்ப எடுத்துக்கொள்ளும் நேரம் என்ன ?","Two pipes A and B can fill a tank in 36 hours and 45hours respectively. If both the pipes are opened simultaneously, how much time will be taken to fill the tank?","16 Hrs","20 Hrs","21 Hrs","18 Hrs",2, Test_Question.CATEGORY_PIPE);
        addQuestion(q3);
        Test_Question q4=new Test_Question("இரு குழாய்கள் முறையே 10, 12 மணிநேரத்தில் ஒரு தொட்டியை நிரப்புகிறது. மற்றொரு குழாய் 20 மணிநேரத்தில் தொட்டியை காலிசெய்கிறது எனில் தொட்டியை நிரப்ப எடுக்கும் நேரம் ?","Two pipes can fill a tank in 10hours and 12 hours respectively while a third, pipe empties the full tank in 20 hours. If all the three pipes operate simultaneously, in how much time will the tank be filled?","5 Hrs","6 1/2 Hrs","7 Hrs","7 1/2 Hrs",4, Test_Question.CATEGORY_PIPE);
        addQuestion(q4);
        Test_Question q5=new Test_Question("இரு குழாய்கள் ஒரே நேரத்தில் இயங்குகிறது, ஒரு பாத்திரத்தை 12மணிநேரத்தில் நிரப்ப வேண்டும். ஒரு குழாய் மற்றொன்றை விட 10 மணிநேரம் வேகமாக பாத்திரத்தை நிரப்புகிறது எனில் இரண்டாம் குழாய் பாத்திரத்தை நிரப்ப எடுக்கும் நேரம்? ","If two pipes function simultaneously, the reservoir will be filled in 12 hours. One pipe fills the reservoir 10 hours faster than the other. How many hours does it take the second pipe to fill the reservoir?","30 Hrs","28 Hrs","32 Hrs","29 Hrs",1, Test_Question.CATEGORY_PIPE);
        addQuestion(q5);
        Test_Question q6=new Test_Question("ஒரு தொட்டியுடன் இணைக்கப்பட்ட இரு குழாய்கள் முறையே 12, 15 நிமிடங்களில் தொட்டியை நிரப்புகிறது. மேலும் இதனுடன் வெளியேற்றும் குழாயும் உள்ளன. அவை மூன்றும் ஒருசேர திறக்கப்பட்டால் 20 நிமிடங்களில் தொட்டி காலியாகிறது, எனில் வெளியேற்றும் குழாய் முழு தொட்டியை காலிசெய்ய எடுக்கும் நேரம்? ","A cistern has two taps which fill it in 12 minutes and 15minutes respectively. There is also a waste pipe in the cistern. When all the 3 are opened , the empty cistern is full in 20 minutes. How long will the waste pipe take to empty the full cistern?","12 mins","10 mins","11 mins","20 mins",2, Test_Question.CATEGORY_PIPE);
        addQuestion(q6);
        Test_Question q7=new Test_Question("ஒரு மின்சார குழாய் 3மணிநேரத்தில் ஒரு தொட்டியை நிரப்புகிறது. இதில் கசிவு உள்ளதால் அந்த தொட்டியை நிரப்ப 3 1/2 மணிநேரம் ஆகிறது. அந்த தொட்டி முழுமையாக கசிவடைய எவ்வளவு நேரம் ஆகும். ","An electric pump can fill a tank in 3 hours. Because of a leak in ,the tank it took 3(1/2) hours to fill the tank. If the tank is full, how much time will the leak take to empty it ?","42 Hrs","27 Hrs","21 Hrs","18 Hrs",3, Test_Question.CATEGORY_PIPE);
        addQuestion(q7);
        Test_Question q8=new Test_Question("இரு குழாய்கள் 14, 16 மணிநேரத்தில் ஒரு பாத்திரத்தை நிரப்பும். இரு குழாய்களும் ஒருநேரத்தில் திறக்கப்பட்டால் அந்த தொட்டில் ஒரு கசிவு உள்ளதால், தொட்டியை  நிரப்ப 32 நிமிடம் அதிகம் ஆகிறது. எனில் கசிவு அந்த தொட்டியை காலிசெய்ய ஆகும் நேரம் ?","Two pipes can fill a cistern in 14 hours and 16 hours respectively. The pipes are opened simultaneously and it is found that due to leakage in the bottom it took 32 minutes more to fill the cistern.When the cistern is full, in what time will the leak empty it? ","112 Hrs","110 Hrs","100 Hrs","150 Hrs",1, Test_Question.CATEGORY_PIPE);
        addQuestion(q8);
        Test_Question q9=new Test_Question("இரு குழாய்கள் A, B முறையே 36, 45 நிமிடங்களில் தொட்டியை நிரப்பும், C என்ற குழாய் 30நிமிடத்தில் தொட்டியை காலிசெய்யும். முதல் 7 நிமிடங்களுக்கு A, B மட்டும் திறக்கப்படுகிறது, 7 நிமிடத்திற்கு பின் குழாய் C திறக்கப்படுகிறது எனில் தொட்டியை நிரப்ப ஆகும் நேரம் என்ன ?","Two pipes A and B can fill a tank in 36 min. and 45 min. respectively. A water pipe C can empty the tank in 30 min. First A and B are opened. after 7 min,C is also opened. In how much time, the tank is full?","60 mins","36 mins","42 mins","39 mins",4, Test_Question.CATEGORY_PIPE);
        addQuestion(q9);
        Test_Question q10=new Test_Question("A மற்றும் B என்ற இரு குழாய்கள் தனித்தனியே ஒரு தொட்டியை 20 மற்றும் 30 நிமிடங்களில் நிரப்புகிறது. இரு குழாய்களும் ஒருசேர திறக்கப்பட்டால் தொட்டி நிறைவடைய ஆகும் நேரம் என்ன? ","Two pipes A and B can fill a tank in 20 and 30 minutes respectively. If both the pipes are used together. then how long will it take to fill the tank?","12 min","15 mins","25 min","50 min",1, Test_Question.CATEGORY_PIPE);
        addQuestion(q10);
        Test_Question q11=new Test_Question("ஒரு பாத்திரத்தை நிரப்ப ஒரு குழாய்க்கு 4 மணிநேரம் ஆகிறது, அதனை காலிசெய்ய 9 மணிநேரம் ஆகிறது எனில் இரு குழாய்களும் ஒருசேர திறக்கப்பட்டால் அந்த பாத்திரத்தை நிரப்ப ஆகும் நேரம் என்ன ?","A cistern can be filled by a tap in 4 hours while it can be emptied by another tap in 9 hours. If both the taps are opened simultaneously then after how much time will the cistern get filled ?","4.5hrs","5 hrs","6.5 hrs","7.2 hrs",4, Test_Question.CATEGORY_PIPE);
        addQuestion(q11);
        Test_Question q12=new Test_Question("ஒரு நீர்தொட்டி 5ல்  2மடங்கு நிரப்பப்பட்டுள்ளது . A என்ற குழாய் தொட்டியை 10நிமிடத்தில் நிரப்பும். B என்ற குழாய் 6நிமிடத்தில் காலிசெய்யும் எனில் அந்த தொட்டியை நிரப்ப அல்லது காலிசெய்ய ஆகும் நேரம் என்ன ?","A water tank is two-fifth full. Pipe A can fill a tank in 10 minutes and Pipe B can empty it in 6 minutes. If both the pipes are open, how long will it take to empty or fill the tank completely?","6 mins to empty","b mins to fill","9 mins to fill","None of these",1, Test_Question.CATEGORY_PIPE);
        addQuestion(q12);
        Test_Question q13=new Test_Question("ஒரு குழாய் ஒரு தொட்டியை 6 மணிநேரத்தில் நிரப்புகிறது. பாதி தொட்டி நிரப்பிய பிறகு, அதே போல் மேலும் 3 குழாய்கள் திறக்கப்படுகிறது எனில் தொட்டியை நிரப்ப ஆகும் நேரம் என்ன? ","A tap can fill a tank in 6 hours. After Half the tank is filled, three more similar taps are opened. what is the total time taken to fill the tank completely?","3hrs 15 mins","3 hrs 45 mins","4 hrs","4hrs 15 mins",2, Test_Question.CATEGORY_PIPE);
        addQuestion(q13);
        Test_Question q14=new Test_Question("ஒரு தொட்டியை குழாய் A 5மணிநேரத்திலும், குழாய் B 10மணிநேரத்திலும், குழாய் C 30 மணிநேரத்திலும் நிரப்புகிறது, அனைத்து குழாய்களும் ஒருசேர திறக்கப்பட்டால். தொட்டியை நிரப்ப ஆகும் நேரம் ?","Pipe A can fill a tank in 5 hours, pipe B in 10 hours and pipe C in 30 hours. If all the pipes are open, in how many hours will the tank be filled?","2 hrs","2.5 hrs","3 hrs","3.5 hrs",3, Test_Question.CATEGORY_PIPE);
        addQuestion(q14);
        Test_Question q15=new Test_Question("ஒரு குழாய் ஒரு தொட்டியை மாற்றோரு குழாயை போல் 3 மடங்கு வேகத்தில் நிரப்பும். இரு குழாய்களும் சேர்ந்து 36நிமிடத்தில் நிரப்பும் எனில் மெதுவாக நிரப்பும் குழாய் எவ்வளவு நேரத்தில் நிரப்பும். ","One pipe can fill a tank three times as fast as another pipe if together the two pipes can fill the tank in 36 mins, then the slower pipe alone able to fill the tank","81 mins","108 mins","144 mins","192 mins",3, Test_Question.CATEGORY_PIPE);
        addQuestion(q15);
    }

    private void addAges(){
        Test_Question q1=new Test_Question("இன்று அபியின் வயது ரீட்டாவின் வயதை போல இரு மடங்கு. 7 வருடங்களுக்கு பின்னர் அவர்களின் வயது வித்யாசம் 5, எனில் ரீட்டாவின் இன்றைய வயது என்ன? ","At present Abi is twice as old as Reeta. After seven years their age difference is 5 years. The present age of Reeta is","5","7","9","10",1, Test_Question.CATEGORY_AGES);
        addQuestion(q1);
        Test_Question q2=new Test_Question("சர்மாவின் தற்போதைய வயது அவரது தந்தையை வயதில் கால் பகுதி, 6வருடங்களுக்கு முன் தந்தையின் வயது சர்மாவின் வயதைப்போல் 7மடங்காகும், அவர்களின் தற்போதை வயது என்ன ?","Now Sharma age is quarter as old as his father. Six years ago the father’s age was seven times as old as Sharma. Find the present ages?","8,32","10,40","12,48","14,56",3, Test_Question.CATEGORY_AGES);
        addQuestion(q2);
        Test_Question q3=new Test_Question("முத்து மற்றும் கார்த்தியின் தற்போதைய வயது விகிதம் 5:3. ஆனால் 6வருடங்களுக்கு முன்னாள் அவர்களின் வயது விகிதம் 3:1 எனில் 5 வருடங்களுக்கு பிறகு வயது விகிதம் என்ன ? ","The ratio of ages of Muthu and Karthi at present is 5:3. But 6 years ago the ratio is 3:1. What is the ratio of their ages after 5 years?","5:4","10:7","10:8","4:3",2, Test_Question.CATEGORY_AGES);
        addQuestion(q3);
        Test_Question q4=new Test_Question("15 வருடங்களுக்கு முன் ராஜீவின் வயது 5 வருடங்களுக்கு முன் அவரின் வயது போல் 5 மடங்கு ஆகும், எனில் அவரின் தற்போதைய வயது என்ன? ","Rajeev's age after 15 years will be 5 times his age 5 years back. What is the present age of Rajeev ?","11","12","10","9",3, Test_Question.CATEGORY_AGES);
        addQuestion(q4);
        Test_Question q5=new Test_Question("இரு நபர்களின் வயது வித்யாசம் 16, இதில் 6 வருடங்களுக்கு முன் ஒருவரின் வயது  மற்றொருவரை விட 3 மடங்கு அதிகம் எனில், அவர்களின் தற்போதைய வயது என்ன ?","The ages of two persons differ by 16 years. If 6 years ago, the elder one be 3 times as old as the younger one, find their present ages.","12, 28","11, 27","14, 36","14, 30",4, Test_Question.CATEGORY_AGES);
        addQuestion(q5);
        Test_Question q6=new Test_Question("ஹரி மற்றும் கார்த்தி இருவரின் வயதின் பெருக்கல் பலன் 240, கார்த்தியின் இருமடங்கு வயது ஹரி விட 4 அதிகம் எனில், கார்த்தியின் வயது என்ன ?","The product of the ages of Hari and Karthi is 240. If twice the age of Karthi is more than Hari's age by 4 years, what is Karthi's age?","22","12","10","15",2, Test_Question.CATEGORY_AGES);
        addQuestion(q6);
        Test_Question q7=new Test_Question("தந்தையின் தற்போதைய வயது, அவரின் மகனின் 3மடங்கு வயதை விட 3 அதிகம். 3வருடங்களுக்கு பின் தந்தையின் வயது  அவரின் மகனின் 2மடங்கு வயதை விட 10 அதிகம், எனில் தந்தையின் வயது என்ன ?","The present age of a father is 3 years more than three times the age of his son. Three years hence, father's age will be 10 years more than twice the age of the son. Find the present age of the father.","30","31","32","33",4, Test_Question.CATEGORY_AGES);
        addQuestion(q7);
        Test_Question q8=new Test_Question("8 வருடங்களுக்கு முன் ரோஹித்தின் வயது அவரின் மகனின் வயதைவிட 4 மடங்கு அதிகம். 8 வருடங்களுக்கு பின் அவரின் வயது அவரின் மகனின் வயது போல் 2 மடங்காகும். எனில் அவர்களின் வயது என்ன ?","Rohit was 4 times as old as his son 8 years ago. After 8 years, Rohit will be twice as old as his son. What are their present ages?","8, 20","16, 56","16, 40","8, 24",3, Test_Question.CATEGORY_AGES);
        addQuestion(q8);
        Test_Question q9=new Test_Question("ஒரு வருடத்திற்கு முன் முகில் மற்றும் சச்சினின் வயது விகிதம் 6:7, 4 வருடத்திற்கு பின் அவர்களின் விகிதம் 7:8 எனில், சச்சினின் வயது என்ன ? ","One year ago, the ratio of Mugil’s and Sachin’s age was 6: 7 respectively. Four years hence, this ratio would become 7: 8. How old is Sachin ?","32","36","34","40",2, Test_Question.CATEGORY_AGES);
        addQuestion(q9);
        Test_Question q10=new Test_Question("6 வருடத்திற்கு பின் அபியின் வயது அவளின் தந்தையின் வயதில் 7ல் 3 பங்காகும். 10 வருடங்களுக்கு முன் அவர்களின் வயது விகிதம் 1:5 ஆகும். எனில் அபியின் தந்தையின் வயது என்ன ? ","Abi’s age after six years will be three-seventh of his fathers age. Ten years ago the ratio of their ages was 1 : 5. What is Abi’s father's age at present?","50","48","36","54",1, Test_Question.CATEGORY_AGES);
        addQuestion(q10);
    }

    private void addRatio(){
        Test_Question q1=new Test_Question("ஒரு குடும்பத்தில் தகப்பனார், ¼ பாகம் கேக் சாப்பிடுகிறார். மற்ற குடும்ப உறுப்பினர்களைப் போல்  மூன்று மடங்கு சாப்பிடுகிறார் எனில் குடும்ப உறுப்பினர்களின் மொத்த எண்ணிக்கை யாது?","In a family, the father took ¼ of the cake, and he had 3 times as much as each the other members had. The total number of family members is","3","7","10","12",3, Test_Question.CATEGORY_RATIO);
        addQuestion(q1);
        Test_Question q2=new Test_Question("ஒரு பண்ணையில் உள்ள குதிரைகளின் எண்ணிக்கை வாத்துகளின் எண்ணிக்கையைப் போல இரு மடங்கு . வாத்து மற்றும் குதிரைகளின் மொத்த பாதங்களை எண்ணினால் 70. வாத்துகளின் எண்ணிக்கை என்ன? ","The number of horses on a farm is twice the number of ducks. The total number of feet of ducks and horses counted together is 70. The number of ducks is","5","7","14","35",2, Test_Question.CATEGORY_RATIO);
        addQuestion(q2);
        Test_Question q3=new Test_Question("a : b என்பது 2 : 3, b : c என்பது 4 : 3 மற்றும் c : d என்பது 2 : 5 எனில் a : d என்பதன் மதிப்பு யாது? ","If a : b is 2 : 3, b : c is 4 : 3 and c : d is 2 : 5 then a : d is","18 : 45","16 : 45","8 : 45","16 : 18",2, Test_Question.CATEGORY_RATIO);
        addQuestion(q3);
        Test_Question q4=new Test_Question("27 : 43 என்ற விகிதத்திலிருக்கும் உறுப்புகளிலிருந்து எந்த எண்ணை கழிக்க 7 : 15 என்கின்ற விகிதம் கிடைக்கும் ","Find The number that must be subtracted from each term of ratio 27 : 43 to make it 7 : 15","17","20","27","13",4, Test_Question.CATEGORY_RATIO);
        addQuestion(q4);
        Test_Question q5=new Test_Question("தங்கம் தண்ணிரைப் போல 19 மடங்கு கனமாகவும், தாமிரம் தண்ணீரைப்போல 9 மடங்கு கனமாகவும் உள்ளது. தண்ணிரைப் போல 15 மடங்கு கனமான உலோக கலவையை பெற , இவைகள் எவ்விதத்தில் கலக்கப் பட  வேண்டும் ?","Gold is 19 times as heavy as water and copper is 9 times as heavy as water. In what ratio should these mixed to get an alloy of 15 times as heavy as water?","1 : 1","2 : 3","1 : 2","3 : 2",4, Test_Question.CATEGORY_RATIO);
        addQuestion(q5);
        Test_Question q6=new Test_Question("மூன்று எண்களின் கூடுதல் 38. முதல் மற்றும் இரண்டாம் எண்கள் 1:2 என்ற விகிதத்திலும் 2 மற்றும் 3 வது எண்கள் 3:5 என்ற விகிதத்திலும் இருந்தால் இரண்டாவது எண் யாது? ","The Sum of three numbers is 38. If the ratio of the first to the second is 1:2 and that of the second to the third is 3:5 then the second number is","6","12","18","24",2, Test_Question.CATEGORY_RATIO);
        addQuestion(q6);
        Test_Question q7=new Test_Question("a : b = 2 : 3, b : c = 5 : 7 மற்றும் c யின் மதிப்பு 42 எனில் a = ?","If a : b = 2 : 3, b : c = 5 : 7 and c is 42 what is a = ?","12","20","21","22",2, Test_Question.CATEGORY_RATIO);
        addQuestion(q7);
        Test_Question q8=new Test_Question("இரண்டு எண்கள் 15:11 என்ற விகிதத்தில் உள்ளன. அவற்றின் மீ.பொ.வ 13 எனில் கீழே கொடுக்கப்பட்டுள்ளவைகளில் அவை எதுவாக இருக்கக் கூடும்? ","The numbers are in the ratio 15 : 11. Their HCF is 13, which of the following pairs can they be?","194, 143","195, 142","195, 143","196, 144",3, Test_Question.CATEGORY_RATIO);
        addQuestion(q8);
        Test_Question q9=new Test_Question("ஒரு செவ்வகத்தின் நீளத்தை  இரு மடங்காகவும் அகலத்தை மூன்று மடங்காகவும் ஆக்கினால், கீழ்க்கண்டவற்றுள் எது சரி? ","If the length of a rectangle is doubled and the breadth is tripled then which of the following is true?","Perimeter is multiplied by 5","Perimeter is multiplied by 5/2","Area is multiplied by 5/2","Area is multiplied by 6",4, Test_Question.CATEGORY_RATIO);
        addQuestion(q9);
        Test_Question q10=new Test_Question(" ஒரு நேர்வட்ட கோளத்திற்கும் , ஒரு நேர்வட்ட கூம்பிற்கும் ஒரே ஆரம், ஒரே உயரம் என்றால் கோளத்தின் கன அளவுக்கும் கூம்பின் கன அளவுக்கும் இடையே உள்ள விகிதம்? ","If a right circular cylinder cone have the same radius and same height then the ratio of volume of cylinder to volume of cone is","3 : 1","1 : 3","1/3  : 2","1 : π",1, Test_Question.CATEGORY_RATIO);
        addQuestion(q10);
        Test_Question q11=new Test_Question("30லிட்டர் அமில கலவையில் அமிலம் மற்றும் தண்ணீர் 2:3 என்ற விகிதத்தில் உள்ளன, அந்த கலவையை 2:5 ஆக மாற்ற எவ்வளவு தண்ணீர் சேர்க்க வேண்டும் ","In 30 litres of acid the ratio of acid and water is 2:3 . What amount of water should be added to the mixture so that the ratio of acid and water becomes 2:5?","19 litres","15 litres","12 litres","10 litres",3, Test_Question.CATEGORY_RATIO);
        addQuestion(q11);
        Test_Question q12=new Test_Question("முத்து மற்றும் கார்த்தியின் தற்போதைய வயது விகிதம் 5:3. ஆனால் 6வருடங்களுக்கு முன்னாள் அவர்களின் வயது விகிதம் 3:1 எனில் 5 வருடங்களுக்கு பிறகு வயது விகிதம் என்ன ?","The ratio of ages of Muthu and Karthi at present is 5:3. But 6 years ago the ratio is 3:1. What is the ratio of their ages after 5 years?","5:4","10:7","10:8","4:3",2, Test_Question.CATEGORY_RATIO);
        addQuestion(q12);
        Test_Question q13=new Test_Question("மூன்று கொள்கலன்கலன்களின் கொள்ளளவின் விகிதம் 3:4:5, அவைகளில் பால் மற்றும் தண்ணீர் பின்வரும் விகிதங்களில் உள்ளன 4:1, 3:1, 5:2. இந்த பாத்திரங்களில் உள்ள கலவையை நான்காவது பாத்திரத்தில் ஊற்றினால், நான்காவது பாத்திரத்தில் உள்ள பால் மற்றும் தண்ணீரின் விகிதம் என்ன ?","Three containers have their volumes in the ratio 3:4:5. They are full of mixtures of milk and water. The mixtures contain milk and water in the ratio of 4:1, 3:1 , and 5:2 respectively. The contents of all these three containers are poured into a fourth container. The ratio of milk and water in the 4th container is","4:1","151:48","157:53","5:2",3, Test_Question.CATEGORY_RATIO);
        addQuestion(q13);
        Test_Question q14=new Test_Question("இரு முழு எண்களில் கூடுதல் 72 எனில், பின்வருபவையில் எது விகிதமாக இருக்காது ?","Two whole numbers whose sum is 72 cannot be in the ratio ?","5:7","3:5","3:4","4:5",2, Test_Question.CATEGORY_RATIO);
        addQuestion(q14);
        Test_Question q15=new Test_Question("a : b = 5 : 9 மற்றும்  b : c = 4: 7, எனில் a : b : c ஐ கண்டறி ","If a : b = 5 : 9 and b : c = 4: 7, find a : b : c","5:36:7","40:36:36","20:36:7","20:36:63",4, Test_Question.CATEGORY_RATIO);
        addQuestion(q15);
        Test_Question q16=new Test_Question("x : y = 3 : 4 எனில் (4x + 5y) : (5x - 2y) கண்டறி .","If x : y = 3 : 4, find (4x + 5y) : (5x - 2y)","32:6","32:7","69:6","2:3",2, Test_Question.CATEGORY_RATIO);
        addQuestion(q16);
        Test_Question q17=new Test_Question("672 ல் 5:3 விகிதங்களை கண்டறி ","Divide Rs. 672 in the ratio 5 : 3","400,272","420,252","300,327","276,396",2, Test_Question.CATEGORY_RATIO);
        addQuestion(q17);
        Test_Question q18=new Test_Question("ரூபாய் 1162ஐ 35:28:20 என்ற விகிதத்தில் A, B, C க்கு பிரித்தளிக்க. ","Divide Rs. 1162 among A, B, C in the ratio 35 : 28 : 20","Rs490, Rs392, Rs280","Rs490,Rs390, Rs282","Rs400, Rs390, Rs372","Rs488, Rs394, Rs280",1, Test_Question.CATEGORY_RATIO);
        addQuestion(q18);
    }

    private void addCI(){
        Test_Question q2=new Test_Question("அரை ஆண்டுக்கு ஒரு முறை வட்டி அசலுடன் சேர்க்கப்பட்டால் ரூ. 8,000 க்கு ஆண்டு வட்டி வீதம் 10% வீதப்படி, 18 மாதங்களுக்கு பின் இறுதி கூட்டுத் தொகை ","If interest is compounded every six months a principal of Rs. 8,000 at 10% rate of interest will amount to ________________ at the end of 18 months.","Rs. 9,000","Rs. 9,156","Rs. 9,261","Rs. 9,282",3, Test_Question.CATEGORY_COMPOUNDINTEREST);
        addQuestion(q2);
        Test_Question q3=new Test_Question("கூட்டு வட்டி முறையில் ரூ. 8,000, 3 ஆண்டுகளில் 5% வருட வட்டி வீதப்படி கிடைக்கும் வட்டி யாது? ","The Compound interest on Rs. 8,000 at 5% p.a. for 3 years is","Rs. 1251","Rs. 1871","Rs. 1361","Rs. 1261",4, Test_Question.CATEGORY_COMPOUNDINTEREST);
        addQuestion(q3);
        Test_Question q4=new Test_Question("அசல் P க்கு r% வட்டி வீதம் என்றால், இரண்டு ஆண்டுகளுக்கு கூட்டு வட்டிக்கும் தனி வட்டிக்கும் உள்ள வித்யாசம் ","The diference between compound interest and simple interest of Principal P, at r% interest for 2 years is ","P(r/100)^2","P(1+ r/100)^2","P(1- r/100)^2","P + (r/100)^2",1, Test_Question.CATEGORY_COMPOUNDINTEREST);
        addQuestion(q4);
        Test_Question q5=new Test_Question("ஒரு தொகைக்கு இரண்டு ஆண்டுகளுக்கு 8% வட்டி வீதத்தில் கூட்டு வட்டிக்கும் தனி வட்டிக்கும் உள்ள வித்யாசம் ரூ. 40 எனில், அந்த தொகை யாது? ","The difference between the C.I and S.I for a sum for two years at 8% rate of interest p.a. is Rs.40. What is the sum? ","Rs. 2,000","Rs. 4,000","Rs. 5,500","Rs. 6,250",4, Test_Question.CATEGORY_COMPOUNDINTEREST);
        addQuestion(q5);
        Test_Question q6=new Test_Question("கூட்டு வட்டி முறையில் 20,000Rs ஆனது 10% ஆண்டு வட்டியில் 26,620 ஆக மாறுகிறது எனில் எத்தனை ஆண்டுகளில் அது மாறுகிறது என கண்டறி ? ","In a compound Interest, the sum 20,000 will turned the amount 26,620 at 10% rate of interest per annum then the number of years is","2 years","3 years","4 years","5 years",2, Test_Question.CATEGORY_COMPOUNDINTEREST);
        addQuestion(q6);
        Test_Question q7=new Test_Question("ஒருவர் Rs.2550 கடனாக பெற்று அதனை கூட்டுவட்டி முறையில்  4%  ஆண்டு வட்டிவிகிதத்தில் 2 ஆண்டுகளில் முடிப்பார் எனில், ஒவ்வொரு தவணைக்கும் அவர் செலுத்தவேண்டிய தொகை என்ன ?","A man borrows Rs.2550 to be paid back with compound interest at the rate of 4% per annum by the end of 2 years in two equal yearly installments. How much will each installment be?","Rs.1275","Rs.1283","Rs.1352","Rs.1377",3, Test_Question.CATEGORY_COMPOUNDINTEREST);
        addQuestion(q7);
        Test_Question q8=new Test_Question("Rs 7500 க்கு 4% ஆண்டு வட்டியில் 2 வருடங்களுக்கு வருடாந்திர கூட்டு வட்டி காண்க. ","Find compound interest on Rs. 7500 at 4% per annum for 2 years, compounded annually.","Rs 612","Rs 632","Rs 610","Rs 630",1, Test_Question.CATEGORY_COMPOUNDINTEREST);
        addQuestion(q8);
        Test_Question q9=new Test_Question("Rs 8000 க்கு 15% ஆண்டு வட்டியில் 2 வருடங்கள் 4மாதங்களுக்கு வருடாந்திர கூட்டு வட்டி காண்க ","Find compound interest on Rs. 8000 at 15% per annum for 2 years 4 months, compounded annually. ","Rs 3103","Rs 3112","Rs 3110","Rs 3109",4, Test_Question.CATEGORY_COMPOUNDINTEREST);
        addQuestion(q9);
        Test_Question q10=new Test_Question("Rs 10,000க்கு 4% ஆண்டு வட்டியில் 2 வருடங்களுக்கு அரைவருடாந்திர கூட்டு வட்டி காண்க. ","Find the compound interest on Rs. 10,000 in 2 years at 4% per annum, the interest being compounded half-yearly.","Rs 824.32","Rs 824","Rs 850","Rs 832",1, Test_Question.CATEGORY_COMPOUNDINTEREST);
        addQuestion(q10);
        Test_Question q11=new Test_Question("Rs. 16,000 அசலுக்கு 20% ஆண்டு வட்டியில் 9 மாதங்களுக்கு கூட்டு வட்டி காண்க. ","Find the compound interest on Rs. 16,000 at 20% per annum for 9 months, compounded quarterly.","Rs 2500","Rs 2522","Rs 2255","Rs 2550",1, Test_Question.CATEGORY_COMPOUNDINTEREST);
        addQuestion(q11);
        Test_Question q12=new Test_Question("ஒரு குறிப்பிட்ட தொகைக்கு 5% ஆண்டு வட்டியில் 3 ஆண்டுக்கான தனிவட்டி Rs.1200 எனில், அதே தொகை மற்றும் ஆண்டு வட்டிக்கு கூட்டு வட்டி கண்டறிக. ","If the simple interest on a sum of money at 5% per annum for 3 years is Rs.1200, find the compound interest on the same sum for the same period at the same rate.","Rs 1622","Rs 1621","Rs 1620","Rs 1662",2, Test_Question.CATEGORY_COMPOUNDINTEREST);
        addQuestion(q12);
        Test_Question q13=new Test_Question("அசல் Rs.1000 ஆனது  10% ஆண்டு வட்டியில் 1331 கூட்டு தொகையை எத்தனை ஆண்டுகளில் தரும் ? ","In what time will Rs. 1000 become Rs. 1331 at 10% per annum compounded annually?","2 years","2.5 years","3 years","4 years",3, Test_Question.CATEGORY_COMPOUNDINTEREST);
        addQuestion(q13);
        Test_Question q14=new Test_Question("Rs. 500க்கு 2வருடங்களில் கூட்டு வட்டியுடன் Rs. 583.20 கிடைக்கிறது எனில் வட்டி விகிதத்தை கண்டறிக. ","If Rs. 500 amounts to Rs. 583.20 in two years compounded annually, find the rate of interest per annum.","8.6%","8.3%","7%","8%",4, Test_Question.CATEGORY_COMPOUNDINTEREST);
        addQuestion(q14);
        Test_Question q15=new Test_Question("ஒரு தொகைக்கு 10%வட்டி விகிதத்தில் 2 வருடங்களுக்கு கிடைக்கும் தனிவட்டி மற்றும் கூட்டு வட்டியின் வித்தியாசம் Rs. 631 எனில் அந்த தொகையை கண்டறி. ","The difference between the compound interest and simple interest on a certain sum at 10% per annum for 2 years is Rs. 631. Find the sum?","Rs 624","Rs 625.5","Rs 624.75","Rs 629",3, Test_Question.CATEGORY_COMPOUNDINTEREST);
        addQuestion(q15);
    }

    private void addVolumes(){
        Test_Question q1=new Test_Question("ஒரு கூம்பு, ஒரு அரைக்கோளம் மற்றும் ஒரு உருளை ஆகியன சம அடிப்பரப்பினை கொண்டுள்ளன. கூம்பின் உயரம், உருளையின் உயரத்திற்கு சமமாகவும், மேலும் இவ்வுயரம் அவற்றின் ஆரத்திற்கு சமமாகவும் இருந்தால் முறையே இம்மூன்றின் கன அளவுகளுக்கு இடையே உள்ள விகிதம் யாது? ","A Cone, a Hemisphere and Cylinder have equal bases. If the heights of the cone and the cylinder are equal and equal to their common radius, then find the ratio of their respective volumes.","1 : 3 : 2","3 : 2 : 1","1 : 2 : 3","3 : 1 : 2",3, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q1);
        Test_Question q2=new Test_Question("ஆறு சமசதுரங்களை முகங்களாக கொண்ட உருவம் ","A Solid having six equal square faces is called a ","கனசதுரம்","கனசெவ்வகம்","சதுரம்","செவ்வகம்",1, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q2);
        Test_Question q3=new Test_Question("7cm ஆரமுள்ள ஒரு வட்டத்தின் 180° மைய கோணம் கொண்ட ஒரு வட்டக் கோணப்பகுதியை வெட்டியெடுத்து , அதன் ஆரங்களை ஒன்றிணைத்து ஒரு கூம்பக்கினால், கிடைக்கும் கூம்பின் வளைப்பரப்பை காண்க (π = 22/7) ","A Sector containing an angle of 180o is cut off from a circle of radius 7 cm and folded into a cone. Find the curved surface area of the cone (Take π = 22/7)","77","22","88","66",1, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q3);
        Test_Question q4=new Test_Question("ஒருவர் நீளம், அகலம் மற்றும் உயரம் முறையே 25 cm, 40 cm, 45 cm,  அளவுடைய ஒரு c.p.u, உரை தைக்க விரும்புகிறார். உரையின் விலை 1ச.மீட்டருக்கு ரூ. 40 எனில் அவருக்கு எவ்வளவு செலவு ?  ","A Man wants to stitch a cover for a c.p.u whose length, breadth and height are 25 cm, 40 cm, 45 cm, respectively. Find the amount he has to pay if it costs Rs. 40 per sq.m","Rs. 27.40","Rs. 26.70","Rs. 22.60","Rs. 25.30",1, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q4);
        Test_Question q5=new Test_Question("ஒரு  உள்ளிடற்ற உருளையின் நீளம் h, வெளி மற்றும் உள்வட்டங்கள் R மற்றும் r என்றால் உருளையின் கன அளவு என்ன ","The Volume of a Hollow cylinder of length h, inner radius r and outer radius R is equal to ","πh (R – r)","πh (R² – r²)","πh (R³ – r³)","π h (R² – r²)",2, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q5);
        Test_Question q6=new Test_Question("ஒரு நேர்வட்ட கோளத்திற்கும், ஒரு நேர்வட்ட கூம்பிற்கும் ஒரே ஆரம், ஒரே உயரம் என்றால் கோளத்தின் கன அளவுக்கும் கூம்பின் கன அளவுக்கும் இடையே உள்ள விகிதம்? ","If a right circular cylinder cone have the same radius and same height then the ratio of volume of cylinder to volume of cone is","3 : 1","1 : 3","1/3 : 2","1 : π",1, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q6);
        Test_Question q7=new Test_Question("ஒரு மருத்துவமனையில் உள்ள நோயாளிகளுக்கு 7cm விட்டம்முள்ள உருளைவடிவ கிண்ணத்தில் சூப் வழங்கப்படுகிறது. ஒருவேளை அதில் 4cm  உயரத்துக்கு பழச்சாறுஊற்றி வழங்கப்பட்டால், 250 நோயாளிகளுக்கு ஒருநாளைக்கு வழங்க எவ்வளவு பழச்சாறு வழங்க வேண்டும். ","A Patient in a hospital is give soup daily in a cylindrical bowl of diameter 7 cm. If the bowl is filled with fruit juice to a height of 4 cm, then find the quantity of fruit juice to be prepared daily in the hospital to serve 250 patients.","37.5 litres","38.5 litres","39.5 litres","40.5 litres",2, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q7);
        Test_Question q8=new Test_Question("ஒரு உருளையின் ஆரம் மற்றும் உயரத்தின் விகிதம் 5:7, மற்றும் அதன் கனளவு 4400 எனில், அதன் உருளையின் அரம் என்ன ?","The radius and height of a cylinder are in the ration of 5:7. If its volume is 4400 cu.cm, find the radius of the cylinder?","6cm","8cm","10cm","12cm",3, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q8);
        Test_Question q9=new Test_Question("இரு உருளைகளின் அரங்களின் விகிதம் 3:2 மற்றும் உயரங்களில் விகிதம் 5:3 எனில் அவற்றின் வைபரப்பின் விகிதம் என்ன ? ","The radis of two right circular cylinders are in the ratio of 3:2 and their heights are in the ratio of 5:3. Find the ratio of their curved surface areas","5:2","2:5","3:2","5:3",1, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q9);
        Test_Question q10=new Test_Question("16m நீளம், 14m அகலம், 5m உயரம் கொண்ட ஒரு கன செவ்வகத்தின் கன அளவு மற்றும் மேற்பரப்பளவு கண்டறி. ","Find the volume and surface area of a cuboid 16 m long, 14 m broad and 5 m high.","1122m^3","1140m^3","1120m^3","1300m^3",3, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q10);
        Test_Question q11=new Test_Question("10m நீளம், 8m அகலம், 10m உயரம் கொண்ட ஒரு அறையில் எவ்வளவு நீளமான கம்பத்தை வைக்கலாம். ","Find the length of the longest pole that can be placed in a room 10 m long 8m broad and 10m high.","6m","7m","7√6m","6√6m",4, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q11);
        Test_Question q12=new Test_Question("24m நீளம், 8m உயரம், 60cm தடிமன் உள்ள ஒரு சுவரை, 24 cm x 12 cm x 8 cm அளவுள்ள செங்கற்களை கொண்டு கொண்டு கட்டினால் எத்தனை கற்கள் தேவைப்படும்? இதில் 20% காரை உள்ளது. ","Find the number of bricks, each measuring 24 cm x 12 cm x 8 cm, required to construct a wall 24 m long, 8m high and 60 cm thick, if 20% of the wall is filled with mortar ?","360000 Bricks","42000 Bricks","40000 Bricks","40020 Bricks",3, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q12);
        Test_Question q13=new Test_Question("ஒரு கன சதுரத்தின் மேற்பரப்பளவு 1734sq cm எனில் அதன் கன அளவு காண்க ","The surface area of a cube is 1734 sq. cm. Find its volume.","4913 cubic cm","4736 cubic cm","4500 cubic cm","5000 cubic cm",1, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q13);
        Test_Question q14=new Test_Question("4cm அடிப்பரப்பு விட்டம்  மற்றும் 20cm உயரம் கொண்ட ஒரு உருளையின் வளைப்பரப்பு, மேற்பரப்பளவு, கன அளவு ஆகியவற்றை காண்க. ","Find the volume , curved surface area and the total surface area of a cylinder with diameter of base 7 cm and height 40 cm.","256 cm^2","276 cm^2","265.3cm^2","276.57cm^2",4, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q14);
        Test_Question q15=new Test_Question("21cm ஆரமும் 28cm உயரமும் கொண்ட ஒரு கூம்பின் சாய்ந்த உயரம், வளைபரப்பு கண்டறிக. ","Find the slant height, volume, curved surface area and the whole surface area of a cone of radius 21 cm and height 28 cm.","2150 sq.cm","2310 sq.cm","2526 sq.cm","2311 sq.cm^2",2, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q15);
        Test_Question q16=new Test_Question("7cm ஆரம் உள்ள ஒரு அரை கோளத்தின் கன அளவு மற்றும் வலைபரப்பு காண்க. ","Find the volume, curved surface area of a hemisphere of radius 7 cm.","300 sq.cm","308 sq.cm","315 sq.cm","336 sq.cm",2, Test_Question.CATEGORY_VOLUMES);
        addQuestion(q16);
    }

    private void addArea(){
        Test_Question q1=new Test_Question("3.78 மீட்டர்கள் நீளமும் 5.25 மீ அகலமும் உடைய ஒரு பிரகாரம் ஒரே அளவுள்ள சரியான சதுர ஓடுகளைக்கொண்டு பரப்பப்பட வேண்டும் .அந்நோக்கத்திற்க்காக உபயோகப்படுத்தக்கூடிய ஓட்டின் மிகப்பெரிய அளவு என்ன? ","A Rectangular courtyard 3.78 meters long and 5.25 metre wide is to be paved exactly with square tiles, all of the same size. What is the largest size of the tile which could be used for the purpose?","14 cms","21 cms","42 cms","None of these",2, Test_Question.CATEGORY_AREA);
        addQuestion(q1);
        Test_Question q2=new Test_Question("ஒரு புல்வெளி மைதானம் அதன் பக்கங்கள் 2 : 3 விகிதத்தில் உள்ள ஒரு செவ்வக வடிவில் உள்ளது. அந்த மைதானத்தின் பரப்பு 1/6 ஹெட்டர் எனில், அதன் நீளத்தை காண்க ","A lawn is in the form of a rectangle having its sides in the ration 2 : 3. The area of the lawn is 1/6  hectares. Find the length of the lawn.","40 m","33 ½ m","50 m","45 m",3, Test_Question.CATEGORY_AREA);
        addQuestion(q2);
        Test_Question q3=new Test_Question("ஒரு வட்டக்கோண பகுதியின் பரப்பு 60 செ.மீ ^2  . அதன் வில்லின் நீளம் 20 செ.மீ ^2 எனில் ஆரம் காண்க.  ","Calculate the radius of a sector whose area and arc length are 60 cm^2 and 20 cm respectively ","3 cm","6 cm","4 cm","5 cm",2, Test_Question.CATEGORY_AREA);
        addQuestion(q3);
        Test_Question q4=new Test_Question("400 சதுர மீட்டர் பரப்பளவு வர்ணம் பூச வேண்டியுள்ளது. A வகை பெயிண்ட் லிட்டருக்கு  150 ரூபாய்; 1 லிட்டர் கொண்டு 4 சதுர மீட்டர் பூசலாம். B வகை பெயிண்ட் லிட்டர் 200 ரூபாய்; லிட்டருக்கு 6 சதுர மீட்டர் பூசலாம். C வகை பெயிண்ட் லிட்டர் ரூபாய் 250; லிட்டருக்கு 8 சதுர மீட்டர் பூசலாம். மிக குறைந்த விலையில் 400 சதுர மீட்டர் வர்ணம் பூச ஆகும் செலவு  ","400 square metres have to be painted. 1 litre of paint A costs Rs. 150 and can be used to paint 4 sq.m. 1 litre of paint B costs Rs. 200 and can paint 6 sq.m 1 litre of paint C costs Rs. 250 and can paint 8 sq.m . least cost of painting 400 sq.m. is","Rs. 10,000","Rs. 12,500","Rs. 15,000","Rs. 16,250",2, Test_Question.CATEGORY_AREA);
        addQuestion(q4);
        Test_Question q5=new Test_Question("ஒரு நபர் 96 சமீ பரப்பளவு  8 நாட்களில் வெள்ளை அடித்தார் எனில் 18 நாட்களில் எவ்வளவு பரப்பளவை வெள்ளை அடிக்க முடியும்?  ","A man white washes 96 sq.m of a compound wall in 8 days. How many sq.m will be white washed in 18 days?","216 sq.m","218 sq.m","198 sq.m","220 sq.m",1, Test_Question.CATEGORY_AREA);
        addQuestion(q5);
        Test_Question q6=new Test_Question("பின்வருவனவற்றுள் எது ABC முக்கோணத்தின் பரப்புக்கான சூத்திரம்அல்ல?   ","Which of the following is not the area of triangle ABC?","a/b sin c","½ bh","s√s(s-a)(s-b)(s-c)","½ d (h1 + h2)",4, Test_Question.CATEGORY_AREA);
        addQuestion(q6);
        Test_Question q7=new Test_Question("ஒரு வட்டமான வயலின் பரப்பளவு 138600 ச.மீ. ,சதுர மீட்டருக்கு ரூ. 4.40 எனும் வீதத்தில், அதை வேலி அடைப்பதற்கான  செலவினை  கணக்கிடுக?  ","The area of a circular field is 138600 m²  . Find the cost of fencing it at the rate of Rs. 4.40 per per metre.","Rs. 5800","Rs. 5808","Rs. 4808","Rs. 6808",2, Test_Question.CATEGORY_AREA);
        addQuestion(q7);
        Test_Question q8=new Test_Question("ஒரு வட்டத்தின் சுற்றளவிற்கும் அதன் விட்டத்திற்கும் உள்ள விகிதம் (தோராயமாக )","The Ratio of Circumference to the diameter of a circles is approximately","8 : 11","11 : 8","7 : 22","22 : 7",4, Test_Question.CATEGORY_AREA);
        addQuestion(q8);
        Test_Question q9=new Test_Question("ஒரு செவ்வகத்தின் நீளத்தை இரு மடங்காகவும் அகலத்தை மூன்று மடங்காகவும் ஆக்கினால், கீழ்க்கண்டவற்றுள் எது சரி? ","If the length of a rectangle is doubled and the breadth is tripled then which of the following is true?","சுற்றளவு 5 மடங்காகும்","சுற்றளவு 5/2  மடங்காகும்","பரப்பளவு 5/2 மடங்காகும் ","பரப்பளவு 6 மடங்காகும்",4, Test_Question.CATEGORY_AREA);
        addQuestion(q9);
        Test_Question q10=new Test_Question("ஒரு செவ்வக வடிவ நிலத்தின் ஒரு பக்கம் 15m மற்றும் அதன் ஒரு மூலை விட்டம் 17m எனில் நிலத்தின் பரப்பளவு கண்டறி. ","One side of a rectangular field is 15 m and one of its diagonals is 17 m. Find the area of the field.","112 sq.m","120 sq.m","200 sq.m","180 sq.m",2, Test_Question.CATEGORY_AREA);
        addQuestion(q10);
        Test_Question q11=new Test_Question("செவ்வக வடிவமுள்ள ஒரு நிலத்தின் பக்கங்கள் முறையே 2:3, நிலத்தின் பரப்பளவு (1/6) ஹெக்டர்ஸ் எனில் நிலத்தின் நீளம் மற்றும் அகலம் கண்டறி ","A lawn is in the form of a rectangle having its sides in the ratio 2: 3. The area of the lawn is (1/6) hectares. Find the length and breadth of the lawn.","43m","57m","50m","75m",3, Test_Question.CATEGORY_AREA);
        addQuestion(q11);
        Test_Question q12=new Test_Question("இரு சதுரங்களின் சுற்றளவு முறையே 40cm , 32cm, இவ்விரு சதுரங்களின் பரப்பளவின் வித்தியாசமானது மூன்றாவது சதுரத்தின் பரப்பளவிற்கு சமம் எனில் மூன்றவது சதுரத்தின் சுற்றளவு காண்க. ","The perimeters of two squares are 40 cm and 32 cm. Find the perimeter of a third square whose area is equal to the difference of the areas of the two squares.","24cm","26cm","63cm","23cm",1, Test_Question.CATEGORY_AREA);
        addQuestion(q12);
        Test_Question q13=new Test_Question("5m 44cm நீளமும் 3m 74 cm அகலமும் உள்ள ஒரு அறையில் சதுர வடிவ கல் பாதிக்க வேண்டும் எனில் மிக குறைந்த அளவிலான சதுர வடிவ கல் பதிக்க தேவையான கற்கள் எத்தனை? ","A room 5m 44cm long and 3m 74 cm broad is to be paved with square tiles. Find the least number of square tiles required to cover the floor. ","136 tiles","196 tiles","170 tiles","176 tiles",4, Test_Question.CATEGORY_AREA);
        addQuestion(q13);
        Test_Question q14=new Test_Question("ஒரு சதுரத்தின் அனைத்து பக்கங்களும் 25% உயர்கிறது எனில் சதுரத்தின் உயர்ந்த பரப்பளவு % என்ன ? ","If each side of a square is increased by 25%, find the percentage change in its area. ","56.25%","50%","25%","75.36%",1, Test_Question.CATEGORY_AREA);
        addQuestion(q14);
        Test_Question q15=new Test_Question("13 cm, 14 cm and 15 cm என்ற பக்கங்கள் கொண்ட முக்கோணத்தின் பரப்பளவு காண்க ","Find the area of a triangle whose sides measure 13 cm, 14 cm and 15 cm","65 sq.cm","76 sq.cm","84sq.cm","96.36s.m",3, Test_Question.CATEGORY_AREA);
        addQuestion(q15);
        Test_Question q16=new Test_Question("12cm அடிமானமும் 13cm கர்ணமும் கொண்ட ஒரு செங்கோண முக்கோணத்தின் பரப்பளவு காண்க ","Find the area of a right-angled triangle whose base is 12 cm and hypotenuse is 13cm.","25 sq.cm","30 sq.cm","27 sq.cm","32 sq.cm",2, Test_Question.CATEGORY_AREA);
        addQuestion(q16);
        Test_Question q17=new Test_Question("9856 sq m பரப்பளவில் உள்ள நிலத்தை மேய்வதற்கு ஒரு மாடு எவ்வளவு நீளமுள்ள கயிற்றில் கட்டப்பட வேண்டும். ","Find the length of a rope by which a cow must be tethered in order that it may be able to graze an area of 9856 sq. metres","46m","50m","56m","75m",3, Test_Question.CATEGORY_AREA);
        addQuestion(q17);
        Test_Question q18=new Test_Question("ஒரு சக்கரம் 1000 சுழற்சிகளில் 44 km கடக்கிறது. எனில் அதன் ஆரத்தை கண்டறி ","A wheel makes 1000 revolutions in covering a distance of 44 km. Find the radius of the wheel.","7m","14m","1000m","12m",1, Test_Question.CATEGORY_AREA);
        addQuestion(q18);
    }

    private void addSI(){
        Test_Question q1=new Test_Question("Rs450 எப்போது வட்டி 81Rs ஐ 4.5% ஆண்டுவட்டியில் தரும் ?","How much time will it take for an amount of Rs.450 to Yield Rs.81 as interest at 4.5% per annum of simple interest?","3.5 years","4 years","4.5 year","5 years",2, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q1);
        Test_Question q2=new Test_Question("12500Rs 4ஆண்டுகளில் 15500Rs ஆக கூடுகிறது,தனிவட்டி முறையில் அதன் வட்டி விகிதம் காண்க? ","A sum of Rs.12500 amounts to Rs.15500 in 4 years at the rate of simpe interest.What is the rate of interest?","3%","4%","5%","6%",4, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q2);
        Test_Question q3=new Test_Question("132Rs ன் தற்போதைய மதிப்பு 2 ஆண்டுகள், 5% வட்டி விகிதத்தில்,தனிவட்டி முறையில்  காண்க ?","What is the present worth of Rs.132 due in 2 years at 5% simple interest per annum?","Rs.12","Rs.118.80","Rs.120","Rs.122",3, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q3);
        Test_Question q4=new Test_Question("ஒரு குறிப்பிட்ட தொகை தனிவட்டியாக Rs1750 ஐ 7 வருடங்கள் கழித்து தருகிறது, அதன் வட்டி விகிதம் 2% அதிகரித்தல்,இன்னும் எவ்வளவு வட்டி அதிகம் கிடைத்திருக்கும் ?","A certain amount earns simple interest of Rs.1750 after 7 years. had the interest been 2 % more, how much more interest would it have earned?","Rs.35","Rs.245","Rs.350","Cannot be determainde",4, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q4);
        Test_Question q5=new Test_Question("ஒரு குறிப்பிட்ட  தொகை ஒரே வட்டிவிகிதத்தில் 6 மற்றும் 9 வருடங்கள் இருந்தால்,அதன் தனிவட்டி விகிதம் என்ன ?","What will be the ratio of simple interest earned by certain amount at the same rate of interest for 6 years and ther for 9 years?","1:3","1:4","2:3","None of these",3, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q5);
        Test_Question q6=new Test_Question("3 வருடங்களில் தனிவட்டி கூடுதல் Rs.815,அதுவே 4 வருடங்களில் Rs.845 எனில் கூடுதல் கண்டறி ? ","A sum of money at simple interest amount to Rs.815 in 3 years and to Rs.845 in 4 years.The sum is?","Rs.650","Rs.690","Rs.698","Rs.700",3, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q6);
        Test_Question q7=new Test_Question("5 வருடங்களில் தனிவட்டி கூடுதல் Rs.9800,அதுவே 4 வருடங்களில் Rs.12005 எனில் அதன் வட்டி விகிதம் காண்க ?","A sum of money amount to Rs.9800 after 5 years and Rs.12005 after 8 years at the same rate of simple interest. the rate of interest per annum is?","12%","8%","5%","15%",1, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q7);
        Test_Question q8=new Test_Question("ரீனா தனிவட்டி முறையில்,தனிவட்டி விகிதத்திற்கு நிகரான ஆண்டுகளுக்கு  Rs.1200 ஐ கடனாக பெறுகிறார், அவர் Rs.432ஐ கடன் காலம் முடியும் போது செலுத்துகிறார்,எனில் தனிவட்டி விகிதம் என்ன ?","Reena took a loan of Rs.1200 with simple interest for as many years as the rate of interest.If she paid Rs.432 as interest at the end of the loan period, What was the rate of interest?","3.6","6","18","Cannot be determined",2, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q8);
        Test_Question q9=new Test_Question("ஒருவன் வங்கியில் ஆண்டுக்கு 12% தனிவட்டி முறையில் கடன் பெறுகிறார், 3வருடங்களுக்கு அந்த காலத்திற்கு  பிறகு அவர் வட்டியாக Rs.5400 செலுத்தவேண்டும்,எனில் அவர் பெற்ற கடன்தொகை என்ன ?","A Man took a loan from a bank at the rate of 12% p.a simple interest.After 3years he had to pay Rs.5400 interest only for the the period.The principal amount brrowed by him was?","Rs.2000","Rs.10,000","Rs.15,000","Rs.20,000",3, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q9);
        Test_Question q10=new Test_Question("Rs.4016.25ஐ மொத்த தனிவட்டியாக 9% ஆண்டுவட்டியில் 5ஆண்டுகளுக்கு பெற்றால் வைப்பு தொகை என்ன ?","A sum fetched a total simple interest of Rs.4016.25 at the rate of 9% p.a, in 5years,what is the sum?","Rs.8925","Rs.4462.50","Rs.8032.50","None of these",1, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q10);
        Test_Question q11=new Test_Question("Rs.800 3ஆண்டுகளில் குறிப்பிட்ட தனிவட்டி விகிதத்தில் Rs.956ஆக மாறுகிறது, எனில் தனிவட்டி விகிதம் 4% ஆக உயர்கிறது என்றால், Rs.800 3ஆண்டுகளில் என்னவாக இருக்கும்?","Rs.800 becomes Rs.956 in 3years at a certain rate of simple interest. If the rate of interest is increased by 4%, What amount will Rs.800 become in 3 years?","Rs.1020.80","Rs.1025","Rs.1052","Data inadeuate",3, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q11);
        Test_Question q12=new Test_Question("Rs.150 8% வட்டிவிகிதத்தில் எத்தனை வருடங்களில், Rs.800 3வருடங்களில் 4.5%வட்டிவிகிதத்தில் வட்டி  தருவதுபோல் வட்டியை தரும்? ","In how many years, Rs.150 will produce the same interest at 8% as Rs.800 produce in 3 years at 4.5 %?","6","8","9","12",3, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q12);
        Test_Question q13=new Test_Question("ஒரே வட்டிவிகிதத்தில் ஒரு குறிப்பிட்ட தொகை 3 மற்றும் 6 வருடங்களில் தரும் வட்டியின் விகிதம் கண்டறி ?","What will be the ratio of simple interest earned by certain amount at the same rate of interest for 3years and that for 6years?","1:2","1:4","2:3","None of these",1, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q13);
        Test_Question q14=new Test_Question("ரூ. 20,000 க்கு 5% ஆண்டு வட்டி விகிதத்தில் 3 மாதங்களுக்கு தனி வட்டி யாது? ","What is the Simple interest earned on Rs. 20,000 invested 3 month at a rate of 5% per annum?","Rs. 250/-","Rs. 100/-","Rs. 125/-","Rs. 500/-",1, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q14);
        Test_Question q15=new Test_Question("ஒரு குறிப்பிட்ட தொகையானது எத்தனை வருடங்களில் 8% தனிவட்டி விகிதத்தில் மூன்று மடங்காக அதிகரிக்கும்? ","A sum of money triples itself at simple interest 8% per annum over a certain time. Find the number of years.","8 years","15 years","23 years","25 years",4, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q15);
        Test_Question q16=new Test_Question("ஒரு முதலீட்டாளர் பிரதி மாதம் தனி வட்டியாக ரூ. 10,000 பெற விரும்புகிறார். வட்டி வீதம்  ஆண்டுக்கு 8% எனில் அவர் முதலீடு செய்ய வேண்டிய தொகை என்ன? ","If an investor wants to receive Rs. 10,000 as simple interest every month and rate of interest is 8% per annum then the amount he should invest is","Rs. 25 lakhs","Rs. 20 lakhs","Rs. 15 lakhs","Rs. 8 lakhs  ",3, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q16);
        Test_Question q17=new Test_Question("ஒரு தொகை 8% ஆண்டு தனிவட்டி முறையில் இரட்டிப்பாக மாற எத்தனை ஆண்டுகள் ஆகும்? ","In how many years will a sum of money doubles itself at 8% SI per annum?","12 and 1/2 years","13 and 1/2 years","14 years","15 years",1, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q17);
        Test_Question q18=new Test_Question("ரூ. 4000 – 2 ஆண்டுகளில் 5% வருட வட்டிவீத முறையில் தனிவட்டிக்கும், கூட்டு வட்டிக்கும் இடையே உள்ள வித்யாசம் ","The difference between the compound interest and simple interest on Rs. 4,000 at 5% per annum for 2 years is","Rs. 10","Rs. 11","Rs. 20","Rs. 100",1, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q18);
        Test_Question q19=new Test_Question("பத்து ஆண்டிற்குப் பிறகு ரம்யாவிற்கு ரூ. 9,00,000 தேவைப்படுகிறது எனில் ஆண்டிற்கு 20% தனி வட்டி அளிக்கும் வங்கியில், எவ்வளவு அசலாக செலுத்த வேண்டும் ?","If Ramya needs Rs. 9,00,000 after ten years, how much should she invest in a bank pays 20% simple interest","Rs. 2,00,000","Rs. 3,00,000","Rs. 4,00,000","Rs. 5,00,000",2, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q19);
        Test_Question q20=new Test_Question("ஒரு தொகையானது குறிப்பிட்ட வருடத்தில் 8% வட்டி விகிதத்தில் அதன் அசலை போல் 5மடங்கு தொகையை தருகிறது எனில் வருடங்களின் எண்ணிக்கை என்ன? ","A sum of money increases 5 times its principal at 8% per annum over a certain year. Find the number of years?","25","50","75","100",2, Test_Question.CATEGORY_SIMPLEINTEREST);
        addQuestion(q20);
    }

    private void addTimeAndDistance(){
        Test_Question q1=new Test_Question("ஒருவர் கிராமத்தில் இருந்து அஞ்சலகத்திற்கு 25kmph வேகத்திலும் மீண்டும் திரும்பி 4kmph வேகத்தில் வருகிறார்,மொத்த பயணம் 5hour 48min எடுக்கிறது எனில், அஞ்சலகத்திற்கும், கிராமத்திற்கும் இடையேயான தூரம் ?","A man travelled from the village to the post-office at the rate of 25kmph and walked back at the rate of 4kmph. If the whole journey took 5 hours 48 minutes find the distance of the post-office from the village?","20km","29km","32km","45km",1, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q1);
        Test_Question q2=new Test_Question("ஒரு ஓட்ட வீரர் 200மீட்டர்ஐ 24 sec ல் கடக்கிறார்,எனில் அவர் வேகம் ?","An athlete runs 200 meters race in 24 seconds.His speed is?","20km/hr","24km/hr","28.5km/hr","30km/hr",1, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q2);
        Test_Question q3=new Test_Question("ஒரு அதிவேக ரயில் சராசரியாக 100km/hr வேகத்தில் செல்கிறது,ஒவ்வொரு 75km  க்கும்  3நிமிடங்கள் நிற்கிறது,எனில் 600km தூரத்தை அடைய எடுத்துக்கொள்ளும் நேரம்?","The express train travelled at an average speeed of 100km/hr, stopping for 3 minutes after every 75km.how long did it take to reach its destination 600km from the starting point?","6hr 21mins","6hr 24 mins","6hr 27 mins","6hr 30 min",1, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q3);
        Test_Question q4=new Test_Question("ஒரு காரின் வேகம் ஒவ்வொரு மணி நேரத்திற்கும் 2km அதிகரிக்கிறது, முதல் ஒரு மணிநேரத்தில் கடந்த தொலைவு 35km எனில்,12 மணி நேரத்தில் கடந்த மொத்த தொலைவு ?","The speed of a car increases by 2kms after every one hour. if the distance travelled in the first one hour was 35kms, what was the total distance travelled in 12 hours?","456kms","482ms","552kms","556kms",3, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q4);
        Test_Question q5=new Test_Question("ஒரு ரயில் 10km  தொலைவை 12mins ல் கடக்கிறது, அதன் வேகம் 5km/hr குறைகிறது,அதே தொலைவை கடக்க எடுக்கும் நேரம் ?","A train covers a distance of 10 km in 12 minutes.If its speed is decreased by 5km/hr,the time taken by it to cover the same distance will be?","10 min","11min 20sec","13min","13min 20sec",4, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q5);
        Test_Question q6=new Test_Question("A என்பவர் ஒரு பயணத்தை 10 மணி நேரத்தில் முடிக்கிறார், முதலில் பாதியை 21km/hr வேகத்திலும் இரண்டாம் பாதியை 24km/hr வேகத்திலும் கடக்கிறார்,அவர் கடந்த மொத்த தொலைவு? ","A can complete a journey in 10 hours.He travels first half of the journey at the rate of 21km/hr and second half at the rate of 24 km/hr .find the total journey in km?","220km","224km","230km","234km",2, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q6);
        Test_Question q7=new Test_Question("ஒருவர் சமமான தொலைவை 3km/hr, 4km/hr, 5km/hr வேகத்தில் 47minல்  கடக்கின்றார்,எனில் கடந்த மொத்த தொலைவு ?","A person travels equals distance with speed of 3 km/hr, 4 km/hr and 5 km/hr and take a total time of 47 minutes. the total distance is(in km)?","2","3","4","5",2, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q7);
        Test_Question q8=new Test_Question("ஒரு உழவர் 61km ஐ  9மணி நேரத்தில் கடக்கிறார், அவர் நடந்து 4km/hr ம் , சைக்கிள் ல்  9km/hr ம் கடக்கிறார், அவர் நடந்து சென்ற தொலைவு ?","A farmer travelled a distance of 61km in 9 hours.He travelled partly on foot at 4 km/hr and partly on bicycle at 9 km/hr .the distance travelled on foot is?","14km","15km","16km","17km",3, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q8);
        Test_Question q9=new Test_Question("A என்பர் Bஐ விட வேகமானவர்,A மற்றும் B ஒவ்வொருவரும் 24km நடக்கின்றனர். அவர்களின் வேகங்களின் கூடுதல் 7km/hr மற்றும் அவர்கள் எடுத்துக்கொண்ட நேரம் 14 மணிநேரம், எனில் Aன் வேகம் ?","A is faster than B. A and B each walk 24km. The sum of their speed is 7 km/hr and the sum of times taken by them is 14 hours.then A's speed is equals to?","3 km/hr","4 km/hr","5 km/hr","7 km/hr",2, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q9);
        Test_Question q10=new Test_Question("ஒருவர் P என்ற இடத்தில் இருந்து Q என்ற இடத்திற்கு 40kmph வேகத்தில் செல்கின்றார்,திரும்பி வரும்போது தனது வேகத்தில் 50%  அதிகரித்து பயணிக்கிறார்,எனில் அவரின் சராசரி வேகம் ?","A person travels from P to Q at a speed of 40 kmph and returns by increasing his speed by 50%.What is his average speed for both the trips?","36 kmph","45 kmph","48 kmph","50 kmph",3, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q10);
        Test_Question q11=new Test_Question("ஒரு பையன் தனது வீட்டில் இருந்து பள்ளிக்கு 3km/hr செல்கிறான், திரும்பி வரும்போது 2km/hr வேகத்தில் வருகிறான், அவன் போய் வருவதற்கு 5மணிநேரம் ஆகிறது எனில் வீட்டிற்கும் ,பள்ளிக்கும் இடைப்பட்ட தொலைவு? ","A boy goes to his school form his house at a speed of 3 km/hr and returns at a speed of 2 km/hr.If he takes 5 hours in going and coming, the distance between his house and school is?","5km","5.5km","6km","6.5km",3, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q11);
        Test_Question q12=new Test_Question("ஒருவர் பயணத்தின் போது முதல் 160km ஐ 64km/hr வேகத்திலும் அடுத்த 160km ஐ 80 km/hr வேகத்திலும் கடக்கிறார்,எனில் முதல் 320km தொலைவுக்கான சராசரி வேகம்? ","A man on tour travel first 160 km at 64 km/hr and the next 160 km at 80 km/hr .The average speed for the first 320km of the tour is?","35.55 km/hr","36 km/hr","71.11 km/hr","71 km/hr",3, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q12);
        Test_Question q13=new Test_Question("நிறுத்தங்களை சேர்க்காமல் ஒரு பேருந்தின் வேகம் 54kmph, நிறுத்தங்களை சேர்த்தால் 45kmph,எனில் ஒருமணி நேரத்திற்கு பேருந்து எவ்வளவு நேரம் நிற்கும் ?","Excluding stoppages, the speed of a bus is 54 kmph and including stoppages, it is 45kmph. for how many minutes does the bus stop per hour?","9","10","12","20",2, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q13);
        Test_Question q14=new Test_Question("30km தொலைவை கடக்க அபி ,சமீரை விட 2மணிநேரம் அதிகம் எடுக்கிறான்.அபி தனது வேகத்தை 2மடங்கு அதிக படுத்தினால் சமீரை விட ஒரு மணிநேரம் குறைவாக எடுத்திக்கொள்வான்,எனில் அபியின் வேகம் ?","In-covering a distance of 30km, Abi takes 2 hours more than Sameer.if abi doubles his speed, then he would take 1 hour less than sameer.Abi's speed is?","5 kmph","6 kmph","6.25 kmph","7.5 kmph",1, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q14);
        Test_Question q15=new Test_Question("ஒருவர் 10km/hr வேகத்திற்கு பதிலாக 14km/hr வேகத்தில் நடந்தால் 20km அதிகமாக நடந்து விடுகிறார், அவர் சரியாக கடக்க வேண்டிய தொலைவு?","If a person walks at 14 km/hr instead of 10 km/hr, he would have walked 20 km more.the actual distance travelled by him is?","50 km","56 km","70 km ","80 km",1, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q15);
        Test_Question q16=new Test_Question("ஒரு திருடன் காரை 2:30pm க்கு திருடுகிறான்,திருட்டு 3:00pm க்கு தெரிய வருகிறது,உரிமையாளர் 75kmph வேகத்தில் வேறொரு காரில் துரத்தினால்,எப்போது திருடனை பிடிப்பார் ?","A thief steals a car at 2.30 pm. and drives it at 60 kmph.the theft is discovered at 3 pm. and the onwer set of in another car at 75 kmph.when will he overtake the thief?","4:30pm","4:45pm","5pm","5.15pm",3, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q16);
        Test_Question q17=new Test_Question("ஒருவர் 15.6 கி.மீ / மணிக்கு வேகத்தில் மிதிவண்டியில் பயணிக்கிறார். அவர் இரண்டு நிமிடங்களில் எவ்வளவு தூரம் கடந்திருப்பார் ? ","A Man cycles at the rate of 15.6 kmph. How many metres does he cover in 2 minutes?","31.2 m","260 m","520 m","5200 m",3, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q17);
        Test_Question q18=new Test_Question("A என்ற இடத்தில் இருந்து B 600 கி.மீ. தூரத்தில் உள்ளது. அக்பர் A யிலிருந்து B எனும் இடத்திற்கு மணிக்கு 40 கி.மீ. வேகத்திலும் , B யிலிருந்து A எனும் இடத்திற்கு மணிக்கு 60 கி.மீ. வேகத்திலும் சென்றால் , சராசரி வேகம் என்ன? ","If the distance from A to B is 600 km and Akbar goes from A to B at a speed 40 km per hour and returns from B to A at a speed of 60 km per hour the overall average speed is","45 km per hour","48 km per hour","50 km per hour","52 km per hour",2, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q18);
        Test_Question q19=new Test_Question("ஒரு கார் மணிக்கு 60 கி.மீ வேகத்தில் 2 மணி நேரம் பயணிக்கிறது. பின் 4 மணி நேரத்தில் 80 கி.மீ வேகத்தில் செல்கிறது எனில் அந்த காரின் சராசரி வேகம்  என்ன?  ","If a car travels at 60 km per hours for 2 hours and then at the speed of 80 km per hour for 4 hours. What is the average speed?","68 kmph","70 kmph","72.1 kmph","73.3 kmph",4, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q19);
        Test_Question q20=new Test_Question("ஒரு ரயில் A என்ற இடத்திலிருந்து B என்ற இடத்திற்கு  6 am  புறப்பட்டு அதே நாளில் 4:30 pm சென்றடைகிறது. அந்த ரயில் 40km/hour  வேகத்தில் சென்றால் அது கடந்த தொலைவு என்ன ?  ","A Train starts from a place A at 6 am and arrivers at another place B at 4.30 pm on the same day. If the speed of the train is 40 km per hour. Find the distance travelled by the train?","42 km","420 km","430 km","480 km",2, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q20);
        Test_Question q21=new Test_Question("ஒருவர் 114மீட்டர் ஒரு பையனுக்கு பின்னாடி நிற்கிறார், அந்த மனிதன்  ஒரு நிமிடத்திற்கு 21மீட்டர் வேகத்தில் செல்கிறார், அந்த பையன் ஒரு நிமிடத்திற்கு 15மீட்டர்  வேகத்தில் சென்றால், அவர்கள் இருவரும் எப்போது சந்திப்பார்கள். ","A man is 114 metres behind a boy. The man runs 21 metres in a minute and the boy runs 15 metres in a minute. In what time they will meet ?","18 min","19 min","20 min","36 min",2, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q21);
        Test_Question q22=new Test_Question("ஒரு வண்டி 360km  ஐ 4மணிநேரத்தில் கடக்கிறது, எனில் அதே வேகத்தில் 6 மணிநேரம் 30 நிமிடம் பயணித்தால் எவ்வளவு தூரம் சென்றிருக்கும். ","A Vehicle travels 360 km in 4hours. Find the distance it covers in 6 hours 30 mins. at the same speed.","585km","575km","625km","685km",1, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q22);
        Test_Question q23=new Test_Question("ஒரு ரயில் 80km/hr வேகத்தில் சென்றால் ஒரு இடத்தை 6மணிநேரத்தில்  சென்றடைகிறது எனில் அந்த இடத்தை 4மணிநேரத்தில் சென்றடைய எந்த வேகத்தில் செல்லவேண்டும்? ","A train running at 80 km/hr , reaches a place in 6 hours . In what speed should it run in order to reach the place in 4 hours ?","90km/hr","100km/hr","110km/hr","120km/hr",4, Test_Question.CATEGORY_TIMEDISTANCE);
        addQuestion(q23);

    }

    private void addTimeAndWork(){
        Test_Question q1=new Test_Question("A ஒரு  வேலையை 10 நாட்களில் முடிக்கிறார், B அதே வேலையை 15 நாட்களில் முடிக்கிறார். இருவரும் சேர்ந்து அந்த வேலையை முடிக்க ஆகும் நாட்கள் ?","A does a work in 10 days and B does the same work in 15 days.In how many days they together will do the same work?","5 days","6 days","8 days","9 days",2, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q1);
        Test_Question q2=new Test_Question("A ஒரு  வேலையை 18 நாட்களில் முடிக்கிறார், B அதே வேலையை A வின் நேரத்தில் பாதி  எடுக்கிறார்  இருவரும் சேர்ந்து ஒருநாளில் முடிக்கும் வேலை ?","A can finish a work in 18 days and B can do the same work in half the time taken by A, then working together, what part of the same work they can finish in a day?","1/6","1/9","2/5","2/7",1, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q2);
        Test_Question q3=new Test_Question("A ஒரு  வேலையை 15 நாட்களில் முடிக்கிறார், அவரின் தந்தை அந்த வேலையை முடிக்க 20 நாட்கள் எடுக்கிறார் மற்றும் அவரது மகன் 25 நாட்கள் எடுக்கிறார். அவர்கள் அனைவரும் சேர்ந்து வேலை செய்தால் எவ்வளவு நேரம் எடுத்துக்கொள்வார்கள் ?","A man can do a job in 15 days, his father takes 20 days and his son finishes it in 25 days. how long will they take to complete the job if they all work together?","less than 6 days","exactly 6 days","approximately 6.4 days","more than 10 days",3, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q3);
        Test_Question q4=new Test_Question("A என்பவர் ஒருவேலையை முடிக்க B போல் 2மடங்கு அல்லது அந்த வேலையை முடிப்பதுபோல் 3மடங்கு நேரம் எடுத்துக்கொள்கிறார்,இருவரும் சேர்ந்து அந்த வேலையை 2நாட்களில் முடிக்கின்றனர்,எனில் B அந்த வேலையை எத்தனை நாட்களில் முடிப்பார் ?","A takes twice as much time as B or thrice as much time to finish a piece of work.Working together, they can finish the work in 2 days.B can do the work alone in?","4 days","6 days","8 days","12 days",2, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q4);
        Test_Question q5=new Test_Question("A மற்றும் B சேர்ந்து ஒரு வேலையை 8நாட்களில் முடிக்கின்றனர்,B மற்றும் C சேர்ந்து அதே வேலையை 12 நாட்களில் முடிகின்றனர், B மற்றும் C சேர்ந்து வேலையை 6 நாட்களில் முடிக்கின்றனர்,எனில் A மற்றும் C சேர்ந்து அந்த வேலையை முடிக்க எடுக்கும் நாள் ?","A and B can do a work in 8 days, B and C can do the same work in 12 days, A,B and C together can finish it in 6 days, A and C together will do it in?","4 days","6 days","8 days","12 days",3, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q5);
        Test_Question q6=new Test_Question("A என்பவர் ஒருவேலையை முடிக்க 4 மணிநேரம் ஆகிறது, B மற்றும் C சேர்ந்து அந்த வேலையை முடிக்க 3 மணிநேரம் ஆகிறது, A  மற்றும் C சேர்ந்து அந்த வேலையை 2 மணிநேரத்தில் முடிக்கின்றனர்,எனில் அந்த வேலையை முடிக்க B எடுத்துக்கொள்ளும் நேரம்? ","A can do a piece of work in 4 hours.B and C together can do it in 3 hours, While A and C together can do it in 2 hours.How long will B alone take to do it?","8 hours","10 hours","12 hours","24 hours",3, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q6);
        Test_Question q7=new Test_Question("A ஒரு வேலையை முடிக்க எடுத்து கொள்ளும் நேரம், B மற்றும் C சேர்ந்து முடிக்க எடுத்து கொள்ளும் நேரத்திற்கு சமம். A  மற்றும் B சேர்ந்து 10 நாட்களில் அந்த வேலையை முடிக்கின்றனர்.C முடிக்க 50நாட்கள் ஆகிறது,எனில் B அந்த வேலையை முடிக்க எடுக்கும் காலம் ?","A can do a certain work in the same time in which B and C together can do it .If A and b together could do it in 10days and C alone in 50 days, then B alone could do it in?","15 days","20days","25 days","30 days",3, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q7);
        Test_Question q8=new Test_Question("A என்பவர் B யை விட 2மடங்கு வேகத்தில் வேலை செய்கிறார்.B 12நாட்களில் அந்த வேலையை முடிக்கிறார் எனில் A  மற்றும் B சேர்ந்து அந்த வேலையை முடிக்க எடுக்கும் நாள் ?","A works twice as fast as B.If B can complete a work in 12 days independently, the number of days in which A and B can together finish the work is?","4 days","6 days","8 days","18 days",1, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q8);
        Test_Question q9=new Test_Question("A ஒரு வேலையை முடிக்க 15நாட்கள் ,B  20நாட்கள் எடுக்கின்றனர், இருவரும் சேர்ந்து 4 நாட்கள் வேலை செய்கின்றனர்,எனில் மீதமுள்ள வேலை எவ்வளவு ?","A can do a work in 15 days and B in 20 days. If they work on it together for 4 days, then the fraction of the work that is left is?.","1/4","1/10","7/15","8/15",4, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q9);
        Test_Question q10=new Test_Question("A மற்றும் B சேர்ந்து ஒரு வேலையை முடிக்க 30 நாட்கள் ஆகிறது, A 16நாட்கள் வேலை செய்கிறார், B மீதமுள்ள வேலையை 44நாட்களில் முடிக்கிறார்.எனில் B அந்த வேலையை தனியே முடிக்க எடுக்கும் நாள் ?","A and B together can do a piece of work in 30 days. A having worked for 16 days, B finishes the remaining work alone in 44 days. In how many days shall B finish the whole work alone?","30 days","40 days","60 days","70 days",4, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q10);
        Test_Question q11=new Test_Question("A மற்றும் B ஒரு வேலையை முடிக்க 45,40 நாட்கள் எடுக்கின்றனர்.இருவரும் சேர்ந்து அந்த வேலையை செய்கின்றனர் அப்போது A அதில் இருந்து விலகுகிறார், B மட்டும் அந்த வேலையை முடிக்க 23நாட்கள் ஆகிறது.எனில் A வேலையை விட்டு சென்ற நாட்கள் ?","A and B can do a piece of work in 45 days and 40 days . They began to do the work together but A leaves after some days and then B completed the remaining work in 23 days . the number of days after Which A left the Work was?","6","8","9","12",3, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q11);
        Test_Question q12=new Test_Question("கிம் 3நாட்களில் ஒரு வேலையை முடிகிறரர்,டேவிட் அதே வேலையை 2நாட்களில் முடிக்கிறார்.இருவரும் சேர்ந்து அந்த வேலையை முடித்தபின் 150Rs பெறுகின்றனர் எனில் கிம்-ன் பங்கு எவ்வளவு ?","Kim can do a work in 3 days while David can do the same work in 2 days, Both of tem finish the work together an get Rs.150 .what is the share of Kim?","Rs.30","Rs.60","Rs.70","Rs.75",2, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q12);
        Test_Question q13=new Test_Question("A மற்றும் B சேர்ந்து ஒரு வேலையை 12 நாட்களில் முடிகின்றனர். A மட்டும் அந்த வேலையை முடிக்க 20 நாட்கள் ஆகிறது.B அந்த வேலையை ஒருநாளில் பாதி மட்டும் வேலை செய்து முடிக்கிறார்,எனில் A மற்றும் B சேர்ந்து அந்த வேலையை முடிக்க எடுக்கும் நாள் ?","A and B together can complete a work in 12 days. A alone can complete it in 20 days. If B does the work only for half a day daily, then in how many days A and B together Will complete the work?","10 days","11 days","15 days","20 days",3, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q13);
        Test_Question q14=new Test_Question("20 பெண்கள் ஒரு வேலையை 16நாட்களில் முடிக்கின்றனர், 16 ஆண்கள் அதே வேலையை 15நாட்களில் முடிக்கின்றனர்.எனில் ஆண் மற்றும் பெண்களின் வேலை திறன் விதம் ?","Twenty women can do a work in 16 days ,16 men can complete the same work in fifteen days.What is the ratio between the capacity of  a man and woman?","3:4","4:3","5:3","none of these",2, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q14);
        Test_Question q15=new Test_Question("12 ஆட்கள் ஒருவேலையை 9நாட்களில் முடிக்கின்றனர், 6 நாட்கள் அவர்கள் அந்த வேலையை தெடர்ந்து பின் மேலும் 6நபர்கள் சேர்கின்றனர்,எனில் மீதமுள்ள வேலையை முடிக்க ஆகும் நாள் ?","12 man can complete a work in 9 days. After they have worked for 6 days,6 more men join them.How many days will take to complete the remaining work?","2 days","3 days","4 days","5days",1, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q15);
        Test_Question q16=new Test_Question("4 ஆண்கள் 6 பெண்கள் ஒரு வேலையை 8நாட்களில் முடிக்கின்றனர்.அதே வேலையை 3ஆண்கள் 7 பெண்கள் சேர்ந்து 10நாட்களில் முடிக்கின்றனர்.10 பெண்கள் சேர்ந்து எத்தனை நாட்களில் அந்த வேலையை முடிப்பார்கள்?  " , "4 men and 6 women can complete a work in 8 days, while 3 men and 7 woment can complete it in 10 days. In how many days will 10 women complete it?","35","40","45","50",2, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q16);
        Test_Question q17=new Test_Question("A என்பவர் ஒரு வேலையை 12 நாட்களில் செய்கிறார் . B என்பவர் A யை விட  60% அதிக திறமையுடையவர். அதே வேலையை B மட்டும் முடிக்க எத்தனை நாட்கள் எடுத்துக் கொள்வார்? " , "A can do a certain job in 12 days. B is 60% more effective than A. How many days does B alone take to do the same job? ","8 days","7 days","7  ½  days","8 ½ days",3, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q17);
        Test_Question q18=new Test_Question("A,B ஆகிய இருவரும் ஒரு வேலையை 6 நாட்களில் செய்து முடிப்பர். B, C ஆகிய இருவரும் அதே வேலையை 10 நாட்களில் செய்து முடிப்பர். C, A ஆகிய இருவரும் சேர்ந்து அந்த வேலையை 7 நாட்களில் செய்து முடிப்பர் எனில் மூவரும் சேர்ந்து அவ்வேலையை எத்தனை நாட்களில் செய்து முடிப்பர்? " , "A, B together do a job in 6 days, B, C together do the same job in 10 days, C, A together do the same job in 7 ½  days. If all three work together in how many days will they complete the job? ","5 days","4 ½  days","4 days","3 days",1, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q18);
        Test_Question q19=new Test_Question("18 மனிதர்கள் ஒரு வேலையை 20 நாட்களில் முடிப்பர். அதே வேலையை 24 மனிதர்கள் முடிக்க தேவையான நாட்கள் " , "If 18 men can do a work in 20 days, then 24 men can do this work in","20 days","25 days","21 days","15 days",4, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q19);
        Test_Question q20=new Test_Question("இரண்டு சிறுவர்கள் சேர்ந்து செய்யும்  போது ஒரு வேலையை 10 நாட்களில் முடிப்பர். முதல் சிறுவன் அவ்வேலையை தனியாக15 நாட்களில் முடித்தால், மற்றொரு சிறுவன் தனியாக அவ்வேலையை எத்தனை நாட்களில் செய்து முடிப்பர்? " , "Two boys can finish a work in 10 days when they work together. The first can do it alone in 15 days. Find in how many days will the second boy do it all by himself? ","24 days","30 days","32 days","40 days",2, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q20);
        Test_Question q21=new Test_Question("ஒரு வேலையை A என்பவர் மட்டும் 60 நாட்களிலும், B என்பவர் மட்டும் 20 நாட்களிலும் செய்ய முடியுமானால் இருவரும் சேர்ந்து அவ்வேலையை செய்ய எவ்வளவு நாட்கள் ஆகும்? " , "If A can do a work in 60 days and B in 20 days. If they work together they complete the work in","10 days","15 days","20 days","17 days",2, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q21);
        Test_Question q22=new Test_Question("A மற்றும் B ஆகிய இருவரும் ஒரு வேலையை செய்கின்றனர் . A, 12 நாட்களில் அவ்வேலையை முடிக்க முடியும். B ஆனவர் அதே வேலையை 20 நாட்களில் முடிக்க முடியும். A, B இருவரும் சேர்ந்து 3 நாட்கள் வேலை செய்த பின் A அவரை விட்டு சென்றுவிட்டனர் எனில் மீதமுள்ள வேலையை B எத்தனை நாட்களில் முடிப்பார்? " , "Two persons A and B are engaged in a work. A can do a piece of work in 12 days and B can do the same work in 20 days. They work together for 3 days and then A goes away. In how many days will B finish the work?","9","10","12","17",3, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q22);
        Test_Question q23=new Test_Question("5 ஆண்கள் மற்றும் 2 பையன்கள் சேர்ந்து செய்யும் வேலையானது , ஒரு ஆண் மற்றும் ஒரு பையன் செய்யும் செய்யும் வேலையைவிட 4மடங்கு வேகத்தில் செய்கின்றனர் எனில் ஒரு ஆண் மற்றும் ஒரு பையனின் வேலைசெய்யும் திறன் விகிதம் கண்டறி ? " ," 5 men and 2 boys working together can do four times as much work as a man and a boy can do then ratio of working capacities of a man and a boy are in the ratio ?","5:2","1:3","2:1","2:5",3, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q23);
        Test_Question q24=new Test_Question("A  என்பவர் Bஐ விட இருமடங்கு வேலை செய்கிறார், இருவரும் சேர்ந்து 18 நாட்களில் வேலையை முடிக்கிறார்கள். A மட்டும் அந்த வேலையை முடிக்க எவ்வளவு நாள் ஆகும் ." , "A is twice as good a workman as B and together they finished a piece of work in 18 days. In how many days A alone finish the work?","26","27","25","24",2, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q24);
        Test_Question q25=new Test_Question("A மற்றும் B சேர்ந்து ஒரு வேலையை 8 நாட்களில் செய்கின்றனர். A மட்டும் அந்த வேலையை 12 நாட்களில் முடிக்கிறார் எனில் B மட்டும் அந்த வேலையை முடிக்க எடுக்க ஆகும் நாள் என்ன ?" , "A and B together can do a piece of work in 8 days, but A alone can do it in 12 days. How many days would B alone take to do the same work?","24 days","16 days","32 days","10 days",1, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q25);
        Test_Question q26=new Test_Question("20 ஆண்கள் ஒரு நாளுக்கு 6மணிநேரம் வேலைசெய்தல் ஒரு வேலையை 4நாட்களில் முடிக்கின்றனர் எனில் 10 ஆண்கள் ஒரு நாளுக்கு 8மணிநேரம் வேலைசெய்தல் எத்தனை நாட்களில் முடிக்கின்றனர்?" , "20 men working 6 hours a day can finish a work in 4 days. In how many days can 10 men working 8 hours a day finish the work?","8 days","6 days","4 days","10 days",2, Test_Question.CATEGORY_TIMEWORK);
        addQuestion(q26);

    }

    private void addProfitLoss(){
        Test_Question q1=new Test_Question("33 மீட்டர் துணியை விற்கும்போது ஒருவர் 11 மீட்டர் துணி விற்பதற்கான லாபம் பெறுகிறார் எனில் லாப%?","By selling 33 metres of cloth, one gains the selling price of 11 metres find the gain percent?","20%","89%","50%","9.3%",3, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q1);
        Test_Question q2=new Test_Question("ஒருவர் ஒரு புத்தகத்தை 20% நட்டத்தில் விற்கிறார், அதுவே அவர் அதை 100rs உயர்த்தி விற்றால் 5% லாபம் கிடைக்கிறது.அந்த புத்தகத்தின் விலை?","A man sold an article at a loss of 20%.If the selling price had been increased by Rs.100, there would have been a gain of 5% . what ws the cost price of the article?","Rs.500","Rs.486","Rs.400","Rs.963",3, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q2);
        Test_Question q3=new Test_Question("ஒருவர் குதிரை மற்றும் வண்டியை 3000rsக்கு வாங்குகிறார், குதிரையை 20% லாபத்திற்கும், வண்டியை 10% நட்டத்திற்கும் விற்கிறார், மொத்தமாக 2% லாபம் கிடைக்கிறது.குதிரையின் வாங்கிய விலை?","A man bought a horse and a carriage for Rs. 3000. He sold the horse at a gain of 20% and the carriage at a loss of 10 %, there by gaining 2% on the whole. Find the cost of the horse?","Rs.1500","Rs.1236","Rs.1200","Rs.1300",3, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q3);
        Test_Question q4=new Test_Question("பீட்டர் ஒரு இயந்திரத்தை 80,000rsக்கு வாங்கி 5000rs செலவுசெய்து மற்றும் 1000rs போக்குவரத்துக்கு செலவுசெய்து 25% லாபத்திற்கு விற்கிறான்,எனில் அவன் வாங்கிய விலை என்ன?","Peter purchased a machine for Rs.80,000 and spent Rs.5000 on repair and Rs.1000 on transport and sold it with 25% profit.At what price did he sell the machine?","Rs.1,50,100","Rs.1,06,250","Rs.1,07,500","None of these",3, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q4);
        Test_Question q5=new Test_Question("வாங்கிய விலை மற்றும் விற்ற விலைக்கு இடையேயான விகிதம் 4:5,எனில் அதன் லாப சதவீதம்?","The ratio of the cost price and the selling price is 4:5 the profit percent is:","10%","20%","25%","30%",3, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q5);
        Test_Question q6=new Test_Question("ஒருவர் ஒரு புத்தகத்தை விற்பதான் மூலம் 20% லாபம் அடைகிறார்.அவர் அதை இருமடங்கிற்கு விற்றால் லாபம் என்ன?","A man gain 20% by selling an article for a certain price. If he sells it at double the price, the percentage of profit will be?","40","100","120","140",4, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q6);
        Test_Question q7=new Test_Question("ஒரு புத்தகத்தை Rs.832க்கு விற்றால் கிடைக்கும் லாபம் அந்த புத்தகத்தை Rs.448 க்கு விற்றால் கிடைக்கும் நட்டத்திற்கு சமம், எனில் 50% லாபம் பெறுவதற்கான விற்பனை விலை என்ன?","The profit earned by selling an article for Rs.832 is equal to the loss incurred when the same article is sold for Rs.448 what should be the sale price for making 50% profit?","Rs.600","Rs.750","Rs.800","None of these",2, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q7);
        Test_Question q8=new Test_Question("20 புத்தகங்களின் அடக்க விலை, x எண்ணிக்கை புத்தகங்களை விற்பதற்கு சமம், லாபம் 25% எனில் x ன் மதிப்பை கண்டறி?","The Cost price of 20 articles is the same as the selling price of x articles.If the profit is 25%,then the value of x is?","15","16","18","25",2, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q8);
        Test_Question q9=new Test_Question("ஒருவர் 18 கட்டில்களை Rs.16,800 க்கு விற்கிறார், அதில் அவர் 3 கட்டில்கள் விற்பதற்கான லாபம் அடைகிறார்,எனில் ஒரு கட்டிலின் விலை?","A man sold 18 cots for Rs.16,800,gaining thereby the cost price of 3 cost. the cost price of a cot is?","Rs.630","Rs.700","Rs.750","Rs.800",4, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q9);
        Test_Question q10=new Test_Question("7 பந்துகள் 720Rsக்கு விற்கப்படுகிறது.இதில் அடையும் நட்டம் 5 பந்துகளின் விலைக்கு சமம்,எனில் ஒரு பந்தின் விலை?","On selling 17 balls at Rs.720, there is a loss equal to the cost price of 5 balls. the cost price of a ball is?","Rs.45","Rs.50","Rs.55","Rs.60",4, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q10);
        Test_Question q11=new Test_Question("ஒருவன் 2 டஜன் வாழைப்பழத்தை, டஜன் Rs.16க்கு வாங்கி, 18 வாழைப்பழங்களை டஜன் 4Rs குறைத்து 12Rs என்ற விலைக்கு விற்றால்,அவர் அடையும் நட்ட சதவீதம்?","A man buys 2 dozen bananas at Rs16 per dozen, after selling 18 bananas at the rate of Rs.12 per dozen, the shopkeeper reduced the rate to Rs.4 per Dozen. the Percent loss is?","25.2%","32.4%","36.5%","37.5%",4, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q11);
        Test_Question q12=new Test_Question("ஒருவர் 8 ஆப்பிள்கள் 32Rs  என்ற விலைக்கு வாங்கி அதை 12 ஆப்பிள்கள் 57Rs  விற்கிறார்,எனில்  45Rs  லாபம் பெற எத்தனை ஆப்பிள்கள் விறக்கவேண்டும் ?","A man bought apples at the rate of 8 for Rs.34 and sold them at the rate of 12 for Rs.57. How many apples should be sold to earn a net profit of Rs.45?","90","100","135","150",1, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q12);
        Test_Question q13=new Test_Question("ஒருவன் 16 பழங்களை 24Rs க்கு வாங்குகிறான், அதை 8 பழங்கள் 18Rs க்கு விற்கிறான்,எனில் லாப சதவீதம் என்ன ?","A man bought some fruits at the rate of 16 for Rs 24 and sold them at the rate of 8 for Rs.18,What is the profit percent?","25%","50%","40%","60%",2, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q13);
        Test_Question q14=new Test_Question("12 மிட்டாய்களை ஒரு ரூபாய்க்கு விற்றால் ஒருவன் 20% நட்டம் அடைகிறான், அவன் எத்தனை மிட்டாய்களை விற்றால் 20% நட்டம்  கிடைக்கும் ?","By selling 12 toffess for a Rupee,a man loses 20%. how many should he sell to get a gain of 20%?","15","5","8","10",3, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q14);
        Test_Question q15=new Test_Question("ஒரு கடைக்காரர் 10% லாபத்தை தனது சரக்குகளில் பெறுகிறார் . 20% சரக்குகளை ஒரு திருட்டில் இழக்கிறார், அவர் அடைந்த நட்ட சதவீதம் என்ன ?","A fair price shopkeeper takes 10% profit on his goods. He lost 20% goods during theft.His loss percent is?","8","10","11","12",4, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q15);
        Test_Question q16=new Test_Question("A என்பவர் B யிடம் தனது சைக்கிள்ஐ  20% லாபத்தில் விற்கிறார், B அந்த சைக்கிள்ஐ  Cயிடம் 25% லாபத்தில் விற்கிறார்,அதாவது Cஅதை 225Rs க்கு வாங்குகிறார், எனில் Aஅந்த சைக்கிள்ஐ விற்ற விலை ? ","A sells a bicycle to B at a profit of 20%, B sells it to C at a profit of 25%.If C pays Rs.225 for it,the cost price of the bicycle for A is?","Rs.110","Rs.120","Rs.125","Rs.150",4, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q16);
        Test_Question q17=new Test_Question("A என்பவர் ஒரு புத்தகத்தை 10% அதன் மதிப்பு குறைவாக வாங்குகிறார்.மீண்டும் அதை  10% அதிகமா விற்கிறார்.எனில்  அவரின் லாப அல்லது நட்ட சதவீதம்?","A man buys an article for 10% less than its value and sells it for 10% more than its value.His gain or loss percent is?","no profit,no loss","20% profit","less than 20% profit","more than 20% profit",4, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q17);
        Test_Question q18=new Test_Question("ஒரு புத்தகத்தை 340Rs க்கு விற்பதற்கு பதிலாக 350Rs க்கு விற்றால் 5% லாபம் கிடைக்கிறது, எனில் அந்த புத்தகத்தின் அடக்க விலை என்ன ?","If 5% more is gained by selling an article for Rs.350 than by selling it for Rs.340, the cost of the article is?","Rs.50","Rs.160","Rs.200","Rs.225",4, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q18);
        Test_Question q19=new Test_Question("ஒருவர் மின்விசிறியை 400Rs இல் இருந்து 380Rs க்கு  விற்கும் போது,2% நட்டம்  அடைகிறார்.எனில் அதன் அடக்க விலை ?","If a man reduces the selling price of a fan from Rs.400 to Rs.380, his loss increases by 2%. The cost price of the fan is?","Rs.480","Rs.500","Rs.600","none of these",4, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q19);
        Test_Question q20=new Test_Question("ஒரு மனிதன் முதல் நாளில் ரூ. 20 சம்பாதித்து அடுத்த நாள் ரூ. 15 செலவு செய்கிறார் . மீண்டும் மூன்றாம் நாள் ரூ. 20 சம்பாதித்து நான்காம் நாள் ரூ. 15  செலவிடுகிறார் . இவ்வாறே அவர் சேமிப்பை செய்கிறார் எனில் ரூ. 60 எவ்வளவு சீக்கிரம் அவரது வகயில் இருக்கும்?","A man earns Rs. 20 on the first day and spends Rs. 15 on the next day. He again earns Rs. 20 on the 3rd day and spends Rs. 15 on the fourth day. If he continues to save like this, how soon will he have Rs. 60 in hand?","On 17th day","On 22nd day","On 30th day","On 40th day",1, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q20);
        Test_Question q21=new Test_Question("ஓருவர் 33 மீட்டர் துணியை விற்பதன் மூலம் 11 மீட்டருக்கான விற்பனை விலையை லாபமாக பெறுகிறார் , எனில் அவரது லாப விழுக்காட்டை கண்டுபிடி?","By selling 33 meters of cloth, one gains the selling price of 11 meters. Find the gain percent.","25%","30%","35%","50%",4, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q21);
        Test_Question q22=new Test_Question("ஒரு பழ வியாபாரி 10 பொட்டி திராச்சைகளை ஒரு பெட்டிக்கு ரூ. 210 வீதம் வாங்கினார். அதில் ஒரு பெட்டி திராச்சை அழுகி விடுகிறது. மீதமுள்ள பெட்டிகளை ஒரு பெட்டிக்கு ரூ. 250 என்ற விலைக்கு விற்கிறார் எனில் இலாப / நட்ட சதவீதம்  என்ன?","A Fruit seller bought 10 boxes of grapes at Rs. 210 each. One box was damaged. He sold the remaining boxes ar Rs. 250 each. Find the profit / loss percentage","7.14% Loss","10.14% Loss","7.14% Profit","10.14% Profit",3, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q22);
        Test_Question q23=new Test_Question("ஒரு பொருள் அதன் உற்பத்தி விலையிலிருந்து 50% அதிகமாக விற்பனை விலை குறிக்கப்படுகிறது. மேலும் அதில் 40% தள்ளுபடி அறிவித்தால் அவருக்கு லாப / நட்ட  சதவீதம் ","An article is marked 50% above the cost price upon the production price and a discount of 40% is allowed. Then the gain or loss Percentage is","10% loss","12% loss","9% loss","8% gain",1, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q23);
        Test_Question q24=new Test_Question("ஒருவர் 3 மேசைகள் மற்றும் 12 நாற்காலி இருக்கைகள் ஆகியவற்றை ரூ. 2,400 க்கு வாங்குகிறான். மேசைகளை 20% லாபத்திற்கும் நாற்காலி இருக்கைகள் 10% இலாபத்திற்கும் விற்கும் போது ரூ. 300 லாபமாக பெறுகிறார் எனில் ஒரு மேசையை எந்த விலைக்கு வாங்கியிருப்பான்? ","A man buys 3 tables and 12 chairs for Rs. 2,400. He sells the tables at a profit 20% and chairs at a profit of 10% and makes a total profit of Rs. 300. At what price did he buy one table? ","Rs. 100","Rs. 200","Rs. 300","Rs. 250",2, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q24);
        Test_Question q25=new Test_Question("ஒரு பொருளின் அடக்க விலையைவிட  குறித்த விலையானது 20% அதிகம். 10% தள்ளுபடி தரப்படுகிறது. தள்ளுபடிக்கு பின் பொருளின் விலை ரூ.518.40, எனில் அப்பொருளின் அடக்க விலை என்ன? ","The marked price of an article is 20% more than its cost price. A discount of 10%is given. After discount the price is Rs. 518.40 What is the cost price?","480","576","596","598",1, Test_Question.CATEGORY_PROFITLOSS);
        addQuestion(q25);

    }

    private void addPercentage(){
        Test_Question q1=new Test_Question("5:4 ஐ சதவீதம் ஆக மாற்றுக.","The ratio 5:4 expressed as a percent equals?","12.5%","40%","80%","125%",4, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q1);
        Test_Question q2=new Test_Question("3.5 ஐ சதவிதமாக மாற்றுக?","3.5 can be expressed in terms of percentafe as?","0.35%","3.5%","35%","350%",4, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q2);
        Test_Question q3=new Test_Question("88% of 370 + 24% 210 -?=118","88% of 370 + 24% 210 -?=118","256","258","268","358",2, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q3);
        Test_Question q4=new Test_Question("45% of 750 - 25% 480=?","45% of 750 - 25% 480=?","216","217.50","236.50","245",2, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q4);
        Test_Question q5=new Test_Question("?% of 932 + 30= 309.6","?% of 932 + 30= 309.6","25","30","35","40",2, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q5);
        Test_Question q6=new Test_Question("ஒரு எண்ணின் 35%=175, எனில் 175இல் எத்தனை சதவீதம் அந்த எண்?","If 35% of a number is 175, then what percent of 175 is that number?","35%","65%","280%","none of these",3, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q6);
        Test_Question q7=new Test_Question("ஒரு தேர்வில் 35% மாணவர்கள் தேர்வடைந்தார்கள், 455 பேர் தோல்வியடைந்தார்கள், தேர்வை எழுதியவர்கள் எத்தனை பேர்?","In an examination 35% of students passed and 455 failded. how many students appeared for the examination?","490","700","845","1300",2, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q7);
        Test_Question q8=new Test_Question("ஒரு நகரின் மக்கள்தொகை 1,75,000ல் இருந்து 2,62,500 ஆகா உயர்கிறது, ஒவ்வொரு ஆண்டும் உயர்ந்த மக்கள்தொகையின் சராசரி சதவீதம் ?","The population of a town increased from 1,75,000 to 2,62,500 in a decade. the average percent increase of population per year is?","4.37%","5%","6%","8.75%",2, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q8);
        Test_Question q9=new Test_Question("pன் p% =36,எனில் p=?","If p% of p is 36, then p is equal to ?","15","60","600","3600",2, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q9);
        Test_Question q10=new Test_Question("ஒரு TV ன் விலை 25% குறைகிறது அதே நேரத்தில் 20% அதன் விற்பனை அதிகரிக்கிறது,எனில் அதன் வருவாய் என்ன?","The price of a T.V set is decreased by 25% as a result of which the sale increased by 20%. What will be the effect on the total revenue of the shop?","5% decrease","5% increased","10% increased","none of these",3, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q10);
        Test_Question q11=new Test_Question("தானியத்தின் விலை 16% குறைகிறது,எனில் அதன் பட்ஜெட் மாறாமல் ஒரு நபரின் பயன்பாட்டை உயர்த்துவதற்கான % ?","The price of wheat falls by 16%, by what percentage a person can increase the consumption of wheat so that his overall budget does not change?","16%","18%","18.5%,","19%",4, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q11);
        Test_Question q12=new Test_Question("ஒரு இயந்திரத்தின் தேய்மான % 20, 3 வருடங்களுக்கு பின் அதன் மதிப்பை எவ்வளவு குறைந்திருக்கும்?","Depreciation applicable to an equipment is 20% The value of the equipment 3 years from now will be less by?","45%","48.8%","51.2%","60%",2, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q12);
        Test_Question q13=new Test_Question("ஒரு நகரின் மக்கள்தொகை ஆண்டுக்கு 5% உயர்கிறது, 2001ல் அதன் மக்கள்தொகை 1,38,915 எனில் 1998ல் மக்கள் தொகை என்ன?","The population of a town increases by 5% annually, if its population in 2001 was 1,38,915, what it was in 1998?","1,00,000","1,80,000","1,10,000","1,20,000",4, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q13);
        Test_Question q14=new Test_Question("இரண்டு எண்கள் மூன்றாவது எண்னை விட 30%, 37% சிறியது,எனில் இரண்டாம் எண் முதலாம் எண்ணைவிட எத்தனை % சிரியது?","Two numbers are less than a third number by 30% and 37 % respectively. How much percent is the second number less than the first?","3%","4%","7%","10%",4, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q14);
        Test_Question q15=new Test_Question("Aன் வருமானம் Bன் வருமானத்தில் 40%, Bன் வருமானம் Cன் வருமானத்தில் 25% எனில், Aன் வருமானம் Cன் வருமானத்தில் எத்தனை %?","A's salary is 40% of B's salary which is 25% of C's salary.What percentage of C's salary is A's salary?","5%","10%","15%","20%",2, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q15);
        Test_Question q16=new Test_Question("பீட்டர் ,ஆல்பர்ட்ஐ விட 40% அதிகம் சம்பதிக்கிறான்.ஆல்பர்ட், மைகேல்ஐ விட 20% குறைவாக சம்பதிக்கிறான்,எனில் மைகேல்ஐ விட பீட்டர் எவ்வளவு% அதிகம் சம்பதிக்கிறான்?","peter earned 40% more money than albert. albert earned 20% less than michael. How much peter earned more than Michael by?","10%","12%","20%","25%",3, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q16);
        Test_Question q17=new Test_Question("பழங்கள் 68% தண்ணீர் கொண்டுள்ளன, வறல்பழங்கள் 20% தண்ணீர் கொண்டுள்ளன.எனில் 100g பழங்களில் இருந்து எவ்வளவு வறல்பழங்கள் பெறலாம்?","Fresh fruit contains 68% water and dry fruit contains 20% water. how much dry fruit can be obtained from 100kg of fresh fruits?","32kg","40kg","52kg","80kg",2, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q17);
        Test_Question q18=new Test_Question("பாலானது 5% தண்ணீர் கொண்டுள்ளது, 10 லிட்டர் பாலின் எத்தனை லிட்டர் பால் சேர்த்தால் அதில் இருக்கும் தண்ணீர் 2% ஆகா குறையும்?","Milk contains 5% water . What quantity of pure mil should be add to 10 litres of mil to reduce this to 2%?","5 liters","7 liters","15 liters","none of these",3, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q18);
        Test_Question q19=new Test_Question("அரிசியின் விலை 2% குறைகிறது, குறைவதற்கு முன் 49kg அரிசிக்கு தேவையான பணத்திற்கு இப்போது எவ்வளவு kg அரிசி வாங்கலாம்?","The price of raice is reduced by 2% . How many kilograms of rice can now be bought for the money which was sufficient to buy 49 kg of rice earlier?","48kg","49kg","50kg","51kg",3, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q19);
        Test_Question q20=new Test_Question("பால்சன் என்பவர் அவரது வருமானத்தில் 75% செலவு செய்கிறான். அவனது வருமானம் 20% அதிகரிக்கப்படுகிறது. அவன் தனது செலவை  10% அதிகரிக்கிறான் எனில் அவனது சேமிப்பில் எத்தனை விழுக்காடு அதிகரிக்கிறது?","Paulson spends 75% of his income. His income is increased by 20% and he increased his expenditures by 10%. Find the Percentage increase in his savings.","27%","50%","30%","28%",2, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q20);
        Test_Question q21=new Test_Question("1 முதல் 50 வரை உள்ள எண்களின் ஒன்றாம் இலக்கத்தில் 0 அல்லது 5 உள்ள எண்களின் சதவீதம் யாது?","What percentage of numbers from 1 to 50 have 0 or 5 in the unit’s digit?","5%","10%","15%","20%",4, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q21);
        Test_Question q22=new Test_Question("ஒரு கிராமத்தில் உள்ள மொத்த மக்கள் தொகை 7600. அதில் கல்வி அறிவு பெற்ற்றவர்கள் 49% எனில் கல்வி அறிவு பெறாதவர்களின்  எண்ணிக்கை யாது?","The Percentage of literacy in a village is 49%. Find the number of illiterates in the village, if the population is 7600","3876","3724","3742","3867",1, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q22);
        Test_Question q23=new Test_Question("ஒரு குறிப்பிட்ட நாளில், 45 மாணவர்கள் உள்ள ஒரு வகுப்பில் 9 மாணவர்கள் வருகை தரவில்லை எனில், வருகை தந்த மாணவர்களின் சதவீதம்  காண்க?","In a class of 45 students, 9 students were absent on a particular day. What percentage of the students were present?","5%","20%","80%","10%",3, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q23);
        Test_Question q24=new Test_Question("ஒருவருடைய மாத வருமானம் ரூ. 5,000 அவருடைய மாத வருமானம் 30% உயரும் போது மாத வருமானம் என்னவாக இருக்கும்?","The monthly income of a person is Rs. 5,000. If his income is increased by 30% then what is his monthly income? ","Rs. 7,000","Rs. 5,500","Rs. 3,500","Rs. 6,500",4, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q24);
        Test_Question q25=new Test_Question("260 ஐ விட 35% குறைவான எண்ணை கண்டறி ","Find the number which is 35% less than 260.","170","169","168","167",2, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q25);
        Test_Question q26=new Test_Question("ராமனின் வருமானம் 50 சதவீதம் குறைக்கப்படுகிறது மற்றும் பின்னர் 50% உயர்த்தப்படுகிறது எனில் அவர் இழந்த சதவீதம் என்ன ?","Raman salary’s was decreased by 50% and subsequently increased by 50%. How much percent does he lose?","15%","20%","25%","30%",3, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q26);
        Test_Question q27=new Test_Question("ஒரு வியாபாரி ஒரு பத்திரிகையை 20% நட்டத்தில் விற்கிறார், அவர் ஒருவேளை அந்த பத்திரிகையை 100RS  அதிகம் விற்றால் 5% லாபம் பெறுகிறார், எனில் அதன் விலை என்ன ?","A tradesman sold an article at a loss of 20%. If eh selling price had been increased by Rs. 100, these would havce been a gain of 5%. What was the cost price of the article?","Rs 100","Rs 200","Rs 400","Rs 500",3, Test_Question.CATEGORY_PERCENTAGE);
        addQuestion(q27);
    }
    private void addAverage(){
        Test_Question q1=new Test_Question("டேவிட் ஆங்கிலம், கணிதம்,இயற்பியல், வேதியல்,உயிரியலில் 76,65,82,67,85 மதிப்பெண் பெற்றுள்ளார்.அவரின் சராசரி மதிப்பெண்?","David obtained 76,65,82,67 and 85 mark(out of 100) in english, maths, physics,chemistry,biology what are his average mark?","65","69","72","none of these",4, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q1);
        Test_Question q2=new Test_Question("20 எண்களின் சராசரி 0 எனில்,அவற்றுள் எத்தனை எண்கள் 0 மேல் மதிப்பெண் பெற்றிருக்கும்?","The average of 20 numbers is 0, Of them at the most , how many may be greater than zero?","0","1","10","19",1, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q2);
        Test_Question q3=new Test_Question("6கும் 34கும் இடைப்பட்ட 5 ஆல் வகுப்படும் எண்களின் சராசரி காண்க?","Find the average of all the numbers between 6 and 34 which are divisible by 5?","18","20","24","30",2, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q3);
        Test_Question q4=new Test_Question("முதல் 5, மூன்றின் மடங்குகளின் சராசரி காண்க?","Average of the first five multiples of 3 is?","3","9","12","15",2, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q4);
        Test_Question q5=new Test_Question("ஒரு மாணவன் 3,11,7,15,13,8,19,17,21,14,x ஆகியவற்றிற்கு கூட்டுசாரசரி 12 காண்கிறான்.எனில் x ?","A student was asked to find the arithmetic mean of the numbers 3,11,7,9,15,13,8,19,17,21,14 and x. He found the mean to be 12. what should be the number in place of x?","3","7","17","31",2, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q5);
        Test_Question q6=new Test_Question("தொடர்ச்சியான 5 ஒற்றைப்படை எண்களின் கூடுதல் 61எனில்,அதில் மிகப்பெரிய மற்றும் மிகச்சிறிய எண்களுக்கு இடைப்பட்ட வேறுபாடு?","The average of five consecutive odd number is 61. what is the defference between the highest and lowest numbers?","2","5","8","none of these",3, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q6);
        Test_Question q7=new Test_Question("ஒரு பூஜியம் இல்லாத எண்ணின் சராசரி,அதன் வர்க்கம் அந்த எண்ணைபோல் 5 மடங்கு எனில் அந்த எண் காண்க?","The average of a non-zero number and its square is 5 times the number.The number is?","9","17","29","295",1, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q7);
        Test_Question q8=new Test_Question("ஒரு வகுப்பிலுள்ள ஆண்களின் சராசரி வயது 16, பெண்களின் சராசரி வயது 15, வகுப்பின் மொத்த சராசரி வயது காண்க?","The average age of the boys in a class is 16 years and that of the girls is 15 years. the average age for the whole class is?","15 years","15.5 years","16 years","cannot calculate",4, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q8);
        Test_Question q9=new Test_Question("ஒரு நூலகம் சராசரியாக 510 வாசகர்களை ஞாயிற்றுகிழமையும், 240 வாசகர்களை மற்ற கிழமைகளிலும் பெற்றுள்ளது.முதல் நாள் ஞாயிற்றுகிழமை கொண்ட 30 நாட்கள் கொண்ட மதத்தின் ஒருநாளுக்கான சராசரி வாசகர்கள்?","A library has an average of 510 visitors on sunday and 240 on other days.the average number of visitors per day in a month of 30 days beginning with a sunday is?","250","276","280","285",4, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q9);
        Test_Question q10=new Test_Question("ஒரு வகுப்பிலுள்ள 16 மாணவர்களின் சராசரி எடை 50.25,மற்ற 8 மாணவர்களின் சராசரி 45.15kg.s சராசரி எடை கண்டறி?","If the average weight of 16 boys in a class is 50.25 and that of the remaining 8 boys is 45.15kgs. find the average weight of all boys in the class?","47.55kgs","48kgs","48.55kgs","49.25kgs",3, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q10);
        Test_Question q11=new Test_Question("ஒருவர் மூன்று ஆண்டுகள் பெட்ரோலை Rs.7.50, Rs.8 and Rs.8.50 per litre என்ற விலையில் வாங்குகிறார்.அவர் ஒவ்வொரு ஆண்டுக்கும் 4000Rs செலவழிக்கிறார் எனில் ஒரு லிட்டர் பெட்ரோலின் சராசரியானா விலை என்ன?",".A car owner buys petrols at Rs.7.50, Rs.8 and Rs.8.50 per litre for three successive years.What approximately is the average cost per litre of petrol if he spends Rs.4000 each year? ","Rs.7.98","Rs.8","Rs.8.50","Rs.9",1, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q11);
        Test_Question q12=new Test_Question("9 பேரில் 8 பேர் உணவுக்காக ஒவொருவரும் 3Rs செலவழிகின்றனர்.9வது ஆள் 9 பேரின் சாரசரியை விட 20Rs அதிகம் செலவழிக்கிறார்,அனைவராலும் செலவழிக்கப்பட்ட பணம் ?","Out of 9 persons,8 persons spent Rs.30 each for their meals. the ninth one spent Rs.20 more than the average expenditure of all the nine. the total money spent by all of them was?","Rs.260","Rs.290","Rs.292.50","Rs.400.50",3, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q12);
        Test_Question q13=new Test_Question("35 மாணவர்களின் சராசரி வயது 16, அதில் 21 மாணவர்களின் சராசரி வயது 14 எனில், மீதமுள்ள 14 மாணவர்களின் சராசரி வயது?","The averae age of 35 students in a class is 16 years.The average age of 21 students is 14. What is the average age of remaining 14 students?","15years","17years","18years","19years",4, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q13);
        Test_Question q14=new Test_Question("A,B,Cன் சராசரி எடை 45kg, A மற்றும் Bன் சராசரி எடை 40kg, B மற்றும் Cன் சராசரி எடை 43kg, எனில் Bன் எடை?","The average weight of A,B,C is 45 kg. If the average weight of A and B be 40kg and that of B and C be 43 kg , then the weight of B is?","17kg","20kg","26kg","31kg",4, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q14);
        Test_Question q15=new Test_Question("P,Qன் சராசரி மாத வருமானம் 5050rs, Q,Rன் சராசரி மாத வருமானம் 6250rs , P,Rன் சராசரி மாத வருமானம் 5200rs, Pன் மாத வருமானம் என்ன?","The average montly income of P and Q is Rs.5050. The average monthly income of Q and R is Rs.6250 and the average montly income of P and R is Rs.5200. The montly income of P is?","Rs.3500","Rs.4000","Rs.4050","Rs.5000",2, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q15);
        Test_Question q16=new Test_Question("ஒரு நிறுவனத்தில் 20 வேலையாட்களின் சராசரி வருமானம் 1500rs, இதில் மேலாளரின் வருமானம் சேர்க்கப்பட்டால் சராசரி வருமானம் 100rs உயர்கிறது. மேலாளரின் வருமானம் என்ன?","The average montly salary of 20 employess in an organisation is Rs.1500.If the manager's salary is added, then the average salary increases by Rs.100.What is the manager's montly salary?","Rs.2000","Rs.2400","Rs.3600","Rs.4800",3, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q16);
        Test_Question q17=new Test_Question("ஒரு வகுப்பில் இருக்கும் 24 மாணவர்களின் சராசரி எடை 35kg, இதில் ஆசிரியரின் எடை சேர்க்கப்பட்டால் 400g அதிகரிக்கிறது,ஆசிரியரின் எடை கண்டறி?","The average weight of a class of 24 students is 35kg . If the weight of the teacher be included, the average rised by 400g, the weight of the teacher is?","45kg","50kg","53kg","55kg",1, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q17);
        Test_Question q18=new Test_Question("A என்ற இடத்தில் இருந்து B, 600 கி.மீ. தூரத்தில் உள்ளது. அக்பர் A யிலிருந்து B எனும் இடத்திற்கு மணிக்கு 40 கி.மீ. வேகத்திலும் , B யிலிருந்து A எனும் இடத்திற்கு மணிக்கு 60 கி.மீ. வேகத்திலும் சென்றால் , சராசரி வேகம் என்ன?","If the distance from A to B is 600 km and Akbar goes from A to B at a speed 40 km per hour and returns from B to A at a speed of 60 km per hour the overall average speed is","45 km per hour","48 km per hour","50 km per hour","52 km per hour",2, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q18);
        Test_Question q19=new Test_Question("5 எண்களின் சராசரி 32. அவ்வெண்களில் இருந்து ஒன்றை நீக்கும்போது , சராசரியில் 4 குறைந்தால் நீக்கப்பட்ட எண்ணை காண்க?","The mean of the 5 numbers is 32. If one of the numbers is excluded, then the mean is reduced by 4. Find the excluded number","40","44","52","48",4, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q19);
        Test_Question q20=new Test_Question("ஒரு கார் மணிக்கு 60 கி.மீ வேகத்தில் 2 மணி நேரம் பயணிக்கிறது. பின் 4 மணி நேரத்திற்கு 80 கி.மீ வேகத்தில் செல்கிறது எனில் அந்த காரின் சராசரி வேகம் என்ன? ","If a car travels at 60 km per hours for 2 hours and then at the speed of 80 km per hour for 4 hours. What is the average speed?","68 kmph","70 kmph","72.1 kmph","73.3 kmph",4, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q20);
        Test_Question q21=new Test_Question("75 மாணவர்களின் சராசரி மதிப்பெண் 35, ஆனால் அதில் ஒரு மதிப்பெண் 32 க்கு பதிலாக 23 என எடுத்துக்கொள்ளப்பட்டது,எனில் சரியான சராசரி என்ன ?","The mean mark of 75 students was found to be 35. Later on it was found that as score of 32 was misread as 23. Find the correct mean corresponding to the correct score.","35.12","35.21","35.23","35.32",1, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q21);
        Test_Question q22=new Test_Question("50 மாணவர்களின் சராசரி மதிப்பெண் 40, ஆனால் அதில் ஒரு மதிப்பெண் 35க்கு பதிலாக 85 என எடுத்துக்கொள்ளப்பட்டது,எனில் 50 மாணவர்களின் சரியான சராசரி என்ன ?","The average marks of 50 students is 40. The mark of a student is wrongly taken as 35 instead of 85. Find the correct average of 50 students by taking the correct mark of a students?","38","39","42","41",4, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q22);
        Test_Question q26=new Test_Question("75 மாணவர்களின் சராசரி மதிப்பெண் 35, ஆனால் அதில் ஒரு மதிப்பெண் 32 க்கு பதிலாக 23 என எடுத்துக்கொள்ளப்பட்டது,எனில் சரியான சராசரி என்ன ?","The mean mark of 75 students was found to be 35. Later on it was found that as score of 32 was misread as 23. Find the correct mean corresponding to the correct score.","35.12","35.21","35.23","35.32",1, Test_Question.CATEGORY_AVERAGE);
        addQuestion(q26);
    }

    private void addDecimal(){
        Test_Question q1=new Test_Question("பின்வருவனவற்றுள் எது ஏறுவரிசையில் உள்ளது ?","Which of the following has fraction in ascending order?","1/3, 2/5, 4/7, 3/5, 5/6, 6/7 ","1/3, 2/5, 3/5, 4/7, 5/6, 6/7","1/3, 2/5, 3/5, 5/6, 4/7, 6/7 ","2/5, 3/5, 1/3, 4/7, 5/6, 6/7",1, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q1);
        Test_Question q2=new Test_Question("பின்வருவனவற்றுள் எது ஏறுவரிசையில் உள்ளது ?","Which of the following has fraction in ascending order?","2/3, 3/5, 7/9, 9/11, 8/9","3/5, 2/3, 9/11, 7/9, 8/9","3/5, 2/3, 7/9, 9/11","8/9, 9/11, 7/9, 2/3, 3/5",3, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q2);
        Test_Question q3=new Test_Question("பின்வருவனவற்றுள் எது இறங்குவரிசையில் உள்ளது ?","Which of the following are in descending order of their value?","5/9, 7/11, 8/15, 11/17 ","5/9, 8/15, 11/17, 7/11","11/17, 7/11, 8/15, 5/9","11/17, 7/11, 5/9, 8/15",4, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q3);
        Test_Question q4=new Test_Question("இவற்றுள் பெரிய மற்றும் சிறிய எண்ணின் வேறுபாடு காண்க 2/3, 3/4, 4/5, 5/6 ?","What is the difference between the biggest and the smallest fraction among 2/3, 3/4, 4/5, 5/6 ?","1/6","1/12","1/20","1/30",1, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q4);
        Test_Question q5=new Test_Question("இவற்றுள் 3/4 விட பெரிய மற்றும் 5/6விட சிறிய எண்ணை கண்டறி ?","Which of the following fractions is greater than 3/4 and less than 5/6?","1/2 ","2/3","4/5 ","9/10",3, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q5);
        Test_Question q6=new Test_Question("தீர்க்க :34.95 + 240.016 + 23.98 =?","Solve: 34.95 + 240.016 + 23.98 =?","298.0946","298.111","298.946","299.09",3, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q6);
        Test_Question q7=new Test_Question("தீர்க்க :617 + 6.017 + 0.617 +6.0017 =?","Solve: 617 + 6.017 + 0.617 +6.0017 =?","2963","62.965 ","629.6357 ","none of these",3, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q7);
        Test_Question q8=new Test_Question("தீர்க்க : 48.95 - 32.006 =?","Solve:  48.95 - 32.006 =?","16.089","16.35","16.89","16.944",4, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q8);
        Test_Question q9=new Test_Question("தீர்க்க : 792.02 +101.32-306.76=?","Solve:  792.02 +101.32-306.76=?","586.58","893.34","997.11 ","1200.10",1, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q9);
        Test_Question q10=new Test_Question("3.14 x 10^6-கு சமமான எண்ணை கண்டறி ","Which of the folling is equal to 3.14 x 10^6","314","3140","3140000","none of these",3, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q10);
        Test_Question q11=new Test_Question("தீர்க்க :0.002 x 0.5 =?","Solve: 0.002 x 0.5 =?","0.0001","0.001","0.01 ","0.1",2, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q11);
        Test_Question q12=new Test_Question("தீர்க்க: 16.02 x 0.001=?","Solve :16.02 x 0.001=?","0.001602","0.01602","0.1602","1.6021",2, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q12);
        Test_Question q13=new Test_Question("144/0.144 = 144/x எனில் x?","If 144/0.144 = 144/x then the value of x is?","0.0144","1.44","14.4 ","144",1, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q13);
        Test_Question q14=new Test_Question("0.232323..... ஐ பின்னமாக்கு.","When 0.232323...... is converted into a fraction, then the result is ?","1/5","2/9","23/99","29/100",3, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q14);
        Test_Question q15=new Test_Question("0.125125....ஐ பின்னமாக்கு.","The rational numbers for the recurring decimal 0.125125..... is?","63/487","119/993","125/999 ","none of these",3, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q15);
        Test_Question q16=new Test_Question("0.4̅7̅ ஐ பின்னமாக்கு.","When 0.4̅7̅ is converted into a fraction, the result is?","46/90","46/99","47/90 ","none of these",4, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q16);
        Test_Question q17=new Test_Question("இதில் மிக சிறிய எண்?","The least among the following is?","0.2","1÷0.2","0.2̅ ","0.2^2",4, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q17);
        Test_Question q18=new Test_Question("2.13̅6̅  ன் மதிப்பு?","The value of 2.13̅6̅ is?","47/220","68/495","47/22","none of these",3, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q18);
        Test_Question q19=new Test_Question("தீர்க்க  :(0.0̅9̅ x 7.3̅)=?","Solve : (0.0̅9̅ x 7.3̅) is equal to ?","0.6̅",".6̅5̅7̅ ",".6̅7̅ ",".65̅7̅",1, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q19);
        Test_Question q20=new Test_Question(" தீர்க்க  :0.346̅7̅ + 0. 133̅3̅=?","Solve :0.346̅7̅ + 0. 133̅3̅ is equal to?","0.48̅","0.4̅8̅","0.480̅1̅","0.48",3, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q20);

        Test_Question q21=new Test_Question("√2116 = 46 எனில் √21.16 + √0.2116 + √0.002116 – யின் மதிப்பு ","If √2116 = 46 then value of √21.16 + √0.2116 + √0.002116","5.106","5.116","5.122","5.221",1, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q21);

        Test_Question q22=new Test_Question("1011 என்ற இருமக் குறியீட்டு எண்ணிற்கு இணையான தசம எண்","The Binary number 1011 is equivalent to the decimal number","10","11","12","13",2, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q22);

        Test_Question q23=new Test_Question("கண்டறி ","1/3  of ½  of 1/5  of x = 15. Find x?","350","450","550","250",2, Test_Question.CATEGORY_DECIMAL);
        addQuestion(q23);

    }

    private void addSimlification(){
        Test_Question q1=new Test_Question("தீர்க்க  :100 + 50 x 2=?","Solve  :100 + 50 x 2=?","75","150","200","300",3, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q1);
        Test_Question q2=new Test_Question("தீர்க்க  :(3080 + 6160) ÷ 28=?","Solve :(3080 + 6160) ÷ 28=?","320","440","3320","none of these",4, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q2);
        Test_Question q3=new Test_Question("தீர்க்க  : 5004 ÷ 139 -6 =?","Solve : 5004 ÷ 139 -6 =?","24","30","36","42",2, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q3);
        Test_Question q4=new Test_Question("தீர்க்க  :7500+ (1250 ÷ 50) =?","Solve :7500+ (1250 ÷ 50) =?","175","300","6575","7525",4, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q4);
        Test_Question q5=new Test_Question("ஒரு நிறுவனத்தின் வருமானம் ஒரு வருடத்திற்கு பின் இரு மடங்கிறது, அதன் முதல் வருமானம் 4 லட்சம் எனில் 5 வருடத்திற்கு பின் அதன் வருமானம்?","Income of a company doubles after every one year. If the initial income was Rs.4 lakhs,what would be the income after 5 years?","Rs. 1.24 crores","Rs.1.28 crores","2.56 crores","none of these",2, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q5);
        Test_Question q6=new Test_Question("ஒரு விளையாட்டு விழாவில்,30 குழந்தைகள் 16 வரிசையாக நிற்கின்றனர்.24 குழந்தைகள் வரிசையில் நின்றால் எத்தனை வரிசை தேவைப்படும்?","On sports day, if 30 children were made to stand in a column, then 16 columns could be formed.If 24 children were made to stand in a column, then how many columns could be formed?","20","22","29","45",1, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q6);
        Test_Question q7=new Test_Question("ஒரு ஒளியானது 13நொடி இடைவெளியில் மின்னுகிறது, அது 1hour 54min 50 secல்  முதலில் மின்னியது அது கடைசியாக 3hour 17 min 49secல் மின்னியது.அது எத்தனை முறை மின்னியிருக்கும்.?","6.A light was seen at interval of 13 seconds it was seen for the first time at 1 hour 54 minutes 50sec and the last time at 3 hours 17 minutes 49 seconds how many times was the light seen?","360","375","378","384",4, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q7);
        Test_Question q8=new Test_Question("ஒரு அன்னாசியின் விலை Rs7, ஒரு தர்ப்பூசணியின் விலை Rs5, X என்ற ஒருவர் 38 Rs இந்த பழங்களை வாங்க செலவழிகிறார் எனில் அவர் வாங்கிய அன்னாசியில் எண்ணிக்கை ?","Pineapple costs Rs. 7 each. a watermelon costs Rs. 5 each, x spends Rs.38 on these fruits. The number of the pineapple purchased is?","2","3","4","data inacdequate",3, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q8);
        Test_Question q9=new Test_Question("டேவிட் வரலாற்றில் பெற்ற மதிப்பெண்போல்  ஆங்கிலத்தில் இரண்டரை மடங்கு மதிப்பெண் பெறுகிறான், இரு பாடங்களிலும் பெற்ற மொத்த மதிப்பெண் 140 எனில் ஆங்கிலத்தில் அவர் பெற்ற மதிப்பெண் ?","David got two and a half  times as many marks in English as in history, If his total mark in the two subjects are 140 the mark obtained by him in English are?","40","75","90","100",4, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q9);
        Test_Question q10=new Test_Question("ஒரு வகுப்பில் பெண்களின் எண்ணிக்கை ஆண்களை போல் 5 மடங்கு.எனில் பின்வரும் எண்களில் எது வகுப்பின் மொத்த எண்ணிக்கையாக இருக்காது?","The number of girls in a class is 5 times the number of boys which of the following cannot be the total number of children in the class?","24","30","35","42",3, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q10);
        Test_Question q11=new Test_Question("ஒரு தொட்டியின் மூன்றில் ஒருமடங்கு கொள்ளளவு 80லிட்டர்,தொட்டியின் அரை மடங்கு கொள்ளளவு என்ன?","If one third of a tank holds 80 litre of water then the quantity of water that half the tank hold is?","80/3 liters","100liters","120 liters","240 liters",3, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q11);
        Test_Question q12=new Test_Question("ஒரு கம்பத்தில் 1/10 சிகப்பு, 1/20 வெள்ளை, 1/30 நீலம், 1/40 கருப்பு, 1/50 ஊதா, 1/60 மஞ்சள், மீதம் உள்ளவை பச்சை நிறத்தில் உள்ளது. பச்சை நிறம் 12.08 meter நீளம் கொண்டது எனில் கம்பத்தில் நீளம் என்ன?","1/10 of the Pole is coloured Red,1/20 white, 1/30 blue,1/40 black 1/50 violet, 1/ 60 yellow and the rest is green if the length of the green proportion of the pole is 12.08 metres then the length of the pole is?","16m","18m","20m","30m",1, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q12);
        Test_Question q13=new Test_Question("ராகுலின் national savings certificateல் உள்ள மூன்றில் ஒரு மடங்கு சேமிப்பு  public provident fundல் உள்ள சேமிப்பின் பாதிக்கு சமம். அவன் மொத்தமாக  Rs.150000 சேமிப்பு வைத்திருந்தால், public provident fundன் மொத்த சேமிப்பு என்ன?","One-Third of Rugul's savings in national saving certificate is equal to one half of his savings in public provident fund if he has Rupees 150000 as total saving how much has he saved in public provident fund?","Rs.30,000","Rs.50,000","Rs.60,000","Rs.90,000",3, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q13);
        Test_Question q14=new Test_Question("60 வினாக்கள் கொண்ட ஒரு தேர்வில் சரியான விடைக்கு 4 மதிப்பெண் வழங்க படுகிறது, தவறான விடைக்கு 1 மதிப்பெண் கழிக்கப்படுகிறது,ஒருவன் 60 வினாக்களுக்கு விடையளித்து 130 மதிப்பெண் பெறுகிறார் எனில் அவர் சரியாக விடையளித்த வினாக்கள் எத்தனை?","In an examination, a student scores 4 mark for every correct answer and loses 1 mark for every wrong anser. If he attempts in all 60 questions and secures 130 marks, the number of questions he attempts correctly is?","35","38","40","42",2, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q14);
        Test_Question q15=new Test_Question("ஒரு அணி அவர்கள் பெற்ற தோல்வியைவிட 3 ஆட்டங்கள் அதிகம் வெற்றி பெறுகின்றனர்.வெற்றி பெற்றால் 2 மதிப்பெண்,தோல்வி அடைந்தால் -1 மதிப்பெண் எனில், 23 மதிப்பெண் பெற அவர்கள் ஆடிய ஆடங்களின் எண்ணிக்கை?","A cricket team won 3 matches more than they lost, If a win gives them 2 points and loss(-1) point, how many matches, in all, have thet played if their score is 23?","17","20","37","40",1, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q15);
        Test_Question q16=new Test_Question("20 பைசா மற்றும் 25 பைசா உள்ள 324 நாணயங்களின் கூடுதல் Rs.71 எனில் எத்தனை 25 பைசா உள்ளது?","A total of 324 coins of 20 paise and 25 paise make a sum of Rs. 71. The number of 25-paise coins is?","120","124","144","200",4, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q16);
        Test_Question q17=new Test_Question("லீலா என்பவர் ஒரு புத்தகத்தின் 1/4 பகுதியை 1 மணி நேரத்தில் படித்து முடிப்பார் எனில் புத்தகத்தின் எவ்வளவு பகுதியை 3 ½ மணி நேரத்தில் படிப்பார்?","Leela reads 1/4th of a book in 1 hour. How much of the book will she read in 3 and 1/2 hours? ","120","124","144","200",2, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q17);
        Test_Question q18=new Test_Question("21 2/7  என்பதை 8  1/11ஆல் வகுத்தால் கிடைப்பது ","If 21 2/7  is divided by 8 1/11 the answer is","1639/633","1639/623","1693/623","149/89",2, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q18);
        Test_Question q19=new Test_Question("முவ்வேறு சாலை சந்திப்புகளில் உள்ள சாலை பாதுகாப்பு விளக்குகள் காலை 8.00 மணிக்கு ஒரே நேரத்தில் மாற்றமடைகின்றன. மூன்றும் முறையே 30 விநாடிக்கு ஒரு முறை ,72 விநாடிக்கு ஒரு முறை , 45 விநாடிக்கு ஒரு முறை மாறுகின்றன. 8.00 முப(A.M ). பின்பு மீண்டும் இம்மூன்றும் எப்போது ஒரே சமயத்தில் மாறும்?","Traffic lights at three different junctions change simultaneously at morning 8.00 am. The first light changes once in 30 seconds, the second once in 72 seconds, the third once in 45 seconds. After 8.00 am which is the next time they change simultaneously?","8.03 AM","8.06 AM","8.10 AM","8.12 AM",2, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q19);
        Test_Question q20=new Test_Question("ஒவ்வொரு பக்கத்திலும் 30 வரிகள் கொண்ட ஒரு புத்தகத்தின் மொத்த பக்கங்கள் 120. அதே செய்தி ஒவ்வொரு பக்கத்திலும் 25 வரிகளாக இருந்தால் புத்தகத்தின் மொத்த பக்கங்களின் எண்ணிக்கை யாது?","A book contains 120 pages. Each page has 30 lines. How many pages will the same matter of the book contain if every pages has 25 lines?","175","150","164","144",4, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q20);
        Test_Question q21=new Test_Question("சுருக்குக :- √48 - 3 √72 - √27 + 5√18","Simplify: – √48 - 3 √72 - √27 + 5√18","√2 + √3","√2 - √3","-√2 +√3","None of these",4, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q21);
        Test_Question q22=new Test_Question("ஒரு பறவை மேற்க்கு திசையில் 200 மீட்டர் பறந்து வலது புறம் திரும்பி மேலும் 100 மீட்டர் பறக்கிறது. பின்னர் கிழக்கு திசையில் திரும்பி 300 மீ பறந்து பின் திரும்பி தெற்கு திசையில் 100 மீட்டர் பறக்கிறது. ஆரம்ப புள்ளியிலிருந்து பறவை எவ்வளவு தூரத்தில் உள்ளது?","A bird flies 200 metres west and then turns right and flies 100 meters. Next it turns east and flies 300 meters. Again it turns and flies south for 100 meters. How far is the bird from starting point?","100 m","150 m","124 m","116 m",1, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q22);
        Test_Question q23=new Test_Question("(-5) (4) (2) (-1/2 ) (3/4 ) ன் மதிப்பு யாது?","The value of (-5) (4) (2) (-1/2 ) (3/4 )","10","15","12","0",2, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q23);

        Test_Question q25=new Test_Question("21 2/7  என்பதை 8  1/11ஆல் வகுத்தால் கிடைப்பது ","If 21 2/7  is divided by 8 1/11 the answer is","1639/633","1639/623","1693/623","149/89",2, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q25);
        Test_Question q26=new Test_Question("ஒவ்வொரு பக்கத்திலும் 30 வரிகள் கொண்ட ஒரு புத்தகத்தின் மொத்த பக்கங்கள் 120. அதே செய்தி ஒவ்வொரு பக்கத்திலும் 25 வரிகளாக இருந்தால் புத்தகத்தின் மொத்த பக்கங்களின் எண்ணிக்கை யாது?","A book contains 120 pages. Each page has 30 lines. How many pages will the same matter of the book contain if every pages has 25 lines?","175","150","164","144",4, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q26);
        Test_Question q27=new Test_Question("ஒரு பறவை மேற்க்கு திசையில் 200 மீட்டர் பறந்து வலது புறம் திரும்பி மேலும் 100 மீட்டர் பறக்கிறது. பின்னர் கிழக்கு திசையில் திரும்பி 300 மீ பறந்து பின் திரும்பி தெற்கு திசையில் 100 மீட்டர் பறக்கிறது. ஆரம்ப புள்ளியிலிருந்து பறவை எவ்வளவு தூரத்தில் உள்ளது?","A bird flies 200 metres west and then turns right and flies 100 meters. Next it turns east and flies 300 meters. Again it turns and flies south for 100 meters. How far is the bird from starting point?","100 m","150 m","124 m","116 m",1, Test_Question.CATEGORY_SIMPLIFICATION);
        addQuestion(q27);

    }

    private void addLcmHcf(){
        Test_Question q1=new Test_Question("252 ஐ எப்படி விரிவாக எழுதலாம்.","252 can be expressed as a product of primes as:","2x2x3x3x7","2x2x2x3x7","3x3x3x3x7 ","2x3x3x3x7",1, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q1);
        Test_Question q2=new Test_Question("எளிய வடிவில் சுருக்கு 1095/1168","1095/1168 when expressed in simplest form is ?","13/16","15/16","17/26","25/26",2, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q2);
        Test_Question q3=new Test_Question("மீ.பொ.வ காண்க :4x27x3125, 8x9x25x7 , 16x81x5x11x49","HCF of 4x27x3125, 8x9x25x7 , 16x81x5x11x49 is?","180","360","540 ","1260",1, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q3);
        Test_Question q4=new Test_Question("பின்வரும் எண்ணிற்கு மீச்சிறு பொது மடங்கு காண்க 24, 36, 40","Find the lowest common multiple of 24, 36, 40","120","240","360 ","480",3, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q4);
        Test_Question q5=new Test_Question("மீ.பொ.வ காண்க 1.08 , 0.36 and 0.9?","The G.C.D of 1.08 , 0.36 and 0.9 is?","0.03","0.9","0.18 ","0.108",3, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q5);
        Test_Question q6=new Test_Question("3240, 3600 மற்றும்  மூன்றாவது எண்ணின் மீ.பொ.வ 36, இவற்றின் மீ .சி.ம 2^4 x3^5 x5^2 x7^2 , எனில் 3வது எண் கண்டறி ?","HCF of 3240, 3600 and a third number is 36 and their LCM is 2^4x 3^5 x5^2 x7^2 the third number is ","2^2 x3^5 x7^2","2^2x5^3x7^2","2^5x5^2x7^2 ","2^3x3^5x7^2",1, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q6);
        Test_Question q7=new Test_Question("இரண்டு எண்களின் விகிதம் 3:4, இவற்றின் மீ.பொ.வ 4 எனில் அதன் மீ .சி.ம  ?","The ratio of two numbers is 3:4 and their HCF is 4. Their LCM is?","12","16","24 ","48",4, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q7);
        Test_Question q8=new Test_Question("இரு எண்களின் மீ.பொ.வ, மீ .சி.ம முறையே 84,21. இவற்றின் விகிதம் 1:4 எனில் மிகபெரிய எண்ணை கண்டறி","The HCF and LCM of two numbers are 84 and 21 respectively, if the ratio of the two numbers is 1:4, then the large of the two numbers is?","12","48","84 ","108",3, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q8);
        Test_Question q9=new Test_Question("இரு எண்களின் மீ.பொ.வ 8 எனில் பின்வருவனவற்றில் எவை மீ .சி.ம வாக கிடைக்காது ","The HCF of two numbers is 8 .Which one of the following can never be their LCM?","24","48","56","60",4, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q9);
        Test_Question q10=new Test_Question("7m, 3m 85cm, 12m 95cm ஆகிய நீளங்களை பொதுவாக அளக்கும் மிகப்பெரிய அளவினை காண்க ?","The greatest posssible length which can be used to measure exactly  the lengths 7m, 3m 85cm, 12m 95cm is ?","15cm","25cm","35cm ","42cm",3, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q10);
        Test_Question q11=new Test_Question("இரு எண்களின் மீ.சி.ம மற்றும் மீ.பொ.வ முறையே 12 மற்றும் 144. அவற்றில் ஒரு எண் 36 எனில் மற்றொரு எண் என்ன ?","The HCF and LCM of two numbers are 12 and 144 respectively. One number is 36 the other number is?","24","58","28","48",4, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q11);
        Test_Question q12 =new Test_Question("இரு எண்களின் மீ.சி.ம அதன் மீ.பொ.வ போல் 20மடங்கு. இரு எண்களின் மீ.சி.ம  மற்றும் மீ.பொ.வ கூடுதல் 2520, அதில் ஒரு எண் 480 எனில் மற்றொரு எண்ணை கண்டறி","The LCM of two numbers is 20 times their HCF. The sum of HCF and LCM is 2520. If one of the number is 480 then the other number is ?","400","120","600","240",3, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q12);
        Test_Question q13 =new Test_Question("இரண்டு எண்கள் 15:11 என்ற விகிதத்தில் உள்ளன. அவற்றின் மீ.பொ.வ 13 எனில் கீழே கொடுக்கப்பட்டுள்ளவைகளில் அவை எதுவாக இருக்கக் கூடும்?","The numbers are in the ratio 15 : 11. Their HCF is 13, which of the following pairs can they be?","194, 143","195, 142","195, 143","196, 144",3, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q13);
        Test_Question q14 =new Test_Question("12, 15, 20 மற்றும் 27 ஆகிய எண்களால் வகுபடும் மிகச் சிறிய எண்ணை காண்க?","Find the least number exactly divisible by 12, 15, 20 and 27.","504","270","108","540",4, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q14);
        Test_Question q15 =new Test_Question("2/5, 3/5 மற்றும் ½ என்பவற்றின் LCM ","LCM of 2/5, 3/5 and ½ is ","3","8","6","12",3, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q15);
        Test_Question q16 =new Test_Question("இரு எண்களின் LCM 150 மற்றும் HCF 4 ஆகும். அதில் ஒரு எண் 50 எனில் மற்றொரு  எண்","LCM of two numbers is 150 and their HCF is 4. If one number is 50, then the other number","15","25","10","12",4, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q16);
        Test_Question q17 =new Test_Question("இரு மிகை எண்களின் பெருக்கு தொகை 800 மற்றும் அவற்றின் LCM 200 எனில் HCF-ன் மதிப்பு யாது?","If the product of two number is 800 and their LCM is 200, then the HCF is","100","4","5","600",2, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q17);
        Test_Question q18 =new Test_Question("x மற்றும் y இன் மீப்பெரு பொது வகுத்தி z, எனில் அவற்றின் மீச்சிறு பொது மடங்கு ","The G.C.D of x and y is z.","xy/z","xz/y","xz/y","(x+y)/z",1, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q18);
        Test_Question q19 =new Test_Question("மீப்பெரு பொது வகுத்தி காண்க 15x^4 y^3 z^5 , 12x^2 y^7 z^2","Find the GCD of 15x^4 y^3 z^5 , 12x^2 y^7 z^2","170x^4 y^7 z^5","3x^2 y^3 z^2","3x^4 y^7 z^5","170x^2 y^3 z^2",2, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q19);
        Test_Question q20 =new Test_Question("போக்குவரத்து சமிக்ஞ்சை விளக்குகள் மூன்று வெவ்வேறு சாலைச் சந்திப்புகளில் முறையே ஒவ்வொரு 48 வினாடிகள், 72 வினாடிகள் மற்றும் 108 விநாடிகளுக்குப் பின் மாறுகிறது. அவை எல்லாமே 8 : 20 :00 மணிகளில் ஒரே நேரத்தில் மாறினால், மீண்டும் எப்போது அவை ஒரே நேரத்தில் மாறும்?","The Traffic Lights at three different road crossings change after every 48 sec, 72 sec and 108 sec especially. If they all changes simultaneously at 8 : 20 : 00 hours, then at what time will they again change simultaneously?","8 : 20 : 48 hrs","8 : 21 : 12 hrs","8 : 21 : 48 hrs","8 : 27 : 12 hrs",4, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q20);
        Test_Question q21 =new Test_Question("மீ. பொ. வ காண்க 2/3, 8/9, 16/81   10/27","Find the HCF of  2/3, 8/9, 16/81 and  10/27","80/3","2/81","1/81","3/80",2, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q21);
        Test_Question q22 =new Test_Question("1657, 2037  என்ற எண்களை வகுக்கும் போது மீதி 6 மற்றும் 5 வருமாறு வகுக்கும் பொது வகுத்தி காண்க ","The greatest number which on dividing 1657 and 2037 leaves remainders 6 and 5 respectively is ?","123","127","235","305",2, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q22);
        Test_Question q23 =new Test_Question("43, 91, 183  என்ற எண்களை வகுக்கும் போது மீதி அனைத்திற்கும் ஒன்றாக வருமாறு வகுக்கும் எண் பின்வருவனவற்றுள் கண்டறி ?","Find the greatest number that will divide 43, 91, 183 so as to leave the same remainder in each case?","4","7","9","13",1, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q23);
        Test_Question q24 =new Test_Question("நிறைய மாணவர்கள் உள்ள வகுப்பில் 1001 பேனா மற்றும் 910 பென்சில் ஐ அனைவருக்கும் சரியாக பகிர்ந்தளிக்க அனைவரும் சரியான எண்ணிக்கை பெறுவதற்கான பேனா, பென்சிலின் எண்ணிக்கை ?","The maximum number of students among them 1001 pens and 910 pencils can be distributed in such a way that each student gets the same numbers of pens and same number of pencils is?","91","910","1001","1911",1, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q24);
        Test_Question q25 =new Test_Question("7m, 3m 85cm, 12m 95cm ஆகிய நீளங்களை பொதுவாக அளக்கும் மிகப்பெரிய அளவினை காண்க ?","The greatest posssible length which can be used to measure exactly  the lengths 7m, 3m 85cm, 12m 95cm is ?","15cm","25cm","35cm","42cm",3, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q25);
        Test_Question q26 =new Test_Question("05, 1001, 2436 என்ற எண்களை வகுக்கக்கூடிய மிகப்பெரிய எண் பின்வருவனவற்றில் எது ?","The greatest number that exactly divides 105, 1001, 2436 is? ","3","7","11","21",2, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q26);
        Test_Question q27 =new Test_Question("இரு எண்களின் மீ.பொ.வ 8 எனில் பின்வருவனவற்றில் எவை மீ .சி.ம வாக கிடைக்காது","The HCF of two numbers is 8 .Which one of the following can never be their LCM?","24","48","56","60",4, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q27);
        Test_Question q28 =new Test_Question("இரு எண்களின் மீ .சி.ம 495,மீ.பொ.வ 5, இரு எண்களின் கூடுதல் 10 எனில் அவற்றிற்கு இடையேயான வேறுபாடு கண்டறி ?","The LCM of two numbers is 495 and their HCF is 5. If the sum of the numbers is 10 , then their difference is?","10","46","70","90",1, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q28);
        Test_Question q29 =new Test_Question("இரு எண்களின் மீ.பொ.வ, மீ .சி.ம முறையே 84,21. இவற்றின் விகிதம் 1:4 எனில் மிகபெரிய எண்ணை கண்டறி ","The HCF and LCM of two numbers are 84 and 21 respectively, if the ratio of the two numbers is 1:4, then the large of the two numbers is?","12","48","84","108",3, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q29);
        Test_Question q30 =new Test_Question("இரு எண்களின் பெருக்கல் பலன் 4107, இவற்றின் மீ.பொ.வ 37 எனில் பெரிய எண்ணை  கண்டறி ","The product of two number is 4107. If the HCF of these number is 37 , then the greater number is ?","101","107","111","185",3, Test_Question.CATEGORY_LCMHCF);
        addQuestion(q30);

    }
    private void addNumbers(){

        Test_Question q1=new Test_Question("தீர்க்க 7589 - ? = 3434 ","Solve 7589 - ? = 3434 ","4242","4155","1123","11023",2, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q1);
        Test_Question q2=new Test_Question("தீர்க்க  4300731 - ? = 2535618","Solve 4300731 - ? = 2535618","1865113","1775123","1765113","1675123",2, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q2);
        Test_Question q3=new Test_Question("512#324 என்ற எண் முழுமையாக 3 ஆல் வகுப்படுமாயின் #ன் மிகச்சிறிய எண்ணை கண்டறி","If the number 512#324 is completely divisible by 3, then the smallest whole number in place of # will be:","0","1","2","none of these",3, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q3);
        Test_Question q4=new Test_Question("97215#7 என்ற எண் முழுமையாக 11 ஆல் வகுப்படுமாயின் #ன் மிகச்சிறிய எண்ணை கண்டறி ","If the number 97215#7 is completely divisible by 11 then the smallest whole number in place of # will be","3","2","1","5",1, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q4);
        Test_Question q5=new Test_Question("பின்வரும் எண்களில் 11 ஆல் வகுப்படும் எண் ?","which one of the following numbers is exactly divisible by 11?","235641","245642","315624","415624",4, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q5);
        Test_Question q6=new Test_Question("பின்வரும் எண்களில் பகு எண் ?","Which of the following is not a prime number?","31","69","71","47",2, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q6);
        Test_Question q10=new Test_Question("ஒரு எண் 296 ஆல் வகுக்கும் போது மீதி =75, அதையே  37 ஆல் வகுக்கும் போது மீதி என்ன ?","A number when divided by 296, leaves, 75 as remainder.when the same number is divided by 37, the remainder will be?","1","2","8","11",1, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q10);
        Test_Question q9=new Test_Question("ஒரு எண்ணை வகுக்கும் போது மீதி =0, ஒரு மாணவன்  21ஆல் வகுப்பதற்கு பதிலாக 12-ஆல் தவறுதலாக வகுக்கும்போது ஈவு =35 கிடைக்கிறது. சரியான ஈவு என்ன ?","In a Division sum, the remainder is 0. A student mistook the divisor by 12 instead of 21 and obtained 35 as quotient, What is the correct quotient?","0","12","13","20",4, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q9);
        Test_Question q8=new Test_Question("ஒரு எண்ணை 5ஆல் வகுக்க 3 மீதியாக கிடைக்கிறது.அதே எண்ணை வர்க்கப்படுத்தி 5 ஆல் வகுத்தால்  மீதி என்ன ?","On dividing a number by 5, we get 3 as a remainder. What will be the remainder when the square of this number is divided by 5? ","4","5","6","7",4, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q8);
        Test_Question q7=new Test_Question("ஒரு எண்ணை 56 ஆல் வகுக்க 29 மீதியாக கிடைக்கிறது.அதே எண்ணை 8 ஆல் வகுக்க மீதி என்ன ?","On dividing a number by 56, we get 29 as a remainder. On dividing the same number by 8, what will be the remainder?","4","6","5","7",3, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q7);
        Test_Question q11=new Test_Question("ஒரு எண்ணை 20, 25, 35 மற்றும் 40 ஆல் வகுத்தால் மீதிகள் முறையே 14, 19, 29, 34 ஆகும் எனில் அந்த எண்ணை கண்டறி","Find the least number which when divided by 20,25,35 and 40 leaves remainders 14,19,29 and 34 respectively","1394","1388","1380","1400",1, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q11);
        Test_Question q12=new Test_Question("முதல் பத்து இயல் எண்களின் வரம்பு என்ன","Range of the first ten positive integers is","10","9","5","4.5",2, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q12);
        Test_Question q13=new Test_Question("ஒரு பந்து மேலிருந்து கீழே விழும்போது ¾ உயரம் மேல்நோக்கி குதிக்கிறது.ஒருவேளை பந்து 32m உயரத்தில் இருந்து விடப்பட்டால் அதன் மூன்றாவது குதித்தலில் அது எவ்வளவு உயரம் குதிக்கும்.","When a ball bounces it rises ¾ of the height from which it fell. If the ball is dropped from a height of 32m, how high will it rise at the third bounce?","13m","13 ½ m","14m","15m",2, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q13);
        Test_Question q14 =new Test_Question("இரு இலக்கங்கள்  கொண்ட ஒரு எண்ணின் இலக்கங்களின் கூடுதல் 9 எனில், அந்த எண்ணை திருப்பிப்போட்டு அதனை இரு மடங்காக்கி 9 ஆல் வகுத்தால்  உண்மையான எண் கிடைக்கிறது எனில் அந்த எண் என்ன ?","A number consists of two digits whose sum is 9. The number formed by reversing the digits decreases twice the original number by 9. Which is that original number?","63","36","62","26",1, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q14);
        Test_Question q15 =new Test_Question("2,5,9,19,37 வரிசையின் அடுத்த எண் என்னவாக இருக்கும்","What would be the next term of the sequence 2,5,9,19,37?","67","76","75","87",3, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q15);
        Test_Question q16 =new Test_Question("வருண் வடக்கு நோக்கி 90மீட்டர் நடக்கிறார், பின் இடதுபக்கம் திரும்பி 25 மீட்டர் நடக்கிறார், மீண்டும் இடதுபக்கம் திரும்பி 100 மீட்டர்  நடக்கிறார். கடைசியாக  அவர் 45° வலதுபக்கம் திரும்பி நிற்கிறார் எனில் அவர் நிற்கும் திசை என்ன ?","Varun moved a distance of 90 meters towards the north. He then moved turned to the left and walking for about 25 metres, turned left again and walked 100 metres. Finally he turned to the right at an angle of 45º. In which direction was he finally moving?","NORTH-EAST","NORTH-WEST","SOUTH-EAST","SOUTH-WEST",4, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q16);
        Test_Question q17 =new Test_Question("8 ஆல் வகுக்கக்கூடிய 3 இலக்க எண்களின் கூட்டுத்தொகை என்ன?","What is the sum of all 3 digit natural numbers, which are divisible by 8","61376","63176","67136","61636",2, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q17);
        Test_Question q18 =new Test_Question("இதில் வேறுபட்ட ஒன்றை கண்டறி  216, 730, 343, 1331","Find the odd man out: 216,730,343,1331 ?","216","343","730","1331",3, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q18);
        Test_Question q19 =new Test_Question("கொடுக்கப்பட்டுள்ள தொடரில் கோடிட்ட இடத்தில் இருக்க வேண்டிய எழுத்துக்கள் யாவை? 13ca, 216fab, 25eb, 237___, 46fd, ….","Find the missing alphabets in the given series: 13ca, 216fab, 25eb, 237___, 46fd, ….","gce","gcb","gdb","fcb",2, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q19);
        Test_Question q20 =new Test_Question("நான் ஓர் மூன்றிலக்க எண். மேலும் 10 இன் மடங்கு ஆவேன். என்னை  6 ஆல் வகுத்து, மீதியின்றிக் கிடைக்கும் ஈவுடன் 4 கைச் சேர்த்தால் , 114 கிடைக்கும் , எனில் எனது மதிப்பு என்ன ? ","I am a three digit number. Moreover I am a multiple of 10. When I am divided by 6, I leave no remainder and if 4 is added to the quotient, 114 is obtained. What is my Value?","220","440","550","660",4, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q20);
        Test_Question q21 =new Test_Question("p, q, r, s, t என்பன கூட்டுத் தொடர் வரிசையில் இருப்பின் p – 4q + 6r – 4s + t = என்பதன் மதிப்பு ","If p, q, r, s, t are in A.P. then the value of p – 4q + 6r – 4s + t is","1","2","3","0",4, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q21);
        Test_Question q22 =new Test_Question("1 முதல் n வரையுள்ள ‘n’ இயல் எண்களின் கூட்டு சராசரி  ","Find the average (mean) of ‘n’ natural numbers from 1 to n"," n/2","(n-1)/2","n^2/2","(n+1)/2",4, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q22);
        Test_Question q23 =new Test_Question("11, 16, 24, 35, 49, ? ","11, 16, 24, 35, 49, ?","62","63","64","66",4, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q23);

        Test_Question q25 =new Test_Question("n ஒரு இயல் எண் எனில்,(6n2+6n) எவற்றால் வகுப்படும் ","If n i a natural number, then (6n2+6n) is always divisible by?","6 only","6 and 12 both","12 only","by 18 only",2, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q25);
        Test_Question q26 =new Test_Question("ஒரு எண்ணை வகுக்கும் போது மீதி =0, ஒரு மாணவன்  21ஆல் வகுப்பதற்கு பதிலாக 12 தவறுதலாக வகுக்கும்போது ஈவு =35 கிடைக்கிறது. சரியான ஈவு என்ன ?","In a Division sum, the remainder is 0. A student mistook the divisor by 12 instead of 21 and obtained 35 as quotient, What is the correct quotient?","0","12","13","20",4, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q26);
        Test_Question q27 =new Test_Question("இரு எண்களின்  வேறுபாடு 1365. அதில் மிகப்பெரிய எண்ணை மிகச்சிறிய எண்ணால் வகுக்க ஈவு =6 ,மீதி =15 ஆக மிகச்சிறிய எண்ணை கண்டறி ?","Difference of two number is 1365. On dividing the large number by the smaller, we get 6 as quotient and 15 as remainder.what is the smaller number?","240","270","295","360",2, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q27);
        Test_Question q28 =new Test_Question("ஒரு எண்ணை 5ஆல் வகுக்க 3 மீதியாக கிடைக்கிறது.அதே எண்ணை வர்க்கப்படுத்தி 5 ஆல் வகுத்தால்  மீதி என்ன ?","On dividing a number by 5, we get 3 as a remainder. What will be the remainder when the square of this number is divided by 5?","4","5","6","7",4, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q28);
        Test_Question q29 =new Test_Question("ஒரு எண்ணை 357 ஆல் வகுக்க 39 மீதியாக கிடைக்கிறது.அதே எண்ணை 17ஆல் வகுக்க மீதி என்ன ?","On dividing a number by 357, we get 39 as a remainder. On dividing the same number by 17 , what will be the remainder?","0","3","5","11",3, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q29);
        Test_Question q30 =new Test_Question("ஒரு எண்ணை 56 ஆல் வகுக்க 29 மீதியாக கிடைக்கிறது.அதே எண்ணை 8 ஆல் வகுக்க மீதி என்ன ?","On dividing a number by 56, we get 29 as a remainder. On dividing the same number by 8, what will be the remainder?","4","5","6","7",2, Test_Question.CATEGORY_NUMBERS);
        addQuestion(q30);
    }
}

package com.weekenddevelopers.tamilaptitude;

import android.provider.BaseColumns;

public final class Test_QuizContract {

    public static class  TestQuestionsTable implements BaseColumns{
        public static final String TABLE_NAME="test_quiz_contract";
        public static final String COLUMN_QUESTION_ENGLISH="question_english";
        public static final String COLUMN_QUESTION_TAMIL="question_tamil";
        public static final String COLUMN_OPTION1="option1";
        public static final String COLUMN_OPTION2="option2";
        public static final String COLUMN_OPTION3="option3";
        public static final String COLUMN_OPTION4="option4";
        public static final String COLUMN_ANSWER_NR="answer_nr";
        public static final String COLUMN_CATEGORY="category";
    }
 }

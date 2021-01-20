package com.weekenddevelopers.tamilaptitude;

public class Practice_Question {
    public static final String CATEGORY_NUMBERS="numbers";
    public static final String CATEGORY_LCMHCF="lcmhcf";
    public static final String CATEGORY_DECIMAL="decimal";
    public static final String CATEGORY_SIMPLIFICATION="simplification";
    public static final String CATEGORY_AVERAGE="average";
    public static final String CATEGORY_PERCENTAGE="percentage";
    public static final String CATEGORY_PROFITLOSS="profitloss";
    public static final String CATEGORY_TIMEDISTANCE="timedistance";
    public static final String CATEGORY_TIMEWORK="timework";
    public static final String CATEGORY_SIMPLEINTEREST="simpleinterest";
    public static final String CATEGORY_AREA="area";
    public static final String CATEGORY_VOLUMES="volumes";
    public static final String CATEGORY_COMPOUNDINTEREST="compoundinterest";
    public static final String CATEGORY_RATIO="ratio";
    public static final String CATEGORY_AGES="problemonages";
    public static final String CATEGORY_PIPE="pipe";
    public static final String CATEGORY_TRAINS="problemontrain";
    public static final String CATEGORY_BOAT="boat";
    public static final String CATEGORY_MIXTURE="mixture";
    public static final String CATEGORY_CALENDER="calender";
    public static final String CATEGORY_HEIGHTANDDISTANCE="heightanddistance";

    private String question_tamil;
    private String question_english;
    private String option1;
    private String Option2;
    private String Option3;
    private String Option4;
    private int answerNr;
    private String hint;
    private String category;

    public Practice_Question(){}

    public String getQuestion_english() {
        return question_english;
    }

    public void setQuestion_english(String question_english) {
        this.question_english = question_english;
    }

    public Practice_Question(String question_tamil,String question_english, String option1, String option2, String option3, String option4, int answerNr, String hint,String category) {
        this.question_tamil = question_tamil;
        this.question_english=question_english;
        this.option1 = option1;
        this.Option2 = option2;
        this.Option3 = option3;
        this.Option4 = option4;
        this.answerNr = answerNr;
        this.hint = hint;
        this.category=category;
    }

    public String getQuestion_tamil() {
        return question_tamil;
    }

    public void setQuestion(String question) {
        this.question_tamil = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String option2) {
        Option2 = option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String option3) {
        Option3 = option3;
    }

    public String getOption4() {
        return Option4;
    }

    public void setOption4(String option4) {
        Option4 = option4;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static String[] getAllCategory(){
        return new String[]{
                CATEGORY_NUMBERS,CATEGORY_LCMHCF,CATEGORY_DECIMAL,CATEGORY_SIMPLIFICATION,CATEGORY_AVERAGE,CATEGORY_PERCENTAGE,CATEGORY_PROFITLOSS,
                CATEGORY_TIMEDISTANCE,
                CATEGORY_TIMEWORK,CATEGORY_SIMPLEINTEREST,CATEGORY_AREA,CATEGORY_VOLUMES,CATEGORY_AGES,CATEGORY_BOAT,
                CATEGORY_CALENDER,CATEGORY_COMPOUNDINTEREST,CATEGORY_HEIGHTANDDISTANCE,CATEGORY_MIXTURE,CATEGORY_PIPE
                ,CATEGORY_RATIO,CATEGORY_TRAINS
        };
    }
}

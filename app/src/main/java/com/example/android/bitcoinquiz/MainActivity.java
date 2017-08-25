package com.example.android.bitcoinquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * This app offers 4 questions and delivers a greade.
 */

public class MainActivity extends AppCompatActivity {
    EditText answerField;
    int grade = 0;
    private boolean Q1_CheckBox1Checked, Q1_CheckBox2Checked, Q1_CheckBox3Checked; /** Private,to use it on onClick_gradeQuiz */


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
         * This the input field method
         */
        answerField = (EditText) findViewById(R.id.answer_input);
    }

    /**
     * QUESTION 1, 3 CHECKBOXES.
     */


    /**
     * Method calculateGrade_Q1 calculates question 1's total grade (Q1 has 3 CheckBoxes).
     *
     * @param Q1_CheckBox1Checked is wether CheckBox1 is checked.
     * @param Q1_CheckBox3Checked is wether CheckBox1 is checked.
     *                            return final grade
     */

    public int calculateGrade_Q1(boolean Q1_CheckBox1Checked, boolean Q1_CheckBox2Checked, boolean Q1_CheckBox3Checked) {

        int finalGrade = 0;
        int CheckBox1 = 0;
        int CheckBox2 = 0;
        int CheckBox3 = 0;


        if (Q1_CheckBox1Checked) {
            CheckBox1 = 2;
        }

        if (Q1_CheckBox3Checked) {
            CheckBox3 = 2;
        }
        if (Q1_CheckBox1Checked & Q1_CheckBox2Checked & Q1_CheckBox3Checked) {
            CheckBox1 = 0;
            CheckBox2 = 0;
            CheckBox3 = 0;
        }

        finalGrade = CheckBox1 + CheckBox2 + CheckBox3;
        return finalGrade;
    }

         /*
         Method calculateGrade_Q2 calculates question 2's total grade (Q2 has 3 RadioButtons).
            *
            * @param Q1_CheckBox1Checked is wether CheckBox1 is checked.
            * @param Q1_CheckBox3Checked is wether CheckBox1 is checked.
            *                            return final grade
         */

    public int calculateGrade_Q2(boolean Q2_RadioButton1Checked, boolean Q2_RadioButton2Checked, boolean Q3_RadioButton3Checked) {

        int finalGrade = 0;
        int RadioButton1 = 0;
        int RadioButton2 = 0;
        int RadioButton3 = 0;


        if (Q2_RadioButton2Checked) {
            RadioButton2 = 2;
        }

        if (Q2_RadioButton1Checked){
            RadioButton2 = 0;
        }
        if (Q3_RadioButton3Checked){
            RadioButton2 = 0;
        }

        finalGrade = RadioButton1 + RadioButton2 + RadioButton3;
        return finalGrade;
    }

    /**
     * Quiz SUMMARY text.
     */

    private String createQuiz_Q1_Summary(int grade, boolean Q1_CheckBox1Checked,boolean Q1_CheckBox2Checked, boolean Q1_CheckBox3Checked) {

        String gradeMessage_Q1 = "\n Question 1 grade: " + calculateGrade_Q1(Q1_CheckBox1Checked, Q1_CheckBox2Checked, Q1_CheckBox3Checked) + "/4";
        return gradeMessage_Q1;
    }
    private String createQuiz_Q2_Summary(int grade, boolean Q2_RadioButton1checked, boolean Q2_RadioButton2checked, boolean Q2_RadioButton3checked) {

        String gradeMessage_Q2 = "\n Question 2 grade: " + calculateGrade_Q2(Q2_RadioButton1checked, Q2_RadioButton2checked, Q2_RadioButton3checked) + "/2";
        return gradeMessage_Q2;
    }


    /**
     * These methods display the given text on the screen.
     */
    private void displayMessage_Q1(String message) {
        TextView quizSummaryTextView = (TextView) findViewById(R.id.grade1_summary);
        quizSummaryTextView.setText(message);
    }
    private void displayMessage_Q2(String message) {
        TextView quizSummaryTextView = (TextView) findViewById(R.id.grade2_summary);
        quizSummaryTextView.setText(message);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void onClick_gradeQuiz(View view) {
        /**
         * * QUESTION 1, 3 checkBoxes.
         */
        CheckBox question1_CheckBox1 = (CheckBox) findViewById(R.id.Q1_checkbox1);
        boolean Q1_CheckBox1Checked = question1_CheckBox1.isChecked();

        Log.v("MainActivity", "Answer to CheckBox 1:" + Q1_CheckBox1Checked);
        /**
         * * Question 1's second checkbox.
         */
        CheckBox question1_CheckBox2 = (CheckBox) findViewById(R.id.Q1_checkbox2);
        boolean Q1_CheckBox2Checked = question1_CheckBox2.isChecked();
        /**
         * Question 1's second checkbox.
         */
        CheckBox question1_CheckBox3 = (CheckBox) findViewById(R.id.Q1_checkbox3);
        boolean Q1_CheckBox3Checked = question1_CheckBox3.isChecked();

        int grade1 = calculateGrade_Q1(Q1_CheckBox1Checked, Q1_CheckBox2Checked, Q1_CheckBox3Checked);
        String gradeMessage_Q1 = createQuiz_Q1_Summary(grade1, Q1_CheckBox1Checked, Q1_CheckBox2Checked, Q1_CheckBox3Checked);
        displayMessage_Q1(gradeMessage_Q1);


    /**
     * QUESTION 2, 3 Radio Buttons.
     */

        /**
         * * Question 2's first RadioButton.
         */
        RadioButton question2_RadioButton1 = (RadioButton) findViewById(R.id.Q2_radio1);
        boolean Q2_RadioButton1checked = question2_RadioButton1.isChecked();
        /**
         * * Question 2's second RadioButton.
         */
        RadioButton question2_RadioButton2 = (RadioButton) findViewById(R.id.Q2_radio2);
        boolean Q2_RadioButton2checked = question2_RadioButton2.isChecked();
        /**
         * * Question 2's third RadioButton.
         */
        RadioButton question2_RadioButton3 = (RadioButton) findViewById(R.id.Q2_radio3);
        boolean Q2_RadioButton3checked = question2_RadioButton3.isChecked();

        int grade2 = calculateGrade_Q2(Q2_RadioButton1checked, Q2_RadioButton2checked, Q2_RadioButton3checked);
        String gradeMessage_Q2 = createQuiz_Q2_Summary(grade2,Q2_RadioButton1checked, Q2_RadioButton2checked, Q2_RadioButton3checked );
        displayMessage_Q2 (gradeMessage_Q2);

    }


}





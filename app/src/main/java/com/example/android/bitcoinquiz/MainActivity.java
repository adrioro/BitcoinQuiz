package com.example.android.bitcoinquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * This app offers 4 questions and delivers a greade.
 */

public class MainActivity extends AppCompatActivity {
    EditText answerField;
    int grade = 0;

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
         * Method calculateGrade_Q1 calculates question 1's total grade (Q1 has 3 CheckBoxes).
         * @param Q1_CheckBox1Checked is wether CheckBox1 is checked.
         * @param Q1_CheckBox3Checked is wether CheckBox1 is checked.
         * return final grade
         */

        private int calculateGrade_Q1(boolean Q1_CheckBox1Checked,boolean Q1_CheckBox3Checked){

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
            finalGrade = CheckBox1 + CheckBox2 + CheckBox3;
            return finalGrade;
        }

    /**
     * Quiz SUMMARY text.
     */

        private String createQuizSummary(int grade, boolean Q1_CheckBox1Checked,boolean Q1_CheckBox3Checked){

            String gradeMessage = "\n Your grade: " + calculateGrade_Q1(Q1_CheckBox1Checked,Q1_CheckBox3Checked);
            return gradeMessage;
    }




}





package com.example.android.bitcoinquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

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

        /**
         * This method displays the given text on the screen.
         */
        private void displayMessage(String message) {
        TextView quizSummaryTextView = (TextView) findViewById(R.id.grade_summary);
            quizSummaryTextView.setText(message);

    }

        /**
         * This method is called when the order button is clicked.
         */
        public void onClick_gradeQuiz(View view) {

            CheckBox question1_CheckBox1 = (CheckBox) findViewById(R.id.Q1_checkbox1);
            boolean yesQuestion1_CheckBox1 = question1_CheckBox1.isChecked();

            Log.v("MainActivity", "Answer to CheckBox 1:" + yesQuestion1_CheckBox1);
            /**
             * * Question 1's second checkbox.
             */
            CheckBox question1_CheckBox2 = (CheckBox) findViewById(R.id.Q1_checkbox2);
            boolean yesQuestion1_CheckBox2 = question1_CheckBox2.isChecked();
            /**
             * Question 1's second checkbox.
             */
            CheckBox question1_CheckBox3 = (CheckBox) findViewById(R.id.Q1_checkbox3);
            boolean yesQuestion1_CheckBox3 = question1_CheckBox3.isChecked();

            int grade = calculateGrade_Q1(Q1_CheckBox1Checked,Q1_CheckBox3Checked);
            String gradeMessage = createQuizSummary(grade, Q1_CheckBox1Checked,Q1_CheckBox3Checked);
            displayMessage(gradeMessage);


    }


}





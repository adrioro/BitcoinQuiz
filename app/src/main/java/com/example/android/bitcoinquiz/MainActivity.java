package com.example.android.bitcoinquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * This app offers 4 questions and delivers a greade.
 */

public class MainActivity extends AppCompatActivity {
    EditText answerField;
    int grade= 0;

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
     * This method is called when each CheckBox is clicked.
     */
    public void questionOne_CheckBoxes(View view) {
        /**
         * Question 1's first checkbox.
         */
        CheckBox question1_CheckBox1 = (CheckBox) findViewById(R.id.Q1_checkbox1);
        boolean yesQuestion1_CheckBox1 = question1_CheckBox1.isChecked();
        /**
         * Question 1's second checkbox.
         */
        CheckBox question1_CheckBox2 = (CheckBox) findViewById(R.id.Q1_checkbox2);
        boolean yesQuestion1_CheckBox2 = question1_CheckBox2.isChecked();
        /**
         * Question 1's second checkbox.
         */
        CheckBox question1_CheckBox3 = (CheckBox) findViewById(R.id.Q1_checkbox3);
        boolean yesQuestion1_CheckBox3 = question1_CheckBox3.isChecked();


    }
    /**
     * Calculates the grade of each CheckBox value.
     */

    private int calculateGrade_Q1 (boolean yesQuestion1_CheckBox1,boolean yesQuestion1_CheckBox2,boolean yesQuestion1_CheckBox3){
        int finalGrade =0;
        int CheckBox1 =0;
        int CheckBox2 =0;
        int CheckBox3 =0;


        if (yesQuestion1_CheckBox1){
            CheckBox1 = 2;
        }

        if (yesQuestion1_CheckBox3){
            CheckBox3 =2;
        }
        finalGrade = CheckBox1 + CheckBox2 + CheckBox3;
        return finalGrade;
    }


    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView gradeSummaryTextView = (TextView) findViewById(R.id.results);
        gradeSummaryTextView.setText(message);

    }
    /**
     * Grade summary text.
     */

        private String createGradeSummary(boolean yesQuestion1_CheckBox1,boolean yesQuestion1_CheckBox2,boolean yesQuestion1_CheckBox3){

            int grade = calculateGrade_Q1(yesQuestion1_CheckBox1,yesQuestion1_CheckBox2,yesQuestion1_CheckBox1);
            String gradeMessage_Q1 = "Your grade" + grade;
            return(gradeMessage_Q1);
    }



    public void submitGrade(View view){
        String gradeMessage = createGradeSummary();
        displayMessage(gradeMessage);
    }




}





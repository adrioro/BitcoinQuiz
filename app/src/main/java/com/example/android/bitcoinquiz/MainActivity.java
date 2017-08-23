package com.example.android.bitcoinquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * This app offers 4 questions and delivers a greade.
 */

public class MainActivity extends AppCompatActivity {
    EditText answerField;

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
     * This method is called when the grade button is clicked.
     */
    public void gradeQuiz(View view) {
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



}





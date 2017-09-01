package com.example.android.bitcoinquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app offers 4 questions and delivers a greade.
 * The following public class will be accessible to other classes defined in the same package.
 */

public class MainActivity extends AppCompatActivity {
    EditText answerField;

    int grade4;
    int grade3;
    int grade2;
    int grade1;
    private String Q4_EditText;

    /**
     * Access of a private variable is restricted to the class itself.
     * It can be modified only withn the class, even if it's private. But never outside the class.
     **/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
         * This is the input field.
         */
        answerField = (EditText) findViewById(R.id.answer_input);
    }

    /**
     * QUESTION 1 has 3 Checkboxes. Correct answers are first checkbox, and last checkbox.
     */
    /**
     * This method calculates question 1's grade.
     * <p>
     * This constructor is private, so it's objects can be created from any other class.
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

    /**
     * QUESTION 2 has 3 RadioButtons. The correct answer is the middle RadioButton.
     */
    /**
     * /*
     * This method calculates question 2's grade.
     */

    public int calculateGrade_Q2(boolean Q2_RadioButton1Checked, boolean Q2_RadioButton2Checked, boolean Q2_RadioButton3Checked) {

        int finalGrade = 0;
        int RadioButton1 = 0;
        int RadioButton2 = 0;
        int RadioButton3 = 0;


        if (Q2_RadioButton2Checked) {
            RadioButton2 = 2;
        }

        if (Q2_RadioButton1Checked) {
            RadioButton2 = 0;
        }
        if (Q2_RadioButton3Checked) {
            RadioButton2 = 0;
        }

        finalGrade = RadioButton1 + RadioButton2 + RadioButton3;
        return finalGrade;
    }
    /**
     * QUESTION 3 has 3 RadioButtons. The correct answer is the last RadioButton.
     */
    /**
     * /*
     * This calculates question 3's grade.
     */

    public int calculateGrade_Q3(boolean Q3_RadioButton1Checked, boolean Q3_RadioButton2Checked, boolean Q3_RadioButton3Checked) {

        int finalGrade = 0;
        int RadioButton1 = 0;
        int RadioButton2 = 0;
        int RadioButton3 = 0;


        if (Q3_RadioButton3Checked) {
            RadioButton3 = 2;
        }

        if (Q3_RadioButton1Checked) {
            RadioButton3 = 0;
        }
        if (Q3_RadioButton2Checked) {
            RadioButton3 = 0;
        }

        finalGrade = RadioButton1 + RadioButton2 + RadioButton3;
        return finalGrade;
    }
    /**
     * QUESTION is a text entry. The correct answer is satoshi.
     */
    /**
     * Method calculateGrade_04 calculates question 4's total grade (1 input).
     */
    public int calculateGrade_Q4(String Q4_EditText) {
        int finalGrade = 0;
        String response = Q4_EditText;

        if (response.equals("satoshi")) {
            finalGrade = 2;
        }
        if (response.equals("SATOSHI")) {
            finalGrade = 2;
        }
        if (response.equals("Satoshi")) {
            finalGrade = 2;
        }
        if (response.equals("satoyi")) { /** The way Argentineans would write it. */
            finalGrade = 2;
        }
        return finalGrade;
    }

    /**
     * This method calculates the sum of all question's grades.
     */
    public int calculateGrade_Total() {

        grade4 = calculateGrade_Q4(Q4_EditText);

        int totalGrade = grade1 + grade2 + grade3 + grade4;
        return totalGrade;

    }

    /**
     * Quiz SUMMARY texts creation.
     */

    /**
     * Question 1 SUMMARY text. It displays the grade received.
     */

    private String createQuiz_Q1_Summary(boolean Q1_CheckBox1Checked, boolean Q1_CheckBox2Checked, boolean Q1_CheckBox3Checked) {

        grade1 = calculateGrade_Q1(Q1_CheckBox1Checked, Q1_CheckBox2Checked, Q1_CheckBox3Checked); /** To be used for the total, final grade.**/

        String gradeMessage_Q1 = "\n Question 1 grade: " + calculateGrade_Q1(Q1_CheckBox1Checked, Q1_CheckBox2Checked, Q1_CheckBox3Checked) + "/4";
        return gradeMessage_Q1; /** Returns the string + int info.**/
    }

    /**
     * Question 2 SUMMARY text. It displays the grade received.
     */
    private String createQuiz_Q2_Summary(boolean Q2_CheckBox1Checked, boolean Q2_CheckBox2Checked, boolean Q2_CheckBox3Checked) {

        grade2 = calculateGrade_Q2(Q2_CheckBox1Checked, Q2_CheckBox2Checked, Q2_CheckBox3Checked); /** To be used for the total, final grade.**/

        String gradeMessage_Q2 = "\n Question 2 grade: " + calculateGrade_Q2(Q2_CheckBox1Checked, Q2_CheckBox2Checked, Q2_CheckBox3Checked) + "/2";
        return gradeMessage_Q2; /** Returns the string + int info.**/
    }

    /**
     * Question 3 SUMMARY text. It displays the grade received.
     */
    private String createQuiz_Q3_Summary(boolean Q3_CheckBox1Checked, boolean Q3_CheckBox2Checked, boolean Q3_CheckBox3Checked) {

        grade3 = calculateGrade_Q3(Q3_CheckBox1Checked, Q3_CheckBox2Checked, Q3_CheckBox3Checked); /** To be used for the total, final grade.**/

        String gradeMessage_Q3 = "\n Question 3 grade: " + calculateGrade_Q3(Q3_CheckBox1Checked, Q3_CheckBox2Checked, Q3_CheckBox3Checked) + "/2";
        return gradeMessage_Q3; /** Returns the string + int info.**/
    }

    /**
     * Question 4 SUMMARY text. It displays the grade received.
     */
    private String createQuiz_Q4_Summary(String Q4_EditText) {

        String gradeMessage_Q4 = "\n Question 4 grade: " + calculateGrade_Q4(Q4_EditText) + "/2";
        return gradeMessage_Q4; /** Returns the string + int info.**/
    }

    /**
     * Total Grade SUMMARY text. It displays the grade received.
     */
    private String createQuiz_total_Summary(int grade) {

        String gradeMessage_total = "\n Total grade: " + calculateGrade_Total() + "/10";
        return gradeMessage_total; /** Returns the string + int total info.**/
    }


    /**
     * These methods displays the given text on the screen.
     */
    private void displayMessage_Q1(String message) {
        TextView quizSummaryTextView = (TextView) findViewById(R.id.grade1_summary); /** Finds the view on the .xml where the text will be displayed**/
        quizSummaryTextView.setText(message); /** Sets the text to be displayed **/
    }

    private void displayMessage_Q2(String message) {
        TextView quizSummaryTextView = (TextView) findViewById(R.id.grade2_summary); /** Finds the view on the .xml where the text will be displayed**/
        quizSummaryTextView.setText(message); /** Sets the text to be displayed **/
    }

    private void displayMessage_Q3(String message) {
        TextView quizSummaryTextView = (TextView) findViewById(R.id.grade3_summary); /** Finds the view on the .xml where the text will be displayed**/
        quizSummaryTextView.setText(message); /** Sets the text to be displayed **/
    }

    private void displayMessage_Q4(String message) {
        TextView quizSummaryTextView = (TextView) findViewById(R.id.grade4_summary); /** Finds the view on the .xml where the text will be displayed**/
        quizSummaryTextView.setText(message); /** Sets the text to be displayed **/
    }

    private void displayMessage_total(String message) {
        TextView quizSummaryTextView = (TextView) findViewById(R.id.totalGrade_summary); /** Finds the view on the .xml where the text will be displayed**/
        quizSummaryTextView.setText(message); /** Sets the text to be displayed **/
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void onClick_gradeQuiz(View view) {
        /**
         * * QUESTION 1, 3 checkBoxes.
         */
        CheckBox question1_CheckBox1 = (CheckBox) findViewById(R.id.Q1_checkbox1); /** Finds the checkbox on the .xml**/
        boolean Q1_CheckBox1Checked = question1_CheckBox1.isChecked(); /** Checks the status**/

        Log.v("MainActivity", "Answer to CheckBox 1:" + Q1_CheckBox1Checked); /** Just for me.**/
        /**
         * * Question 1's second checkbox.
         */
        CheckBox question1_CheckBox2 = (CheckBox) findViewById(R.id.Q1_checkbox2); /** Finds the checkbox on the .xml**/
        boolean Q1_CheckBox2Checked = question1_CheckBox2.isChecked();/** Checks the status**/
        /**
         * Question 1's second checkbox.
         */
        CheckBox question1_CheckBox3 = (CheckBox) findViewById(R.id.Q1_checkbox3); /** Finds the checkbox on the .xml**/
        boolean Q1_CheckBox3Checked = question1_CheckBox3.isChecked();/** Checks the status**/


        String gradeMessage_Q1 = createQuiz_Q1_Summary(Q1_CheckBox1Checked, Q1_CheckBox2Checked, Q1_CheckBox3Checked);
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


        String gradeMessage_Q2 = createQuiz_Q2_Summary(Q2_RadioButton1checked, Q2_RadioButton2checked, Q2_RadioButton3checked);
        displayMessage_Q2(gradeMessage_Q2);

        /**
         * QUESTION 3, 3 Radio Buttons.
         */

        /**
         * * Question 3's first RadioButton.
         */
        RadioButton question3_RadioButton1 = (RadioButton) findViewById(R.id.Q3_radio1);
        boolean Q3_RadioButton1checked = question3_RadioButton1.isChecked();
        /**
         * * Question 3's second RadioButton.
         */
        RadioButton question3_RadioButton2 = (RadioButton) findViewById(R.id.Q3_radio2);
        boolean Q3_RadioButton2checked = question3_RadioButton2.isChecked();
        /**
         * * Question 2's third RadioButton.
         */
        RadioButton question3_RadioButton3 = (RadioButton) findViewById(R.id.Q3_radio3);
        boolean Q3_RadioButton3checked = question3_RadioButton3.isChecked();


        String gradeMessage_Q3 = createQuiz_Q3_Summary(Q3_RadioButton1checked, Q3_RadioButton2checked, Q3_RadioButton3checked);
        displayMessage_Q3(gradeMessage_Q3);

        /**
         * QUESTION 4, 1 text entry.
         */
        EditText question4_EditText = (EditText) findViewById(R.id.answer_input);  /** Finds the view on the .xml where the text will be displayed**/
        Q4_EditText = question4_EditText.getText().toString();

        int grade4 = calculateGrade_Q4(Q4_EditText);
        String gradeMessage_Q4 = createQuiz_Q4_Summary(Q4_EditText);
        displayMessage_Q4(gradeMessage_Q4);

        /**
         * Total grade.
         */

        int gradeTotal = calculateGrade_Total();
        String gradeMessage_Total = createQuiz_total_Summary(gradeTotal);
        displayMessage_total(gradeMessage_Total);

        Context context = getApplicationContext();
        CharSequence text = "Thank you for completing the text! Your final grade is: " + gradeTotal;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

}





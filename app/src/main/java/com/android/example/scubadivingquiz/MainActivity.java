package com.android.example.scubadivingquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //storage for correct and incorrect answers
    int correctAnswerOne = 0;   //a
    int correctAnswerTwo = 0;   //a
    int correctAnswerThree = 0; //24
    int correctAnswerFour = 0;  //b
    int correctAnswerFive = 0;  //all
    int wrongAnswerOne = 1;
    int wrongAnswerTwo = 1;
    int wrongAnswerThree = 1;
    int wrongAnswerFour = 1;
    int wrongAnswerFive = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Check Question one for answer when button is pressed
    public void questionOneButton(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        //if one of the four buttons are pressed store the number of correct and incorrect answers
        switch (view.getId()) {
            case R.id.radio_one_one:
                if (checked)
                    correctAnswerOne = 1;
                wrongAnswerOne = 0;
                break;
            case R.id.radio_one_two:
                if (checked)
                    wrongAnswerOne = 1;
                correctAnswerOne = 0;
                break;
            case R.id.radio_one_three:
                if (checked)
                    wrongAnswerOne = 1;
                correctAnswerOne = 0;
                break;
            case R.id.radio_one_four:
                if (checked)
                    wrongAnswerOne = 1;
                correctAnswerOne = 0;
                break;
        }
    }

    // Check Question two for answer when button is pressed
    public void questionTwoButton(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        //if one of the two buttons are pressed store the number of correct and incorrect answers
        switch (view.getId()) {
            case R.id.radio_two_one:
                if (checked)
                    correctAnswerTwo = 1;
                wrongAnswerTwo = 0;
                break;
            case R.id.radio_two_two:
                if (checked)
                    wrongAnswerTwo = 1;
                correctAnswerTwo = 0;
                break;
        }
    }

    // Check question three for correct answer when submit button is pressed
    public void questionThreeTextField() {

        EditText answerTextField = findViewById(R.id.answer_field_three);

        //NumberFormatException error without any answer insert, cannot convert null to int
        //quick and dirty deal with error: if error skip it -> catch
        //better solution?
        try {
            if (Integer.parseInt(answerTextField.getText().toString()) == 24) {
                correctAnswerThree = 1;
                wrongAnswerThree = 0;
            } else {
                wrongAnswerThree = 1;
                correctAnswerThree = 0;
            }
        } catch (Exception ex) {
            wrongAnswerThree = 1;
            correctAnswerThree = 0;
        }

    }

    // Check question four for answer when button is pressed
    public void questionFourButton(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        //if one of the four buttons are pressed store the number of correct and incorrect answers
        switch (view.getId()) {
            case R.id.radio_four_one:
                if (checked)
                    wrongAnswerFour = 1;
                correctAnswerFour = 0;
                break;
            case R.id.radio_four_two:
                if (checked)
                    correctAnswerFour = 1;
                wrongAnswerFour = 0;
                break;
            case R.id.radio_four_three:
                if (checked)
                    wrongAnswerFour = 1;
                correctAnswerFour = 0;
                break;
            case R.id.radio_four_four:
                if (checked)
                    wrongAnswerFour = 1;
                correctAnswerFour = 0;
                break;
        }
    }

    //Check question five for Answer when submit button is pressed
    public void questionFiveCheckBox() {

        CheckBox checkBoxOne = findViewById(R.id.check_five_one);
        CheckBox checkBoxTwo = findViewById(R.id.check_five_two);
        CheckBox checkBoxThree = findViewById(R.id.check_five_three);
        CheckBox checkBoxFour = findViewById(R.id.check_five_four);

        //check if all correct answers are checked
        if (checkBoxOne.isChecked() && checkBoxTwo.isChecked() && checkBoxThree.isChecked() && checkBoxFour.isChecked()) {
            correctAnswerFive = 1;
            wrongAnswerFive = 0;
        } else {
            wrongAnswerFive = 1;
            correctAnswerFive = 0;
        }
    }

    // Submit button
    public void submitAnswersButton(View view) {

        // call method to check question five and three
        questionFiveCheckBox();
        questionThreeTextField();

        //add number of correct and inccorect answers
        int correctAnswers = correctAnswerOne + correctAnswerTwo + correctAnswerThree + correctAnswerFour + correctAnswerFive;
        int wrongAnswers = wrongAnswerOne + wrongAnswerTwo + wrongAnswerThree + wrongAnswerFour + wrongAnswerFive;

        // Create answer string
        String finalAnswer = "You have answerd " + correctAnswers + " questions correct and " + wrongAnswers + " questions wrong!";

        // Show answer message as a Toast
        Toast.makeText(getApplicationContext(), finalAnswer, Toast.LENGTH_LONG).show();
    }
}

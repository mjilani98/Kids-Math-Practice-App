package com.example.kidsmathpracticeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Generator generator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //create a generator object
         generator = new Generator();

        initialize(generator);
    }

    public void initialize(Generator generator)
    {
        // - generate
        generator.generate();

        //display number 1
        TextView output1 = findViewById(R.id.Num1);
        String strNum1 = generator.getNum1()+"";
        output1.setText(strNum1);

        //display number 2
        TextView output2 = findViewById(R.id.Num2);
        String strNum2 = generator.getNum2()+"";
        output2.setText(strNum2);

        //set the operator text view
        TextView operatorView = findViewById(R.id.Operator);
        String operator = "";
        if(generator.getOperator() == 1)
            operator = "+";
        if(generator.getOperator() == 2)
            operator = "-";
        if(generator.getOperator() == 3)
            operator = "*";
        if(generator.getOperator() == 4)
            operator = "/";
        operatorView.setText(operator);

        //get the total answers and correct answers
        TextView scoreOutPut = findViewById(R.id.Scores);
        scoreOutPut.setText("0/0");

        //- enable submit button, disable next button

        //submit button
        Button submitBtn = findViewById(R.id.SubmitButton);
        submitBtn.setEnabled(true);

        //next button
        Button nextBtn = findViewById(R.id.NextButton);
        nextBtn.setEnabled(false);
    }

    public void submit(View v)
    {
        //read a users answer
        EditText userInput = findViewById(R.id.AnswerInputBox);
        String strUserInput = userInput.getText().toString();
        int userAnswer=0;
        try {
             userAnswer = Integer.parseInt(strUserInput);
        }
        catch (NumberFormatException e) // if the user enters an empty answer
        {
            generator.incrementTotalQuestions();
        }

        // if the user did not enter an empty answer , check if the answer is right
        if(!strUserInput.isEmpty())
        {
            //get answer
            int answer = generator.getCorrectAnswer();

            //if users answer equal answer , increase correct
            if(userAnswer == answer)
            {
                generator.incrementCorrectAnswers();
                generator.incrementTotalQuestions();
            }
            else
                generator.incrementTotalQuestions();
        }

        //getting the number of correct answers and number of questions
        String strCorrectAnswer = generator.getTotalCorrectAnswers()+"";
        String strTotalQuestions = generator.getTotalQuestions()+"";

        //getting hold of the text view and display the score
        TextView scoreOutPut = findViewById(R.id.Scores);
        scoreOutPut.setText(strCorrectAnswer+"/"+strTotalQuestions);

        //submit button , disabled
        Button submitBtn = findViewById(R.id.SubmitButton);
        submitBtn.setEnabled(false);

        //next button , enabled
        Button nextBtn = findViewById(R.id.NextButton);
        nextBtn.setEnabled(true);
    }

    public void next(View v)
    {
        //generate
        generator.generate();

        //get operator , two numbers, correct, total
        //display two numbers, operator

        //display number 1
        TextView output1 = findViewById(R.id.Num1);
        String strNum1 = generator.getNum1()+"";
        output1.setText(strNum1);

        //display number 2
        TextView output2 = findViewById(R.id.Num2);
        String strNum2 = generator.getNum2()+"";
        output2.setText(strNum2);

        //set the operator text view
        TextView operatorView = findViewById(R.id.Operator);
        String operator = "";
        if(generator.getOperator() == 1)
            operator = "+";
        if(generator.getOperator() == 2)
            operator = "-";
        if(generator.getOperator() == 3)
            operator = "*";
        if(generator.getOperator() == 4)
            operator = "/";
        operatorView.setText(operator);

        //display correct, total
        //get the total answers and correct answers
        TextView scoreOutPut = findViewById(R.id.Scores);
        String strCorrectAnswer = generator.getTotalCorrectAnswers()+"";
        String strTotalQuestions = generator.getTotalQuestions()+"";
        scoreOutPut.setText(strCorrectAnswer+"/"+strTotalQuestions);

        //enable submit button, disable submit button

        //submit button , disabled
        Button submitBtn = findViewById(R.id.SubmitButton);
        submitBtn.setEnabled(true);

        //next button , enabled
        Button nextBtn = findViewById(R.id.NextButton);
        nextBtn.setEnabled(false);

        //clearing the input from the previous question
        EditText input = findViewById(R.id.AnswerInputBox);
        input.setText("");
    }


}
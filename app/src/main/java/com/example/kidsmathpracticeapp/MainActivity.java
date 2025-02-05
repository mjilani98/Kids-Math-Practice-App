package com.example.kidsmathpracticeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //create a generator object
        Generator generator = new Generator();

        initialize(generator);







    }

    public void initialize(Generator generator)
    {

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

        String strCorrectAnswer = generator.getTotalCorrectAnswers()+"";
        String strTotalQuestions = generator.getTotalQuestions()+"";

        scoreOutPut.setText(strCorrectAnswer + "/" + strTotalQuestions);
    }


}
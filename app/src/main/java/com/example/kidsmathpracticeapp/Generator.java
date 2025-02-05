package com.example.kidsmathpracticeapp;

import java.util.Random;

public class Generator {

    //number 1 will be randomly generated
    private int num1;
    //number 2 will be randomly generated
    private int num2;
    //The correct answer based on the type of operation
    private int correctAnswer;
    //The number that will be inputted from the user
    private int answerInput;
    //The type of operation, randomly will be generated
    private int operator;
    //The total number of questions been answered
    private int totalQuestions;
    //The total number of the right answers
    private int totalCorrectAnswers = 0 ;


    //create a Random class object
    private Random random = new Random();
    //public constructor
    public Generator()
    {
        //the operator will range between 1 and 4 , both inclusive
        operator = random.nextInt(4) +1 ;
        totalQuestions +=1;

    }
    // if the operation is less or equal to 2 it is Addition or subtraction
    // if the operation is more than 2 is is Multiplication or Division

    //get number 1
    public int getNum1()
    {
        //if the operation is Addition or subtraction , number range between 1 - 999
        if(operator <= 2)
            num1 = random.nextInt(999) + 1;
        else
            //if the operation is Multiplication or Division , number range between 1 - 99
            num1 = random.nextInt(99) + 1;

        return num1;
    }

    //get number 2
    public int getNum2()
    {
        //if the operation is Addition or subtraction , number range between 1 - 999
        //if the operation is Division , the number 2 has to be between 1 - 99
        if(operator <= 3)
            num2 = random.nextInt(999) + 1;
        else
            //if the operation is Multiplication or Division , number range between 1 - 99
            num2 = random.nextInt(99) + 1;

        return num2;
    }

    //get the correct answer
    public int getCorrectAnswer()
    {
        //if Addition
        if(operator == 1 )
            correctAnswer = num1 + num2;
        //if Subtraction
        if(operator == 2)
            correctAnswer = num1 - num2;
        if(operator == 3 )
            correctAnswer = num1 * num2;
        if(operator == 4 )
            correctAnswer = num1 / num2;

        return correctAnswer;
    }

    //get total questions
    public int getTotalQuestions()
    {
        return totalQuestions;
    }

    //get the total of correct answers
    public int getTotCorrectAnswers()
    {
        return totalCorrectAnswers;
    }

    public void incrementCorrectAnswes()
    {
        totalCorrectAnswers +=1;
    }



}

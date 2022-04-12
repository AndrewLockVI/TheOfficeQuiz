package com.nebuladev.quizgame

import android.widget.Toast

class checkAnswer
{
    var Question : Question = Question()

    fun answerCheck( questionNum : Int , buttonText : String) : Boolean
    {
       var questionList : List<String> =  Question.question(questionNum);
       if(questionList[1] == buttonText)
       {
           return true
       }

           return false

    }




}
package com.nebuladev.quizgame

import android.widget.Button
import android.widget.TextView

class ClickChange
{

    fun changeClick(buttonOne: Button , buttonTwo : Button , buttonThree : Button , buttonFour : Button)
    {
        if(buttonOne.isClickable == false)
        {
            buttonTwo.isClickable = true
            buttonOne.isClickable = true
            buttonThree.isClickable = true
            buttonFour.isClickable = true
        }
        else
        {
            buttonTwo.isClickable = false
            buttonOne.isClickable = false
            buttonThree.isClickable = false
            buttonFour.isClickable = false
        }


    }


}
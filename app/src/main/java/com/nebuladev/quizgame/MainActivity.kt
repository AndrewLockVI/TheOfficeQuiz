package com.nebuladev.quizgame

import android.app.PendingIntent.getActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{

 private lateinit var buttonOne : Button;
 private lateinit var buttonTwo : Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonOne = findViewById(R.id.answer_one)
        buttonTwo = findViewById(R.id.answer_two)
        buttonTwo.setOnClickListener{
            var text : TextView = findViewById(R.id.txtQuestion)

        }
        buttonOne.setOnClickListener{

        }

    }
}
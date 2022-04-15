package com.nebuladev.quizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LandingPage : AppCompatActivity()
{

    private lateinit var playGame : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)
        playGame = findViewById(R.id.playButton)
        playGame.setOnClickListener(){
            playGame()
        }
    }



    fun playGame()
    {
        val intent = Intent(this , MainActivity::class.java)
        startActivity(intent)

    }

}
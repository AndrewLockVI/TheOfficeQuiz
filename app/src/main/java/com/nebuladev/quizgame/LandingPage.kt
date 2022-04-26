package com.nebuladev.quizgame

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import org.w3c.dom.Text

class LandingPage : AppCompatActivity()
{

    private lateinit var playGame : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_landing_page)
        playGame = findViewById(R.id.playButton)
        playGame.setOnClickListener(){
            playGame()
        }
        var level : TextView = findViewById(R.id.frontpageLvl)
        var sharedPrefrences : SharedPreferences = getSharedPreferences("score" , MODE_PRIVATE)
        level.text = "level " + sharedPrefrences.getInt("level" , MODE_PRIVATE)
        var currentLvl : TextView = findViewById(R.id.currLevel)
        var nextLvl : TextView = findViewById(R.id.nextLevel)
        currentLvl.text = sharedPrefrences.getInt("level" , MODE_PRIVATE).toString()
        nextLvl.text =  (sharedPrefrences.getInt("level" , MODE_PRIVATE) + 1).toString()

        var totalScore : TextView = findViewById(R.id.scoreTotal)
        totalScore.text = sharedPrefrences.getInt("total" , MODE_PRIVATE).toString()
        var highScore : TextView = findViewById(R.id.highScore)
        highScore.text = sharedPrefrences.getInt("high", MODE_PRIVATE).toString()


        var progressBar : ProgressBar = findViewById(R.id.progressbar_horizontal)
        ObjectAnimator.ofInt(progressBar,"progress",  ((((sharedPrefrences.getInt("score" , MODE_PRIVATE).toDouble() - (sharedPrefrences.getInt("level" , MODE_PRIVATE).toDouble() - 1) * 100) / 100) * 100) + 1).toInt())
            .setDuration(1000)
            .start()

    }



    fun playGame()
    {
        val intent = Intent(this , MainActivity::class.java)
        startActivity(intent)

    }

}
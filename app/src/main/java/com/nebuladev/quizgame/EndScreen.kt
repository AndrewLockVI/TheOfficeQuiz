package com.nebuladev.quizgame

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.app.NotificationCompat.getExtras
import org.w3c.dom.Text

class EndScreen : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_screen)
        var levelScore = 100
        var score : String = getIntent().getStringExtra("score").toString()
        var  scoreText : TextView = findViewById(R.id.scoreText)
        var progressBar1 : ProgressBar = findViewById(R.id.progressToLevel)
        scoreText.text = "+" + (score.substringBefore("/").toInt() * 10).toString()
        var sharedPreferences : SharedPreferences = getSharedPreferences("score" , MODE_PRIVATE)
        var sharedPreferencesEditor : SharedPreferences.Editor = sharedPreferences.edit()
        sharedPreferencesEditor.putInt("score", sharedPreferences.getInt("score" , 0) + score.substringBefore("/").toInt() * 10)
        sharedPreferencesEditor.commit()
        if(sharedPreferences.getInt("score", MODE_PRIVATE) >= (sharedPreferences.getInt("level", MODE_PRIVATE)) * levelScore)
        {
            sharedPreferencesEditor.putInt("level" , sharedPreferences.getInt("level", MODE_PRIVATE) + 1)
        }



        sharedPreferencesEditor.commit()
        var level : TextView = findViewById(R.id.level)
        level.text = (sharedPreferences.getInt("level" , MODE_PRIVATE)).toString()
        var totalScoreInt = sharedPreferences.getInt("score" , MODE_PRIVATE).toString() + " / " + ((sharedPreferences.getInt("level" , MODE_PRIVATE)) * levelScore).toString()
        var totalScore : TextView = findViewById(R.id.totalScore)
        totalScore.text = totalScoreInt

        progressBar1.progress = (((sharedPreferences.getInt("score" , MODE_PRIVATE).toDouble() - (sharedPreferences.getInt("level" , MODE_PRIVATE).toDouble() - 1) * levelScore) / levelScore) * 100).toInt()


        var mainMenu : Button = findViewById(R.id.mainMenu)
        mainMenu.setOnClickListener(){
            var intentMenu : Intent = Intent(this,LandingPage::class.java)
            startActivity(intentMenu)
        }
        var playAgain : Button = findViewById(R.id.playAgain)
        playAgain.setOnClickListener(){
            var intentPlay : Intent = Intent(this,MainActivity::class.java)
            startActivity(intentPlay)

        }



    }


    fun resetPrefs()
    {
        var sharedPreferences : SharedPreferences = getSharedPreferences("score" , MODE_PRIVATE)
        var sharedPreferencesEditor : SharedPreferences.Editor = sharedPreferences.edit()
        sharedPreferencesEditor.putInt("score" , 0)
        sharedPreferencesEditor.putInt("level" , 0)
        sharedPreferencesEditor.commit()
    }




}
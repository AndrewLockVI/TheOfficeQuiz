package com.nebuladev.quizgame

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
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
    private lateinit var media : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_landing_page)
        musicPlay()

        playGame = findViewById(R.id.playButton)
        playGame.setOnClickListener(){
            playGame()
        }
        var level : TextView = findViewById(R.id.frontpageLvl)
        var sharedPrefrences : SharedPreferences = getSharedPreferences("score" , MODE_PRIVATE)
        var sharedPreferencesEditor : SharedPreferences.Editor = sharedPrefrences.edit()
        while(sharedPrefrences.getInt("score", MODE_PRIVATE) >= (sharedPrefrences.getInt("level", MODE_PRIVATE)) * 100)
        {
            sharedPreferencesEditor.putInt("level" , sharedPrefrences.getInt("level", MODE_PRIVATE) + 1)
            sharedPreferencesEditor.commit()
        }


        if(sharedPrefrences.getBoolean("first" , false) == false)
        {
            var prefs : SharedPreferences = getSharedPreferences("sound" , MODE_PRIVATE)
            var prefsEditor = prefs.edit()
            prefsEditor.putBoolean("sfx" , true)
            prefsEditor.commit()
            sharedPreferencesEditor.putBoolean("first" , true)
            sharedPreferencesEditor.commit()
        }







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





        var settingsBtn : Button = findViewById(R.id.settings)
        settingsBtn.setOnClickListener(){
            var intentSetting : Intent = Intent(this, SettingScreen::class.java)
            startActivity(intentSetting)
            overridePendingTransition(R.anim.sliding_setting, R.anim.sliding_setting_out)
        }

        var percent = scorePercent()

        var score : TextView = findViewById(R.id.highScoreTextPercent)
        score.text = percent.scorePercentReturn(sharedPrefrences.getInt("high" , MODE_PRIVATE)).toString() + "%"


        var total : TextView = findViewById(R.id.correctAnswerPercenttxt)
        total.text = percent.totalPercentReturn(sharedPrefrences.getInt("total" , MODE_PRIVATE)).toString() + "%"







    }



    fun playGame()
    {
        val intent = Intent(this , MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition( R.anim.slide_down , R.anim.slide_up );
    }

    public fun musicPlay()
    {
        media = MediaPlayer.create(this, R.raw.the_office_background)
        media.setLooping(true)
        media.setVolume(1.0f,1.0f)
        media.start()
    }


}
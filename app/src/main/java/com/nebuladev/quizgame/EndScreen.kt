package com.nebuladev.quizgame

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.app.NotificationCompat.getExtras
import org.w3c.dom.Text

class EndScreen : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_screen)
        var levelScore = 100
        var characterImage : ImageView = findViewById(R.id.charImage)
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
        level.text = "Level: " + (sharedPreferences.getInt("level" , MODE_PRIVATE)).toString()
        level(sharedPreferences.getInt("level" , MODE_PRIVATE) , characterImage)

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

    fun level(currLevel : Int , image : ImageView)
    {
        if(currLevel == 1)
        {
            image.setBackgroundResource(R.drawable.todd)
        }
        else if (currLevel == 2)
        {
            image.setBackgroundResource(R.drawable.toby)
        }
        else if (currLevel == 3)
        {
            image.setBackgroundResource(R.drawable.nellie)
        }
        else if (currLevel == 4)
        {
            image.setBackgroundResource(R.drawable.karen)
        }
        else if (currLevel == 5)
        {
            image.setBackgroundResource(R.drawable.deangelo)
        }
        else if (currLevel == 6)
        {
            image.setBackgroundResource(R.drawable.gabe)
        }
        else if (currLevel == 7)
        {
            image.setBackgroundResource(R.drawable.jan)
        }
        else if (currLevel == 8)
        {
            image.setBackgroundResource(R.drawable.merideth)
        }
        else if (currLevel == 9)
        {
            image.setBackgroundResource(R.drawable.erin)
        }
        else if (currLevel == 10)
        {
            image.setBackgroundResource(R.drawable.mose)
        }
        else if (currLevel == 11)
        {
            image.setBackgroundResource(R.drawable.david)
        }
        else if (currLevel == 12)
        {
            image.setBackgroundResource(R.drawable.andy)
        }
        else if (currLevel == 13)
        {
            image.setBackgroundResource(R.drawable.roy)
        }
        else if (currLevel == 14)
        {
            image.setBackgroundResource(R.drawable.robert)
        }

        else if (currLevel == 15)
        {
            image.setBackgroundResource(R.drawable.oscar)
        }
        else if (currLevel == 16)
        {
            image.setBackgroundResource(R.drawable.darryl)
        }
        else if (currLevel == 17)
        {
            image.setBackgroundResource(R.drawable.kevin)
        }

        else if (currLevel == 18)
        {
            image.setBackgroundResource(R.drawable.stanley)
        }

        else if (currLevel == 19)
        {
            image.setBackgroundResource(R.drawable.dwight)
        }
        else if (currLevel == 20)
        {
            image.setBackgroundResource(R.drawable.michael)
        }
        else if (currLevel == 21)
        {
            image.setBackgroundResource(R.drawable.pam)
        }
        else
        {
            image.setBackgroundResource(R.drawable.jim)
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
package com.nebuladev.quizgame

import android.animation.ObjectAnimator
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
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.NotificationCompat.getExtras
import org.w3c.dom.Text

class EndScreen : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_end_screen)
        var levelScore = 100
        var characterImage : ImageView = findViewById(R.id.charImage)
        var score : String = getIntent().getStringExtra("score").toString()
        var  scoreText : TextView = findViewById(R.id.scoreText)
        var progressBar1 : ProgressBar = findViewById(R.id.progressToLevel)
        scoreText.text = "+" + (score.substringBefore("/").toInt() * 10).toString()
        var sharedPreferences : SharedPreferences = getSharedPreferences("score" , MODE_PRIVATE)
        var sharedPreferencesEditor : SharedPreferences.Editor = sharedPreferences.edit()
        progressBar1.progress = (((sharedPreferences.getInt("score" , MODE_PRIVATE).toDouble() - (sharedPreferences.getInt("level" , MODE_PRIVATE).toDouble() - 1) * levelScore) / levelScore) * 100).toInt()
        sharedPreferencesEditor.putInt("score", sharedPreferences.getInt("score" , 0) + score.substringBefore("/").toInt() * 10)
        sharedPreferencesEditor.commit()
        if(sharedPreferences.getInt("score", MODE_PRIVATE) >= (sharedPreferences.getInt("level", MODE_PRIVATE)) * levelScore)
        {
            sharedPreferencesEditor.putInt("level" , sharedPreferences.getInt("level", MODE_PRIVATE) + 1)
        }






        sharedPreferencesEditor.commit()
        var level : TextView = findViewById(R.id.level)
        level.text = "Level " + (sharedPreferences.getInt("level" , MODE_PRIVATE)).toString() + ":"
        level(sharedPreferences.getInt("level" , MODE_PRIVATE) , characterImage)

        var totalScoreInt = sharedPreferences.getInt("score" , MODE_PRIVATE).toString() + " / " + ((sharedPreferences.getInt("level" , MODE_PRIVATE)) * levelScore).toString()
        var totalScore : TextView = findViewById(R.id.totalScore)
        totalScore.text = totalScoreInt
        ObjectAnimator.ofInt(progressBar1,"progress",  ((((sharedPreferences.getInt("score" , MODE_PRIVATE).toDouble() - (sharedPreferences.getInt("level" , MODE_PRIVATE).toDouble() - 1) * levelScore) / levelScore) * 100) + 1).toInt())
            .setDuration(1000)
            .start()




        var name : TextView = findViewById(R.id.name)
        name.text = getName(sharedPreferences.getInt("level" , MODE_PRIVATE))

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
    fun getName(currLevel : Int) : String
    {
        if(currLevel == 1)
        {
            return "Todd"
        }
        else if (currLevel == 2)
        {
            return "Toby"
        }
        else if (currLevel == 3)
        {
            return "Nellie"
        }
        else if (currLevel == 4)
        {
            return "Karen"
        }
        else if (currLevel == 5)
        {
            return "Deangelo"
        }
        else if (currLevel == 6)
        {
            return "Gabe"
        }
        else if (currLevel == 7)
        {
            return "Jan"
        }
        else if (currLevel == 8)
        {
            return "Meredith"
        }
        else if (currLevel == 9)
        {
            return "Erin"
        }
        else if (currLevel == 10)
        {
            return "Mose"
        }
        else if (currLevel == 11)
        {
            return "David"
        }
        else if (currLevel == 12)
        {
            return "Andy"
        }
        else if (currLevel == 13)
        {
            return "Roy"
        }
        else if (currLevel == 14)
        {
            return "Robert"
        }

        else if (currLevel == 15)
        {
            return "Oscar"
        }
        else if (currLevel == 16)
        {
            return "Darryl"
        }
        else if (currLevel == 17)
        {
            return "Kevin"
        }

        else if (currLevel == 18)
        {
            return "Stanley"
        }

        else if (currLevel == 19)
        {
            return "Dwight"
        }
        else if (currLevel == 20)
        {
            return "Michael"
        }
        else if (currLevel == 21)
        {
            return "Pam"
        }
        else
        {
            return "Jim"
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
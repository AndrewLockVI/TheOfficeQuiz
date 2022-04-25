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
        //var characterImage : ImageView = findViewById(R.id.charImage)
        var score : String = getIntent().getStringExtra("score").toString()
     //   var  scoreText : TextView = findViewById(R.id.scoreLast)
        var progressBar1 : ProgressBar = findViewById(R.id.progressToLevel)
        var affirmation : TextView = findViewById(R.id.goodJobtxt)
    //    scoreText.text = "+" + (score.substringBefore("/").toInt() * 10).toString()
        var sharedPreferences : SharedPreferences = getSharedPreferences("score" , MODE_PRIVATE)
        var sharedPreferencesEditor : SharedPreferences.Editor = sharedPreferences.edit()
        progressBar1.progress = (((sharedPreferences.getInt("score" , MODE_PRIVATE).toDouble() - (sharedPreferences.getInt("level" , MODE_PRIVATE).toDouble() - 1) * levelScore) / levelScore) * 100).toInt()
        sharedPreferencesEditor.putInt("score", sharedPreferences.getInt("score" , 0) + score.substringBefore("/").toInt() * 10)
        sharedPreferencesEditor.commit()
        if(sharedPreferences.getInt("score", MODE_PRIVATE) >= (sharedPreferences.getInt("level", MODE_PRIVATE)) * levelScore)
        {
           affirmation.text = "Level Up!"
            sharedPreferencesEditor.putInt("level" , sharedPreferences.getInt("level", MODE_PRIVATE) + 1)
        }
        var scoreOutOf : TextView = findViewById(R.id.totalScore)
        scoreOutOf.text = score.substringBefore("/") + " / 15"


        if(score.substringBefore("/").toInt() < 4)
        {
            affirmation.text = "Keep Going!"
        }
        else if(score.substringBefore("/").toInt() < 6)
        {
            affirmation.text = "Pretty Good!"
        }
        else if(score.substringBefore("/").toInt() < 7)
        {
            affirmation.text = "Nice Job!"
        }
        else if(score.substringBefore("/").toInt() <= 12)
        {
            affirmation.text = "Wow Amazing!"
        }
        else if(score.substringBefore("/").toInt() == 15)
        {
            affirmation.text = "Perfect Score!"
        }

        var totalScore : TextView = findViewById(R.id.scoreTotal)
        totalScore.text = sharedPreferences.getInt("total" , MODE_PRIVATE).toString()


            sharedPreferencesEditor.commit()
       // var level : TextView = findViewById(R.id.level)
       // level.text = "Level " + (sharedPreferences.getInt("level" , MODE_PRIVATE)).toString() + ":"
       // level(sharedPreferences.getInt("level" , MODE_PRIVATE) , characterImage)
        var currentLvl : TextView = findViewById(R.id.currLevel)
        var nextlvl : TextView = findViewById(R.id.nextLevel)

        currentLvl.text = sharedPreferences.getInt("level" , MODE_PRIVATE).toString()
        nextlvl.text = (sharedPreferences.getInt("level" , MODE_PRIVATE) + 1).toString()



        var totalScoreInt = sharedPreferences.getInt("score" , MODE_PRIVATE).toString() + " / " + ((sharedPreferences.getInt("level" , MODE_PRIVATE)) * levelScore).toString()
   //     var totalScore : TextView = findViewById(R.id.totalScore)
    //    totalScore.text = totalScoreInt
        ObjectAnimator.ofInt(progressBar1,"progress",  ((((sharedPreferences.getInt("score" , MODE_PRIVATE).toDouble() - (sharedPreferences.getInt("level" , MODE_PRIVATE).toDouble() - 1) * levelScore) / levelScore) * 100) + 1).toInt())
            .setDuration(1000)
            .start()




        /*var name : TextView = findViewById(R.id.name)
        name.text = getName(sharedPreferences.getInt("level" , MODE_PRIVATE))
  */
        var mainMenu : Button = findViewById(R.id.mainMenu)
        mainMenu.setOnClickListener(){
            var intentMenu : Intent = Intent(this,LandingPage::class.java)
            startActivity(intentMenu)
        }


        var playAgain : Button = findViewById(R.id.playButton)
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
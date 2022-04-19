package com.nebuladev.quizgame

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.app.NotificationCompat.getExtras
import org.w3c.dom.Text

class EndScreen : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_screen)
        var score : String = getIntent().getStringExtra("score").toString()
        var  scoreText : TextView = findViewById(R.id.scoreText)
        var progressBar1 : ProgressBar = findViewById(R.id.progressToLevel)
        scoreText.text = "+" + (score.substringBefore("/").toInt() * 10).toString()
        progressBar1.progress = scoreText.text.toString().toInt()
        var sharedPreferences : SharedPreferences = getSharedPreferences("score" , MODE_PRIVATE)
        var sharedPreferencesEditor : SharedPreferences.Editor = sharedPreferences.edit()
        sharedPreferencesEditor.putInt("score", sharedPreferences.getInt("score" , 0) + score.substringBefore("/").toInt() * 10)
        sharedPreferencesEditor.commit()

        var totalScore : TextView = findViewById(R.id.totalScore)
        totalScore.text = sharedPreferences.getInt("score" , 0).toString()
    }




}
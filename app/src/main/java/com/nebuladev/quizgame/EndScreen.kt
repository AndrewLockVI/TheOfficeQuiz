package com.nebuladev.quizgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.NotificationCompat.getExtras

class EndScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_screen)
        var score = getIntent().getStringExtra("score");
        var  scoreText : TextView = findViewById(R.id.scoreText)
        scoreText.text = score


    }
}
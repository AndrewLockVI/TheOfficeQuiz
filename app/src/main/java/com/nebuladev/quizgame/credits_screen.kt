package com.nebuladev.quizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class credits_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credits_screen)
        var backArrow : Button = findViewById(R.id.backArrow)
        var intentSetting : Intent = Intent(this, SettingScreen::class.java)
        backArrow.setOnClickListener(){

            startActivity(intentSetting)
            overridePendingTransition(R.anim.landing_in, R.anim.setting_out_toleft)
        }
    }
}
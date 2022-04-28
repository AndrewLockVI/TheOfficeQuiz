package com.nebuladev.quizgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button

class SettingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_screen)

        var backArrow : Button = findViewById(R.id.backArrow)
        var intentMenu : Intent = Intent(this, LandingPage::class.java)
        backArrow.setOnClickListener(){

            startActivity(intentMenu)
            overridePendingTransition(R.anim.landing_in, R.anim.setting_out_toleft)
        }


    }
}
package com.nebuladev.quizgame

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate

class credits_screen : AppCompatActivity() {
    private var newscreen : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_credits_screen)
        var backArrow : Button = findViewById(R.id.backArrow)
        var intentSetting : Intent = Intent(this, SettingScreen::class.java)
        backArrow.setOnClickListener(){
            newscreen = true
            startActivity(intentSetting)
            overridePendingTransition(R.anim.landing_in, R.anim.setting_out_toleft)
        }
    }
    @Override
    override fun onStop() {
        super.onStop()
        if(newscreen == false) {
            val svc = Intent(this, BackgroundSoundService::class.java)
            stopService(svc)
        }

    }


    @Override
    override fun onStart() {

        super.onStart()
        var sharedPrefs : SharedPreferences = getSharedPreferences("music" , MODE_PRIVATE)
        if(sharedPrefs.getBoolean("music" , true) == true) {
            val svc = Intent(this, BackgroundSoundService::class.java)
            startService(svc)
        }

    }
}
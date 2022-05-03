package com.nebuladev.quizgame

import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.Switch

class SettingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting_screen)

        var prefs1 : SharedPreferences = getSharedPreferences("sound" , MODE_PRIVATE)
        var switchSoundEffect : Switch = findViewById(R.id.soundSwitch)
        if(prefs1.getBoolean("sfx" , false))
        {
            switchSoundEffect.isChecked = true
        }
        else
        {
            switchSoundEffect.isChecked = false
        }



        var backArrow : Button = findViewById(R.id.backArrow)
        var intentMenu : Intent = Intent(this, LandingPage::class.java)
        backArrow.setOnClickListener(){

            startActivity(intentMenu)
            overridePendingTransition(R.anim.landing_in, R.anim.setting_out_toleft)
        }



        var contact : Button = findViewById(R.id.contactButton)
        var contactIntent : Intent = Intent(this, Contact_screen::class.java)
        contact.setOnClickListener(){

            startActivity(contactIntent)
            overridePendingTransition(R.anim.sliding_setting, R.anim.sliding_setting_out)
        }



        var aboutButton : Button = findViewById(R.id.aboutButton)
        var aboutIntent : Intent = Intent(this, About_Screen::class.java)
        aboutButton.setOnClickListener(){

            startActivity(aboutIntent)
            overridePendingTransition(R.anim.sliding_setting, R.anim.sliding_setting_out)
        }



        var creditButton : Button = findViewById(R.id.creditsButton)
        var creditIntent : Intent = Intent(this, credits_screen::class.java)
        creditButton.setOnClickListener(){

            startActivity(creditIntent)
            overridePendingTransition(R.anim.sliding_setting, R.anim.sliding_setting_out)
        }


        var sfxSwith : Switch = findViewById(R.id.soundSwitch)
        sfxSwith.setOnClickListener(){

            var prefs : SharedPreferences = getSharedPreferences("sound" , MODE_PRIVATE)
            var prefsEditor : SharedPreferences.Editor = prefs.edit()

            if(sfxSwith.isChecked == false)
            {

                prefsEditor.putBoolean("sfx" , false)

            }
            else
            {
                prefsEditor.putBoolean("sfx" , true)
            }

            prefsEditor.commit()
        }




    }
}
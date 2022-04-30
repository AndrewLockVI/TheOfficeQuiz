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





    }
}
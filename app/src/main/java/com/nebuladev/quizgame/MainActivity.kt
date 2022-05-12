package com.nebuladev.quizgame
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {

    private var newscreen : Boolean = false
    private lateinit var buttonOne: Button;
    private var intScore = 0
    private var intQuestion = 0
    private lateinit var buttonTwo: Button;
    private lateinit var buttonThree: Button;
    private lateinit var buttonFour: Button;
    private lateinit var textOne: TextView;
    private var question1: Question = Question();
    private var rndOrder: RandomOrder = RandomOrder();
    private var checkAnswer: checkAnswer = checkAnswer();
    private var click: ClickChange = ClickChange();
    private lateinit var score: TextView;
    private var answer = false
    private var rndInt : Int = 0
    private var questionsUsed : List<Int> = listOf()
    private var minterstitialAd : InterstitialAd? = null
    private final var TAG = "Ta"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main)




        buttonOne = findViewById(R.id.answer_one)


        buttonTwo = findViewById(R.id.answer_two)
        buttonThree = findViewById(R.id.answer_three)
        buttonFour = findViewById(R.id.answer_four)
        textOne = findViewById(R.id.txtQuestion)
        score = findViewById(R.id.txtScore)
        nextQuestion()
        MobileAds.initialize(this) {}

        var adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-6659094757182534/8784763418", adRequest, object : InterstitialAdLoadCallback()
        {
            override fun onAdFailedToLoad(adError: LoadAdError)
            {
                Log.d(TAG, adError?.message)
                minterstitialAd = null

            }

            override fun onAdLoaded(interstitialAd: InterstitialAd)
            {
                Log.d(TAG, "Ad was loaded.")
                minterstitialAd = interstitialAd

            }
        })

















        buttonOne.setOnClickListener()
        {
            answer = checkAnswer.answerCheck(rndInt, buttonOne.text.toString())
            if (answer) {
                intScore += 1
                intQuestion += 1
                correctAnswer()
                score.text = intScore.toString()
                answer = false
                animationControl()

            } else {
                intQuestion += 1
                score.text = intScore.toString()
                buttonOne.setBackgroundResource((R.drawable.btn_std_wro))

                var prefs : SharedPreferences = getSharedPreferences("sound" , MODE_PRIVATE)
                if(prefs.getBoolean("sfx" , false))
                {
                    var media: MediaPlayer = MediaPlayer.create(this, R.raw.incorrect)
                    media.start()
                }
                animationControl()
            }


        }
        buttonTwo.setOnClickListener()
        {
            answer = checkAnswer.answerCheck(rndInt, buttonTwo.text.toString())
            if (answer) {
                intScore += 1
                intQuestion += 1
                score.text = intScore.toString()
                answer = false
                correctAnswer()
                animationControl()

            } else {

                intQuestion += 1
                score.text = intScore.toString()
                buttonTwo.setBackgroundResource(R.drawable.btn_std_wro)


                var prefs : SharedPreferences = getSharedPreferences("sound" , MODE_PRIVATE)
                if(prefs.getBoolean("sfx" , false)) {
                    var media: MediaPlayer = MediaPlayer.create(this, R.raw.incorrect)
                    media.start()
                }
                animationControl()


            }


        }
        buttonThree.setOnClickListener()
        {
            answer = checkAnswer.answerCheck(rndInt, buttonThree.text.toString())
            if (answer) {
                intScore += 1
                intQuestion += 1
                score.text = intScore.toString()
                answer = false
                correctAnswer()
                animationControl()

            } else {
                intQuestion += 1
                score.text = intScore.toString()
                buttonThree.setBackgroundResource(R.drawable.btn_std_wro)
                var prefs : SharedPreferences = getSharedPreferences("sound" , MODE_PRIVATE)
                if(prefs.getBoolean("sfx" , false)) {
                    var media: MediaPlayer = MediaPlayer.create(this, R.raw.incorrect)
                    media.start()
                }
                animationControl()

            }


        }
        buttonFour.setOnClickListener()
        {
            answer = checkAnswer.answerCheck(rndInt, buttonFour.text.toString())
            if (answer) {
                intScore += 1
                intQuestion += 1
                score.text = intScore.toString()
                answer = false
                correctAnswer()
                animationControl()

            } else
            {
                intQuestion += 1
                score.text = intScore.toString()
                buttonFour.setBackgroundResource(R.drawable.btn_std_wro)
                var prefs : SharedPreferences = getSharedPreferences("sound" , MODE_PRIVATE)
                if(prefs.getBoolean("sfx" , false)) {
                    var media: MediaPlayer = MediaPlayer.create(this, R.raw.incorrect)
                    media.start()
                }
                animationControl()




            }


        }


    }
    fun correctAnswer()
    {
        var sharedPreferences : SharedPreferences = getSharedPreferences("score" , MODE_PRIVATE)
        var sharedPrefEdit : SharedPreferences.Editor = sharedPreferences.edit()
        sharedPrefEdit.putInt("total" , (sharedPreferences.getInt("total" , MODE_PRIVATE) + 1))
        sharedPrefEdit.commit()
        var prefs : SharedPreferences = getSharedPreferences("sound" , MODE_PRIVATE)
        if(prefs.getBoolean("sfx" , false)) {
            var media: MediaPlayer = MediaPlayer.create(this, R.raw.correct)
            media.start()
        }
    }




    fun greenCorrect()
    {

        if(checkAnswer.answerCheck(rndInt, buttonFour.text.toString()))
        {
            buttonFour.setBackgroundResource(R.drawable.button_standardright)
        }
        else if(checkAnswer.answerCheck(rndInt, buttonTwo.text.toString()))
        {
            buttonTwo.setBackgroundResource(R.drawable.button_standardright)
        }
        else if(checkAnswer.answerCheck(rndInt, buttonThree.text.toString()))
        {
            buttonThree.setBackgroundResource(R.drawable.button_standardright)
        }
        else if(checkAnswer.answerCheck(rndInt, buttonOne.text.toString()))
        {
            buttonOne.setBackgroundResource(R.drawable.button_standardright)
        }
    }

    fun animationControl()
    {

        click.changeClick(buttonOne , buttonTwo , buttonThree , buttonFour)
        greenCorrect()
        animationRun()


    }

    fun animationRun()
    {

            val intent : Intent = Intent(this,EndScreen::class.java)

        object : CountDownTimer(500, 1000) {
            override fun onTick(p0: Long)
            {
            }
            override fun onFinish()
            {
                if(score.text.toString().toInt() < questionsUsed.size)
                {
                    intent.putExtra("score" , score.text)
                    startActivity(intent)
                    newscreen = true
                    overridePendingTransition(   R.anim.slide_from_top , R.anim.slide_from_top_down );
                    var sharedPreferences : SharedPreferences = getSharedPreferences("run" , MODE_PRIVATE)
                    var sharedEdit : SharedPreferences.Editor = sharedPreferences.edit()
                    if(sharedPreferences.getInt("run" , 0) >= 2)
                    {
                        minterstitialAd?.show(this@MainActivity)
                        sharedEdit.putInt("run" , 0)
                        sharedEdit.commit()
                    }
                    else
                    {
                        sharedEdit.putInt("run" , sharedPreferences.getInt("run" , 0) + 1)
                        sharedEdit.commit()
                    }
                }

                textOne.animate().apply {
                    duration = 600
                    alpha(0f)
                }

                var buttons : List<Button> = listOf(buttonOne,buttonTwo,buttonThree,buttonFour)
                var count = 0
                while(count < 4){
                    buttons[count].animate().apply {
                        duration = 600
                        alpha(0f)
                   //     translationX(1500f)
                        count += 1

                    }

                }
            }


        }.start()

        object : CountDownTimer(1220, 1000) {
            override fun onTick(p0: Long)
            {
            }
            override fun onFinish()
            {




                textOne.animate().apply {
                    duration = 0
                    alpha(1f)
                }
                var buttons : List<Button> = listOf(buttonOne,buttonTwo,buttonThree,buttonFour)
                var count = 0
                while(count < 4) {
                    buttons[count].animate().apply {
                        duration = 0
                        alpha(1f)
                       // translationX(0f)
                        buttons[count].setBackgroundResource(R.drawable.button_outline)
                        count += 1

                    }
                }

                nextQuestion()
                click.changeClick(buttonOne , buttonTwo , buttonThree , buttonFour)
            }


        }.start()
    }


    fun nextQuestion()
    {

        var listLength = question1.getQuestionLength()

        while(rndInt == 0 || questionsUsed.contains(rndInt))
        {
            var random = Math.random() * listLength
            rndInt = random.roundToInt()
        }
        questionsUsed = questionsUsed + rndInt




    //    buttonOne.x= 00f
   //     buttonThree.translationX = 00f
    //    buttonTwo.translationX = 00f
    //    buttonFour.translationX = 00f



        var questionAndAnswer: List<String> = question1.question(rndInt);
        textOne.text = questionAndAnswer[0]


        var answerOrder = rndOrder.randomAnswers()
        buttonOne.text = questionAndAnswer[answerOrder[0]]
        buttonTwo.text = questionAndAnswer[answerOrder[1]]
        buttonThree.text = questionAndAnswer[answerOrder[2]]
        buttonFour.text = questionAndAnswer[answerOrder[3]]
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

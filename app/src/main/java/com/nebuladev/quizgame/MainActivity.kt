package com.nebuladev.quizgame
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {

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
                var media : MediaPlayer = MediaPlayer.create(this , R.raw.incorrect)
                media.start()
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
                var media : MediaPlayer = MediaPlayer.create(this , R.raw.incorrect)
                media.start()
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
                var media : MediaPlayer = MediaPlayer.create(this , R.raw.incorrect)
                media.start()
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
                var media : MediaPlayer = MediaPlayer.create(this , R.raw.incorrect)
                media.start()
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
        var media : MediaPlayer = MediaPlayer.create(this , R.raw.correct)
        media.start()
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
                if(score.text.toString().toInt() < questionsUsed.size)
                {

                    intent.putExtra("score" , score.text)
                    startActivity(intent)
                }
                else
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


}

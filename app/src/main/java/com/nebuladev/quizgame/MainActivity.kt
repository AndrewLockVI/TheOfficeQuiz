package com.nebuladev.quizgame
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.Animation
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.thread
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
                score.text = intScore.toString() + "/" + intQuestion.toString()
                answer = false
                animationControl()

            } else {
                intQuestion += 1
                score.text = intScore.toString() + "/" + intQuestion.toString()
                buttonOne.setBackgroundColor(getColor(R.color.red))
                animationControl()
            }


        }
        buttonTwo.setOnClickListener()
        {
            answer = checkAnswer.answerCheck(rndInt, buttonTwo.text.toString())
            if (answer) {
                intScore += 1
                intQuestion += 1
                score.text = intScore.toString() + "/" + intQuestion.toString()
                answer = false
                animationControl()

            } else {

                intQuestion += 1
                score.text = intScore.toString() + "/" + intQuestion.toString()
                buttonTwo.setBackgroundColor(getColor(R.color.red))
                animationControl()


            }


        }
        buttonThree.setOnClickListener()
        {
            answer = checkAnswer.answerCheck(rndInt, buttonThree.text.toString())
            if (answer) {
                intScore += 1
                intQuestion += 1
                score.text = intScore.toString() + "/" + intQuestion.toString()
                answer = false
                animationControl()

            } else {
                intQuestion += 1
                score.text = intScore.toString() + "/" + intQuestion.toString()
                buttonThree.setBackgroundColor(getColor(R.color.red))
                animationControl()

            }


        }
        buttonFour.setOnClickListener()
        {
            answer = checkAnswer.answerCheck(rndInt, buttonFour.text.toString())
            if (answer) {
                intScore += 1
                intQuestion += 1
                score.text = intScore.toString() + "/" + intQuestion.toString()
                answer = false
                animationControl()

            } else
            {
                intQuestion += 1
                score.text = intScore.toString() + "/" + intQuestion.toString()
                buttonFour.setBackgroundColor(getColor(R.color.red))
                animationControl()




            }


        }


    }


    fun greenCorrect()
    {

        if(checkAnswer.answerCheck(rndInt, buttonFour.text.toString()))
        {
            buttonFour.setBackgroundColor(getColor(R.color.green))
        }
        else if(checkAnswer.answerCheck(rndInt, buttonTwo.text.toString()))
        {
            buttonTwo.setBackgroundColor(getColor(R.color.green))
        }
        else if(checkAnswer.answerCheck(rndInt, buttonThree.text.toString()))
        {
            buttonThree.setBackgroundColor(getColor(R.color.green))
        }
        else if(checkAnswer.answerCheck(rndInt, buttonOne.text.toString()))
        {
            buttonOne.setBackgroundColor(getColor(R.color.green))
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

            val intent : Intent = Intent(this,LandingPage::class.java)

        object : CountDownTimer(500, 1000) {
            override fun onTick(p0: Long)
            {
            }
            override fun onFinish()
            {

                textOne.animate().apply {
                    duration = 1000
                    alpha(0f)
                }

                var buttons : List<Button> = listOf(buttonOne,buttonTwo,buttonThree,buttonFour)
                var count = 0
                while(count < 4){
                    buttons[count].animate().apply {
                        duration = 1000
                        alpha(0f)
                        translationX(1500f)
                        count += 1
                    }
                }
            }


        }.start()

        object : CountDownTimer(1500, 1000) {
            override fun onTick(p0: Long)
            {
            }
            override fun onFinish()
            {
                if(questionsUsed.size > 2)
                {
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
                        translationX(0f)
                        buttons[count].setBackgroundColor(getColor(R.color.light_blue))
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




        buttonOne.x= 00f
        buttonThree.translationX = 00f
        buttonTwo.translationX = 00f
        buttonFour.translationX = 00f
        buttonOne.alpha = 1f
        buttonTwo.alpha = 1f
        buttonThree.alpha = 1f
        buttonFour.alpha = 1f


        var questionAndAnswer: List<String> = question1.question(rndInt);
        textOne.text = questionAndAnswer[0]


        var answerOrder = rndOrder.randomAnswers()
        buttonOne.text = questionAndAnswer[answerOrder[0]]
        buttonTwo.text = questionAndAnswer[answerOrder[1]]
        buttonThree.text = questionAndAnswer[answerOrder[2]]
        buttonFour.text = questionAndAnswer[answerOrder[3]]
    }


}

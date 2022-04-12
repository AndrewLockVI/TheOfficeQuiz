package com.nebuladev.quizgame
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonOne = findViewById(R.id.answer_one)
        buttonTwo = findViewById(R.id.answer_two)
        buttonThree = findViewById(R.id.answer_three)
        buttonFour = findViewById(R.id.answer_four)
        textOne = findViewById(R.id.txtQuestion)
        score = findViewById(R.id.txtScore)

        var listLength = question1.getQuestionLength()
        var random = Math.random() * listLength
        var rndInt = random.roundToInt()
        var questionAndAnswer: List<String> = question1.question(rndInt);
        textOne.text = questionAndAnswer[0]


        var answerOrder = rndOrder.randomAnswers()
        buttonOne.text = questionAndAnswer[answerOrder[0]]
        buttonTwo.text = questionAndAnswer[answerOrder[1]]
        buttonThree.text = questionAndAnswer[answerOrder[2]]
        buttonFour.text = questionAndAnswer[answerOrder[3]]


        buttonOne.setOnClickListener()
        {
            answer = checkAnswer.answerCheck(rndInt, buttonOne.text.toString())
            if (answer) {
                intScore += 1
                intQuestion += 1
                score.text = intScore.toString() + "/" + intQuestion.toString()
                answer = false
                //     click.changeClick(buttonOne , buttonTwo , buttonThree , buttonFour)

            } else {
                intQuestion += 1
                score.text = intScore.toString() + "/" + intQuestion.toString()

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
                //    click.changeClick(buttonOne , buttonTwo , buttonThree , buttonFour)

            } else {

                intQuestion += 1
                score.text = intScore.toString() + "/" + intQuestion.toString()


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
                //   click.changeClick(buttonOne , buttonTwo , buttonThree , buttonFour)

            } else {
                intQuestion += 1
                score.text = intScore.toString() + "/" + intQuestion.toString()

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
                //   click.changeClick(buttonOne , buttonTwo , buttonThree , buttonFour)

            } else {
                intQuestion += 1
                score.text = intScore.toString() + "/" + intQuestion.toString()

            }


        }


    }
}

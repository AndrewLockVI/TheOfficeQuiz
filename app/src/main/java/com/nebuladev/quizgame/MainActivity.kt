package com.nebuladev.quizgame
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {

    private lateinit var buttonOne: Button;
    private lateinit var buttonTwo: Button;
    private lateinit var buttonThree: Button;
    private lateinit var buttonFour: Button;
    private lateinit var textOne: TextView;
    private var question1 : Question = Question();
    private var rndOrder : RandomOrder = RandomOrder();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonOne = findViewById(R.id.answer_one)
        buttonTwo = findViewById(R.id.answer_two)
        buttonThree = findViewById(R.id.answer_three)
        buttonFour = findViewById(R.id.answer_four)
        textOne = findViewById(R.id.txtQuestion)

        var listLength = question1.getQuestionLength()
        var random = Math.random() * listLength
        var rndInt = random.roundToInt()
        var questionAndAnswer : List<String> = question1.question(rndInt);
        textOne.text = questionAndAnswer[0]

        var answerOrder = rndOrder.randomAnswers()
        buttonOne.text = questionAndAnswer[answerOrder[0]]
        buttonTwo.text = questionAndAnswer[answerOrder[1]]
        buttonThree.text = questionAndAnswer[answerOrder[2]]
        buttonFour.text = questionAndAnswer[answerOrder[3]]





        }
    }

package com.nebuladev.quizgame

class Question
{
     fun question(questionNum : Int): List<String>
    {
        val questionBank = populateQuestions()
        return questionBank[questionNum]
    }

    fun getQuestionLength() : Int
    {
        val questionBank = populateQuestions()
        return questionBank.size - 1
    }


    fun populateQuestions(): List<List<String>>
    {
        var question1 = listOf("What did Roy get arrested for?" , "Drunk Driving" , "Assault" , "Vandalism" , "Theft")
        var question2 = listOf("Who gave up a child?" , "Phyllis" , "Erin" , "Pam" , "Helene")
        var question3 = listOf("What did Pam get arrested for?" , "Drunk Driving" , "Assault" , "Vandalism" , "Theft")




        val questionBank = listOf(question1, question2 , question3)
        return questionBank;
    }



}
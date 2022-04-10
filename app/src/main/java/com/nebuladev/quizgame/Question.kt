package com.nebuladev.quizgame

class Question
{
     fun question(questionNum : Int): List<String>
    {
        var question1 = listOf("What did Roy get arrested for?" , "Drunk Driving" , "Assault" , "Vandalism" , "Theft")
        var question2 = listOf("Who gave up a child?" , "Phyllis" , "Erin" , "Pam" , "Helene")
        var question3 = listOf("What did Roy get arrested for?" , "Drunk Driving" , "Assault" , "Vandalism" , "Theft")




        val questionBank = listOf(question1, question2 , question3)
        return questionBank[0]
    }



}
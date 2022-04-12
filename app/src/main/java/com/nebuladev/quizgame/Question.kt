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
        var question3 = listOf("What does Pam steal in the first season?" , "Post-It Notes" , "Pencils" , "Tape" , "Paper")
        var question4 = listOf("What's Pam's favorite yogurt flavor?" , "Mixed Berry" , "Cherry" , "Vanilla" , "Blueberry")
        var question5 = listOf("What was Phyllis' nickname in high school?" , "Easy Rider" , "Granny" , "Phil" , "Lazy Lucy")
        var question6 = listOf("Who came up with Suck It?" , "David Wallace" , "Michael" , "Dwight" , "Andy")
        var question7 = listOf("How many brothers does Jim have?" , "Two" , "Three" , "One" , "Four")
        var question8 = listOf("How much did Bob Vance bid on a hug from Phyllis?" , "$1,000" , "$500" , "$5,000" , "$700")
        var question9 = listOf("Pam and Jim's first kiss took place where?" , "Chilli's" , "The Office" , "Jim's Party" , "Dwight's Farm")
        var question10 = listOf("What is Erin's real name?" , "Kelly" , "Jan" , "Hannah" , "Julia")
        var question11 = listOf("Who did Kelly get for secret santa?" , "Oscar" , "Pam" , "Ryan" , "Jim")
        var question12 = listOf("Who did Dwight bring to Michael's dinner party?" , "His Babysitter" , "Kelly" , "Angela" , "Pam's Sister")
        var question13 = listOf("What is the name of Kevin's first band?" , "Scrantonicity" , "Do Re Migos" , "Scrantones" , "Kevin and the Zits")
        var question14 = listOf("What did Michael buy for the Scott's Tots?" , "Batteries" , "Laptops" , "College" , "Notebooks")
        var question15 = listOf("What does Meredith have a PhD in?" , "School Psychology" , "Teaching" , "Management" , "Child Psychology")
        var question16 = listOf("What is Dwight's favorite movie?" , "The Crow" , "Lord of the Rings" , "Harry Potter" , "Superman")
        var question17 = listOf("What does Michael return with after his trip to Jamaica?" , "Beads in his hair" , "Dreadlocks" , "Goatee" , "Beard")
        var question18 = listOf("How many push-ups does Stanley do to beat Michael?" , "26" , "30" , "40" , "35")
        var question19 = listOf("What is the name of Jim's uprising group against Dwight?" , "The First" , "The Rebellion" , "Paper Pushers" , "The Social Club")
        var question20 = listOf("What is Andy known as after his singing audition goes viral?" , "Baby Wawa" , "Sit There and Cry Guy" , "Audition Guy" , "Roo-Doo-Doot-Da-Doo")
        var question21 = listOf("What passport other than a US one does Creed have?" , "Swiss" , "German" , "Canadian" , "Australian")
        var question22 = listOf("How many cousins does Dwight have?" , "70" , "10" , "25" , "3")
        var question23 = listOf("How old does Helene turn on her Birthday?" , "58" , "55" , "49" , "59")
        var question24 = listOf("How much does Michael think the first-aid dummy costs?" , "$5,300" , "$35,000" , "$3,500" , "$53,00")
        var question25 = listOf("What is the name of the chair model?" , "Deborah" , "Lynn" , "Carrie" , "Morgan")
        var question26 = listOf( "Which of the following was not one of Jim's Halloween costumes" , "Dwight" , "Three hole Punch Jim" , "Bookface" , "Dave")
        var question27 = listOf("What kind of sandwich does Michael have a dream about?" , "Peanut Butter and Tuna" , "Tuna and Skittles" , "Mayo and Black Olives" , "Tuna and Jam")
        var question28 = listOf("What is Dwight's porcupine's name?","Henrietta","Hilly","Hetty","Henry")
        var question29 = listOf("What is Kelly Kapoor's middle name?" , "Rajnigandha" , "Naya" , "Inaya" , "Diya")
        var question30 = listOf("What is Kelly Hannon's middle name" , "Erin" , "Samantha" , "Sylvia" , "Pam")
        var question31 = listOf("What does Michael eat instead of ice cream?" , "Mayo and Black Olives" , "Mayo and Chocolate Chips" , "Mayo and Pickles" , "Sour cream and Olives")
        var question32 = listOf("What acronym does Creed come up with? " , "BOBODDY" , "NOBODDY" , "DUNDER" , "BOBANY")
        var question33 = listOf("What does Michael order when he goes to lunch with the insurance salesman?" , "Gabagool" , "Capicola" , "Prosciutoo" , "Sangria")
        var question34 = listOf("What do Shrutes stand in while getting married?" , "Graves" , "Bath Tub" , "Barn" , "Manure")
        var question35 = listOf("Where does Michael go on a business trip?" , "Winnipeg" , "Montreal" , "Quebec" , "Toronto")
        var question36 = listOf("When auditioning for the play what show does Michael act out?" , "Law & Order" , "CSI : Miami" , "Lost" , "Blue Bloods")
        var question37 = listOf("How much does Michael's plasma TV cost?" , "$200" , "$100" , "$500" , "$250")
        var question38 = listOf("What is Roy's brother's name?" , "Kenny" , "Nick" , "Troy" , "Chris")
        var question39 = listOf("Who was Pam's replacement when she was on maternity leave?" , "Kathy" , "Katie" , "Karen" , "Katherine")
        var question40 = listOf("What outlet store does Dwight tell Jan to go to?" , "Liz Claiborne" , "Anne Taylor" , "JCPenny" , "Adrianna Papell")
        var question41 = listOf("What does Devon dress up as on Halloween?" , "Homeless man" , "Vampire" , "Mummy" , "Zombie")
        var question42 = listOf("What does Michael put in Toby's desk to frame him for drug possession?" , "Caprese Salad" , "Spinach" , "Frisee Salad" , "Caesar Salad")
        var question43 = listOf("What clothing does Michael have dry cleaned?" , "Jeans" , "Ties" , "Socks" , "Suit Jacket")
        var question44 = listOf("What is the name of the insurance salesman?" , "Grotti" , "Gotti" , "Gozi" , "Gradle")
        var question45 = listOf("Who tries to kiss Pam at the Diwali celebration?" , "Michael" , "Roy" , "Jim" , "Toby")
        var question46 = listOf("What did Ryan leave in the toaster oven?" , "Cheese Pita" , "Pit Bread" , "Bagel" , "Poptart")
        var question47 = listOf("What is Todd Packer's license plate?" , "WLHUNG" , "PRVRT" , "LOL69" , "BOOBZ")
        var question48 = listOf("What type of farm does Dwight have?" , "Beet" , "Candy" , "Carrot" , "Bear")
        var question49 = listOf("Which of Angela's cats does Dwight kill?" , "Sprinkles" , "Bandit" , "Sparkles" , "Fluffy")
        var question50 = listOf("Who did Michael hit with his car?" , "Meredith" , "Angela" , "Kelly" , "Stanley")






        val questionBank = listOf(question1, question2 , question3, question4, question5 , question6 ,question7 ,question8 ,question9 ,question10,question11,question12,question13,question14,question15,question16,question17,question18,question19,question20,question21,question22,question23 , question24 , question25, question26 , question27, question28 , question29, question30, question31,question32,question33,question34,question35,question36,question37,question38,question39,question40,question41,question42,question43,question44,question45,question46,question47,question48,question49,question50)
        return questionBank;
    }



}
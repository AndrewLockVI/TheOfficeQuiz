package com.nebuladev.quizgame

import kotlin.math.roundToInt
import kotlin.random.Random

class RandomOrder
{

    fun randomAnswers(): List<Int>
    {
        var value1Int = 0
        var value2Int = 0
        var value3Int = 0
        var value4Int = 0

while(value1Int == value2Int || value1Int == value3Int || value1Int == value4Int || value2Int == value3Int || value2Int == value4Int || value3Int == value4Int) {

    var value1 = Math.random() * 3 + 1
    value1Int = value1.roundToInt()

    var value2 = Math.random() * 3 + 1
    value2Int = value2.roundToInt()

    var value3 = Math.random() * 3 + 1
    value3Int = value3.roundToInt()

    var value4 = Math.random() * 3 + 1
    value4Int = value4.roundToInt()

}
    var orderAnswers = listOf(value1Int , value2Int , value3Int , value4Int)



        return orderAnswers
    }
}
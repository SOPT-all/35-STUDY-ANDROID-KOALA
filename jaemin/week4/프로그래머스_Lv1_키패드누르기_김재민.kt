package programmers

import java.lang.StringBuilder
import kotlin.math.*


fun main(args: Array<String>){
    println(calculateDistanceBetweenCenterAndThumb(0,7))
    println(calculateDistanceBetweenCenterAndThumb(0,12))
}

fun solution(numbers: IntArray, hand: String): String {
    var answer = ""
    var currentLeft = 10
    var currentRight = 12
    val sb = StringBuilder()
    numbers.forEach { clickNumber->
        val leftOrRight = when(clickNumber){
            1,4,7 -> {
                currentLeft = clickNumber
                "L"
            }
            3,6,9 -> {
                currentRight = clickNumber
                "R"
            }
            2,5,8,0 -> {
                if(calculateDistanceBetweenCenterAndThumb(clickNumber,currentLeft)
                    > calculateDistanceBetweenCenterAndThumb(clickNumber,currentRight)){
                    currentRight = clickNumber
                    "R"
                }
                else if(calculateDistanceBetweenCenterAndThumb(clickNumber,currentLeft)
                    < calculateDistanceBetweenCenterAndThumb(clickNumber,currentRight)) {
                    currentLeft = clickNumber
                    "L"
                }
                else {
                    if (hand == "left") {
                        currentLeft = clickNumber
                        "L"
                    } else {
                        currentRight = clickNumber
                        "R"
                    }
                }
            }
            else -> ""
        }
        sb.append(leftOrRight)
    }
    answer = sb.toString()
    return answer
}

fun numberToCoordinate(number: Int): Pair<Int,Int>{
    var keypadNumber = 0
    keypadNumber = if(number==0) 11 else number
    val row = (keypadNumber-1) / 3
    val column = (keypadNumber-1) % 3

    return Pair(row,column)
}

fun calculateDistanceBetweenCenterAndThumb(center: Int, thumb: Int): Int{
    val coordinatesOfNumber1 = numberToCoordinate(center)
    val coordinatesOfNumber2 = numberToCoordinate(thumb)

    return abs(coordinatesOfNumber2.first - coordinatesOfNumber1.first) + abs(coordinatesOfNumber2.second - coordinatesOfNumber1.second)
}


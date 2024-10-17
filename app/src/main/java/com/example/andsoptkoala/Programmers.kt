package com.example.andsoptkoala

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var answerString = s.replace(oldValue = "zero", newValue = "0")
        answerString = answerString.replace(oldValue = "one", newValue = "1")
        answerString = answerString.replace(oldValue = "two", newValue = "2")
        answerString = answerString.replace(oldValue = "three", newValue = "3")
        answerString = answerString.replace(oldValue = "four", newValue = "4")
        answerString = answerString.replace(oldValue = "five", newValue = "5")
        answerString = answerString.replace(oldValue = "six", newValue = "6")
        answerString = answerString.replace(oldValue = "seven", newValue = "7")
        answerString = answerString.replace(oldValue = "eight", newValue = "8")
        answerString = answerString.replace(oldValue = "nine", newValue = "9")
        answer = answerString.toInt()
        return answer
    }
}




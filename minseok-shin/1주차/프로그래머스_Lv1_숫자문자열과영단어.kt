package com.example.andsoptkoala

class Solution1{
    fun solution(s: String): Int {
        var answer: Int = 0
        val answerString = s.replace(oldValue = "zero", newValue = "0")
            .replace(oldValue = "one", newValue = "1")
            .replace(oldValue = "two", newValue = "2")
            .replace(oldValue = "three", newValue = "3")
            .replace(oldValue = "four", newValue = "4")
            .replace(oldValue = "five", newValue = "5")
            .replace(oldValue = "six", newValue = "6")
            .replace(oldValue = "seven", newValue = "7")
            .replace(oldValue = "eight", newValue = "8")
            .replace(oldValue = "nine", newValue = "9")
        answer = answerString.toInt()
        return answer
    }
}

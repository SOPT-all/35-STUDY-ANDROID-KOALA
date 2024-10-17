package com.example.andsoptkoala

class Solution1 {
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


class Solution2 {
    fun solution(s: String): IntArray {
        var answer = intArrayOf()
        val numbers = s.replace("{", "").replace("}", "")
            .split(",")
            .filter { it.isNotEmpty() }
            .map { it.toInt() }

        val map = mutableMapOf<Int, Int>()
        for (num in numbers) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        val sortedTuple= map.toList()
            .sortedByDescending { it.second }
            .map { it.first }

        answer = sortedTuple.toIntArray()

        return answer
    }
}

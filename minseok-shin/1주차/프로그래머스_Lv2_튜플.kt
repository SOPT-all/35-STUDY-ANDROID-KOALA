package com.example.andsoptkoala


class Solution {
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

        val sortedTuple = map.toList()
            .sortedByDescending { it.second }
            .map { it.first }

        answer = sortedTuple.toIntArray()

        return answer
    }
}

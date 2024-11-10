package com.example.andsoptkoala

class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        val ratio = mutableListOf<Pair<Int, Double>>()

        for (cnt in 1..N) {
            val all = stages.count { it >= cnt }
            val miss = stages.count { it == cnt }
            val failRate = if(all!=0) miss.toDouble() / all.toDouble() else 0.0
            ratio.add(Pair(cnt, failRate))
        }

        val answer = ratio.sortedWith(compareByDescending<Pair<Int, Double>> { it.second }.thenBy { it.first })
            .map { it.first }
            .toIntArray()

        return answer
    }
}

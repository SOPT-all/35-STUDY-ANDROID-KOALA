package com.example.andsoptkoala

class Solution {
    fun solution(n: Int, k: Int): Int {
        //n을 k 진수로 바꿔 버려용!
        val transformInt = n.toString(radix=k)
        println(transformInt)

        //0을 기준으로 잘라 버려용!
        val numberList = transformInt.split("0").filter { it.isNotEmpty() }.map { it.toInt() }

        // val max = numberList.max()
        val max = numberList.maxOrNull() ?: 0 // 프로그래머스에서 max()를 못알아먹어요!
        println(max)

        //진수 변환했을떄 Int 뚫는 큰 수도 있대요!
        fun isPrime(num: Long): Boolean {
            if (num <= 1) return false
            return (2..Math.sqrt(num.toDouble()).toLong()).none { num % it == 0L }
        }

        var answer = 0
        for (num in numberList){
            if (isPrime(num.toLong())) answer++
        }

        return answer
    }
}

package com.example.andsoptkoala

class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var left = 1
        var right = stones.maxOrNull() ?: 0
        var answer = 0

        while (left <= right) {
            val mid = (left + right) / 2
            var cnt = 0
            var flag = true

            for (num in stones) {
                if (num - mid <= 0) {
                    cnt++
                    if (cnt >= k) {
                        flag = false
                        break
                    }
                } else {
                    cnt = 0
                }
            }

            if (flag) {
                answer = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return answer+1
    }
}
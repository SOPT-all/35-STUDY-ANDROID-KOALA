package week5

import java.util.LinkedList
import java.util.Queue

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val q1: Queue<Long> = LinkedList(queue1.map { it.toLong() })
        val q2: Queue<Long> = LinkedList(queue2.map { it.toLong() })

        var cnt = 0
        val max = (queue1.size + queue2.size) * 2
        val totalSum = q1.sum() + q2.sum()

        if (totalSum % 2 != 0L) return -1

        val targetSum = totalSum / 2

        var q1Sum = q1.sum()
        var q2Sum = q2.sum()

        while (q1Sum != targetSum && cnt < max) {
            if (q1Sum > q2Sum) {
                val element = q1.poll().toLong()
                q1Sum -= element
                q2.offer(element)
                q2Sum += element
            } else {
                val element = q2.poll().toLong()
                q2Sum -= element
                q1.offer(element)
                q1Sum += element
            }
            cnt++
        }

        return if (q1Sum == targetSum) cnt else -1
    }

}
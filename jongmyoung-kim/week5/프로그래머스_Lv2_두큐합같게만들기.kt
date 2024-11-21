package week5

import java.util.LinkedList

fun solution(queue1: IntArray, queue2: IntArray): Int {
    var answer: Int = 0
    val q1 = LinkedList(queue1.map { it.toLong() })
    val q2 = LinkedList(queue2.map { it.toLong() })
    var q1Sum = q1.sum()
    var q2Sum = q2.sum()
    val target = ((q1Sum + q2Sum) / 2)

    if (q1.any { it > target } || q2.any { it > target }) return -1

    while (true) {
        if (q1Sum == q2Sum) break
        if (answer > queue1.size * 4) {
            answer = -1
            break
        }
        when {
            q1Sum > q2Sum -> {
                val num = q1.poll()
                q2.addLast(num)
                q2Sum += num
                q1Sum -= num
            }

            else -> {
                val num = q2.poll()
                q1.addLast(num)
                q1Sum += num
                q2Sum -= num
            }
        }
        answer++
    }
    return answer
}
package week14

import java.util.PriorityQueue

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val maxQueue = PriorityQueue<Int>()
    val minQueue = PriorityQueue<Int>(compareByDescending { it })

    repeat(N) {
        val num = br.readLine().toInt()
        if (maxQueue.size == minQueue.size) {
            maxQueue.offer(num)
            minQueue.offer(maxQueue.poll())
        } else {
            minQueue.offer(num)
            maxQueue.offer(minQueue.poll())
        }
        write("${minQueue.peek()}\n")
    }
    close()
}

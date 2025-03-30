package week14

import java.util.PriorityQueue

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }).apply { offer(Pair(N, 0)) }
    val visited = BooleanArray(100001).apply { this[N] = true }

    while (queue.isNotEmpty()) {
        val (position, move) = queue.poll()

        visited[position] = true

        if (position == K) {
            write("$move")
            break
        }

        if (position + 1 in visited.indices && !visited[position + 1]) queue.offer(Pair(position + 1, move + 1))
        if (position - 1 in visited.indices && !visited[position - 1]) queue.offer(Pair(position - 1, move + 1))
        if (position * 2 in visited.indices && !visited[position * 2]) queue.offer(Pair(position * 2, move))
    }
    close()
}
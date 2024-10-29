package week2

import java.util.LinkedList
import kotlin.math.abs

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val case = br.readLine().toInt()

    repeat(case) {
        val marketNum = br.readLine().toInt()
        val coordinates = ArrayList<Pair<Int, Int>>()

        repeat(marketNum + 2) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            coordinates.add(Pair(x, y))
        }
        write("${bfs(marketNum, coordinates)}\n")
    }
    close()
}

fun bfs(marketNum: Int, coordinates: ArrayList<Pair<Int, Int>>): String {
    val queue = LinkedList<Int>()
    queue.add(0)

    val visited = BooleanArray(marketNum + 2) { false }.apply {
        this[0] = true
    }

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current == marketNum + 1) return "happy"

        for (next in 1..marketNum+1) {
            val distance =
                abs(coordinates[current].first - coordinates[next].first) + abs(coordinates[current].second - coordinates[next].second)
            if (distance <= 1000 && !visited[next]) {
                queue.add(next)
                visited[next] = true
            }
        }
    }
    return "sad"
}

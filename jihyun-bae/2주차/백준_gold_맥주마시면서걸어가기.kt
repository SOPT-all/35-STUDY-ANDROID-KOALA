import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = bufferedReader.readLine().toInt()

    repeat(t) {
        val n = bufferedReader.readLine().toInt()

        val coordinates = Array(n + 2) {
            bufferedReader.readLine().split(" ").let { Pair(it[0].toInt(), it[1].toInt()) }
        }.toList()

        bufferedWriter.write(bfs(coordinateNum = n + 2, coordinates = coordinates))
        bufferedWriter.newLine()
    }


    bufferedWriter.flush()
    bufferedWriter.close()
}

fun bfs(coordinateNum: Int, coordinates: List<Pair<Int, Int>>): String {
    val visited = BooleanArray(coordinateNum + 1) { false }
    val queue: Queue<Int> = LinkedList()

    visited[0] = true
    queue.add(0)

    while (queue.isNotEmpty()) {
        val now = queue.poll()

        if (now == coordinateNum - 1) return "happy"

        for (index in coordinates.indices) {
            if (!visited[index] && distance(now = coordinates[now], next = coordinates[index]) <= 1000) {
                visited[index] = true
                queue.add(index)
            }
        }
    }

    return "sad"
}

fun distance(now: Pair<Int, Int>, next: Pair<Int, Int>) = abs(now.first - next.first) + abs(now.second - next.second)

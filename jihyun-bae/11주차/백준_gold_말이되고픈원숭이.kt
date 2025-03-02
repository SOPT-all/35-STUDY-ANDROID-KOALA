import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val k = bufferedReader.readLine().toInt()
    val (h, w) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val road = Array(w) { bufferedReader.readLine().split(" ").map { it.toInt() } }

    val horse = listOf(Pair(-2, 1), Pair(-1, 2), Pair(1, 2), Pair(2, 1), Pair(2, -1), Pair(1, -2), Pair(-1, -2), Pair(-2, -1))
    val monkey = listOf(Pair(0, 1), Pair(0, -1), Pair(-1, 0), Pair(1, 0))

    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    val visited = Array(w) { Array(h) { IntArray(k + 1) { 0 } } }
    var answer = -1

    queue.add(Triple(0, 0, 0))
    visited[0][0][0] = 1

    while (queue.isNotEmpty()) {
        val now = queue.poll() ?: break

        if (now.first == w - 1 && now.second == h - 1) {
            answer = visited[now.first][now.second][now.third] - 1
            break
        }

        for (i in monkey.indices) {
            val next = Triple(now.first + monkey[i].first, now.second + monkey[i].second, now.third)

            if (next.first < 0 || next.first >= w || next.second < 0 || next.second >= h) continue
            if (road[next.first][next.second] == 0 && visited[next.first][next.second][next.third] == 0) {
                queue.add(next)
                visited[next.first][next.second][next.third] = visited[now.first][now.second][now.third] + 1
            }
        }

        if (now.third < k) {
            for (i in horse.indices) {
                val next = Triple(now.first + horse[i].first, now.second + horse[i].second, now.third + 1)

                if (next.first < 0 || next.first >= w || next.second < 0 || next.second >= h || next.third > k) continue
                if (road[next.first][next.second] == 0 && visited[next.first][next.second][next.third] == 0) {
                    queue.add(next)
                    visited[next.first][next.second][next.third] = visited[now.first][now.second][now.third] + 1
                }
            }
        }
    }

    bufferedWriter.write(answer.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

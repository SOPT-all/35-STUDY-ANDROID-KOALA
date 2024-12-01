import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

fun main() {
    fun Array<Array<Int>>.dijkstra(n: Int, x: Int): Array<Int> {
        val time = Array(n) { Int.MAX_VALUE }.apply { this[x - 1] = 0 }
        val visited = Array(n) { false }
        val queue = PriorityQueue<Pair<Int,Int>>(compareBy { it.second })
        queue.add(Pair(x - 1, time[x - 1]))

        while(queue.isNotEmpty()) {
            val start = queue.poll() ?: Pair(x - 1, time[x - 1])
            if (visited[start.first]) continue
            for (i in this.indices) {
                if (this[start.first][i] != 0) {
                    if (time[i] == -1 || time[i] > time[start.first] + this[start.first][i]) {
                        time[i] = time[start.first] + this[start.first][i]
                        queue.add(Pair(i, time[i]))
                    }
                }
            }
        }
        return time
    }

    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m, x) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val road = Array(n) { Array(n) { 0 } }
    val reversedRoad = Array(n) { Array(n) { 0 } }

    repeat(m) {
        val (start, end, t) = bufferedReader.readLine().split(" ").map { it.toInt() }
        road[start - 1][end - 1] = t
        reversedRoad[end - 1][start - 1] = t
    }

    val roadTime = road.dijkstra(n = n, x = x)
    val reversedRoadTime = reversedRoad.dijkstra(n = n, x = x)

    bufferedWriter.write(roadTime.zip(reversedRoadTime) { time, reversedTime -> time + reversedTime }
        .max().toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

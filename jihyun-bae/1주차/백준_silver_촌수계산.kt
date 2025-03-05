import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = bufferedReader.readLine().toInt()
    val graph = Array(n + 1) { IntArray(n + 1) { 0 } }

    val (a, b) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val m = bufferedReader.readLine().toInt()

    repeat(m) {
        val (x, y) = bufferedReader.readLine().split(" ").map { it.toInt() }

        graph[x][y] = 1
        graph[y][x] = 1
    }

    val queue: Queue<Int> = LinkedList()
    val visited = IntArray(n + 1) { -1 }

    queue.add(a)
    visited[a] = 0

    while (queue.isNotEmpty()) {
        val now = queue.poll() ?: continue

        for (i in graph.indices) {
            if (graph[now][i] == 1 && visited[i] == -1) {
                visited[i] = visited[now] + 1
                queue.add(i)

                if (i == b) break
            }
        }
    }

    bufferedWriter.write(visited[b].toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

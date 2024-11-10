import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (f, s, g, u, d) = bufferedReader.readLine().split(" ").map { it.toInt() }

    val dy = arrayOf(u, -d)

    val queue: Queue<Int> = LinkedList<Int>()
    val visited = IntArray(f + 1) { 0 }

    queue.add(s)
    visited[s] = 1

    Loop@ while (queue.isNotEmpty()) {
        val now = queue.poll()

        for (index in dy.indices) {
            val next = now + dy[index]

            if (0 >= next || next > f) continue

            if (visited[next] == 0) {
                queue.add(next)
                visited[next] = visited[now] + 1
                if (next == g) break@Loop
            }
        }
    }

    bufferedWriter.write(if (visited[g] == 0) "use the stairs" else (visited[g] - 1).toString())

    bufferedWriter.flush()
    bufferedWriter.close()

}

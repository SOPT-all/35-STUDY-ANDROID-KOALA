import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val draw = Array(n) { bufferedReader.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val stack: Queue<Pair<Int, Int>> = LinkedList()
    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(-1, 1, 0, 0)
    var max = 0

    for (i in 0..< n) {
        for (j in 0..< m) {
            if (draw[i][j] == 1) {
                stack.add(Pair(i, j))
                var temp = 1

                while (stack.isNotEmpty()) {
                    stack.poll()?.let { now ->
                        for (k in dx.indices) {
                            val next = Pair(now.first + dx[k], now.second + dy[k])

                            if (next.first < 0 || next.first >= n || next.second < 0 || next.second >= m) continue

                            if (draw[next.first][next.second] == 1 && Pair(i, j) != next) {
                                draw[next.first][next.second] = draw[now.first][now.second] + 1
                                temp += 1
                                stack.add(next)
                            }
                        }
                    }
                }

                max = max(max, temp)
            }
        }
    }

    bufferedWriter.write(draw.sumOf { row -> row.count { it == 1 } }.toString())
    bufferedWriter.newLine()
    bufferedWriter.write(max.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

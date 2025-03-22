import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

data class Position(var x: Int, var y: Int)
data class Marble(val red: Position, val blue: Position, val count: Int)

val d = listOf(Pair(-1, 0), Pair(0, 1), Pair(1, 0), Pair(0, -1))

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { bufferedReader.readLine().toCharArray() }
    val red = Position(0, 0)
    val blue = Position(0, 0)

    for (i in graph.indices) {
        for (j in graph[i].indices) {
            when (graph[i][j]) {
                'R' -> {
                    red.x = i
                    red.y = j
                    graph[i][j] = '.'
                }

                'B' -> {
                    blue.x = i
                    blue.y = j
                    graph[i][j] = '.'
                }
            }
        }
    }

    val visited = Array(n) { Array(m) { Array(n) { BooleanArray(m) { false } } } }
    val queue: Queue<Marble> = LinkedList()
    queue.add(Marble(red, blue, 0))
    visited[red.x][red.y][blue.x][blue.y] = true

    Loop@ while (true) {
        if (queue.isEmpty()) {
            bufferedWriter.write("-1")
            break@Loop
        }

        val now = queue.poll()

        if (now.count >= 10) {
            bufferedWriter.write("-1")
            break@Loop
        }

        for (i in d.indices) {
            val blueNext = graph.moveMarble(now.blue, i)
            if (graph[blueNext.x][blueNext.y] == 'O') continue

            val redNext = graph.moveMarble(now.red, i)
            if (graph[redNext.x][redNext.y] == 'O') {
                bufferedWriter.write((now.count + 1).toString())
                break@Loop
            }

            if (blueNext == redNext) {
                when (i) {
                    0 -> if (now.red.x > now.blue.x) redNext.x++ else blueNext.x++
                    1 -> if (now.red.y < now.blue.y) redNext.y-- else blueNext.y--
                    2 -> if (now.red.x < now.blue.x) redNext.x-- else blueNext.x--
                    3 -> if (now.red.y > now.blue.y) redNext.y++ else blueNext.y++
                }
            }

            if (!visited[redNext.x][redNext.y][blueNext.x][blueNext.y]) {
                visited[redNext.x][redNext.y][blueNext.x][blueNext.y] = true
                queue.add(Marble(redNext, blueNext, now.count + 1))
            }
        }
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}

fun Array<CharArray>.moveMarble(position: Position, direction: Int): Position {
    val p = Position(position.x, position.y)
    while (this[p.x + d[direction].first][p.y + d[direction].second] != '#') {
        p.x += d[direction].first
        p.y += d[direction].second

        if (this[p.x][p.y] == 'O') return p
    }

    return p
}

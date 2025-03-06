import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val (r, c, d) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val room = Array(n) { bufferedReader.readLine().split(" ").map { it.toInt() }.toTypedArray() }
    val way = listOf(Pair(-1, 0), Pair(0, 1), Pair(1, 0), Pair(0, -1))

    var answer = 0
    var now = Pair(r, c)
    var nowWay = d

    fun checkCleaning(now: Pair<Int, Int>): Boolean {
        for (i in way.indices) {
            val next = Pair(now.first + way[i].first, now.second + way[i].second)
            if (0 > next.first || next.first >= n || 0 > next.second || next.second >= m) continue

            if (room[next.first][next.second] == 0) return true
        }

        return false
    }

    while (true) {
        if (room[now.first][now.second] == 0) {
            answer++
            room[now.first][now.second] = 2
        }

        if (!checkCleaning(now)) {
            val next = Pair(now.first - way[nowWay].first, now.second - way[nowWay].second)
            if (0 > next.first || next.first >= n || 0 > next.second || next.second >= m) break
            if (room[next.first][next.second] == 1) break
            now = next
        } else {
            nowWay = (nowWay + 3) % 4
            val next = Pair(now.first + way[nowWay].first, now.second + way[nowWay].second)
            if (room[next.first][next.second] == 0) now = next
        }
    }

    bufferedWriter.write(answer.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

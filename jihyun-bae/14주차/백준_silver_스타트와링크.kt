import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = bufferedReader.readLine().toInt()
    val abilities = Array(n) { bufferedReader.readLine().split(" ").map { it.toInt() } }
    var answer = 200

    fun dfs(team: IntArray, check: Int) {
        if (team.size == n / 2) {
            var score = Pair(0, 0)

            for (i in 0..<n) {
                for (j in 0..<n) {
                    if (i in team && j in team) {
                        score = score.copy(first = score.first + abilities[i][j])
                    }
                    else if (i !in team && j !in team) {
                        score = score.copy(second = score.second + abilities[i][j])
                    }
                }
            }

            answer = Math.min(answer, abs(score.first - score.second))
        }
        if (check == n) return

        for (i in check..<n) {
            dfs(team + i, i + 1)
        }
    }

    dfs(intArrayOf(), 0)

    bufferedWriter.write(answer.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

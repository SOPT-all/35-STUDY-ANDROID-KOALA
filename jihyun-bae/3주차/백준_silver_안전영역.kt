import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

val dx = arrayOf(0, 0, -1, 1)
val dy = arrayOf(-1, 1, 0, 0)

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = bufferedReader.readLine().toInt()
    val region = Array(n) { bufferedReader.readLine().split(" ").map { it.toInt() } }

    val min = region.flatMap { it }.minOrNull()
    val max = region.flatMap { it }.maxOrNull()

    var safeAreaNumber = 1

    if (min != null && max != null) {
        for (rain in min..max) {
            val visited = Array(n) { BooleanArray(n) }
            var count = 0

            for (i in region.indices) {
                for (j in region.indices) {
                    if (region[i][j] - rain > 0 && !visited[i][j]) {
                        count += 1
                        dfs(rain = rain, x = i, y = j, region = region, visited = visited)
                    }
                }
            }

            safeAreaNumber = maxOf(safeAreaNumber, count)
        }
    }

    bufferedWriter.write(safeAreaNumber.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

fun dfs(rain: Int, x: Int, y: Int, region: Array<List<Int>>, visited: Array<BooleanArray>) {
    visited[x][y] = true

    for (i in dx.indices) {
        if (x + dx[i] in visited.indices && y + dy[i] in visited.indices && region[x + dx[i]][y + dy[i]] > rain && !visited[x + dx[i]][y + dy[i]]) dfs(
            rain = rain,
            x = x + dx[i],
            y = y + dy[i],
            region = region,
            visited = visited
        )
    }
}

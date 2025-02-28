import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    fun List<Int>.dfs(index: Int, list: IntArray) {
        if (list.size == 6) bufferedWriter.write(list.joinToString(" ") + "\n")
        else if (index >= this.size) return
        else {
            for (i in index ..<this.size) {
                dfs(i + 1, list + this[i])
            }
        }
    }

    while (true) {
        val (k, s) = bufferedReader.readLine().split(" ").map { it.toInt() }
            .let { it.first() to it.drop(1) }

        if (k == 0) break
        else {
            s.dfs(0, intArrayOf())
            bufferedWriter.newLine()
        }
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}

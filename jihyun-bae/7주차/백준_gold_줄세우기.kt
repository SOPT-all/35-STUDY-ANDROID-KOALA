import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = bufferedReader.readLine().toInt()
    val children = bufferedReader.readLine().split(" ").map { it.toInt() }.toMutableList()
    val dp = IntArray(n + 1) { 0 }.toMutableList()

    children.forEach { child ->
        dp[child] = dp[child - 1] + 1
    }

    bufferedWriter.write((n - dp.max()).toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

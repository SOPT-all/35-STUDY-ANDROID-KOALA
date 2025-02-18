import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, k) = bufferedReader.readLine().split(" ").map { it.toInt() }

    val dp = Array(n + 1) { LongArray(k + 1) { 1 } }

    for (i in 1..n) {
        for (j in 2..k) {
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000
        }
    }

    bufferedWriter.write(dp[n][k].toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

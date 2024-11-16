package week4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val dp = IntArray(n + 1)

    dp[0] = 1
    dp[1] = 3

    for (i in 2..n) {
        dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901
    }

    bw.write(dp[n].toString())
    bw.flush()
    bw.close()
    br.close()
}

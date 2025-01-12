package week6

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val T = br.readLine().toInt()

    repeat(T) {
        val n = br.readLine().toInt()
        val dp = Array(2) { IntArray(n) }
        repeat(2) { idx ->
            dp[idx] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        }
        if (n > 1) {
            dp[0][1] += dp[1][0]
            dp[1][1] += dp[0][0]
            for (i in 2 until n) {
                dp[0][i] += dp[1][i - 1].coerceAtLeast(dp[1][i - 2])
                dp[1][i] += dp[0][i - 1].coerceAtLeast(dp[0][i - 2])
            }
        }
        write("${dp[0][n - 1].coerceAtLeast(dp[1][n - 1])}\n")
    }
    close()
}
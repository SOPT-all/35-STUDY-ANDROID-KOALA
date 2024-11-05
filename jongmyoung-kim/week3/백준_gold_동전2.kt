package week3

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(k + 1) { 10001 }.apply {
        this[0] = 0
    }

    repeat(n) {
        val coin = br.readLine().toInt()

        for (i in coin..k) {
            dp[i] = minOf(dp[i], dp[i - coin] + 1)
            write("${dp[i]}")
        }
    }

    if (dp[k] == 10001) write("-1")
    else write("${dp[k]}")
    close()
}
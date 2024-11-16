package week4

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val dp = IntArray(N + 1).apply {
        this[0] = 1
        this[1] = 3
    }

    for (i in 2..N) {
        dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901
    }

    write("${dp[N]}")
    close()
}
package week14

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(N + 1) { IntArray(2) }
    val dp = Array(N + 1) { IntArray(K + 1)}
    repeat(N) {
        arr[it + 1] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (i in 1..N) {
        for (j in 1..K) {
            if (arr[i][0] > j) dp[i][j] = dp[i - 1][j]
            else dp[i][j] = (arr[i][1] + dp[i - 1][j - arr[i][0]]).coerceAtLeast(dp[i - 1][j])
        }
    }
    write("${dp[N][K]}")
    close()
}

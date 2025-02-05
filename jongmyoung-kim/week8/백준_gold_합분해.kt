package week8

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, K) = br.readLine().split(" ").map(String::toInt)
    val dp = Array(K + 1) { IntArray(N + 1) { 1 } }
    for (i in 2..K) for (j in 1..N) dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_000
    write("${dp[K][N]}")
    close()
}

//fun main() = with(System.out.bufferedWriter()) {
//    val (N, K) = br.readLine().split(" ").map(String::toInt)
//    getDupPermutation(0, 0, N, K)
//    write("${answer / 1_000_000_000}")
//    close()
//}
//
//fun getDupPermutation(sum: Int, cnt: Int, N: Int, K: Int) {
//    if (sum == N) answer++
//    else if (cnt < K) {
//        for (i in 0..N) getDupPermutation(sum + i, cnt + 1, N, K)
//    }
//}
// 재귀방식은 시간초과 -> DP
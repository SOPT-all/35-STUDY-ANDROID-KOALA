package week7

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val children = br.readLine().toInt()
    val line = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(children + 1)
    var max = 0
    for (child in line) {
        dp[child] = dp[child-1] + 1
        max = maxOf(max, dp[child])
    }
    write("${children - max}")
    close()
}
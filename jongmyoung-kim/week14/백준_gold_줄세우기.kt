package week14

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val line = IntArray(N)
    val dp = IntArray(N) { 1 }
    repeat(N) { line[it] = br.readLine().toInt() }
    for (i in 1 until N) {
        for (j in 0..i) {
            if (line[i] > line[j]) dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
        }
    }
    write("${if (dp.maxOf { it } == 1) 0 else N - dp.maxOf { it }}")
    close()
}
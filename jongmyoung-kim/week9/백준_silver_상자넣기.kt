package week9

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val size = br.readLine().toInt()
    val box = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(size) { 1 }

    for (i in 1 until size) for (j in 0..i) {
        if (box[i] > box[j]) dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
    }
    write("${dp.maxOf { it }}\n")
    close()
}
package week6

import kotlin.math.ln

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (A, B) = br.readLine().split(" ").map { it.toLong() }
    val dp = LongArray(55).apply { this[0] = 1 }
    for (i in 1 until dp.size) {
        dp[i] = ((dp[i - 1] shl 1) + (1L shl i))
    }
    write("${countOnes(B, dp) - countOnes(A - 1, dp)}")
    close()
}

fun countOnes(n: Long, dp: LongArray): Long {
    var num = n
    var count = num and 1
    val size = (ln(num.toDouble()) / ln(2.0)).toInt()
    for (i in size downTo 1) {
        if ((num and (1L shl i)) != 0L) {
            count += dp[i - 1] + (num - (1L shl i) + 1)
            num -= 1L shl i
        }
    }
    return count
}

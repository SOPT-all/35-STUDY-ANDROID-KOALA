package koala.baekjoon

import kotlin.math.max

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val stickerBoard = Array(2) { IntArray(n) }
        val dp = Array(2) { IntArray(n) }
        repeat(2) { index ->
            val sticker = readln().split(" ").map { it.toInt() }.toIntArray()
            stickerBoard[index] = sticker
        }
        dp[0][0] = stickerBoard[0][0]
        dp[1][0] = stickerBoard[1][0]

        repeat(n) { idx ->
            if (idx != 0) {
                dp[0][idx] = max(dp[1][idx - 1] + stickerBoard[0][idx], dp[0][idx - 1])
                dp[1][idx] = max(dp[0][idx - 1] + stickerBoard[1][idx], dp[1][idx - 1])
            }
        }

        println(max(dp[0][n - 1], dp[1][n - 1]))
    }
}

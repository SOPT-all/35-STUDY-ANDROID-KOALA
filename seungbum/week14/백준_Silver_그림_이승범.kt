package baekjoon_practice

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(n) { BooleanArray(m) }
    val queue = ArrayDeque<Pair<Int, Int>>()
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    var num = 0
    var maxSize = 0

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (board[i][j] == 0 || visited[i][j]) continue
            num++
            visited[i][j] = true
            queue.add(i to j)
            var area = 0
            while (queue.isNotEmpty()) {
                val next = queue.removeFirst()
                area++
                for (dir in 0..3) {
                    val x = next.first + dx[dir]
                    val y = next.second + dy[dir]

                    if (x < 0 || x >= n || y < 0 || y >= m) continue
                    if (visited[x][y] || board[x][y] != 1) continue

                    visited[x][y] = true
                    queue.add(x to y)
                }
            }
            maxSize = max(area, maxSize)
        }
    }
    println("$num\n$maxSize")
}

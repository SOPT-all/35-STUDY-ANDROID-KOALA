package baekjoon_practice

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val queue = ArrayDeque<Pair<Int, Int>>()
    val distance = Array(n) { IntArray(m) { -1 } }
    var emptySpaceNum = 0
    var totalCount = 0
    var max = 0

    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)
    val boardSize = n * m

    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == 1) {
                queue.add(i to j)
                totalCount++
            } else if (board[i][j] == -1) {
                emptySpaceNum++
            }
        }
    }

    if (totalCount + emptySpaceNum == boardSize) {
        println(0)
        return
    }

    while (queue.isNotEmpty()) {
        val next = queue.removeFirst()
        for (dir in 0..3) {
            val x = next.first + dx[dir]
            val y = next.second + dy[dir]
            if (x < 0 || x >= n || y < 0 || y >= m) continue
            if (board[x][y] != 0 || distance[x][y] >= 0) continue
            distance[x][y] = distance[next.first][next.second] + 1
            max = max(max, distance[x][y])
            totalCount++
            queue.add(x to y)
        }
    }
    println(if (totalCount + emptySpaceNum != n * m) -1 else max + 1)
}

// day를 배열위에 표현하면 확실히 쉽게 도겠구나
// level queue쓰는법 반드시기억해
// val size = queue.size()
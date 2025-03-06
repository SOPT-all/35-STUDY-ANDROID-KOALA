package week11

import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private val direction = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
private val hop = arrayOf(Pair(1, 2), Pair(2, 1), Pair(2, -1), Pair(1, -2), Pair(-1, -2), Pair(-2, -1), Pair(-2, 1), Pair(-1, 2))
private var move = 40000

fun main() = with(System.out.bufferedWriter()) {
    val K = br.readLine().toInt()
    val (W, H) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(H) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    bfs(K, board)
    write(if (move == 40000) "-1" else "$move")
    close()
}

fun bfs(K: Int, board: Array<IntArray>) {
    val visited = Array(board.size) { Array(board[0].size) { BooleanArray(K + 1) } }.apply { this[0][0][0] = true }
    val queue = LinkedList<Triple<Pair<Int, Int>, Int, Int>>().apply { offer(Triple(Pair(0, 0), 0, 0)) }

    while (queue.isNotEmpty()) {
        val (coordinate, hopCount, curMove) = queue.poll()
        if (coordinate == Pair(board.size - 1, board[0].size - 1)) {
            move = move.coerceAtMost(curMove)
            break
        }
        for (i in direction.indices) { // 우선적으로 상하좌우 이동
            val dx = coordinate.first + direction[i].first
            val dy = coordinate.second + direction[i].second
            if (dx in board.indices && dy in board[0].indices && !visited[dx][dy][hopCount] && board[dx][dy] == 0) {
                visited[dx][dy][hopCount] = true
                queue.offer(Triple(Pair(dx, dy), hopCount, curMove + 1))
            }
        }
        if (hopCount < K) { // 아직 K 번 뛰지 않았을 때
            for (i in hop.indices) {
                val dx = coordinate.first + hop[i].first
                val dy = coordinate.second + hop[i].second
                if (dx in board.indices && dy in board[0].indices && !visited[dx][dy][hopCount + 1] && board[dx][dy] == 0) {
                    visited[dx][dy][hopCount + 1] = true
                    queue.offer(Triple(Pair(dx, dy), hopCount + 1, curMove + 1))
                }
            }
        }
    }
}
package week4

import java.util.LinkedList

class Solution {
    val directions = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(0, -1),
        intArrayOf(-1, 0),
        intArrayOf(0, 1)
    )

    fun solution(board: Array<IntArray>) = bfs(board.size, board)

    fun bfs(size: Int, board: Array<IntArray>): Int {
        val visited = Array(size) { Array(size) { IntArray(4) { Int.MAX_VALUE } } }
        val queue = LinkedList<Triple<Pair<Int, Int>, Int, Int>>().apply {
            this.add(Triple(Pair(0, 0),0, -1))
        }

        while(queue.isNotEmpty()) {
            val (xy, cost, direction) = queue.poll()

            for(i in 0..3) {
                val dx = xy.first + directions[i][0]
                val dy = xy.second + directions[i][1]
                val nc = if(direction == i || direction == -1) cost + 100 else cost + 600

                if (dx in 0 until size && dy in 0 until size
                    && board[dx][dy] != 1 && visited[dx][dy][i] >= nc) {
                    visited[dx][dy][i] = nc
                    queue.add(Triple(Pair(dx, dy), nc, i))
                }
            }
        }

        return visited[size - 1][size - 1].minOf { it }
    }
}
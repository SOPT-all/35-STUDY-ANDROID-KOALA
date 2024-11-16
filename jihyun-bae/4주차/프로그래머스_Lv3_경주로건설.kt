import java.util.LinkedList
import java.util.Queue

class Solution {
    fun bfs(board: Array<IntArray>, start: Pair<Int, Int>, directs: Int, cost: Int) : Int {
        val directions = listOf(Pair(0, 1), Pair(0, -1), Pair(-1, 0), Pair(1, 0))
        val queue : Queue<Triple<Pair<Int, Int>, Int, Int>> = LinkedList<Triple<Pair<Int, Int>, Int, Int>>()
        
        queue.add(Triple(start, directs, cost))
        
        while(queue.isNotEmpty()) {
            val top = queue.poll()
            
            directions.forEachIndexed { index, direction ->
                val next = Pair(top.first.first + direction.first, top.first.second + direction.second)
                val cost = top.third + if (top.second / 2 == index / 2) 100 else 600
                
                if (next == Pair(0, 0) || next.first !in board.indices || next.second !in board.indices || board[next.first][next.second] == 1) return@forEachIndexed
                
                if (board[next.first][next.second] == 0 || cost <= board[next.first][next.second]) {
                    board[next.first][next.second] = cost
                    queue.add(Triple(next, index, cost))
                }
            }
        }
        
        return board[board.size - 1][board.size - 1]
    }
    
    fun solution(board: Array<IntArray>): Int = minOf(bfs(board = board, start = Pair(0, 0), directs = 1, cost = 0), bfs(board = board, start = Pair(0, 0), directs = 3, cost = 0))
}

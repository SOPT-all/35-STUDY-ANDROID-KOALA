class Solution {
    data class Point(
        val x: Int, 
        val y: Int, 
        val dir: Int, 
        val cost: Int
    )
    
    fun solution(board: Array<IntArray>): Int {
        val n = board.size
        val dx = arrayOf(0, 1, 0, -1)
        val dy = arrayOf(1, 0, -1, 0)
        val costs = Array(n) { Array(n) { Array(4) { Int.MAX_VALUE } } }
        
        val queue = ArrayDeque<Point>()
        
        queue.add(Point(0, 0, 0, 0))
        queue.add(Point(0, 0, 1, 0))
        costs[0][0][0] = 0
        costs[0][0][1] = 0
        
        while (queue.isNotEmpty()) {
            val (x, y, dir, cost) = queue.removeFirst()
            
            if (cost > costs[x][y][dir]) continue
            
            for (i in 0..3) {
                val nx = x + dx[i]
                val ny = y + dy[i]
                
                if (nx !in 0 until n || ny !in 0 until n || board[nx][ny] == 1) continue
                
                val newCost = cost + if (dir == i) 100 else 600
                
                if (newCost < costs[nx][ny][i]) {
                    costs[nx][ny][i] = newCost
                    queue.add(Point(nx, ny, i, newCost))
                }
            }
        }
        
        return costs[n-1][n-1].minOrNull()!!
    }
}
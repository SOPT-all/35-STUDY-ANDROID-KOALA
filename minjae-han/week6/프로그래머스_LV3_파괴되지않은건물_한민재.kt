class Solution {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        val sum = Array(board.size + 1) { IntArray(board[0].size + 1) }
        
        for (s in skill) {
            val degree = if (s[0] == 1) -s[5] else s[5]
            val (r1, c1, r2, c2) = s.slice(1..4)
            
            sum[r1][c1] += degree
            sum[r1][c2 + 1] -= degree
            sum[r2 + 1][c1] -= degree
            sum[r2 + 1][c2 + 1] += degree
        }
        
        for (r in sum.indices) {
            for (c in 1 until sum[0].size) {
                sum[r][c] += sum[r][c-1]
            }
        }
        
        for (c in sum[0].indices) {
            for (r in 1 until sum.size) {
                sum[r][c] += sum[r-1][c]
            }
        }
        
        var count = 0
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] + sum[i][j] > 0) count++
            }
        }
        
        return count
    }
}
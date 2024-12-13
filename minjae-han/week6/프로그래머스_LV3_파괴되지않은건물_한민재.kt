class Solution {
   fun solution(board: Array<IntArray>, skill: Array<IntArray>) = with(Array(board.size + 1) { IntArray(board[0].size + 1) }) {
       skill.forEach { (t, r1, c1, r2, c2, d) ->
           val damage = if (t == 1) -d else d
           this[r1][c1] += damage
           this[r1][c2 + 1] -= damage
           this[r2 + 1][c1] -= damage
           this[r2 + 1][c2 + 1] += damage
       }
       (0..board.size).forEach { i -> (1..board[0].size).forEach { j -> this[i][j] += this[i][j - 1] } }
       (1..board.size).forEach { i -> (0..board[0].size).forEach { j -> this[i][j] += this[i - 1][j] } }
       board.indices.sumOf { i -> board[0].indices.count { j -> board[i][j] + this[i][j] > 0 } }
   }
}
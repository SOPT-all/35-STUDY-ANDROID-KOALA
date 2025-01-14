class Solution {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        val prefixSumOfSkill = Array(board.size + 1) { IntArray(board[0].size + 1) }
        
        skill.forEach {
            val degree = if (it[TYPE] == 1) -it[DEGREE] else it[DEGREE]
            
            prefixSumOfSkill[it[R1]][it[C1]] += degree
            prefixSumOfSkill[it[R2] + 1][it[C2] + 1] += degree
            prefixSumOfSkill[it[R1]][it[C2] + 1] -= degree
            prefixSumOfSkill[it[R2] + 1][it[C1]] -= degree
        }
        
        board.forEachIndexed { index, row ->
            for (column in 1..row.size) {
                prefixSumOfSkill[index][column] += prefixSumOfSkill[index][column -1]
            }
        }
        
        for (column in board[0].indices) {
            for (row in 1..board.size) {
                 prefixSumOfSkill[row][column] += prefixSumOfSkill[row - 1][column]
            }
        }
        
        return board.indices.sumOf { row ->
            board[row].indices.count { column ->
                board[row][column] + prefixSumOfSkill[row][column] > 0
            }
        }
    }
    
    companion object {
        private const val TYPE = 0
        private const val R1 = 1
        private const val C1 = 2
        private const val R2 = 3
        private const val C2 = 4
        private const val DEGREE = 5
    }
}

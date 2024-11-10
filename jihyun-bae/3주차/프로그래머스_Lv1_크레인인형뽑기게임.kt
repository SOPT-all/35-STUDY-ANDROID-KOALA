class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        
        val line = board[0].indices.map { i -> board.map { it[i] }.filter { it != 0 }.toMutableList() }
        val stack = ArrayDeque<Int>()
        
        for (move in moves) {
            if (line[move - 1].isNotEmpty()) {
                val doll = line[move - 1].removeAt(0)
                
                if (stack.lastOrNull() == doll) {
                    answer += 2
                    stack.removeLast()
                } else {
                    stack.addLast(doll)
                }
            }
        }
        
        return answer
    }
}

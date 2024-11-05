class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val basket = ArrayDeque<Int>()
        var answer = 0
        
        moves.forEach { position ->
            val col = position - 1
            
            val doll = board.indices
                .firstOrNull { row -> board[row][col] != 0 }
                ?.let { row -> 
                    board[row][col].also { 
                        board[row][col] = 0 
                    }
                } ?: return@forEach
            
            if (basket.isNotEmpty() && basket.last() == doll) {
                basket.removeLast()
                answer += 2
            } else {
                basket.addLast(doll)
            }
        }
        
        return answer
    }
}
                

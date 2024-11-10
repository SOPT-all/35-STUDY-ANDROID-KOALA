class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        
        var answer = 0
        val basket = mutableListOf<Int>()

        moves.forEach { move ->
            val lineNum = move - 1
            var doll = 0

    
            for (i in board.indices) {
                val currentDoll = board[i][lineNum]
                if(currentDoll != 0) {
                    doll = currentDoll
                    board[i][lineNum] = 0
                    break
                }
            } 

            if (doll != 0) {
                if (basket.isNotEmpty() && basket.last() == doll) {
                    basket.removeLastOrNull()
                    answer += 2
                } else {
                    basket.add(doll)
                }
            }
        }
        return answer
    }
}
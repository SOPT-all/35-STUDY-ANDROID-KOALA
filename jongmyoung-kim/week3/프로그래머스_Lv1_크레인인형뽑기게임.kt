class 프로그래머스_Lv1_크레인인형뽑기게임 {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        val basket = mutableListOf<Int>()
        var answer = 0

        moves.forEach { move ->
            for(row in board) {
                if(row[move-1] != 0) {
                    if(basket.isNotEmpty() && basket.last() == row[move-1]) {
                        basket.removeLast()
                        answer += 2
                    } else {
                        basket.add(row[move-1])
                    }
                    row[move-1] = 0
                    break
                }
            }
        }
        return answer
    }
}
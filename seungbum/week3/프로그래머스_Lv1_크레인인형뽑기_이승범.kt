package koala.programmers

import java.util.*

class Kakao_64061 {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var count = 0
        val characterBoard = Array(board[0].size) { Stack<Int>() }
        val bucket = Stack<Int>()

        for (i in board[0].lastIndex downTo 0) {
            for (j in board.indices) {
                if (board[i][j] != 0) {
                    characterBoard[j].push(board[i][j])
                }
            }
        }

        moves.forEach { index ->
            val character = if (characterBoard[index - 1].isNotEmpty())
                characterBoard[index - 1].pop() else return@forEach
            if (bucket.isEmpty()) {
                bucket.push(character)
            } else {
                if (bucket.last() == character) {
                    count += 2
                    bucket.pop()
                } else {
                    bucket.push(character)
                }
            }
        }
        return count
    }
}

/*
1. 각 배열에 들어잇는값을 순서대로 재배치 0 빼고 나머지
2. for 문을 사용해 순차적으로 moves에 값을 뽑음
3. 값이 없다면 그냥 삽입 /있다면 비교후 삽입하고 같다면 pop하고 count+
 */
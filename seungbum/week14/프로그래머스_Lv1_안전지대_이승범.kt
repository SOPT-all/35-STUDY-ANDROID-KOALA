package koala.programmers

class Week14Second {
    fun solution(board: Array<IntArray>): Int {
        val n = board.size
        var count = 0
        val wideBoard = Array(n + 2) { IntArray(n + 2) { 0 } }
        for (i in board.indices) {
            for (j in board.indices) {
                if (board[i][j] == 1) {
                    val x = i + 1
                    val y = j + 1
                    wideBoard[x][y] = 1
                    wideBoard[x - 1][y] = 1
                    wideBoard[x + 1][y] = 1
                    wideBoard[x][y - 1] = 1
                    wideBoard[x][y + 1] = 1
                    wideBoard[x - 1][y + 1] = 1
                    wideBoard[x - 1][y - 1] = 1
                    wideBoard[x + 1][y - 1] = 1
                    wideBoard[x + 1][y + 1] = 1
                }
            }
        }

        for (i in board.indices) {
            for (j in board.indices) {
                if (wideBoard[i + 1][j + 1] == 0) count++
            }
        }
        return count
    }
}

// 문제를 풀려는데 가장자리 부분을 어떻게 처리할까가 고민이됨 그래서 많이 if else 혹은 wihle을
// 쓸까하다가 그냥 개큰board를 만들어버림
fun main() {
    val new = Week14Second()
    val board2 = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 0, 0)
    )
    val board1 = arrayOf(
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 0, 0, 0),
        intArrayOf(0, 0, 1, 1, 0),
        intArrayOf(0, 0, 0, 0, 0)
    )

    println(new.solution(board2))
}
/*

 */
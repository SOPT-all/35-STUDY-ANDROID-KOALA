package week6

fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
    var answer: Int = 0
    val totalDamage = Array(board.size + 1) { IntArray(board[0].size + 1) }
    skill.forEach {
        val degree = if (it[0] == 1) -it[5] else it[5]
        totalDamage[it[1]][it[2]] += degree
        totalDamage[it[3] + 1][it[4] + 1] += degree
        totalDamage[it[1]][it[4] + 1] -= degree
        totalDamage[it[3] + 1][it[2]] -= degree
    }

    for (i in board.indices) {
        for (j in 1 until board[0].size) {
            totalDamage[i][j] += totalDamage[i][j - 1]
        }
    }
    for (i in board[0].indices) {
        for (j in 1 until board[0].size) {
            totalDamage[j][i] += totalDamage[j - 1][i]
        }
    }
    for (i in board.indices) {
        for (j in board[0].indices) {
            answer += if(board[i][j] + totalDamage[i][j] > 0) 1 else 0
        }
    }
    return answer
}
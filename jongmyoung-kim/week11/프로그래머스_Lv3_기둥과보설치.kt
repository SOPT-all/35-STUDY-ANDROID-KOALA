package week11

lateinit var frame: Array<Array<BooleanArray>>
private var answer = mutableListOf<IntArray>()

fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
    frame = Array(n + 2) { Array(n + 2) { BooleanArray(2) } }
    for ((x, y, a, b) in build_frame) {
        when (b) {
            0 -> {
                frame[x + 1][y + 1][a] = false
                if (!checkDel(n)) frame[x + 1][y + 1][a] = true
            }
            1 -> if (check(a, x + 1, y + 1)) frame[x + 1][y + 1][a] = true
        }
    }
    for (i in 1..n + 1) {
        for (j in 1..n + 1) {
            if (frame[i][j][0]) answer.add(intArrayOf(i - 1, j - 1, 0))
            if (frame[i][j][1]) answer.add(intArrayOf(i - 1, j - 1, 1))
        }
    }
    return answer.toTypedArray()
}

fun check(type: Int, x: Int, y: Int): Boolean = when (type) {
    0 -> y == 1 || frame[x][y - 1][0] || frame[x - 1][y][1] || frame[x][y][1]
    else -> frame[x][y - 1][0] || frame[x + 1][y - 1][0] || (frame[x - 1][y][1] && frame[x + 1][y][1])
}

fun checkDel(n: Int): Boolean {
    for (i in 1..n + 1) {
        for (j in 1..n + 1) {
            if (frame[i][j][0] && !check(0, i, j)) return false
            if (frame[i][j][1] && !check(1, i, j)) return false
        }
    }
    return true
}
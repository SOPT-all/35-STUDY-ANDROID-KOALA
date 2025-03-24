import java.util.LinkedList

private val br = System.`in`.bufferedReader()
private lateinit var red: Pair<Int, Int>
private lateinit var blue: Pair<Int, Int>

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(N) { br.readLine().toCharArray() }

    for (i in board.indices) {
        for (j in board[0].indices) {
            if (board[i][j] == 'R') {
                red = Pair(i, j)
                board[i][j] = '.'
            }
            if (board[i][j] == 'B') {
                blue = Pair(i, j)
                board[i][j] = '.'
            }
        }
    }
    write("${bfs(N, M, board)}")
    close()
}

fun bfs(N: Int, M: Int, board: Array<CharArray>): Int {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    val queue = LinkedList<Triple<Pair<Int, Int>, Pair<Int, Int>, Int>>().apply { offer(Triple(red, blue, 0)) }
    val visited = Array(N) { Array(M) { Array(N) { BooleanArray(M) } } }.apply { this[red.first][red.second][blue.first][blue.second] = true }

    while (queue.isNotEmpty()) {
        val (r, b, move) = queue.poll()
        if (move >= 10) return -1

        for (i in directions.indices) {
            blue = b.moveToEnd(directions[i], board)
            if (blue.first == -1) continue
            red = r.moveToEnd(directions[i], board)
            if (red.first == -1) return move + 1

            if (red == blue) {
                when (i) {
                    0 -> if (r.first < b.first) red = Pair(red.first - 1, red.second) else blue = Pair(blue.first - 1, blue.second)
                    1 -> if (r.second > b.second) red = Pair(red.first, red.second + 1) else blue = Pair(blue.first, blue.second + 1)
                    2 -> if (r.first > b.first) red = Pair(red.first + 1, red.second) else blue = Pair(blue.first + 1, blue.second)
                    3 -> if (r.second < b.second) red = Pair(red.first, red.second - 1) else blue = Pair(blue.first, blue.second -1)
                }
            }
            if (!visited[red.first][red.second][blue.first][blue.second]) {
                visited[red.first][red.second][blue.first][blue.second] = true
                queue.offer(Triple(Pair(red.first, red.second), Pair(blue.first, blue.second), move + 1))
            }
        }
    }
    return -1
}

fun Pair<Int, Int>.moveToEnd(direction: Pair<Int, Int>, board: Array<CharArray>): Pair<Int, Int> {
    var dx = this.first
    var dy = this.second
    while (dx + direction.first in board.indices && dy + direction.second in board[0].indices && board[dx + direction.first][dy + direction.second] != '#') {
        dx += direction.first
        dy += direction.second
        if (board[dx][dy] == 'O') return Pair(-1, -1)
    }
    return Pair(dx, dy)
}
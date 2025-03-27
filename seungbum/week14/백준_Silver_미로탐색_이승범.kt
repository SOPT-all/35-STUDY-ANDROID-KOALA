package baekjoon_practice

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val board = Array(n) { readLine().chunked(1).map { it.toInt() }.toIntArray() }

    val queue = ArrayDeque<Pair<Int, Int>>()
    val visited = Array(n) { IntArray(m) { 0 } }
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)

    queue.add(0 to 0)
    visited[0][0] = 1

    while (queue.isNotEmpty()) {
        val next = queue.removeFirst()
        val distance = visited[next.first][next.second]
        for (dir in 0..3) {
            val x = next.first + dx[dir]
            val y = next.second + dy[dir]
            if (x < 0 || x >= n || y < 0 || y >= m) continue
            if (board[x][y] == 0 || visited[x][y] >= 1) continue
            queue.add(x to y)
            visited[x][y] = distance + 1
        }
    }

    println(visited[n - 1][m - 1])
}
//bfs 설정이 익숙하지가 않다
//
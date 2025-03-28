package week14

import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val maze = Array(8) { br.readLine().toCharArray() }
    write("${bfs(maze)}")
    close()
}

fun bfs(maze: Array<CharArray>): Int {
    val directions = arrayOf(Pair(1, 0), Pair(1, -1), Pair(0, -1), Pair(-1, -1), Pair(-1, 0), Pair(-1, 1), Pair(0, 1), Pair(1, 1), Pair(0, 0))
    val queue = LinkedList<Pair<Int, Int>>().apply { offer(Pair(7, 0)) }

    while (queue.isNotEmpty()) {
        val visited = Array(8) { BooleanArray(8) }

        repeat(queue.size) {
            val (x, y) = queue.poll()

            if (maze[x][y] == '#') return@repeat // 현재 위치가 벽이라면 continue
            if (x == 0 && y == 7 || maze.all { !it.contains('#') }) return 1 // 종료 지점 or 미로에 벽이 없으면 1

            for (i in directions.indices) {
                val dx = x + directions[i].first
                val dy = y + directions[i].second

                if (dx in 0..7 && dy in 0..7 && maze[dx][dy] != '#' && !visited[dx][dy]) {
                    queue.offer(Pair(dx, dy))
                    visited[dx][dy] = true
                }
            }
        }
        maze.moveMaze()
    }
    return 0
}

fun Array<CharArray>.moveMaze() {
    for (i in 7 downTo 1) this[i] = this[i - 1].copyOf()
    this[0].fill('.')
}
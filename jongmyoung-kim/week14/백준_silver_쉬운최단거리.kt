package week14

import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(n) { BooleanArray(m) }

    var target = Pair(0, 0)

    for (i in map.indices) {
        for (j in map[0].indices) {
            if (map[i][j] == 2) {
                target = Pair(i, j)
                break
            }
        }
    }
    map.bfs(target, visited)
    for (i in map.indices) {
        for (j in map[0].indices) {
            if (map[i][j] == 1 && !visited[i][j]) map[i][j] = -1
        }
    }
    map.forEach {
        write("${it.joinToString(" ")}\n")
    }
    close()
}

fun Array<IntArray>.bfs(target: Pair<Int, Int>, visited: Array<BooleanArray>) {
    val queue = LinkedList<Pair<Pair<Int, Int>, Int>>().apply { offer(Pair(target, 0)) }
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))

    visited[target.first][target.second] = true

    while (queue.isNotEmpty()) {
        val (coordinate, move) = queue.poll()
        this[coordinate.first][coordinate.second] = move

        for (dir in directions) {
            val dx = coordinate.first + dir.first
            val dy = coordinate.second + dir.second

            if (dx in this.indices && dy in this[0].indices && !visited[dx][dy] && this[dx][dy] != 0) {
                queue.offer(Pair(Pair(dx, dy), move + 1))
                visited[dx][dy] = true
            }
        }
    }
}
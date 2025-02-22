package week10

import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (row, col) = br.readLine().split(" ").map { it.toInt() }
    val canvas = Array(row) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(row) { BooleanArray(col) }
    var pictureCount = 0
    var pictureSize = 0

    for (i in 0 until row) for (j in 0 until col) {
        if (!visited[i][j] && canvas[i][j] == 1) {
            pictureCount++
            pictureSize = pictureSize.coerceAtLeast(bfs(canvas, visited, i, j))
        }
    }
    write("${pictureCount}\n$pictureSize")
    close()
}

fun bfs(canvas: Array<IntArray>, visited: Array<BooleanArray>, row: Int, col: Int): Int {
    val directions = arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0), Pair(0, 1))
    val queue = LinkedList<Pair<Int, Int>>().apply { offer(Pair(row, col)) }
    var size = 1
    visited[row][col] = true

    while (queue.isNotEmpty()) {
        val coordinate = queue.poll()

        for (i in directions) {
            val dx = coordinate.first + i.first
            val dy = coordinate.second + i.second
            if (dx in canvas.indices && dy in canvas[0].indices && canvas[dx][dy] == 1 && !visited[dx][dy]) {
                visited[dx][dy] = true
                queue.offer(Pair(dx, dy))
                size++
            }
        }
    }
    return size
}
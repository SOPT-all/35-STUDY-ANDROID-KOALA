package week3

private val br = System.`in`.bufferedReader()
private val N = br.readLine().toInt()
private val area = Array(N) { IntArray(N) }
private val directions = arrayOf(
    arrayOf(-1, 0),
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1)
)

fun main() = with(System.out.bufferedWriter()) {
    var maxHeight = 0
    var safeCount = 1 // 최소 안전영역 = 1

    for(i in 0 until N) {
        area[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        maxHeight = area[i].maxBy { it } // 최고 수위를 넘어가는 순간 안전영역은 0
    }

    for(i in 1..maxHeight) {
        val visited = Array(N) { BooleanArray(N) }
        var tmpCount = 0

        for(x in 0 until N) {
            for(y in 0 until N) {
                if(area[x][y] > i && !visited[x][y]) {
                    tmpCount++
                    dfs(i, x, y, visited)
                }
            }
        }
        safeCount = maxOf(tmpCount, safeCount)
    }
    write("$safeCount")
    close()
}

fun dfs(height: Int, x: Int, y: Int, visited: Array<BooleanArray>) {
    if(x !in 0 until N || y !in 0 until N || area[x][y] <= height || visited[x][y]) return

    visited[x][y] = true
    directions.forEach {
        dfs(height, x + it[0], y + it[1], visited)
    }
}
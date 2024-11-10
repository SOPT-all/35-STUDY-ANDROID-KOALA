fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    val dx = arrayOf(-1, 1, 0, 0)
    val dy = arrayOf(0, 0, -1, 1)
    
    fun dfs(h: Int, x: Int, y: Int, visited: Array<BooleanArray>): Boolean {
        if (x !in 0 until n || y !in 0 until n || visited[x][y] || map[x][y] <= h) return false
        visited[x][y] = true
        repeat(4) { dfs(h, x + dx[it], y + dy[it], visited) }
        return true
    }
    
    println((0..100).maxOf { h ->
        var cnt = 0
        val visited = Array(n) { BooleanArray(n) }
        for (i in 0 until n) for (j in 0 until n) {
            if (dfs(h, i, j, visited)) cnt++
        }
        cnt
    })
}
private val dx = intArrayOf(-1, 1, 0, 0)
private val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    
    var minHeight = 100
    var maxHeight = 1
    val area = Array(n) { 
        readLine().split(" ").map { 
            it.toInt().also { h ->
                minHeight = minOf(minHeight, h)
                maxHeight = maxOf(maxHeight, h)
            }
        }.toIntArray()
    }
    

    val visited = Array(n) { BooleanArray(n) }
    var maxSafeAreas = 1 
    
    for (height in minHeight until maxHeight) {
        var count = 0
        
        for (i in 0 until n) {
            visited[i].fill(false)
        }
        
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (!visited[i][j] && area[i][j] > height) {
                    dfs(i, j, height, area, visited, n)
                    count++
                }
            }
        }
        
        maxSafeAreas = maxOf(maxSafeAreas, count)
    }
    
    print(maxSafeAreas)
}

private fun dfs(x: Int, y: Int, height: Int, area: Array<IntArray>, visited: Array<BooleanArray>, n: Int) {
    visited[x][y] = true
    
    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        
        if (nx in 0 until n && ny in 0 until n && 
            !visited[nx][ny] && area[nx][ny] > height) {
            dfs(nx, ny, height, area, visited, n)
        }
    }
}
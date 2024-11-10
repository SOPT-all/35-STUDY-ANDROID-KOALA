import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer
import kotlin.math.max

fun main(): Unit = with(System.`in`.bufferedReader()) {
    
    // n x n 지도 생성
    val n = readLine().toInt()
    val map = Array(n) { Array(n) { 0 } }
    
    // 이동 옵션 정의 
    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0) 

    var maxHeight = 0 

    // 지도를 입력받고, 최대 높이를 찾는다.
    repeat(n) { x ->
        val st = StringTokenizer(readLine())
        repeat(n) { y ->
            map[x][y] = st.nextToken().toInt()
            maxHeight = max(maxHeight, map[x][y]) 
        }
    }

    var maxSafety = 0
	
    // 빗물의 높이 0부터 최대 높이까지 탐색
    for (height in 0..maxHeight) {
        var cnt = 0
        val visited = Array(n) { Array(n) { false } }

		// 모든 지점에 대해 BFS 수행
        repeat(n) { x ->
            repeat(n) { y ->
                if (visited[x][y] || map[x][y] <= height) return@repeat
                cnt++
                    
                val q = LinkedList<Pair<Int, Int>>() as Queue<Pair<Int, Int>>
                q.offer(Pair(x, y))
                visited[x][y] = true

                while (q.isNotEmpty()) {
                    val target = q.poll()

                    for (i in 0 until 4) {
                        val nx = target.first + dx[i]
                        val ny = target.second + dy[i]

                        if (nx !in 0 until n || ny !in 0 until n || visited[nx][ny] || map[nx][ny] <= height) continue

                        q.offer(Pair(nx, ny))
                        visited[nx][ny] = true
                    }
                }
            }
        }

        maxSafety = max(maxSafety, cnt)
    }

    println(maxSafety)
}
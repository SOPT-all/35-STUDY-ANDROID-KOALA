private val br = System.`in`.bufferedReader()
var cleanCount = 0
val directions = arrayOf( // starting from N -> E -> S -> W
    arrayOf(-1, 0),
    arrayOf(0, 1),
    arrayOf(1, 0),
    arrayOf(0, -1)
)

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() } // 방의 크기 n * m
    val (x, y, direction) = br.readLine().split(" ").map { it.toInt() } // 청소기의 시작 위치 x, y, 바라보는 방향 direction
    val room = Array(n) { IntArray(m) } // 방의 정보를 담을 2차원 배열

    for (i in 0 until n) { // 방의 정보 저장
        room[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    fun clean(x: Int, y: Int, dir: Int) {
        if (room[x][y] == 0) { // 청소되어 있지 않다면 청소 후, cnt ++
            room[x][y] = 2
            cleanCount++
        }

        var tempDir = dir
        for(i in directions.indices) { // 4 방향 기준 청소할 칸 확인
            val nextDir = if (tempDir == 0) 3 else tempDir - 1 // 반시계 90도 회전
            val nextX = x + directions[nextDir][0]
            val nextY = y + directions[nextDir][1]

            if (nextX !in 0 until n || nextY !in 0 until m || room[nextX][nextY] != 0) { // 주변이 벽일 경우
                tempDir = nextDir
                continue
            }
            clean(nextX, nextY, nextDir)
            return
        }

        val nextX = x - directions[dir][0]
        val nextY = y - directions[dir][1]
        if (nextX in 0 until n && nextY in 0 until m && room[nextX][nextY] != 1) { // 청소할 칸이 없을 경우
            clean(nextX, nextY, dir)
        }
    }

    clean(x, y, direction)
    write(cleanCount.toString())
    close()
}
package koala.baekjoon

import java.util.*
import kotlin.math.max


fun main(args: Array<String>) {
    val n = readln().toInt()
    val heightBoard = Array(n) { IntArray(n) }
    var max = 1

    repeat(n) { index ->
        val heightColumn = readln().split(" ").map { it.toInt() }.toIntArray()
        max = max(heightColumn.max(), max)
        heightBoard[index] = heightColumn
    }
    var maxCount = 1

    for (rainAmount in 1 .. max) {
        var count = 0
        val visited = Array(n) { BooleanArray(n) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (heightBoard[i][j] > rainAmount && !visited[i][j]) {
                    bfs(n, Pair(i, j), visited, heightBoard, rainAmount)
                    count++
                }
            }
        }
        maxCount = max(maxCount, count)
    }
    print(maxCount)
}


val dirXY = arrayOf(arrayOf(0,1), arrayOf(1,0), arrayOf(0,-1), arrayOf(-1,0))

fun bfs(
    n: Int,
    node: Pair<Int, Int>,
    visited: Array<BooleanArray>,
    heightBoard: Array<IntArray>,
    rainAmount: Int,
) {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(node)
    visited[node.first][node.second] = true


    while (queue.isNotEmpty()) {
        val head = queue.poll()

        val y = head.first
        val x = head.second

        for (i in 0 until 4) {
            val ny = y + dirXY[i][0]
            val nx = x + dirXY[i][1]

            if (ny !in 0 until n || nx !in 0 until n || visited[ny][nx] || heightBoard[ny][nx] <= rainAmount) continue
            queue.add(Pair(ny, nx))
            visited[ny][nx] = true
        }
    }
}


/*
1. N*N으로 높이가 주어짐 -> array 배열(heightBoard)
2. 안전한 지점 : 사방면이 모두 안전한 지역인경우
3. 얼마나 많은 구역으로 나누어져있는가? -> 중간에 끊어지는 순간 count ++
4.  min ~ max 까지 싹다 돌아버려
5. 비의양으로 회색 1로 표시하고 흰색 0으로 표시
6. 흰색 영역을 구하고 그 흰색영역으로 다음 진행
7. 영역 제일 많은경우를 구하자!
8. 여기서 사용할건 bfs
9. 영역을 돌다가 비의 양보다 크고 visited되지않은 지역 찾기
10. bfs 시작
11. bfs :  bfs의 edge는 어떻게 할거야? : 왼 -> 오른쪽으로 가니까 왼쪽은 이미 검증된 곳일거야 visited 됫거나 아무것도 없거나
    1.i , j 가 있다면 j+1 (j<n보다작을때)같다면 안함 / 그리고 i + 1 (i가 n보다 작을때) 같다면 안함 / i-1 (i 가 0보다 클때) 같으면 안함
    만족하고 bfs가 끝나면 count++
11. bfs  -> min을 넣고 첫번째로 min보다 큰수를 넣고 시작
            한바퀴 돌고 count 증가,
 */
package week1

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs

data class Location(val x: Int, val y: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt() // 테스트케이스 수

    repeat(t) {
        val n = br.readLine().toInt() // 편의점 수
        val locations = mutableListOf<Location>()

        // 위치들 정보
        repeat(n + 2) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            locations.add(Location(x, y))
        }

        // BFS로 편의점과 목적지에 도달할 수 있는지 확인
        if (bfs(locations)) {
            bw.write("happy\n")
        } else {
            bw.write("sad\n")
        }
    }

    bw.flush()
    bw.close()
    br.close()
}

fun bfs(locations: List<Location>): Boolean {
    val visited = BooleanArray(locations.size) { false }
    val queue: Queue<Location> = LinkedList()
    queue.add(locations[0]) // 출발 지점
    visited[0] = true

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current == locations.last()) return true // 목적지 도달

        for (i in locations.indices) {
            if (!visited[i] &&  abs(current.x - locations[i].x) +abs(current.y - locations[i].y)<=1000 )  {
                visited[i] = true
                queue.add(locations[i])
            }
        }
    }
    return false
}

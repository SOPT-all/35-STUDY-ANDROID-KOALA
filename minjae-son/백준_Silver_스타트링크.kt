import java.util.LinkedList
import java.util.Queue


fun main() {
    val (f, s, g, u, d) = readLine()!!.split(" ").map { it.toInt() }
    bfs(f, s, g, u, d)
}

fun bfs(totalFloor: Int, startFloor: Int, goalFloor: Int, upStairs: Int, downStairs: Int) {
    val visited = IntArray(totalFloor + 1) { -1 }
    val queue: Queue<Int> = LinkedList()

    queue.add(startFloor)
    visited[startFloor] = 0

    while (queue.isNotEmpty()) {
        val currentFloor = queue.poll()

        if (currentFloor == goalFloor) {
            println(visited[currentFloor])
            return
        }

        val nextFloorUp = currentFloor + upStairs
        if (nextFloorUp <= totalFloor && visited[nextFloorUp] == -1) {
            visited[nextFloorUp] = visited[currentFloor] + 1
            queue.add(nextFloorUp)
        }

        val nextFloorDown = currentFloor - downStairs
        if (nextFloorDown >= 1 && visited[nextFloorDown] == -1) {
            visited[nextFloorDown] = visited[currentFloor] + 1
            queue.add(nextFloorDown)
        }
    }

    println("use the stairs")
}

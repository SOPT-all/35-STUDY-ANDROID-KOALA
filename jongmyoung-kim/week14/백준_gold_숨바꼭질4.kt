package week14

import java.util.PriorityQueue

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }).apply { offer(Pair(N, 0)) }
    val visited = IntArray(100001) { -1 }

    while (queue.isNotEmpty()) {
        val (position, move) = queue.poll()

        if (position == K) {
            write("$move\n")
            val routes = mutableListOf<Int>()
            var route = K
            while (route != N) {
                routes.add(route)
                route = visited[route]
            }
            routes.add(route)
            write(routes.reversed().joinToString(" "))
            break
        }

        if (position + 1 in visited.indices && visited[position + 1] == -1) {
            queue.offer(Pair(position + 1, move + 1))
            visited[position + 1] = position
        }
        if (position - 1 in visited.indices && visited[position - 1] == -1) {
            queue.offer(Pair(position - 1, move + 1))
            visited[position - 1] = position

        }
        if (position * 2 in visited.indices && visited[position * 2] == -1) {
            queue.offer(Pair(position * 2, move + 1))
            visited[position * 2] = position
        }
    }
    close()
}
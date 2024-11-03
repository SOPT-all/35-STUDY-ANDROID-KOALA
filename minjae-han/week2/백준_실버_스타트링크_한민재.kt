import java.util.LinkedList
import java.util.Queue

fun main() {
    val (F, S, G, U, D) = readLine()!!.split(" ").map { it.toInt() }

    fun bfs(): Int {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val visited = BooleanArray(F + 1) { false }
        queue.add(Pair(S, 0))
        visited[S] = true

        while (queue.isNotEmpty()) {
            val (current, steps) = queue.poll()

            if (current == G) {
                return steps
            }

            val up = current + U
            val down = current - D

            if (up <= F && !visited[up]) {
                visited[up] = true
                queue.add(Pair(up, steps + 1))
            }

            if (down >= 1 && !visited[down]) {
                visited[down] = true
                queue.add(Pair(down, steps + 1))
            }
        }

        return -1
    }

    val result = bfs()
    if (result == -1) {
        println("use the stairs")
    } else {
        println(result)
    }
}

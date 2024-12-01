import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, x) = readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableMapOf<Int, Int>() }
    repeat(m) { readLine().split(" ").map { it.toInt() }.let { (s, e, t) -> graph[s][e] = t } }

    fun dijkstra(start: Int) = IntArray(n + 1) { Int.MAX_VALUE }.apply {
        this[start] = 0
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        pq.offer(start to 0)
        
        while (pq.isNotEmpty()) {
            val (cur, dist) = pq.poll()
            if (dist > this[cur]) continue
            graph[cur].forEach { (next, cost) ->
                val nextDist = dist + cost
                if (nextDist < this[next]) {
                    this[next] = nextDist
                    pq.offer(next to nextDist)
                }
            }
        }
    }

    val fromX = dijkstra(x)
    print((1..n).maxOf { if (it == x) 0 else dijkstra(it)[x] + fromX[it] })
}
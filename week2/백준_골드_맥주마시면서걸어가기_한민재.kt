import java.util.LinkedList
import kotlin.math.abs

fun manhattanDistance(x1: Int, y1: Int, x2: Int, y2: Int) = 
    abs(x1 - x2) + abs(y1 - y2)

fun canReachFestival(home: Pair<Int, Int>, festival: Pair<Int, Int>, stores: List<Pair<Int, Int>>): String {
    val points = listOf(home) + stores + listOf(festival)
    val n = points.size
    val graph = Array(n) { mutableListOf<Int>() }
    
    // Build graph - connect points within 1000 distance
    for (i in 0 until n) {
        val (x1, y1) = points[i]
        for (j in i + 1 until n) {
            val (x2, y2) = points[j]
            if (manhattanDistance(x1, y1, x2, y2) <= 1000) {
                graph[i].add(j)
                graph[j].add(i)
            }
        }
    }
    
    // BFS
    val visited = BooleanArray(n)
    val queue = LinkedList<Int>().apply { 
        add(0)
        visited[0] = true 
    }
    
    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        if (curr == n - 1) return "happy"
        
        for (next in graph[curr]) {
            if (!visited[next]) {
                visited[next] = true
                queue.add(next)
            }
        }
    }
    
    return "sad"
}

fun main() {
    repeat(readLine()!!.toInt()) {
        val n = readLine()!!.toInt()
        val home = readLine()!!.split(" ").let { Pair(it[0].toInt(), it[1].toInt()) }
        val stores = List(n) { 
            readLine()!!.split(" ").let { Pair(it[0].toInt(), it[1].toInt()) }
        }
        val festival = readLine()!!.split(" ").let { Pair(it[0].toInt(), it[1].toInt()) }
        
        println(canReachFestival(home, festival, stores))
    }
}
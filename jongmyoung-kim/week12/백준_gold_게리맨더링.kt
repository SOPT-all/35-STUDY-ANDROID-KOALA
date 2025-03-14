package week12

import java.util.LinkedList
import kotlin.math.abs

private val br = System.`in`.bufferedReader()
private val combination = mutableSetOf<Set<Int>>()

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val popularity = br.readLine().split(" ").map { it.toInt() }.toIntArray() // 각 구의 인구수
    val graph = Array(N + 1) { IntArray(N + 1) }
    val visited = BooleanArray(N + 1)
    var answer = 1001

    repeat(N) { i ->
        val (num, near) = br.readLine().split(" ").map { it.toInt() }.let { it[0] to it.drop(1).toIntArray() }
        repeat(num) { j ->
            graph[i + 1][near[j]] = 1
            graph[near[j]][i + 1] = 1
        }
    }
    if (graph.all { !it.contains(1) } && N > 2 || N <= 1) write("-1")
    else {
        for (i in 1 until N) getCombination(i, 1, graph, visited, mutableListOf())
        combination.forEach { set ->
            val opposite = (1..N).toMutableSet() - set
            visited.fill(false)
            if (checkConnection(set, graph, visited) && checkConnection(opposite, graph, visited)) {
                answer = abs(set.sumOf { popularity[it - 1] } - opposite.sumOf { popularity[it - 1] }).coerceAtMost(answer)
            }
        }
        write(if (answer == 1001) "-1" else "$answer")
    }
    close()
}

fun getCombination(target: Int, current: Int, graph: Array<IntArray>, visited: BooleanArray, comb: MutableList<Int>) {
    if (comb.size == target) combination.add(comb.toSet())
    else {
        for (i in current .. (graph.size / 2 + 1)) {
            if (!visited[i]) {
                visited[i] = true
                comb.add(i)
                getCombination(target, i + 1, graph, visited, comb)
                visited[i] = false
                comb.removeLast()
            }
        }
    }
}

fun checkConnection(set: Set<Int>, graph: Array<IntArray>, visited: BooleanArray): Boolean {
    val queue = LinkedList<Int>().apply { offer(set.first()) }
    var count = 1
    visited[set.first()] = true

    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        for (i in set) {
            if (!visited[i] && graph[cur][i] == 1) {
                visited[i] = true
                queue.offer(i)
                count++
            }
        }
    }
    return count == set.size
}
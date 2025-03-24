package week14

import java.util.LinkedList

var network = 0
fun solution(n: Int, computers: Array<IntArray>): Int {
    val graph = Array(n) { mutableListOf<Int>() }
    val visited = BooleanArray(n)

    computers.forEachIndexed { idx, computer ->
        computer.forEachIndexed { i, c ->
            if (c == 1) graph[idx].add(i)
        }
    }

    for (i in graph.indices) {
        for (j in graph[i].indices) {
            if (!visited[i]) dfs(i, graph, visited)
        }
    }
    return network
}

fun dfs(node: Int, graph: Array<MutableList<Int>>, visited: BooleanArray) {
    val stack = LinkedList<Int>().apply { push(node) }
    visited[node] = true
    network++

    while (stack.isNotEmpty()) {
        val cur = stack.pop()
        for (i in graph[cur]) {
            if (!visited[i]) {
                stack.push(i)
                visited[i] = true
            }
        }
    }
}
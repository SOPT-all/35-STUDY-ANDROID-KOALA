class Solution {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        val graph = Array(n + 1) { IntArray(n + 1) { MAX } }
        var answer = MAX
        
        for (i in graph.indices) {
            graph[i][i] = 0
        }
        
        fares.forEach { fare ->
            graph[fare[0]][fare[1]] = fare[2]
            graph[fare[1]][fare[0]] = fare[2]
        }
        
        for (i in graph.indices) {
            for (j in graph.indices) {
                for (k in graph.indices) {
                    graph[j][k] = kotlin.math.min(graph[j][k], graph[j][i] + graph[i][k])
                }
            }
        }
        
        for (i in graph.indices) {
            (graph[s][i] + graph[i][a] + graph[i][b]).let { temp ->
                answer = kotlin.math.min(answer, temp)
            }
        }
        
        return answer
    }
    
    companion object {
        private const val MAX = 200 * 100000 + 1
    }
}

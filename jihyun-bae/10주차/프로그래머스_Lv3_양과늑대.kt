import java.util.*

class Solution {
    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        var answer = 0
        val visited = Array(info.size) { false }
        
        fun dfs(sheep: Int, wolf: Int) {
            if (sheep > wolf) answer = Math.max(answer, sheep)
            else return
            
            edges.forEach {
                if (visited[it[0]] && !visited[it[1]]) {
                    visited[it[1]] = true
                    if (info[it[1]] == 0) dfs(sheep + 1, wolf) else dfs(sheep, wolf + 1)
                    visited[it[1]] = false
                }
            }
        }
        
        visited[0] = true
        dfs(1, 0)
        
        return answer
    }
}

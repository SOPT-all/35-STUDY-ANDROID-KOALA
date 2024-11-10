class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        val nows = IntArray(N + 1) { 0 }
        
        for (stage in stages) {
            nows[stage - 1] += 1
        }
        
        val pass = IntArray(N + 1) { 0 }
        pass[0] = stages.size
        
        for (now in 1..nows.size - 1) {
            pass[now] = pass[now - 1] - nows[now - 1]
        }
        
        val answer = DoubleArray(N) { i -> if (pass[i] == 0) pass[i].toDouble() else nows[i].toDouble() / pass[i] }.withIndex().sortedByDescending { it.value }.map { it.index + 1 }.toIntArray()
        
        return answer
    }
}

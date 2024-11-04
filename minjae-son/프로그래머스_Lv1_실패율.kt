class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        
        val totalUser = stages.size
        var remainUser = totalUser.toDouble()
        val challengers = IntArray(N+1) { 0 } 
        val failureRate = DoubleArray(N+1) { 0.0 } 

        for (stage in stages) if(stage in 1..N) challengers[stage]++

        for (i in 1..N) {
            failureRate[i] = challengers[i].toDouble() / remainUser
            remainUser -= challengers[i].toDouble()
            if(remainUser == 0.0) break
        }
        
        return failureRate.drop(1).withIndex()
            .sortedByDescending { it.value }
            .map { it.index + 1 }
            .toIntArray()
    }
}
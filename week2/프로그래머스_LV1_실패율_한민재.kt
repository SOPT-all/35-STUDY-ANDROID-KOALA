class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        val stageCounts = IntArray(N + 2)
        stages.forEach { stageCounts[it]++ }

        val failureRates = mutableListOf<Pair<Int, Double>>()
        var playersRemaining = stages.size

        for (stage in 1..N) {
            if (playersRemaining == 0) {
                failureRates.add(Pair(stage, 0.0))
            } else {
                val failureRate = stageCounts[stage].toDouble() / playersRemaining
                failureRates.add(Pair(stage, failureRate))
            }
            playersRemaining -= stageCounts[stage]
        }

        return failureRates
            .sortedWith(compareByDescending<Pair<Int, Double>> { it.second }.thenBy { it.first })
            .map { it.first }
            .toIntArray()
    }
}

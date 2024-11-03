package week2

class 프로그래머스_Lv1_실패율 {
    fun solution(N: Int, stages: IntArray): IntArray {
        var totalUser = stages.size.toDouble()
        val failure = IntArray(N + 1) { 0 }
        val failRate = DoubleArray(N + 1) { 0.0 }

        for(stage in stages) {
            if(stage > N) continue
            failure[stage]++
        }

        for(i in 1..N) {
            val failedUser = failure[i].toDouble()
            failRate[i] = failedUser / totalUser
            totalUser -= failedUser
            if(totalUser == 0.0) break
        }

        return failRate.drop(1).withIndex()
            .sortedByDescending { it.value }
            .map { it.index + 1 }
            .toIntArray()
    }
}
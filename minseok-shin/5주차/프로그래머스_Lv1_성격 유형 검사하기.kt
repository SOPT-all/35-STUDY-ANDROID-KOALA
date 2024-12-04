package week5

class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer = ""
        val mutableMap = mutableMapOf(
            "R" to 0, "T" to 0,
            "C" to 0, "F" to 0,
            "J" to 0, "M" to 0,
            "A" to 0, "N" to 0,
        )

        for (i in survey.indices) {
            val a = survey[i][0].toString()
            val b = survey[i][1].toString()
            val score = choices[i] - 4
            if (score > 0) {
                mutableMap[b] = mutableMap[b]!! + score
            } else {
                mutableMap[a] = mutableMap[a]!! + score * (-1)
            }
        }

        answer += if (mutableMap["R"]!! >= mutableMap["T"]!!) "R" else "T"
        answer += if (mutableMap["C"]!! >= mutableMap["F"]!!) "C" else "F"
        answer += if (mutableMap["J"]!! >= mutableMap["M"]!!) "J" else "M"
        answer += if (mutableMap["A"]!! >= mutableMap["N"]!!) "A" else "N"

        println(mutableMap)

        return answer
    }
}
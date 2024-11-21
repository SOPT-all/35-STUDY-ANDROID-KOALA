package week5

class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        val personality = arrayOf('R', 'T', 'C', 'F', 'J', 'M', 'A', 'N')
        val p_score = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0)

        survey.forEachIndexed { idx, _ ->
            p_score[personality.indexOf(survey[idx][1])] += choices[idx] - 4
        }

        for(i in 0..7 step 2) {
            answer += if (p_score[i] >= p_score[i + 1]) personality[i] else personality[i + 1]
        }
        return answer
    }
}
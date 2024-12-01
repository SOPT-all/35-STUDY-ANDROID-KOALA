class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val personalityTypeScore: MutableMap<Char, Int> = mutableMapOf()
        val scores = listOf(3, 2, 1, 0, 1, 2, 3)
        val personalityTypes = listOf(Pair('R', 'T'), Pair('C', 'F'), Pair('J', 'M'), Pair('A', 'N'))
        
        survey.forEachIndexed { index, answer ->
            when(choices[index]) {
                in 1.. 3 -> personalityTypeScore.merge(answer[0], scores[choices[index] - 1]) { oldValue, newValue -> oldValue + newValue }
                in 5..7 -> personalityTypeScore.merge(answer[1], scores[choices[index] - 1]) { oldValue, newValue -> oldValue + newValue }
                else -> Unit
            }
        }
        
        return personalityTypes.joinToString("") { (first, second) ->
            if (personalityTypeScore.getOrDefault(first, 0) >= personalityTypeScore.getOrDefault(second, 0)) first.toString() else second.toString()
        }
    }
}

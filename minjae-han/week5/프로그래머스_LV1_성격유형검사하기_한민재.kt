class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val score = IntArray(128)
        
        for(i in survey.indices) {
            val type = survey[i]
            val choice = choices[i]
            if(choice > 4) score[type[1].code] += choice - 4
            else if(choice < 4) score[type[0].code] += 4 - choice
        }
        
        return "${if(score['R'.code] >= score['T'.code]) 'R' else 'T'}" +
               "${if(score['C'.code] >= score['F'.code]) 'C' else 'F'}" +
               "${if(score['J'.code] >= score['M'.code]) 'J' else 'M'}" +
               "${if(score['A'.code] >= score['N'.code]) 'A' else 'N'}"
    }
}
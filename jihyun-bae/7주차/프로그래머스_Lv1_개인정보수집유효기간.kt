class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        
        val day = today.split(".").map { it.toInt() }
        
        val term = HashMap<String, Int>().apply {
            terms.forEach { t ->
                val (type, length) = t.split(" ")
                this[type] = length.toInt()
            }
        }
        
        val privacyList = privacies.map { it.split(" ").let { data ->
            Pair(data[0].split(".").map { it.toInt() }, data[1])
        } }
        
        privacyList.forEachIndexed { index, date ->
            val endDay = date.first.toMutableList()
            endDay[1] += term.getOrDefault(date.second, 0)
            endDay[2] -= 1
            
            if (endDay[2] == 0) {
                endDay[2] = 28
                endDay[1] -= 1
            }
            
            if (endDay[1] > 12) {
                endDay[0] += endDay[1] / 12
                endDay[1] -= (endDay[1] / 12) * 12
                
                if (endDay[1] == 0) {
                    endDay[0] -= 1
                    endDay[1] += 12
                }
            }
            
            println(endDay)
            
            if (day[0] > endDay[0] || (day[0] == endDay[0] && day[1] > endDay[1]) || (day[0] == endDay[0] && day[1] == endDay[1] && day[2] > endDay[2])) answer.add(index + 1)
        }
        
        return answer.toIntArray()
    }
}

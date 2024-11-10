import kotlin.math.ceil

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        
        val groupedRecord = records.map { it.split(" ") }.groupBy({ it[1].toInt() }, { Pair(it[0].replace(":", "").toInt(), it[2]) }).toSortedMap()
        
        val answer = mutableListOf<Int>()
        
        groupedRecord.forEach { (number, car) ->
            val totalParkedTime = car.chunked(2).sumOf {
                if (it.size == 2) it[1].first.toMinutes() - it[0].first.toMinutes() else 2359.toMinutes() - it[0].first.toMinutes()
            }
            
            val cost = if (totalParkedTime - fees[0] <= 0) fees[1] else fees[1] + (ceil((totalParkedTime - fees[0]) / fees[2].toDouble()).toInt()) * fees[3]
            
            answer.add(cost)
        }
        
        return answer.toIntArray()
    }
    
    fun Int.toMinutes(): Int = (this / 100) * 60 + this % 100
}

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val inTimes = mutableMapOf<String, Int>()
        val totalMinutes = mutableMapOf<String, Int>()
        
        for (record in records) {
            val time = record.substring(0, 5)
            val car = record.substring(6, 10)
            val isIn = record[11] == 'I'
            
            val minutes = (time[0] - '0') * 600 + 
                         (time[1] - '0') * 60 + 
                         (time[3] - '0') * 10 + 
                         (time[4] - '0')
            
            if (isIn) {
                inTimes[car] = minutes
            } else {
                val parkingTime = minutes - (inTimes.remove(car) ?: 0)
                totalMinutes[car] = (totalMinutes[car] ?: 0) + parkingTime
            }
        }
        
        inTimes.forEach { (car, inTime) ->
            val parkingTime = 1439 - inTime
            totalMinutes[car] = (totalMinutes[car] ?: 0) + parkingTime
        }
        
        val (basicTime, basicFee, unitTime, unitFee) = fees
        
        return totalMinutes.entries
            .sortedBy { it.key }
            .map { (_, minutes) -> 
                if (minutes <= basicTime) basicFee
                else {
                    val extraTime = minutes - basicTime
                    val extraUnits = (extraTime + unitTime - 1) / unitTime
                    basicFee + extraUnits * unitFee
                }
            }
            .toIntArray()
    }
}
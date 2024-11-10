class Solution {
    fun solution(fees: IntArray, records: Array<String>) = records
        .map { it.split(" ") }
        .groupBy { it[1] } 
        .map { (car, list) -> 
            car to list.chunked(2).sumOf { record ->
                val time = record.getOrNull(1)?.get(0)?.let { out ->
                    getMinutes(out) - getMinutes(record[0][0])
                } ?: (1439 - getMinutes(record[0][0]))
                time
            }
        }
        .sortedBy { it.first }  
        .map { (_, time) -> 
            if (time <= fees[0]) fees[1]
            else fees[1] + ((time - fees[0] + fees[2] - 1) / fees[2]) * fees[3]
        }
        .toIntArray()

    private fun getMinutes(time: String) = 
        time.split(":").let { it[0].toInt() * 60 + it[1].toInt() }
}
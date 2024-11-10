package week3

import kotlin.math.ceil

class Solution {
    fun toTime(timeStamp: String): Int {
        val (hour, minute) = timeStamp.split(":").map { it.toInt() }
        return hour * 60 + minute
    }

    fun calcFees(fees: IntArray, parkingTime: Int): Int {
        return if (parkingTime <= fees[0]) fees[1]
        else {
            (fees[1] + ceil(((parkingTime - fees[0]) / fees[2].toDouble())) * fees[3]).toInt()
        }
    }

    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val enterMap = mutableMapOf<String, Int>()
        val exitMap = mutableMapOf<String, Int>()

        records.forEach { record ->
            val (timeStamp, plate, state) = record.split(" ")

            if (state == "IN") {
                enterMap[plate] = toTime(timeStamp) // 입차 시간
            } else {
                val enterTime = enterMap.getOrDefault(plate, 0)
                val totalTime = exitMap.getOrDefault(plate, 0)
                val parkingTime = toTime(timeStamp) - enterTime + totalTime
                exitMap[plate] = parkingTime
                enterMap.remove(plate)
            }
        }
        enterMap.forEach {
            val totalTime = exitMap.getOrDefault(it.key, 0)
            val parkingTime = 1439 - it.value + totalTime
            exitMap[it.key] = parkingTime
        }
        val list = mutableListOf<Int>()
        exitMap.toSortedMap(compareBy<String> { it }).forEach {
            list.add(calcFees(fees, it.value))
        }
        return list.toIntArray()
    }
}

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val parkingLot: MutableMap<String, Int> = mutableMapOf()
        val parkingTimeRecord: MutableMap<String, Int> = mutableMapOf()

        records.forEach { record ->
            val (hourMinute, carNumber, inOut) = record.split(" ")
            val (hour, minute) = hourMinute.split(":")
            val time = hour.toInt() * 60 + minute.toInt()

            if (inOut == "IN") {
                parkingLot[carNumber] = time
            } else {
                val enterTime = parkingLot.remove(carNumber) ?: 0
                val parkingTime = time - enterTime
                parkingTimeRecord[carNumber] = parkingTimeRecord.getOrDefault(carNumber, 0) + parkingTime
            }
        }

        // 남아있는 IN 차량 처리
        parkingLot.forEach { (carNumber, enterTime) ->
            val parkingTime = 1439 - enterTime 
            parkingTimeRecord[carNumber] = parkingTimeRecord.getOrDefault(carNumber, 0) + parkingTime
        }

        // 차량 번호 순으로 정렬하여 요금 계산
        val answer = parkingTimeRecord.toSortedMap().map { (_, parkingTime) ->
            if (parkingTime <= fees[0]) {
                fees[1]
            } else {
                val extraTime = parkingTime - fees[0]
                fees[1] + Math.ceil(extraTime / fees[2].toDouble()).toInt() * fees[3]
            }
        }.toIntArray()

        return answer
    }
}
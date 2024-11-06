package koala.programmers

import kotlin.math.ceil

class Kakao_92341 {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer: IntArray
        val basicTime = fees[0]
        val basicFee = fees[1]
        val unitTime = fees[2]
        val unitFee = fees[3]
        val defaultExitTime = 60 * 23 + 59
        val carDepartureRecords = mutableMapOf<String, Pair<Int, Int>>()
        val totalTime = mutableMapOf<String, Int>()

        records.forEach {
            val record = it.split(" ")
            val departureTime = timeToMinute(record[0])
            val carNumber = record[1]
            val departureStatus = if (record[2] == "IN") 1 else 0

            if (departureStatus == 1) {
                carDepartureRecords[carNumber] = departureTime to departureStatus
            } else {
                val entryTime = carDepartureRecords.getValue(carNumber).first
                totalTime[carNumber] = (departureTime - entryTime) + (totalTime[carNumber] ?: 0)
                println("carNumber : $carNumber time : ${totalTime[carNumber]}")
                carDepartureRecords.remove(carNumber)
            }
        }

        carDepartureRecords.forEach {
            totalTime[it.key] = defaultExitTime - it.value.first + (totalTime[it.key] ?: 0)
            println(totalTime[it.key])
        }

        answer = totalTime.keys.sorted().map {
            calculateTotalFee(basicTime, basicFee, unitTime, unitFee, totalTime.getValue(it))
        }.toIntArray()

        return answer
    }

    fun timeToMinute(time: String): Int {
        val stringHour = time.split(":")[0]
        val hour =
            when {
                stringHour.startsWith("0") -> stringHour.substring(1).toInt()
                else -> stringHour.toInt()
            }

        val minute = time.split(":")[1].toInt()
        return hour * 60 + minute
    }

    fun calculateTotalFee(basicTime: Int, basicFee: Int, unitTime: Int, unitFee: Int, totalTime: Int): Int {
        var totalFee: Int
        val extraTime = (totalTime - basicTime) / (unitTime.toDouble())
        if (totalTime < basicTime) return basicFee
        else {
            totalFee = basicFee + ceil(extraTime).toInt() * unitFee
            return totalFee
        }
    }
}


/*
fees에 들어오는값 : basicTime , basicFee , unitTime , unitFee
records에 들어오는값 : StringArray -> "05:34 차량번호 IN"
입차후 출차 기록이 없다면 -> 23:59에 출차
누적 주차 시간 < basicTime -> basicFee
누적 주차 시간 > basicTiem - > basicFee + extraTime/extrafee * 단위요금 -> 안나눠지면 올림함수 사용
각차량이 가지고 있어야하는 state : True , False / totalParkedTime  -> Map?
단위 시간을 구하는 방법? -> split(" ") -> 시간 , 번호 , 출차
시간 차 구하는 함수 -> String 받고 그냥 Int로 변환
 */
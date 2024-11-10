package com.example.andsoptkoala

class Solution {
    data class Car(
        val carNum: String = "",
        var inCar: String = "",
        var outCar: String = "",
        var totalTime: Int = 0
    )

    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val carMap = mutableMapOf<String, Car>()
        val (baseTime, baseFee, perTime, perFee) = fees.toList()


        fun calculateTime(start: String, end: String): Int {
            val (h1, m1) = start.split(":").map { it.toInt() }
            val startTime = h1 * 60 + m1

            val (h2, m2) = end.split(":").map { it.toInt() }
            val endTime = h2 * 60 + m2

            return endTime - startTime
        }

        for (record in records) {
            val (time, num, inOut) = record.split(" ")
            if (inOut == "IN") {
                if (carMap.containsKey(num)) {
                    carMap[num]?.inCar = time
                } else {
                    carMap[num] = Car(carNum = num, inCar = time)
                }
            } else {
                val car = carMap[num] ?: continue
                car.outCar = time
                car.totalTime += calculateTime(car.inCar, car.outCar)
                car.inCar = ""
                car.outCar = ""
            }
        }

        // 출차 기록이 없는 차량에 대한 누적 시간 추가
        for (car in carMap.values) {
            if (car.inCar.isNotEmpty()) {
                car.totalTime += calculateTime(car.inCar, "23:59")
            }
        }

        fun calculateTotalFee(totalTime: Int):Int{
            var totalFee = baseFee
            if (0<(totalTime-baseTime)){
                totalFee +=  ((totalTime - baseTime + perTime - 1) / perTime) * perFee
            }
            return totalFee
        }

        val answer = carMap.values.sortedBy { it.carNum }.map { calculateTotalFee(it.totalTime) }.toIntArray()
        println(carMap)
        println(answer.joinToString(", "))
        return answer
    }

}
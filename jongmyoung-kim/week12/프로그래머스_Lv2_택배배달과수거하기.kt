package week12

fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
    var answer: Long = 0
    var delivered = 0
    var pickedup = 0
    for (i in n downTo 1) {
        val toDeliver = deliveries[i - 1]
        val toPickup = pickups[i - 1]
        if (toDeliver != 0 || toPickup != 0) {
            var cnt = 0
            while (toDeliver > delivered || toPickup > pickedup) {
                cnt++
                delivered += cap
                pickedup += cap
            }
            delivered -= toDeliver
            pickedup -= toPickup
            answer += (i * 2 * cnt)
        }
    }
    return answer
}
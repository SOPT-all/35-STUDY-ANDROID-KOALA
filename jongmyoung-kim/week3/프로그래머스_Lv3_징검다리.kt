package week3

fun solution(stones: IntArray, k: Int): Int {
    var high = stones.maxOf { it }
    var low = stones.minOf { it }

    while (low <= high) {
        val mid = (high + low) / 2
        if (isCrossable(stones, mid, k)) {
            low = mid + 1
        } else high = mid - 1
    }
    return low
}

fun isCrossable(stones: IntArray, mid: Int, k: Int): Boolean {
    var count = 0 // 디딤돌 횟수

    for (stone in stones) {
        if (stone - mid <= 0) count++
        else count = 0
        if (count == k) return false // 연속된 k개의 돌이 0 이하일 때
    }
    return true
}

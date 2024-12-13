class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var sum1 = queue1.sumOf { it.toLong() }
        val total = sum1 + queue2.sumOf { it.toLong() }
        if (total % 2 != 0L) return -1
        val target = total / 2
        
        val q = queue1 + queue2
        var left = 0
        var right = queue1.size
        var count = 0
        val len = q.size
        
        while (count < len * 2 && left < len) {
            when {
                sum1 == target -> return count
                sum1 > target -> sum1 -= q[left++].toLong()
                else -> {
                    if (right >= len) return -1
                    sum1 += q[right++].toLong()
                }
            }
            count++
        }
        return -1
    }
}
import java.util.*

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer: Int = 0
        
        val queue = queue1 + queue2
        val target = queue.sumOf { it.toLong() } / 2
        var start = 0
        var end = queue1.size - 1
        var sum = queue1.sumOf { it.toLong() }
        
        if (queue.sum() % 2 != 0) return -1
        
        while (answer < queue.size * 2) {
            if (sum > target) {
                sum -= queue[start]
                start = (start + 1) % queue.size
            } else if (sum < target) {
                end = (end + 1) % queue.size
                sum += queue[end]
            } else break
            
            answer++
        }
        
        return if(sum == target) answer else -1
    }
}

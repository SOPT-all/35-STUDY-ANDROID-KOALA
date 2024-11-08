class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var min = stones.minOf { it }
        var max = stones.maxOf { it }
        
        while (min <= max) {
            val mid = (min + max) / 2
        
            if (stones.canCross(k = k, num = mid)) min = mid + 1
            else max = mid - 1

        }
        
        return min
    }
    
    fun IntArray.canCross(k: Int, num: Int): Boolean {
        var canNotCrossStone = 0
        
        for (stone in this) {
            if (stone <= num) canNotCrossStone++
            else canNotCrossStone = 0
            
            if (canNotCrossStone == k) return false
        }
        
        return true
    }
}

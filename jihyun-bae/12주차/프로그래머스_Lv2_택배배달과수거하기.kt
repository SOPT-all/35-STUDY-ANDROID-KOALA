class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = 0
        
        var delivery = 0
        var pickup = 0
        
        for (i in deliveries.size - 1 downTo 0) {
            delivery += deliveries[i]
            pickup += pickups[i]
            
            while (pickup > 0 || delivery > 0) {
                pickup -= cap
                delivery -= cap
                
                answer += (i + 1) * 2
            }
        }
        
        return answer
    }
}

class Solution {
    fun isPrime(n: Long): Boolean {
        if (n <= 1) return false
        
        return (2..Math.sqrt(n.toDouble()).toInt()).none { n % it == 0L }
    }
    
    fun solution(n: Int, k: Int): Int {
        val nums = n.toString(k)
                    .split("0")
                    .filter { it.isNotEmpty() }
                    .map { it.toLong() }
        
        return nums.count { isPrime(it) }
    }
}

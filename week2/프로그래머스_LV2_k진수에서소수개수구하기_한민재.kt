import kotlin.math.sqrt
class Solution {
    fun solution(n: Int, k: Int): Int {
        val converted = n.toString(k)
        val splitNumbers = converted.split("0")
        var count = 0

        for (numStr in splitNumbers) {
            if (numStr.isNotEmpty()) {
                val num = numStr.toLong()
                if (isPrime(num)) {
                    count++
                }
            }
        }

        return count
    }

    private fun isPrime(num: Long): Boolean {
        if (num < 2) return false
        for (i in 2..sqrt(num.toDouble()).toLong()) {
            if (num % i == 0L) return false
        }
        return true
    }
}



class Solution {
    fun solution(n: Int, k: Int): Int {
        val convertedAndSplit = n.toString(k)
            .split("0")
            .filter { it.isNotEmpty() }

        fun isPrime(num: Long): Boolean {
            if (num < 2) return false
            for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
                if (num % i == 0L) return false
            }
            return true
        }

        return convertedAndSplit.count { isPrime(it.toLong()) }
    }
}
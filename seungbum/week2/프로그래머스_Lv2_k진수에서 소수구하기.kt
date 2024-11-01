package koala.programmers

class Kakao_92335 {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = -1
        val primeNum = n.toString(k)
            .split("0")
            .filter { it.isNotEmpty() }
            .map(String::toLong)
        val prime = primeNum.filter { prime -> isPrime(prime) }
        answer = prime.size
        return answer
    }

    fun isPrime(num: Long): Boolean {
        if (num < 2) return false
        var i = 2L
        while (i * i <= num) {
            if (num % i == 0L) return false
            i++
        }
        return true
    }
}


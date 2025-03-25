package koala.programmers

class week14First {
    fun solution(n: Int): Int {
        var answer: Int = 0
        return n - findDemicalNum(size = n) - 1
    }

    fun findDemicalNum(size: Int): Int {
        val isNotPrime = BooleanArray(size + 1)
        isNotPrime[0] = true
        isNotPrime[1] = true

        for (i in 2..size) {
            if (!isNotPrime[i]) {
                for (j in i * 2..size step i) {
                    isNotPrime[j] = true
                }
            }
        }
        return isNotPrime.count { !it }
    }
}
//소수까지 지워버려서 문제야 생각해 바보야!

fun main() {
    val new = week14First()
    println(new.solution(10))
}
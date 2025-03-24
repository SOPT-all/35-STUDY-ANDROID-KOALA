package week14

fun solution(brown: Int, yellow: Int): IntArray {
    var answer = intArrayOf()
    val size = brown + yellow
    for (i in 1..size) {
        if (size % i == 0 && (i - 2) * (size / i - 2) == yellow) answer += i
    }
    if (answer.size == 1) answer += answer[0]
    return answer.reversed().toIntArray()
}
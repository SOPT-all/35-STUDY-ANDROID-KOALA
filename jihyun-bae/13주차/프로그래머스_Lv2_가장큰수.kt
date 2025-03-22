class Solution {
    fun solution(numbers: IntArray): String = numbers.map { it.toString().repeat(3) }
        .sortedDescending()
        .map { it.substring(0, it.length / 3) }
        .joinToString("")
        .let { if (it.all { number -> number == '0' }) "0" else it }
}

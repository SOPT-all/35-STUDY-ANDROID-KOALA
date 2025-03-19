package week13

fun solution(numbers: IntArray): String {
    val result = numbers
        .map { it.toString() }
        .sortedWith { num1, num2 -> (num2 + num1).compareTo(num1 + num2) }
        .joinToString("")
    return if (result[0] == '0') "0" else result
}
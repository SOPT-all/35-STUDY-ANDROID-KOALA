package week8

import kotlin.math.abs

fun solution(expression: String): Long {
    var answer = longArrayOf()
    val permutation = arrayOf("+-*", "+*-", "-*+", "-+*", "*+-", "*-+")

    for (i in permutation.indices) {
        val operator = expression.filter { !it.isDigit() }.toMutableList()
        val operand = expression.split("*", "-", "+").map(String::toLong).toMutableList()
        for (j in permutation[i].indices) {
            var index = 0
            while (index < operator.size) {
                if (operator[index] == permutation[i][j]) {
                    operand[index] = operate(operand[index], operand[index + 1], operator[index])
                    operator.removeAt(index)
                    operand.removeAt(index + 1)
                } else index++
            }
        }
        answer += abs(operand[0])
    }
    return answer.maxOf { it }
}

fun operate(num1: Long, num2: Long, operator: Char): Long {
    return when (operator) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        else -> num1 * num2
    }
}
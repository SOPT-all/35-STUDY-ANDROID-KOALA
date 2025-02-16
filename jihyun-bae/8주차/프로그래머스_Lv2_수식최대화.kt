import kotlin.math.abs

class Solution {
    fun solution(expression: String): Long {
        val answer = Array(6) { 0L }
        val priorities = arrayOf("+-*", "+*-", "-+*", "-*+", "*-+", "*+-")
        
        priorities.forEachIndexed { index, priority ->
            val operator = expression.filter { !it.isDigit() }.toMutableList()
            val operand = expression.split("+", "-", "*").map { it.toLong() }.toMutableList()
            
            for (p in priority) {
                var i = 0
                while (i < operator.size) {
                    if (p == operator[i]) {
                        operand[i] = p.calculate(a = operand[i], b = operand[i + 1])
                        operator.removeAt(i)
                        operand.removeAt(i + 1)
                    } else i++
                }
            }
            
            answer[index] = abs(operand[0])
        }
        
        return answer.maxOf { it }
    }
    
    fun Char.calculate(a: Long, b: Long) = when (this) {
        '-' -> a - b
        '+' -> a + b
        else -> a * b
    }
}

import kotlin.math.abs

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var left = 10
        var right = 12

        return numbers.map { number ->
            when (number) {
                1, 4, 7 -> {
                    left = number
                    "L"
                }

                3, 6, 9 -> {
                    right = number
                    "R"
                }

                else -> {
                    val rightDistance = measureDistance(x = if (number == 0) 10 else number - 1, y = right - 1)
                    val leftDistance = measureDistance(x = if (number == 0) 10 else number - 1, y = left - 1)

                    when {
                        rightDistance > leftDistance || rightDistance == leftDistance && hand == "left" -> {
                            left = if (number == 0) 11 else number
                            "L"
                        }

                        else -> {
                            right = if (number == 0) 11 else number
                            "R"
                        }
                    }
                }
            }
        }.joinToString("")
    }


    private fun measureDistance(x: Int, y: Int) = abs(x / 3 - y / 3) + abs(x % 3 - y % 3)
}

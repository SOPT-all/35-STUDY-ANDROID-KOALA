package week4

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        val answer = mutableListOf<String>()
        val isRightHand = hand == "right"
        var L = 10
        var R = 12

        fun distance(from: Int, to: Int): Int {
            val fromX = (from - 1) % 3
            val fromY = (from - 1) / 3
            val toX = (to - 1) % 3
            val toY = (to - 1) / 3
            return Math.abs(fromX - toX) + Math.abs(fromY - toY)
        }

        for (number in numbers) {
            val target = if (number == 0) 11 else number
            when (target % 3) {
                1 -> {
                    L = target
                    answer.add("L")
                }

                0 -> {
                    R = target
                    answer.add("R")
                }

                2 -> {
                    val leftDistance = distance(L, target)
                    val rightDistance = distance(R, target)

                    if (leftDistance < rightDistance) {
                        L = target
                        answer.add("L")
                    } else if (rightDistance < leftDistance) {
                        R = target
                        answer.add("R")
                    } else {
                        if (isRightHand) {
                            R = target
                            answer.add("R")
                        } else {
                            L = target
                            answer.add("L")
                        }
                    }
                }
            }
        }
        return answer.joinToString("")
    }
}

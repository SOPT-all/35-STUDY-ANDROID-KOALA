import kotlin.math.abs

fun solution(numbers: IntArray, hand: String): String {
    var answer = ""
    var left = 10
    var right = 12
    numbers.forEach { number ->
        when (number) {
            1, 4, 7 -> {
                answer += 'L'
                left = number
            }

            3, 6, 9 -> {
                answer += 'R'
                right = number
            }

            else -> {
                val number = if (number == 0) 11 else number
                val lDist = abs((left - number) / 3) + abs((left - number) % 3)
                val rDist = abs((right - number) / 3) + abs((right - number) % 3)
                if (lDist == rDist) {
                    if (hand.startsWith('l')) {
                        answer += 'L'
                        left = number
                    } else {
                        answer += 'R'
                        right = number
                    }
                } else {
                    if (lDist < rDist) {
                        answer += 'L'
                        left = number
                    } else {
                        answer += 'R'
                        right = number
                    }
                }
            }
        }
    }
    return answer
}
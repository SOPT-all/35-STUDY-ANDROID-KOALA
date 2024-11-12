package koala.programmers

import kotlin.math.abs

class kakao_67256 {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        val left = listOf(1, 4, 7)
        val right = listOf(3, 6, 9)
        val handLocation = IntArray(2)
        handLocation[0] = 9
        handLocation[1] = 11
        numbers.forEach { number ->
            val actualNumber = if (number == 0) 10 else number - 1

            when {
                left.contains(number) -> {
                    answer += "L"
                    handLocation[0] = actualNumber
                }

                right.contains(number) -> {
                    answer += "R"
                    handLocation[1] = actualNumber
                }

                else -> {
                    val leftSide = Pair(handLocation[0] / 3, handLocation[0] % 3)
                    val rightSide = Pair(handLocation[1] / 3, handLocation[1] % 3)
                    val numberLocation = Pair(actualNumber / 3, actualNumber % 3)

                    val leftDistance =
                        abs(leftSide.first - numberLocation.first) + abs(leftSide.second - numberLocation.second)
                    val rightDistance =
                        abs(rightSide.first - numberLocation.first) + abs(rightSide.second - numberLocation.second)

                    if (rightDistance < leftDistance) {
                        answer += "R"
                        handLocation[1] = actualNumber
                    } else if (rightDistance > leftDistance) {
                        answer += "L"
                        handLocation[0] = actualNumber
                    } else {
                        if (hand == "left") {
                            answer += "L"
                            handLocation[0] = actualNumber
                        } else {
                            answer += "R"
                            handLocation[1] = actualNumber
                        }
                    }
                }
            }
        }
        return answer
    }
}

/*
1. left = 왼속(*) , right = 오른손(#)
    왼손 -> 1,4,7 오른손 -> 3,6,9
    가운데(2,5,8,0)은 둘중 가까운 손가락 사용
    위치가 동일하다면 주손 사용(hand)
    왼손 위치 , 오른손 위치 담는 배열 -> handLocation
    중요한건 각 손과 누르는 번호와의 거리
    1.번호가 정해진 곳일때 -> 해당손
    2.번호가 가운데일때
    ->길이가 다를때 -> 위치가 가까운곳
    ->길이가 같을때 -> 주손

 */
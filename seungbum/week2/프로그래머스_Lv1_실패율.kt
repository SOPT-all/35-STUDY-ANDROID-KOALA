package koala.programmers

class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        val answer = IntArray(N)

        val indexMap: MutableMap<Int, Int> = mutableMapOf()
        val failureMap: MutableMap<Int, Double> = mutableMapOf()

        stages.forEach {
            when (indexMap.containsKey(it)) {
                true -> indexMap[it] = indexMap.getValue(it) + 1
                false -> indexMap[it] = 1
            }
        }

        var totalCount = stages.size

        for (i in 1..N) {
            when (indexMap.containsKey(i)) {
                true -> {
                    failureMap[i] = (indexMap.getValue(i) / totalCount.toDouble())
                    totalCount -= indexMap.getValue(i)
                }

                false -> failureMap[i] = 0.0
            }
        }
        val list = failureMap.toList().sortedByDescending { (_, value) ->
            value
        }

        for (i in 0 until N) {
            answer[i] = list[i].first
        }
        return answer
    }
}

/*
1. 전체 스테이지의 개수 N 받기
2. 게임을 이용하는 사용자가 멈춰있는 스테이지번호 가 담기배열 = stages
3. 각 숫자는 그스테이지에 도달했으나 아직 클리어하지 못한 플레이어
    -> 스테이지별로 클리어 못한 인원 배열에 넣기
4. 실패율 = A번 스테이지에 있는 사람수 / A번 스테이지 + 이후에 있는 사람들의 스테이지 수
    -> 함수로 각 스테이지별 실패율 정리, 스테이지에 도달한 수가 없다면 실패율 = 0
5. 실패율이 같으면 낮은 번호부터
    -> 실패율 정렬
 */
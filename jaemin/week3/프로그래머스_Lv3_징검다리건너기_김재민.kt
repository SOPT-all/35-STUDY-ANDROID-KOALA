package programmers

import java.util.*

fun solution1(stones: IntArray, k: Int): Int {
    var answer = Int.MAX_VALUE
    var index = 0
    while(index <=  stones.size-k){
        var max = 0
        var maxIndexInSub = 0
        for(j in index until index+k){
            if(stones[j] >= max){
                maxIndexInSub = j
                max = stones[j]
            }
        }
        index = maxIndexInSub+1
        if(max < stones[index]) index += k
        answer = if(max < answer) max else answer
    }
    return answer
}

fun solution(stones: IntArray, k: Int): Int {
    var answer = Int.MAX_VALUE
    var index = 0
    val deque: Deque<Int> = LinkedList()
    for (i in stones.indices) {
        var max = 0
        // 윈도우 범위를 벗어나는 인덱스를 제거
        if (deque.isNotEmpty() && deque.first< i - k + 1) {
            deque.removeFirst()
        }

        // 현재 값보다 작은 값의 인덱스를 덱에서 제거
        while (deque.isNotEmpty() && stones[deque.last] <= stones[i]) {
            deque.removeLast()
        }

        // 현재 인덱스를 덱에 추가
        deque.addLast(i)

        // 첫 번째 인덱스가 현재 윈도우의 최대값
        if (i >= k - 1) {
            max = stones[deque.first]
            answer = if(max < answer) max else answer
        }
    }
    print(answer)


    return answer
}

fun main(args: Array<String>){
    solution(
        stones = intArrayOf(2, 4, 5, 3, 2, 1, 4, 2, 5, 1),
        k = 3
    )
}
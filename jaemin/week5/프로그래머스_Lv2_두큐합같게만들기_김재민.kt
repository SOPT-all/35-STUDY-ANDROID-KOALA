package programmers

fun solution(queue1: IntArray, queue2: IntArray): Int {
    var answer: Int = 0
    val length = queue1.size
    var sum: Long = 0
    var sumOfQueue1: Long = 0
    var targetNumber: Long = 0

    for(i in 0 until length){
        sum += queue1[i].toLong() + queue2[i].toLong()
        sumOfQueue1 += queue1[i].toLong()
    }
    if(sum % 2 == 1L) answer = -1 else targetNumber = sum/2

    var start: Long = 0L
    var end: Long = length - 1L
    while(true){
        if(end < start || start >= 2*length || end >= 3*length) {
            answer = -1
            break
        }
        if(sumOfQueue1 < targetNumber){
            end++
            if(end in length until 2*length) sumOfQueue1 += queue2[(end%length).toInt()]
            else if(end in 2*length until 3*length) sumOfQueue1 += queue1[(end%length).toInt()]
            answer++
        }
        else if(sumOfQueue1 > targetNumber){
            if(start in 0 until length) sumOfQueue1 -= queue1[start.toInt()]
            else if(start in length until 2*length) sumOfQueue1 -= queue2[(start%length).toInt()]
            start++
            answer++
        }
        else break
    }
    return answer
}

fun main(args:Array<String>){
    solution(
        queue1 = intArrayOf(1, 1),
        queue2 = intArrayOf(1, 5)
    )
}

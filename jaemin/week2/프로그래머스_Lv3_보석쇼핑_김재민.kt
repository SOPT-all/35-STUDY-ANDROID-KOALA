package week2

fun solution(gems: Array<String>): IntArray {
    val countMap = mutableMapOf<String, Int>()

    gems.forEach {
        if(!countMap.containsKey(it))countMap[it] = 0
    }

    val numberOfAllKind = countMap.keys.size
    var numberOfCurrentKind = 0
    var start = 0
    var end = 0
    var minDistance = Int.MAX_VALUE
    var answerStart = 0
    var answerEnd = 0

    while(start <= end){
        if(numberOfCurrentKind < numberOfAllKind && end==gems.size) break
        if(numberOfCurrentKind < numberOfAllKind){
            if (countMap.get(gems[end]) == 0){
                numberOfCurrentKind++
                if(numberOfCurrentKind==numberOfAllKind){
                    if(minDistance > end-start){
                        minDistance = end-start
                        answerEnd = end+1
                        answerStart = start+1
                    }
                }
            }
            countMap.put(gems[end], countMap.get(gems[end])!! + 1)
            end++
        }else{
            if(countMap.get(gems[start]) == 1) {
                numberOfCurrentKind--
                 if(minDistance > end-start-1){
                     minDistance = end-start-1
                     answerEnd = end
                     answerStart = start+1
                 }
            }
            countMap.put(gems[start],countMap.get(gems[start])!! -1)
            start++
        }
    }

    var answer = intArrayOf(answerStart, answerEnd)
    print(gems.contentToString())
    print(numberOfAllKind)
    print(countMap)
    print(answer.contentToString())
    return answer
}

fun main(args: Array<String>){
    solution(arrayOf("A" ,"B", "B", "B", "C", "D", "D", "D", "D", "D" ,"D", "D", "B", "C" ,"A"))
}
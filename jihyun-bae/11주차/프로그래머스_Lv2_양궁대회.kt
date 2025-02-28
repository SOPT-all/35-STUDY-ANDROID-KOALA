class Solution {
    fun solution(n: Int, info: IntArray): IntArray {
        var answer: IntArray = intArrayOf(-1)
        var diff: Int = 0
        
        fun IntArray.dfs(index: Int, number: Int, ryan: IntArray) {
            if (number == n) {
                val point = point(info, ryan)
                
                if (point[0] < point[1]) {
                    if (diff < point[1] - point[0]) {
                        answer = ryan.clone()
                        diff = point[1] - point[0]
                    } else if (diff == point[1] - point[0]) {
                        for (i in answer.indices.reversed()) {
                            if (answer[i] < ryan[i]) {
                                answer = ryan.clone()
                                break
                            } else if (answer[i] > ryan[i]) break
                        }
                    }
                }
            }
            else if (index == info.size) return
            else {
                for (i in 0..this[index] + 1) {
                    ryan[index] = i
                    dfs(index + 1, number + i, ryan)
                    ryan[index] = 0
                }
            }
        }
        
        info.dfs(0, 0, IntArray(11) { 0 })
        
        return answer
    }
    
    fun point(apeach: IntArray, ryan: IntArray) : IntArray {
        val point = IntArray(2) { 0 }
        
        for (i in apeach.indices) {
            if (apeach[i] == 0 && ryan[i] == 0) continue
            if (apeach[i] < ryan[i]) point[1] += 10 - i else point[0] += 10 - i
        }
        
        return point
    }
}

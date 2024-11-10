class Solution {
    fun solution(gems: Array<String>): IntArray {
        val gemType = gems.toSet().size
        var gemCount = HashMap<String, Int>()
        var answer = IntArray(2)
        var start = 0
        var end = 0
        var distinct = 100000
        
        while (true) {
            if (gemCount.size == gemType) {
                if (end - start < distinct) {
                    distinct = end - start
                    answer = intArrayOf(start + 1, end)
                }
                
                if (gemCount[gems[start]] == start + 1) gemCount.remove(gems[start])
                start += 1
            }
            
            else if (end == gems.size) break
            else gemCount[gems[end]] = ++end
        }
        
        return answer
    }
}

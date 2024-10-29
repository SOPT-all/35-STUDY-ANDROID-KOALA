package week2

class 프로그래머스_Lv3_보석쇼핑 {
    fun solution(gems: Array<String>): IntArray {
        var answer = IntArray(2)
        val totalGems = gems.toSet().size
        val gemMap = mutableMapOf<String, Int>()
        var start = 0
        var end = 0
        var dist = 100000

        while (true) {
            if (gemMap.size == totalGems) {
                if (end - start < dist) {
                    dist = end - start
                    answer = intArrayOf(start + 1, end)
                }
                if (gemMap[gems[start]] == start + 1) {
                    gemMap.remove(gems[start])
                }
                start++
            }
            else if (end == gems.size) break
            else gemMap[gems[end]] = ++end
        }
        return answer
    }
}
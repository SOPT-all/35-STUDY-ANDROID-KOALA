class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        sizes.forEach { size ->
            size.sort()
        }
        
        return sizes.maxOf { it[0] } * sizes.maxOf { it[1] }
    }
}

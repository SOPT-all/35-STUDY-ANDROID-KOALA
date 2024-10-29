class Solution {
    fun solution(s: String): IntArray = s.substring(2 .. s.length - 3).split("},{")
        .map{ it.split(",").map { num -> num.toInt() } }
        .toList()
        .sortedBy { it.size }
        .fold(setOf<Int>()) {total, list -> total.union(list)}
        .toIntArray()
}

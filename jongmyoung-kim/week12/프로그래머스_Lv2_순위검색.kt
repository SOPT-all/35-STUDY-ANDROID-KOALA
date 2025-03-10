package week12

private val map = mutableMapOf<String, MutableList<Int>>()

fun solution(info: Array<String>, query: Array<String>): IntArray {
    val answer = IntArray(query.size)

    info.forEach {
        val (lang, position, rank, food, score) = it.split(" ")
        val infoArr= Array(4) { Array(2) {"-"} }.apply {
            this[0][0] = lang
            this[1][0] = position
            this[2][0] = rank
            this[3][0] = food
        }
        getCombination(0, infoArr, score.toInt(), "")
    }
    map.forEach { it.value.sort() }

    query.forEachIndexed { idx, q ->
        val (key, score) = q.replace("and ", "").split(" ").let { it.take(4).joinToString("") to it[4].toInt() }
        val values = map.getOrDefault(key, mutableListOf())
        if (map.containsKey(key)) answer[idx] = values.lowerBound(score)
    }
    return answer
}

fun getCombination(depth: Int, infoArr: Array<Array<String>>, score: Int, combination: String) {
    if (depth == 4) {
        val current = map.getOrDefault(combination, mutableListOf())
        current.add(score)
        map[combination] = current
        return
    }
    getCombination(depth + 1, infoArr, score, combination + infoArr[depth][0])
    getCombination(depth + 1, infoArr, score, combination + infoArr[depth][1])
}

fun List<Int>.lowerBound(target: Int): Int {
    var low = 0
    var high = this.size - 1
    while (low <= high) {
        val mid = (low + high) / 2
        if (this[mid] < target) low = mid + 1
        else high = mid - 1
    }
    return this.size - low
}

// 1차 시도
/*
var answer = IntArray(query.size)
val employee = info.map { it.split(" ") }.sortedBy { it[4] }
query.forEachIndexed { idx, q ->
    val (lang, position, rank, food, score) = q.replace("-", ".*").replace("and ", "").split(" ")
    val index = employee.binarySearch { it[4].toInt() - score.toInt() }
    employee.forEachIndexed loop1@ { idx2, emp ->
        if (idx2 < index) return@loop1
        if (!emp[0].matches(lang.toRegex()) || !emp[1].matches(position.toRegex()) || !emp[2].matches(rank.toRegex())
            || !emp[3].matches(food.toRegex()) || emp[4].toInt() < score.toInt()
        ) return@loop1
        else answer[idx]++
    }
}
return answer
 */

// 2차 시도 -> 내장함수 binarySearch로 구현하려니 중복 요소 때문에 실패
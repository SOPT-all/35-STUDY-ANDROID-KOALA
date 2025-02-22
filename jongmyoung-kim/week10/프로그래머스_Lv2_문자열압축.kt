package week10

fun solution(s: String): Int {
    val result = mutableListOf<String>()
    var min = s.length

    for (length in 1..s.length) {
        var count = 1
        val group = s.windowed(length, length).toMutableList()
        if (s.length % length != 0) group.add((s.takeLast(s.length % length)))
        for (i in 0 until group.size) {
            val current = group[i]
            val next = if (i + 1 < group.size) group[i + 1] else ""
            if (current == next) count++
            else {
                result.add(if (count > 1) "$count$current" else current)
                count = 1
            }
        }
        min = min.coerceAtMost(result.joinToString("").length)
        result.clear()
    }
    return min
}
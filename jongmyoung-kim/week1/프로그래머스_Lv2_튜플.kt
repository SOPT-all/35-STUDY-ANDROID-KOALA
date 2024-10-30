package week1

fun tuple(s: String): IntArray {
    var answer = mutableSetOf<Int>()
    val stringList = s.substring(2, s.length - 2)
        .split("},{")
        .sortedBy{ it.length }
    stringList.forEach {
        val stringToken = it.split(",").map { it.toInt() }
        stringToken.forEach {
            answer.add(it)
        }
    }
    return answer.toIntArray()
}
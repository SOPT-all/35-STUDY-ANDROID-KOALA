package week6

val courseMap = mutableMapOf<String, Int>()
var courseCombination = ""

fun solution(orders: Array<String>, course: IntArray): Array<String> {
    var answer: Array<String> = arrayOf<String>()
    val order = orders.map { it.toCharArray().sorted().joinToString("") }

    course.forEach { courseNum ->
        courseMap.clear()
        order.forEach { orderArr ->
            findCombination(0, courseNum, orderArr)
        }
        val max = courseMap.maxOfOrNull { it.value } ?: 0
        if (max > 1) {
            courseMap.filter { it.value == max }.map {
                answer += it.key
            }
        }
    }
    return answer.sorted().toTypedArray()
}

fun findCombination(index: Int, course: Int, order: String) {
    if (courseCombination.length == course) {
        courseMap[courseCombination] = courseMap.getOrDefault(courseCombination, 0) + 1
        return
    }
    for (i in index until order.length) {
        courseCombination += order[i]
        findCombination(i + 1, course, order)
        courseCombination = courseCombination.dropLast(1)
    }
}

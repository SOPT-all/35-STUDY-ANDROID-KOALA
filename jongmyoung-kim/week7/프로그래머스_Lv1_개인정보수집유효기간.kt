package week7

fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
    var answer: IntArray = intArrayOf()
    val termMap = HashMap<String, Int>()

    terms.forEach { term ->
        val (type, period) = term.split(" ")
        termMap.put(type, period.toInt())
    }

    privacies.forEachIndexed { index, privacy ->
        val (date, term) = privacy.split(" ")
        val (_, month, _) = date.split(".").map { it.toInt() }
        val period = termMap.getOrDefault(term, 0)
        val expirePeriod = if (month + period > 12) period / 12 * 10000 + period % 12 * 100 else period * 100
        var expireDate = (date.replace(".", "").toInt() + expirePeriod)
        if (expireDate.toString().substring(4, 6).toInt() > 12) expireDate += 8800
        if (today.replace(".", "").toInt() >= expireDate) answer += index + 1
    }
    return answer
}
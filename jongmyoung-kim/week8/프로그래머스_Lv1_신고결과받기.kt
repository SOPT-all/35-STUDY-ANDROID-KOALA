package week8

fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
    val answer = IntArray(id_list.size)
    val reportSet = report.toSet()
    val reportedCount = HashMap<String, Int>()
    val reportUser = HashMap<String, Set<String>>()

    reportSet.forEach {
        val (reporter, reported) = it.split(" ")
        reportedCount[reported] = reportedCount.getOrDefault(reported, 0) + 1
        reportUser[reporter] = reportUser.getOrDefault(reporter, emptySet()) + reported
    }

    id_list.forEachIndexed { index, id ->
        reportUser[id]?.forEach {
            if (reportedCount.getOrDefault(it, 0) >= k) {
                answer[index]++
            }
        }
    }
    return answer
}

/*
report.map { it.split(" ") }
            .groupBy { it[1] } // 신고 "당한" 유저 기준으로 group
            .asSequence() // 지연 계산으로 오버헤드 방지
            .map { it.value.distinct() } // 신고자들의 중복 방지
            .filter { it.size >= k } // 그 중에서 k개 이상
            .flatten()
            .map { it[0] }
            .groupingBy { it }
            .eachCount() // 신고자 count
            .run { id_list.map { getOrDefault(it, 0) }.toIntArray() }

가독성도 좋고 시간 복잡도도 더 짧음..
*/
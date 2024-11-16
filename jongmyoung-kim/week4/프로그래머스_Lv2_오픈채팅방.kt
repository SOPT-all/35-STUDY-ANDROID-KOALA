package week4

fun solution(record: Array<String>): Array<String> {
    var answer = arrayOf<Pair<String, String>>()
    val uidMap = HashMap<String, String>()

    record.forEach {
        val rec = it.split(" ")
        when (rec[0]) {
            "Enter" -> {
                answer += Pair("님이 들어왔습니다.", rec[1])
                uidMap[rec[1]] = rec[2]
            }

            "Leave" -> answer += Pair("님이 나갔습니다.", rec[1])
            else -> uidMap[rec[1]] = rec[2]
        }
    }
    return answer.map { uidMap[it.second] + it.first }.toTypedArray()
}
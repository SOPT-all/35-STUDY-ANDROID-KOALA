package week4

class Solution {
    fun solution(record: Array<String>): Array<String> {
        val answer = mutableListOf<String>()
        val userMap = mutableMapOf<String, String>()

        for (log in record) {
            val parts = log.split(" ")
            val act = parts[0]
            val id = parts[1]
            val name = if (parts.size > 2) parts[2] else null
            if (act == "Enter" || act == "Change") {
                userMap[id] = name ?: ""
            }
        }

        for (log in record){
            val parts = log.split(" ")
            val act = when(parts[0]){
                "Enter"->"들어왔습니다."
                "Leave"->"나갔습니다."
                else->"no"
            }
            val id = parts[1]
            val name= userMap[id]
            if (act!="no"){
                val str = name + "님이 " +act
                answer.add(str)
            }
        }
        return answer.toTypedArray()
    }
}

class Solution {
    fun solution(record: Array<String>): Array<String> {
        val userMap = mutableMapOf<String, String>()

        record.forEach {
            val data = it.split(" ")
            if (data[0] != "Leave" && data.size > 2) {
                userMap[data[1]] = data[2]
            }
        }

        return record.mapNotNull {
            val data = it.split(" ")
            when(data[0]) {
                "Enter" -> "${userMap[data[1]]}님이 들어왔습니다."
                "Leave" -> "${userMap[data[1]]}님이 나갔습니다."
                else -> null
            }
        }.toTypedArray()
    }
}

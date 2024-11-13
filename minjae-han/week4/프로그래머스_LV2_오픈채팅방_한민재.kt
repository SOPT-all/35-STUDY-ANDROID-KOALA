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
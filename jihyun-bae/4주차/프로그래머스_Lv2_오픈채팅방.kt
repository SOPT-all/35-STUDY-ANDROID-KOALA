class Solution {
    fun solution(record: Array<String>): Array<String> {
        val datas = record.fold(Pair(mutableMapOf<String, String>(), mutableListOf<Pair<String, String>>())) { (nicknameMap, codeList), record -> 
            val (code, id, nickname) = record.split(" ").let { Triple(it[0], it[1], it.getOrElse(2) { "" })}
            
            if (code != "Change") codeList.add(Pair(code, id))
            if (code == "Enter" || code == "Change") nicknameMap[id] = nickname
            
            Pair(nicknameMap, codeList)
        }
        
        return datas.second.map {
            when(it.first) {
                "Enter" -> datas.first[it.second] + "님이 들어왔습니다."
                else -> datas.first[it.second] + "님이 나갔습니다."
            }
        }.toTypedArray()
    }
}

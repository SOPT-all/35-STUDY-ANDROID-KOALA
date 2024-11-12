package com.example.andsoptkoala

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

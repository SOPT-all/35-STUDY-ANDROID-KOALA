package programmers

import java.lang.StringBuilder

fun solution2(record: Array<String>): Array<String> {

    // 1. 각 문장에서 enter, leave는 저장 change일 경우 uid - nickname 맵변경
    // 2. enter 일때도 맵 체크
    // 3. enter, leave일 경우 행위의 id 저장 하고, 행위도 저장(자료구조는 뭘쓸까)

    val idToNicknameMap = mutableMapOf<String,String>()
    val event = mutableListOf<Pair<String, String>>()

    record.forEach{ string ->
        val seperatedString = string.split(" ")
        when(seperatedString[0]){
            "Enter" ->{
                idToNicknameMap[seperatedString[1]] = seperatedString[2]
                event.add(Pair(seperatedString[0],seperatedString[1]))
            }
            "Leave" ->{
                event.add(Pair(seperatedString[0],seperatedString[1]))
            }
            "Change"->{
                idToNicknameMap[seperatedString[1]] = seperatedString[2]
            }
            else -> {}
        }
    }

    val answer = Array(event.size){ index ->
        val sb = StringBuilder()
        sb.append(idToNicknameMap[event[index].second])
        sb.append("님이 ")
        sb.append(if(event[index].first=="Enter") "들어왔습니다." else "나갔습니다.")
        sb.toString()
    }

    print(answer.contentToString())

    return answer
}

fun main(args: Array<String>){
    solution2(arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"))
}
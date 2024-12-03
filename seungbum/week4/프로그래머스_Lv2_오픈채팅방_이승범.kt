package koala.programmers

/*
채팅방에서 닉네임변경 방법
1. 채팅방을 나간후 새로운 닉네임으로 입장.
2. 채팅방에서 닉네임을 변경

닉네임 rule
1. 닉네임 변경방법 1.번에 의해 바꾸면 채팅방에 존재하던 해당 유저의 기존 닉네임도 현재닉네임으로 변경
2. 중복닉네임 허용 -> 각 닉네임은 key를 가져야한다.

맵으로 관리
uid로 순서를 기억하다가
배열이 끝나면 uid에 따라 순차적으로 넣어줌
 */

fun solution(record: Array<String>): Array<String> {
    val inOutList = mutableListOf<Pair<String,String>>()
    val nickNameMap = mutableMapOf<String, String>()

    record.forEach { word ->
        val (state, uid) = word.split(" ")
        when (state) {
            "Leave" ->{
                inOutList.add(Pair(uid,"님이 나갔습니다."))
            }
            "Enter" -> {
                nickNameMap[uid] = word.split(" ")[2]
                println(nickNameMap[uid])
                println(uid)
                inOutList.add(Pair(uid,"님이 들어왔습니다."))
            }
            "Change" -> {
                nickNameMap[uid] = word.split(" ")[2]
            }
        }
    }
   return inOutList.map { (uid,message)->
        "${nickNameMap[uid]}$message"
    }.toTypedArray()
}
fun main(){
    val records = arrayOf(
        "Enter uid1234 Muzi",
        "Enter uid4567 Prodo",
        "Leave uid1234",
        "Enter uid1234 Prodo",
        "Change uid4567 Ryan"
    )
    val answer = solution(records)
    answer.forEach { ans->
        println(ans)
    }
}
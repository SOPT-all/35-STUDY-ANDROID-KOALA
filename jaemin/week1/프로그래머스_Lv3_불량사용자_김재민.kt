package week1

import java.util.*
import kotlin.collections.ArrayList


fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
    var answer = 0
    val numberOfCase = Array(banned_id.size){ArrayList<Int>()}
    val answerSet = mutableSetOf<String>()
    val visited = BooleanArray(user_id.size)
    for(userId in 0 until user_id.size){
        for(bannedId in 0 until banned_id.size){
            if(matchId(user_id[userId], banned_id[bannedId])) numberOfCase[bannedId].add(userId)
        }
    }
    print(Arrays.toString(numberOfCase))
    dfs(0,visited, numberOfCase, answerSet)
    return answerSet.size
}

fun matchId(user_id: String, banned_id: String): Boolean{
    if(user_id.length != banned_id.length) return false
    else{
        val length = banned_id.length
        for(i in 0 until length){
            if(user_id[i] != banned_id[i] && banned_id[i] != '*') return false
        }
    }
    return true
}

fun dfs(start: Int, visited: BooleanArray, numberOfCase: Array<ArrayList<Int>>, answerSet: MutableSet<String>){
    if(start == numberOfCase.size){
        val sb = StringBuffer()
        for(i in 0 until visited.size){
            if(visited[i]) sb.append(i)
        }
        answerSet.add(sb.toString())
        return
    }
    for(next in numberOfCase[start]){
        if(visited[next]) continue
        visited[next] = true
        dfs(start+1, visited, numberOfCase,answerSet)
        visited[next] = false
    }
    return
}


fun main(args: Array<String>){
    val user_id: Array<String> = arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc")
    val banned_id: Array<String> = arrayOf("*rodo", "*rodo", "******")
    print(solution(user_id, banned_id))
}
class Solution {
    var answer = mutableSetOf<List<Int>>()
    
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        val candidate = Array(banned_id.size) { mutableListOf<Int>() }
        
        for (b in banned_id.indices) {
            for (i in user_id.indices) {
                if (checkBanned(user_id[i], banned_id[b])) candidate[b].add(i)
            }
        }
        
        candidate.dfs(0, mutableListOf<Int>())
        
        return answer.size
    }
    
    fun checkBanned(user_id: String, banned_id: String): Boolean {
        if (user_id.length != banned_id.length) return false
        return user_id.zip(banned_id).all { (user, banned) -> banned == '*' || user == banned }
    }
    
    fun Array<MutableList<Int>>.dfs(check: Int, now: MutableList<Int>) {
        if (now.size == this.size) {
            if (now.size == now.toSet().size) answer.add(now.sorted())
            return
        }
        
        if (check == this.size) return
            
        for (i in check until this.size) {
            for (j in this[i].indices) {
                now.add(this[i][j])
                dfs(i + 1, now)
                now.removeAt(now.size - 1)
            }
        }
    }
}

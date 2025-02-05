class Solution {
    fun solution(p: String): String {
        if (p.isEmpty()) return ""
        
        (p.conversion()).let { balanced ->
            if (balanced.first.checkRight()) return balanced.first + solution(balanced.second)
            else {
                var answer = "("
                answer += solution(balanced.second)
                answer += ")"
                
                for (i in 1..balanced.first.length-2) {
                    answer += if (balanced.first[i] == '(') ")" else "("
                }
                
                return answer
            }
        }
    }
    
    fun String.conversion(): Pair<String, String> {
        this.forEachIndexed { index, _ ->
            if (this.slice(0..index).checkBalanced()) return Pair(this.slice(0..index), this.slice(index + 1..this.length - 1))
        }
        return Pair("", "")
    }
    
    fun String.checkBalanced(): Boolean = this.count { char -> char == '('} == this.count { char -> char == ')' }
    
    fun String.checkRight(): Boolean {
        var size = 0
        
        this.forEach { temp ->
            when (temp) {
                '(' -> size++
                else -> size--
            }
            
            if (size < 0) return false
        }
        
        return true
    }
}

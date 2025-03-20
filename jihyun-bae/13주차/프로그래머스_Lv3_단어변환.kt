class Solution {
    var answer = 0
    lateinit var check: Array<Int>
    
    fun solution(begin: String, target: String, words: Array<String>): Int {
        check = Array(words.size) { 0 }
        words.dfs(begin, target, 0)
        return answer
    }
    
    fun Array<String>.dfs(begin: String, target: String, num: Int) {
        if (begin == target) {
            answer = num
            return
        }
        
        this.forEachIndexed { index, word ->
            if (check[index] == 0 && checkChange(begin, word)) {
                check[index] = num + 1
                dfs(word, target, num + 1)
                check[index] = 0
            }
        }
    }
    
    fun checkChange(begin: String, target: String): Boolean = begin.zip(target).count { (begin, target) -> begin != target } == 1
}

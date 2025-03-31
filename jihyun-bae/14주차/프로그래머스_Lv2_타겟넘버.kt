class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        
        fun dfs(index: Int, sum: Int) {
            if (index == numbers.size) {
                if (sum == target) answer++
                return
            }
            
            dfs(index + 1, sum - numbers[index])
            dfs(index + 1, sum + numbers[index])
        }
        
        dfs(0, 0)
        
        return answer
    }
}

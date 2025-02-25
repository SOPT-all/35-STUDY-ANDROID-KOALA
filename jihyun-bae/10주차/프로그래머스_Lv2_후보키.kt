class Solution {
    fun solution(relation: Array<Array<String>>): Int {
        var answer = mutableListOf<List<Int>>()
        val combination = mutableListOf<List<Int>>()
        
        
        for (i in relation[1].indices) {
            combination += combination(relation[1], i + 1)
        }
        
        Loop@ for (i in combination.indices) {
            if (relation.isCandidateKey(combination[i])) {
                for(j in answer.indices) {
                    if (answer[j].all { it in combination[i] }) continue@Loop
                }
                
                answer += combination[i]
                println(answer)
            }
        }
        
        return answer.size
    }
    
    fun combination(array: Array<String>, r: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        
        fun combine(start: Int, comb: List<Int>) {
            if (comb.size == r) {
                result.add(comb)
                return
            }
            for (i in start until array.size) {
                combine(i + 1, comb + i)
            }
        }
        
        combine(0, emptyList())
        return result
    }
    
    fun Array<Array<String>>.isCandidateKey(checkList: List<Int>): Boolean 
    = this.map { checkList.joinToString() { index -> it[index] } }.distinct().size == this.size
}

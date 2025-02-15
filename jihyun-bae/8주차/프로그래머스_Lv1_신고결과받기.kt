class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = IntArray(id_list.size)
        
        val ids: HashMap<String, Int> = HashMap()
        val reports: HashMap<String, Set<String>> = HashMap()
        
        report.distinct().forEach {
            val (from, to) = it.split(" ")
            
            ids[to] = ids.getOrDefault(to, 0) + 1
            reports[from] = reports.getOrDefault(from, emptySet()) + to
        }
        
        id_list.forEachIndexed { index, id ->
            reports[id]?.forEach { name ->
                if (ids.getOrDefault(name, 0) >= k) answer[index]++
            }
        }
        
        return answer
    }
}

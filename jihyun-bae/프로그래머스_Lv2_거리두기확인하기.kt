import java.util.LinkedList
import java.util.Queue

class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        var answer: IntArray = intArrayOf()
        
        places.forEach { place ->
            var rule = true
            loop@ for (i in place.indices) {
                for (j in place[i].indices) {
                    if (place[i][j] == 'P' && !place.bfs(Pair(i, j))) {
                        rule = false
                        break@loop
                    }
                }
            }
            answer += if (rule) 1 else 0
        }
        
        return answer
    }
    
    fun Array<String>.bfs(start:Pair<Int, Int>) : Boolean {
        val dx = arrayOf(0, 0, -1, 1)
        val dy = arrayOf(-1, 1, 0, 0)

        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        queue.add(start)
        
        while (queue.isNotEmpty()) {
            val top = queue.poll()
            
            for (index in dx.indices) {
                val next = Pair(top.first + dx[index], top.second + dy[index])
                
                if (0 > next.first || next.first >= 5 || 0 > next.second || next.second >= 5) continue
                
                val d = Math.abs(start.first - next.first) + Math.abs(start.second - next.second)
    
                if (d == 0 || d > 2) continue
                
                if (this[next.first][next.second] == 'P') return false
                
                if (this[next.first][next.second] == 'O' && d < 2) queue.add(next)
            }
        }
        
        return true
    }
}

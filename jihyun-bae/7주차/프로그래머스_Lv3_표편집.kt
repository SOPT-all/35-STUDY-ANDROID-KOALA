import java.util.*

class Solution {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        var position = k
        val stack = Stack<Int>()
        val linkedList = Array(n) { Pair(it - 1, it + 1) }
        
        cmd.forEach { command ->
            command.split(" ").let {
                when(it[0]) {
                    "U" -> {
                        for (i in 1..it[1].toInt()) {
                            position = linkedList[position].first
                        }
                    }
                    
                    "D" -> {
                        for (i in 1..it[1].toInt()) {
                            position = linkedList[position].second
                        }
                    }
                    
                    "C" -> {
                        stack.push(position)
                        
                        val before = linkedList[position].first
                        val after = linkedList[position].second
                        
                        if (before >= 0) linkedList[before] = linkedList[before].copy(second = linkedList[position].second)
                        if (after < n) linkedList[after] = linkedList[after].copy(first = linkedList[position].first)
                        
                        position = if (after >= n) before else after
                    }
                    
                    "Z" -> {
                        stack.pop().let { revert ->
                            val before = linkedList[revert].first
                            val after = linkedList[revert].second
                            
                            if (before >= 0) linkedList[before] = linkedList[before].copy(second = revert)
                            if (after < n) linkedList[after] = linkedList[after].copy(first = revert)
                        }
                    }
                }
            }
        }
        
        val answer = Array(n) { 'O' }
        
        while(stack.isNotEmpty()) {
            answer[stack.pop()] = 'X'
        }
        
        return answer.joinToString("")
    }
}

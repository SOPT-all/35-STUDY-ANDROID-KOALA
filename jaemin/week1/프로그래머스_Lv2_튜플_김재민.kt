package week1

import java.util.*
import kotlin.math.sqrt

class Solution {
    fun solution(s: String): IntArray {
        val countMap = mutableMapOf<Int, Int>()
        val numbers = s.filter{
            it != '{' && it != '}'
        }
        val st = StringTokenizer(numbers, ",")
        val numberList = st.toList().map{it.toString().toInt()}
        val maxCount = getMax(numberList.size)
        var answer = IntArray(maxCount)
        numberList.forEach{
            if(countMap.containsKey(it)){
                countMap[it] = countMap[it]!!+ 1
            }else{
                countMap[it] = 1
            }
        }
        countMap.keys.forEach {
            answer[maxCount - countMap[it]!!] = it
        }
        return answer
    }
    private fun getMax(x: Int): Int{
        return ((sqrt((8*x+1).toDouble())-1)/2).toInt()
    }
}

fun main(args: Array<String>){
    val solution = Solution()
    solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")
}
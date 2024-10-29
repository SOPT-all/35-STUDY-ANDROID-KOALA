fun main(args : Array<String>){
    val solution = Solution()
    solution.solution("one4seveneight")
}

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var index: Int = 0
        // replace 방법보다 이게 빠를 거 같음
        val stringToNumber = mapOf(
            "zero" to 0,
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9
        )
        val numberList = mutableListOf<String>()

        while(index < s.length){
            if(s[index].isDigit()) {
                numberList.add(s[index].toString())
                index++
            }
            else{
                val sb = StringBuffer()
                while(!stringToNumber.containsKey(sb.toString())){
                    sb.append(s[index])
                    index++
                }
                numberList.add(stringToNumber[sb.toString()].toString())
            }
        }
        //joinToString()도 buffer사용해서 string만듦
        answer = numberList.joinToString("").toInt()
        return answer
    }
}

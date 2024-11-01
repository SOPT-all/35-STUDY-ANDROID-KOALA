class Solution {
    fun solution(s: String): Int {
        var result = ""
        var numStr = ""
        val numberMap = mapOf(
            "zero" to "0",
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9"
        )
        for (i in s.indices) {
            val char = s[i].toString()
            if (numberMap.containsValue(char as Any)) {
                result += char
                continue
            } else {
                numStr += char
                if (numberMap.containsKey(numStr)) {
                    result += numberMap[numStr]!!
                    numStr = ""
                }
            }
        }
        return result.toInt()
    }
}
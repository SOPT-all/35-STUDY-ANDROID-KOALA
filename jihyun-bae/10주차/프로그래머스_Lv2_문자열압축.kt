class Solution {
    fun solution(s: String): Int {
        var answer = s.length
        
        for (i in 1..(s.length / 2)) {
            answer = Math.min(answer, s.compress(size = i))
        }
        
        return answer
    }
    
    fun String.compress(size: Int) : Int {
        var length = 0
        var now = ""
        var compressingNumber = 1
        
        val chunks = this.chunked(size) + ""
        
        chunks.forEachIndexed { index, chunk ->
            if (index == 0) now = chunk
            else {
                if (now == chunk) compressingNumber += 1
                else {
                    length += if (compressingNumber != 1) compressingNumber.toString().length + now.length else now.length
                    
                    compressingNumber = 1
                    now = chunk
                }
            }
        }
    
        return length
    }
}

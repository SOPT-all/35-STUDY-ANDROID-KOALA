class Solution {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val n = lock.size
        val m = key.size
        val size = n + 2 * (m - 1)
        val map = Array(size) { IntArray(size) }.apply {
            for(i in 0 until n) for(j in 0 until n) 
                this[i + m - 1][j + m - 1] = lock[i][j]
        }
        
        fun rotate(arr: Array<IntArray>) = Array(m) { i ->
            IntArray(m) { j -> arr[m - 1 - j][i] }
        }
        
        fun check(x: Int, y: Int, key: Array<IntArray>): Boolean {
            val temp = Array(size) { map[it].clone() }
            for(i in 0 until m) for(j in 0 until m) 
                temp[x + i][y + j] += key[i][j]
            
            return (m-1 until m-1+n).all { i ->
                (m-1 until m-1+n).all { j -> temp[i][j] == 1 }
            }
        }
        
        var rotatedKey = key
        repeat(4) {
            for(x in 0..n+m-2) for(y in 0..n+m-2) 
                if(check(x, y, rotatedKey)) return true
            rotatedKey = rotate(rotatedKey)
        }
        return false
    }
}
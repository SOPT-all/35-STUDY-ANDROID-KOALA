class Solution {
    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
        val expandedLock = Array(lock.size + (key.size - 1) * 2) { i -> Array(lock.size + (key.size - 1) * 2) { j -> if (i in key.size - 1 until key.size - 1 + lock.size && j in key.size - 1 until key.size - 1 + lock.size) lock[i - key.size + 1][j - key.size + 1] else 0} }
        
        var checkingKey = key
        
        repeat (4) {
            for (targetX in 0 until expandedLock.size - key.size + 1) {
                for (targetY in 1 until expandedLock.size - key.size + 1) {
                    val checkingOpen = expandedLock.map { it.clone() }.toTypedArray()
                    for (x in key.indices) {
                        for (y in key.indices) {
                            checkingOpen[targetX + x][targetY + y] += checkingKey[x][y]
                        }
                    }
                    if (checkingOpen.check(keySize = key.size, lockSize = lock.size)) return true
                }
            }
            
            checkingKey = checkingKey.rotate()
        }
        
        return false
    }
    
    fun Array<Array<Int>>.check(keySize: Int, lockSize: Int) : Boolean {
        for (i in keySize - 1 until keySize - 1 + lockSize) {
             for (j in keySize - 1 until keySize - 1 + lockSize) {
                 if (this[i][j] != 1) return false
             }
        }
        return true
    }
    
    fun Array<IntArray>.rotate() : Array<IntArray> {
        val rotated = Array(this.size) { IntArray(this.size) }
        
        for (i in this.indices) {
            for (j in this.indices) {
                rotated[i][j] = this[this.size - j - 1][i]
            }
        }
        
        return rotated
    }
}

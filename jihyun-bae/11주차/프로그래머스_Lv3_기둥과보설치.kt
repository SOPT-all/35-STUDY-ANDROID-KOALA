class Solution {
    fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
        val wall = Array(n + 2) { Array(n + 2) { BooleanArray(2) }}
        var answer = mutableListOf<IntArray>()
        
        build_frame.forEach {
            if (it[3] == 0) {
                wall[it[0]][it[1]][it[2]] = false
                
                if(!wall.check()) wall[it[0]][it[1]][it[2]] = true
            } else {
                if (it[2] == 0 && wall.checkColumn(it)) wall[it[0]][it[1]][it[2]] = true
                else if (it[2] == 1 && wall.checkBeam(it)) wall[it[0]][it[1]][it[2]] = true
            }
        }
        
        for (i in wall.indices) {
            for (j in wall.indices) {
                if (wall[i][j][0]) answer.add(intArrayOf(i, j, 0))
                if (wall[i][j][1]) answer.add(intArrayOf(i, j, 1))
            }
        }
        
        return answer.toTypedArray()
    }
    
    fun Array<Array<BooleanArray>>.checkColumn(input: IntArray): Boolean = input[1] == 0 || this[input[0]][input[1] - 1][0] || (input[0] > 0 && this[input[0] - 1][input[1]][1]) || this[input[0]][input[1]][1]
    
    fun Array<Array<BooleanArray>>.checkBeam(input: IntArray): Boolean = (input[0] > 0 && this[input[0] - 1][input[1]][1] && this[input[0] + 1][input[1]][1]) || (input[1] > 0 && (this[input[0]][input[1] - 1][0] || this[input[0] + 1][input[1] - 1][0]))
    
    fun Array<Array<BooleanArray>>.check(): Boolean {
        for (i in this.indices) {
            for (j in this.indices) {
                if(this[i][j][0] && !checkColumn(intArrayOf(i, j))) return false
                if(this[i][j][1] && !checkBeam(intArrayOf(i, j))) return false
            }
        }
        
        return true
    }
}

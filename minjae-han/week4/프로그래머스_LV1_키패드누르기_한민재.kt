class Solution {
    private val keypadPos = arrayOf(
        Pair(3,1),  // 0
        Pair(0,0),  // 1
        Pair(0,1),  // 2
        Pair(0,2),  // 3
        Pair(1,0),  // 4
        Pair(1,1),  // 5
        Pair(1,2),  // 6
        Pair(2,0),  // 7
        Pair(2,1),  // 8
        Pair(2,2)   // 9
    )
    
    fun solution(numbers: IntArray, hand: String): String = buildString {
        var leftPos = Pair(3,0)   
        var rightPos = Pair(3,2)  
        val isRightHanded = hand[0] == 'r'
        
        numbers.forEach { num ->
            val numPos = keypadPos[num]
            when {
                num in listOf(1,4,7) -> {
                    append('L')
                    leftPos = numPos
                }
                num in listOf(3,6,9) -> {
                    append('R')
                    rightPos = numPos
                }
                else -> {
                    val leftDist = leftPos.manhattanDistanceTo(numPos)
                    val rightDist = rightPos.manhattanDistanceTo(numPos)
                    
                    if (leftDist < rightDist || (leftDist == rightDist && !isRightHanded)) {
                        append('L')
                        leftPos = numPos
                    } else {
                        append('R')
                        rightPos = numPos
                    }
                }
            }
        }
    }
    
    private fun Pair<Int,Int>.manhattanDistanceTo(other: Pair<Int,Int>) =
        Math.abs(first - other.first) + Math.abs(second - other.second)
}
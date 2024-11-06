import java.util.LinkedList
import java.util.Stack

fun solution(board: Array<IntArray>, moves: IntArray): Int {
    var answer = 0
    val transposedArray = transpose(board)
    val pickedDolls = Stack<Int>()

    moves.forEach {
        if(transposedArray[it-1].isNotEmpty()){
            if(pickedDolls.isNotEmpty() && pickedDolls.peek() == transposedArray[it-1].first ){
                transposedArray[it-1].poll()
                pickedDolls.pop()
                answer += 2
            }
            else pickedDolls.push( transposedArray[it-1].poll())
        }
    }

    return answer
}

fun main(args: Array<String>){
    solution(
        board = arrayOf(
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 1, 0, 3),
            intArrayOf(0, 2, 5, 0, 1),
            intArrayOf(4, 2, 4, 4, 2),
            intArrayOf(3, 5, 1, 3, 1)
        ),
        moves = intArrayOf(1,5,3,5,1,2,1,4)
    )
}

fun transpose(matrix: Array<IntArray>): Array<LinkedList<Int>> {
    val rowCount = matrix.size
    val colCount = matrix[0].size
    val transposedMatrix = Array(colCount) { LinkedList<Int>() }

    for (i in 0 until rowCount) {
        for (j in 0 until colCount) {
            if(matrix[i][j]!=0) transposedMatrix[j].add(matrix[i][j])
        }
    }
    return transposedMatrix
}
package week7

import java.util.LinkedList

fun solution(n: Int, k: Int, cmd: Array<String>): String {
    var index = k
    var size = n
    val deletedRow = LinkedList<Int>()
    cmd.forEach { command ->
        when(command[0]) {
            'U' -> index -= command.split(" ")[1].toInt()
            'D' -> index += command.split(" ")[1].toInt()
            'C'-> {
                deletedRow.push(index)
                size--
                if (index == size) index--
            }
            else -> { // Z
                size++
                val prevRow = deletedRow.poll()
                if (prevRow <= index) index++
            }
        }
    }
    val answer = StringBuilder()
    repeat(size) { answer.append('O') }

    while (deletedRow.isNotEmpty()) {
        answer.insert(deletedRow.pop(), 'X')
    }
    return answer.toString()
}
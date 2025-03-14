package baekjoon_practice

lateinit var numbers: IntArray
lateinit var visited: Array<Boolean>

var totalNum = 0
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        numbers = readLine().split(" ").map { it.toInt() }.toIntArray()
        totalNum = numbers[0]
        visited = Array(totalNum + 1) { false }
        if (totalNum == 0) break

        printNumber(0, 0)
        sb.append("\n")
    }
    print(sb)
}

fun printNumber(number: Int, count: Int) {
    if (count == 6) {
        for (i in 0 until  totalNum) {
            if (visited[i]) {
                sb.append(numbers[i+1]).append(" ")
            }
        }
        sb.append("\n")
        return
    }

    for (i in number until totalNum - (6 - count) + 1){
        visited[i] = true
        printNumber(number = i + 1, count = count + 1)
        visited[i] = false
    }
}

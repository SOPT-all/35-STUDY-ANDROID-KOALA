import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = bufferedReader.readLine().toInt()
    val numbers = bufferedReader.readLine().split(" ").map { it.toInt() }
    val stack: Stack<Int> = Stack()
    val nge = Array(n) { -1 }

    for (i in numbers.indices) {
        if (i == 0) stack.push(i)
        else {
            while(stack.isNotEmpty() && numbers[i] > numbers[stack.peek()]) {
                nge[stack.pop()] = numbers[i]
            }
            stack.push(i)
        }
    }

    nge.forEach {
        bufferedWriter.write("$it ")
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}

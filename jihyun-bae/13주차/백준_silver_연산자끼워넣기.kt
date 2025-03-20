import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = bufferedReader.readLine().toInt()
    val numbers = bufferedReader.readLine().split(" ").map { it.toInt() }
    val operators = bufferedReader.readLine().split(" ").map { it.toInt() }.toMutableList()

    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE

    fun dfs(index: Int, number: Int) {
        if (index == n) {
            max = Math.max(max, number)
            min = Math.min(min, number)
        }

        for (i in operators.indices) {
            if (operators[i] > 0) {
                operators[i] -= 1

                when (i) {
                    0 -> dfs(index + 1, number + numbers[index])
                    1 -> dfs(index + 1, number - numbers[index])
                    2 -> dfs(index + 1, number * numbers[index])
                    3 -> dfs(index + 1, number / numbers[index])
                }

                operators[i] += 1
            }
        }
    }

    dfs(1, numbers[0])

    bufferedWriter.write(max.toString())
    bufferedWriter.newLine()
    bufferedWriter.write(min.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

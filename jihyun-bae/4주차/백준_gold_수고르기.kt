import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val numbers = Array(n) { bufferedReader.readLine().toInt() }.sortedArray()

    var start = 0
    var end = 0
    var difference = numbers[numbers.size - 1] - numbers[0]

    while (start in numbers.indices && end in numbers.indices) {
        val temp = numbers[end] - numbers[start]

        if (temp < m) end++
        else {
            start++
            
            if (temp < difference) {
                difference = temp
                if (difference == m) break
            }
        }
    }

    bufferedWriter.write(difference.toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

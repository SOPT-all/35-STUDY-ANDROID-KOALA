import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = bufferedReader.readLine().toInt()

    repeat(t) {
        val n = bufferedReader.readLine().toInt()
        val stocks = bufferedReader.readLine().split(" ").map { it.toInt() }

        var profit = 0L
        var selling = stocks.last()

        for (i in n - 2 downTo 0) {
            when {
                stocks[i] > selling -> selling = stocks[i]
                stocks[i] < selling -> profit += selling - stocks[i]
            }
        }

        bufferedWriter.write(profit.toString())
        bufferedWriter.newLine()
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}

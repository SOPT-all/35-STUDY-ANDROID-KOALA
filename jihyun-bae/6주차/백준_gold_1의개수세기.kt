import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val max = 54

    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (a, b) = bufferedReader.readLine().split(" ").map { it.toLong() }

    val dp = LongArray(max) { 0 }

    fun LongArray.count(number: Long) : Long {
        val binary = number.toString(2)
        var sum = 0L
        var temp = number

        for (i in binary.indices) {
            if (binary[i] == '1') {
                val sqrt = binary.length - i - 1
                sum += dp[sqrt]

                temp -= (1L shl sqrt)
                sum += temp + 1
            }
        }

        return sum
    }

    for (i in 1..<max) {
        dp[i] = dp[i - 1] * 2 + (1L shl (i - 1))
    }

    bufferedWriter.write((dp.count(number = b) - dp.count(number = a - 1)).toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

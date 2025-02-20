import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = bufferedReader.readLine().toInt()
    val boxes = bufferedReader.readLine().split(" ").map { it.toInt() }

    val dp = IntArray(1001) { 1 }

    boxes.forEachIndexed { index, box ->
        var number = 1

        for (i in index - 1 downTo 0) {
            if (box > boxes[i] && number < dp[boxes[i]] + 1) {
                number = dp[boxes[i]] + 1
            }
        }

        dp[box] = max(dp[box], number)
    }

    bufferedWriter.write(dp.max().toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

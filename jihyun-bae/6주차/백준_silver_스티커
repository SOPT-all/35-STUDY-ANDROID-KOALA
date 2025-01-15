import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.max

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val t = bufferedReader.readLine().toInt()

    repeat(t) {
        val n = bufferedReader.readLine().toInt()
        val sticker = Array(2) { bufferedReader.readLine().split(" ").map { it.toInt() }.toIntArray() }

        for (i in 1..<n) {
            if (i == 1) {
                sticker[0][i] += sticker[1][i - 1]
                sticker[1][i] += sticker[0][i - 1]
            }
            else {
                sticker[0][i] += max(sticker[1][i - 1], sticker[1][i - 2])
                sticker[1][i] += max(sticker[0][i - 1], sticker[0][i - 2])
            }
        }

        bufferedWriter.write(max(sticker[0][n - 1], sticker[1][n - 1]).toString())
        bufferedWriter.newLine()
    }

    bufferedWriter.flush()
    bufferedWriter.close()
}

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = bufferedReader.readLine().toInt()
    val cage = IntArray(100001) { 0 }.apply { this[1] = 3; this[2] = 7 }

    for (i in 3..n) {
        cage[i] = (2 * cage[i - 1] + cage[i - 2]) % 9901
    }

    bufferedWriter.write(cage[n].toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

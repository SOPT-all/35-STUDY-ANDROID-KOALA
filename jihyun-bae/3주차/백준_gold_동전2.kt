import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, k) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val num = IntArray(k + 1) { 100001 }.apply { this[0] = 0 }

    repeat(n) {
        val coin = bufferedReader.readLine().toInt()

        for (i in coin..k) {
            num[i] = minOf(num[i], num[i - coin] + 1)
        }
    }

    bufferedWriter.write(if (num[k] == 100001) "-1" else num[k].toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

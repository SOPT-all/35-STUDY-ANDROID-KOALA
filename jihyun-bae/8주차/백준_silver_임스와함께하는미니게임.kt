import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, type) = bufferedReader.readLine().split(" ").let { it[0].toInt() to it[1] }
    val user = Array(n) { bufferedReader.readLine() }.distinct()

    bufferedWriter.write((user.size / when(type) {
        "Y" -> 1
        "F" -> 2
        else -> 3
    }).toString())

    bufferedWriter.flush()
    bufferedWriter.close()
}

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = bufferedReader.readLine().toInt()
    val person = bufferedReader.readLine().split(" ").map { it.toInt() }
    val answer = Array(n) { 0 }

    person.forEachIndexed { index, i ->
        answer.locate(n = i + 1, value = index + 1)
    }

    bufferedWriter.write(answer.joinToString(" "))

    bufferedWriter.flush()
    bufferedWriter.close()
}

fun Array<Int>.locate(n: Int, value: Int) {
    var zeroCount = 0

    for (i in this.indices) {
        if(this[i] == 0) {
            zeroCount++
            if (zeroCount == n) {
                this[i] = value
                break
            }
        }
    }
}

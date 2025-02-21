import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val bufferedWriter = BufferedWriter(OutputStreamWriter(System.`out`))

    val (l, c) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val characters = bufferedReader.readLine().split(" ").sorted()

    fun dfs(index: Int, password: String) {
        if (password.length == l) {
            var check = Pair(0, 0)

            password.forEach {
                check = if (it in "aeiou") check.copy(first = check.first + 1) else check.copy(second = check.second + 1)
            }

            if (check.first >= 1 && check.second >= 2) bufferedWriter.write(password + "\n")
        } else {
            for (i in index + 1..<c) dfs(i, password + characters[i])
        }
    }

    dfs(index = -1, password = "")

    bufferedWriter.flush()
    bufferedWriter.close()
}

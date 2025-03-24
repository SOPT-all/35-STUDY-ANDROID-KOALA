package week14

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var count = 0
    val N = br.readLine().toInt()
    val words = Array(N) { br.readLine() }
    words.forEach {
        for (i in it.indices) {
            if (i == it.lastIndex) count++
            else {
                if (it[i] == it[i + 1]) continue
                else if (it.drop(i + 1).contains(it[i])) break
            }
        }
    }
    write("$count")
    close()
}
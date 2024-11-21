package week5

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val people = br.readLine().toInt()
    val record = br.readLine().split(" ").map { it.toInt() }
    val line = ArrayList<Int>()

    for(i in people - 1 downTo 0) {
        line.add(record[i], i + 1)
    }

    line.forEach { write("$it ") }
    flush()
    close()
}
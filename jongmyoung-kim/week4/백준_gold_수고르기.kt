package week4

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val sequence = ArrayList<Int>()
    repeat(N) { sequence.add(br.readLine().toInt()) }

    var start = 0
    var end = 0
    var max = Int.MAX_VALUE

    while(end in start until N) {
        if (sequence[end] - sequence[start] < M) end++
        else max = minOf(max, sequence[end] - sequence[start++])
    }
    write("$max")
    close()
}
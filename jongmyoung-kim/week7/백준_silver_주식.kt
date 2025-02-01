package week7

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val T = br.readLine().toInt()
    repeat(T) {
        var answer = 0L
        val N = br.readLine().toInt()
        val stockArray = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        var maxPrice = stockArray.last()
        stockArray.reversed().drop(1).forEach {
            if (it < maxPrice) answer += (maxPrice - it)
            else maxPrice = it
        }
        write("$answer\n")
    }
    close()
}
// 역방향 탐색
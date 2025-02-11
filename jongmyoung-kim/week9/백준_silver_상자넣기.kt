package week9

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val size = br.readLine().toInt()
    val box = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(size) { 1 }

    for (i in 1 until size) for (j in 0..i) {
        if (box[i] > box[j]) dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
    }
    write("${binarySearch(box)}\n")
    close()
}

fun binarySearch(box: List<Int>): Int {
    val lis = mutableListOf<Int>()

    for (num in box) {
        val pos = lis.binarySearch(num)
        val insertPos = if (pos < 0) -pos - 1 else pos

        if (insertPos == lis.size) lis.add(num)
        else lis[insertPos] = num
    }
    return lis.size
}
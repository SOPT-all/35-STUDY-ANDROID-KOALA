package week12

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M) = br.readLine().split(" ").map { it.toInt() }
    val table = Array(N + 1) { IntArray(N + 1) }
    repeat(N) { row ->
        val nums = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        repeat(N) { col ->
            table[row + 1][col + 1] = nums[col] + table[row][col + 1] + table[row + 1][col] - table[row][col]
        }
    }

    repeat(M) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        write("${table[x2][y2] - table[x2][y1 - 1] - table[x1 - 1][y2] + table[x1 - 1][y1 - 1]}\n")
    }
    close()
}
package week13

private val br = System.`in`.bufferedReader()
private var max = Int.MIN_VALUE
private var min = Int.MAX_VALUE

fun main() = with(System.out.bufferedWriter()) {
    val N = br.readLine().toInt()
    val operands = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val (add, sub, mul, div) = br.readLine().split(" ").map { it.toInt() }
    dfs(1, operands[0], operands, add, sub, mul, div)
    write("$max\n$min")
    close()
}

fun dfs(depth: Int, result: Int, operands: IntArray, add: Int, sub: Int, mul: Int, div: Int) {
    if (depth == operands.size) {
        max = result.coerceAtLeast(max)
        min = result.coerceAtMost(min)
        return
    }
    if (add > 0) dfs(depth + 1, result + operands[depth], operands, add - 1, sub, mul, div)
    if (sub > 0) dfs(depth + 1, result - operands[depth], operands, add, sub - 1, mul, div)
    if (mul > 0) dfs(depth + 1, result * operands[depth], operands, add, sub, mul - 1, div)
    if (div > 0) dfs(depth + 1, result / operands[depth], operands, add, sub, mul, div - 1)
}
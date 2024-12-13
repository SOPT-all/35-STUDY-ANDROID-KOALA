fun main() {
    fun c(x: Long): Long {
        var r = 0L
        var b = 1L
        while (b <= x) {
            val g = (x + 1) / (b * 2)
            val m = (x + 1) % (b * 2)
            r += g * b + maxOf(0, m - b)
            b *= 2
        }
        return r
    }

    val (a, b) = readLine()!!.split(" ").map { it.toLong() }
    println(c(b) - c(a - 1))
}

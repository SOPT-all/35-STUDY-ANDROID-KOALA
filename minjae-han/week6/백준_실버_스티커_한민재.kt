fun main() {
    repeat(readLine()!!.toInt()) {
        val n = readLine()!!.toInt()
        val s = Array(2) { readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
        if (n == 1) println(maxOf(s[0][0], s[1][0]))
        else {
            s[0][1] += s[1][0]
            s[1][1] += s[0][0]
            for (i in 2 until n) {
                s[0][i] += maxOf(s[1][i-1], s[1][i-2])
                s[1][i] += maxOf(s[0][i-1], s[0][i-2])
            }
            println(maxOf(s[0][n-1], s[1][n-1]))
        }
    }
}
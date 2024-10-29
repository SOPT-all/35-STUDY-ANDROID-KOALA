package week2

import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (f, s, g, u, d) = br.readLine().split(" ").map { it.toInt() }

    val queue = LinkedList<Pair<Int, Int>>()
    val visited = BooleanArray(f + 1) { false }

    queue.add(Pair(s, 0))
    visited[s] = true

    while (queue.isNotEmpty()) {
        val (cf, cd) = queue.poll()

        if (cf == g) {
            write(cd.toString())
            close()
            return
        }

        val uf = cf + u
        val df = cf - d

        if (uf in 1..f && !visited[uf]) {
            visited[uf] = true
            queue.add(Pair(uf, cd + 1))
        }

        if (df in 1..f && !visited[df]) {
            visited[df] = true
            queue.add(Pair(df, cd + 1))
        }
    }
    write("use the stairs")
    close()
}

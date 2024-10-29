package week2

import java.util.LinkedList

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (f, s, g, u, d) = br.readLine().split(" ").map { it.toInt() }

    write(bfs(f, s, g, u, d))
    close()
}

fun bfs(f: Int, s: Int, g: Int, u: Int, d: Int): String {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(s, 0))

    val visited = BooleanArray(f + 1) { false }.apply {
        this[s] = true
    }

    while (queue.isNotEmpty()) {
        val (cf, cd) = queue.poll()

        if (cf == g) {
            return cd.toString()
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
    return "use the stairs"
}
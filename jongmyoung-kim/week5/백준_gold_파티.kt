package week5

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, M, X) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(N + 1) { IntArray(N + 1) { 100000 } }

    repeat(M) {
        val (start, end, dist) = br.readLine().split(" ").map { it.toInt() }
        graph[start][end] = dist
    }

    for (i in 1..N) {
        for (j in 1..N) {
            for (k in 1..N) {
                graph[j][k] = graph[j][k].coerceAtMost((graph[j][i] + graph[i][k]))
            }
        }
    }

    graph[X][X] = 0

    var answer = 0
    for (i in 1..N) {
        if (graph[X][i] < 100000 && graph[i][X] < 100000) {
            answer = answer.coerceAtLeast((graph[X][i] + graph[i][X]))
        }
    }

    write("$answer")
    close()
}
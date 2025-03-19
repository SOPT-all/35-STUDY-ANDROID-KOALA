package week13

import java.util.LinkedList

fun solution(begin: String, target: String, words: Array<String>): Int = if (!words.contains(target)) 0 else bfs(begin, target, words)

fun bfs(begin: String, target: String, words: Array<String>): Int {
    val queue = LinkedList<Pair<String, Int>>().apply { offer(Pair(begin, 0)) }
    val visited = BooleanArray(words.size)
    var min = 50

    while (queue.isNotEmpty()) {
        val (cur, depth) = queue.poll()
        if (cur == target) {
            min = min.coerceAtMost(depth)
            break
        }
        words.forEachIndexed { idx, word ->
            var count = 0
            if (visited[idx]) return@forEachIndexed
            for (i in word.indices) {
                if (cur[i] == word[i]) count++
            }
            if (count == cur.length -1) {
                queue.offer(Pair(word, depth + 1))
                visited[idx] = true
            }
        }
    }
    return min
}
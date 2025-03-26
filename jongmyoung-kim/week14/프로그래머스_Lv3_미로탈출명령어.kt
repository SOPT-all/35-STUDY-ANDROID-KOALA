package week14

import java.util.LinkedList
import kotlin.math.abs

fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
    val distance = abs(x - r) + abs(y - c)
    return if ((k - distance) % 2 == 0 || distance > k) dfs(n, m, x, y, r, c, k) else "impossible"
}

fun dfs(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
    val stack = LinkedList<Pair<Pair<Int, Int>, String>>().apply { push(Pair(Pair(x, y), "")) }
    val directions = arrayOf(Pair(-1, 0), Pair(0, 1), Pair(0, -1), Pair(1, 0)) // u, r, l, d

    while (stack.isNotEmpty()) {
        val (coordinate, route) = stack.pop()
        val distance = abs(coordinate.first - r) + abs(coordinate.second - c)

        if (route.length == k && coordinate.first == r && coordinate.second == c) return route

        if(k - route.length - distance % 2 == 1 || distance > k - route.length) continue // 시간초과 발생 -> 잔여 거리 계산을 하지 않음(도달하지 못하는 거리임에도 탐색을 진행하기에 시간초과 발생)

        for (i in directions.indices) {
            val dx = coordinate.first + directions[i].first
            val dy = coordinate.second + directions[i].second

            if (dx in 1..n && dy in 1..m && route.length < k) {
                val dir = when (i) {
                    0 -> 'u'
                    1 -> 'r'
                    2 -> 'l'
                    else -> 'd'
                }
                stack.push(Pair(Pair(dx, dy), route + dir))
            }
        }
    }
    return "impossible"
}

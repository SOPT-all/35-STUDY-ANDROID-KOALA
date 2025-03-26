package week14

private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val numbers = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val map = mutableMapOf<Int, Int>()
    var start = 0
    var end = 0
    var max = 0
    var sequence = 0

    while (start < N) {
        while (end < N) { // end를 늘리면서 최장 부분 수열 구하기
            val count = map.getOrDefault(numbers[end], 0)

            if (count >= K) break

            map[numbers[end++]] = count + 1
            sequence++
        }
        max = max.coerceAtLeast(sequence--)
        map[numbers[start]] = map.getOrDefault(numbers[start], 0) - 1
        start++
    }

    write("$max")
    close()
}

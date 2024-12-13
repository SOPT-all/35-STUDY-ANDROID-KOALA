class Solution {
    fun solution(orders: Array<String>, course: IntArray) = course
        .flatMap { size ->
            orders.flatMap { order ->
                order.toList().sorted().combinations(size)
                    .map { it.joinToString("") }
            }
            .groupingBy { it }
            .eachCount()
            .filter { it.value > 1 }
            .entries
            .groupBy { it.value }
            .maxByOrNull { it.key }
            ?.value
            ?.map { it.key }
            ?: emptyList()
        }
        .sorted()
        .toTypedArray()

    private fun List<Char>.combinations(length: Int): List<List<Char>> =
        if (length == 1) map { listOf(it) }
        else dropLast(length - 1).mapIndexed { index, char ->
            drop(index + 1).combinations(length - 1).map { listOf(char) + it }
        }.flatten()
}
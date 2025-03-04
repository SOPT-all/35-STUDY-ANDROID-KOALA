package week11

private val br = System.`in`.bufferedReader()
private val combination = mutableListOf<Set<Int>>()

fun main() = with(System.out.bufferedWriter()) {
    while (true) {
        val (K, S) = br.readLine().split(" ").let { it[0].toInt() to it.drop(1).map { num -> num.toInt() } }
        if (K == 0) break
        findCombination(0, S, mutableListOf())
        combination.forEach { write("${it.joinToString(" ")}\n") }
        newLine()
        combination.clear()
    }
    close()
}

fun findCombination(depth: Int, numList: List<Int>, currentList: MutableList<Int>) {
    if (currentList.size == 6) {
        combination.add(currentList.toSortedSet())
        return
    }

    for (i in depth until numList.size) {
        currentList.add(numList[i])
        findCombination(i + 1, numList, currentList)
        currentList.removeLast()
    }
}
package week9

private val br = System.`in`.bufferedReader()
private val set = mutableSetOf<String>()
private val combination = mutableListOf<String>()
lateinit var alphabets: List<String>

fun main() = with(System.out.bufferedWriter()){
    val vowels = arrayOf("a", "e", "i", "o", "u")
    val (L, _) = br.readLine().split(" ").map { it.toInt() }
    alphabets = br.readLine().split(" ").map { it }

    findCombination(L, 0, 0)
    set.filter { comb -> comb.any { vowels.contains("$it") } && comb.count { !vowels.contains("$it")} >= 2 }.sorted().forEach {
        write("$it\n")
    }
    close()
}

fun findCombination(count: Int, index: Int, depth: Int) {
    if (count == depth)  {
        set.add(combination.sorted().joinToString(""))
        return
    }
    for (i in index until alphabets.size) {
        combination.add(alphabets[i])
        findCombination(count, i + 1, depth + 1)
        combination.removeLast()
    }
}
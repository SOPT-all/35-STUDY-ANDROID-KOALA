package week10

class Solution {
    val combination = mutableListOf<Set<Int>>()

    fun solution(relation: Array<Array<String>>): Int {
        val toRemove = mutableListOf<Set<Int>>()

        for (i in 1..relation[0].size) {
            findCombination(i, 0, relation, mutableSetOf())
        }

        combination.forEach { set ->
            if (checkUnique(set, relation)) toRemove.addAll(combination.filter { it != set && it.containsAll(set) })
            else toRemove.add(set)
        }

        combination.removeAll(toRemove)
        return combination.size
    }

    fun findCombination(size: Int, currentSize: Int, relation: Array<Array<String>>, currentSet: MutableSet<Int>) {
        if (currentSet.size == size) {
            combination.add(currentSet.toSet())
            return
        }

        for (i in currentSize until relation[0].size) {
            currentSet.add(i)
            findCombination(size, i + 1, relation, currentSet)
            currentSet.remove(i)
        }
    }

    fun checkUnique(set: Set<Int>, relation: Array<Array<String>>): Boolean = relation.map { set.joinToString { index -> it[index] } }.distinct().size == relation.size
}
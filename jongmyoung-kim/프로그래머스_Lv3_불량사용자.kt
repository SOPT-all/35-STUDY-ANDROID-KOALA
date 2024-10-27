fun badUser(user_id: Array<String>, banned_id: Array<String>): Int {
    val overlap_id = Array(banned_id.size) { mutableListOf<String>() }

    for(i in banned_id.indices) {
        user_id.forEach { id ->
            if(id.matches(banned_id[i].replace("*", ".*").toRegex())
                && id.length == banned_id[i].length) {
                overlap_id[i].add(id)
            }
        }
    }

    val resultSet = mutableSetOf<Set<String>>()

    fun findCombinations(index: Int, currentSet: MutableSet<String>) {
        if(index == banned_id.size) {
            resultSet.add(currentSet.toSet())
            return
        }

        for(id in overlap_id[index]) {
            if(!currentSet.contains(id)) {
                currentSet.add(id)
                findCombinations(index + 1, currentSet)
                currentSet.remove(id)
            }
        }
    }
    findCombinations(0, mutableSetOf())

    return resultSet.size
}

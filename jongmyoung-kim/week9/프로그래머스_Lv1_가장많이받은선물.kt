package week9

fun solution(friends: Array<String>, gifts: Array<String>): Int {
    val giveMap = HashMap<String, List<String>>()
    val receiveMap = HashMap<String, List<String>>()
    val nextMonth = HashMap<String, Int>()

    gifts.forEach {
        val (give, receive) = it.split(" ")
        giveMap[give] = giveMap.getOrDefault(give, emptyList()) + receive
        receiveMap[receive] = receiveMap.getOrDefault(receive, emptyList()) + give
    }

    friends.forEach { giver ->
        val given = giveMap[giver].orEmpty()
        val received = receiveMap[giver].orEmpty()

        friends.filter { it != giver }.forEach { friend ->
            if (given.count { it == friend } > received.count { it == friend } ||
                given.count { it == friend } == received.count { it == friend } &&
                (given.size - received.size) > (giveMap[friend].orEmpty().size - receiveMap[friend].orEmpty().size))
                nextMonth[giver] = nextMonth.getOrDefault(giver, 0) + 1
        }
    }
    return nextMonth.values.maxByOrNull { it } ?: 0
}
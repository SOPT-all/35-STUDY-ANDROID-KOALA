class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val friendsMap: HashMap<String, Int> = HashMap()
        val gift = Array(friends.size) { Array(friends.size) { 0 } }
        val giftCount = Array(friends.size) { 0 }
        
        friends.forEachIndexed { index, friend ->
            friendsMap.put(friend, index)
        }
        
        gifts.forEach {
            val (from, to) = it.split(" ")
            gift[friendsMap.getOrDefault(from, 0)][friendsMap.getOrDefault(to, 0)] += 1
        }
        
        for (i in friends.indices) {
            for (j in friends.indices) {
                if (i == j) continue
                
                if (gift[i][j] > gift[j][i]) giftCount[i] += 1
                else if (gift[i][j] == gift[j][i] && gift.getGiftPoint(i) > gift.getGiftPoint(j)) giftCount[i] += 1
            }
            println()
        }
        
        return giftCount.maxOrNull() ?: 0
    }
    
    fun Array<Array<Int>>.getGiftPoint(friend: Int): Int = this[friend].sum() - this.sumOf { it[friend] }
}

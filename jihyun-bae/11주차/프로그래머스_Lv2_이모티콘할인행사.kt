class Solution {
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        val answer = arrayOf(0, 0)
        val discounts = arrayOf(10, 20, 30, 40)
        
        fun dfs(check: Array<Int>, index: Int) {
            if (index == emoticons.size) {
                var subscriptions = 0
                var money = 0

                for (u in users.indices) {
                    var sum = 0
                    for (e in emoticons.indices) {
                        if (check[e] >= users[u][0]) sum += emoticons[e] * (100 - check[e]) / 100
                        if (sum >= users[u][1]) break
                    }

                    if (sum >= users[u][1]) subscriptions += 1 else money += sum
                }

                if (answer[0] < subscriptions) {
                    answer[0] = subscriptions
                    answer[1] = money
                } else if (answer[0] == subscriptions && answer[1] < money) {
                    answer[1] = money
                }
            }
            else {
                for (i in discounts.indices) {
                    val temp = check.copyOf()
                    temp[index] = discounts[i]
                    dfs(temp, index + 1)
                }
            }
        }
        
        dfs(Array(users.size) { 0 }, 0)
        
        return answer.toIntArray()
    }
}

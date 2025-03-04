package week11

class Solution {
    var answer = Pair(0, 0)
    val emoticonRate = ArrayList<Int>()

    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        getCombination(0, users, emoticons)
        return answer.toList().toIntArray()
    }

    fun getCombination(size: Int, users: Array<IntArray>, emoticons: IntArray) {
        val rates = intArrayOf(10, 20, 30, 40)
        if (size == emoticons.size) {
            getProfit(emoticonRate, users, emoticons)
            return
        }

        for (rate in rates) {
            emoticonRate.add(rate)
            getCombination(size + 1, users, emoticons)
            emoticonRate.removeLast()
        }
    }

    fun getProfit(emoticonRate: ArrayList<Int>, users: Array<IntArray>, emoticons: IntArray) {
        var subscriber = 0
        val profit = IntArray(users.size)

        users.forEachIndexed { idx, (rate, price) ->
            emoticonRate.forEachIndexed { idx2, rate2 ->
                if (rate2 >= rate) profit[idx] += emoticons[idx2] * (100 - rate2) / 100
            }
            if (profit[idx] >= price) {
                profit[idx] = 0
                subscriber++
            }
        }
        if (subscriber > answer.first || (subscriber == answer.first && profit.sum() > answer.second)) answer = Pair(subscriber, profit.sum())
    }
}
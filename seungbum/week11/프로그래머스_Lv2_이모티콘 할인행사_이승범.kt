package koala.programmers

class Kakao_150369 {
    lateinit var emoticonDiscount: IntArray
    lateinit var emoticon: IntArray
    lateinit var answer: IntArray
    lateinit var users: Array<IntArray>
    val discountRate = arrayOf(10, 20, 30, 40)

    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        answer = intArrayOf(0, 0)
        this.users = users
        emoticonDiscount = IntArray(emoticons.size) { 0 }
        emoticon = emoticons
        calculatePrice(0)
        return answer
    }

    fun calculatePrice(index: Int) {
        if (index == emoticon.size) {
            answer = selectMax(calculateAnswer(), answer)
            return
        }
        for (rate in discountRate) {
            emoticonDiscount[index] = rate
            calculatePrice(index + 1)
        }
    }

    fun calculateAnswer(): IntArray {
        var priceSum = 0
        var subscribeNum = 0
        for (user in users) {
            var userEmoticonValue = 0
            for (i in emoticon.indices) {
                if (emoticonDiscount[i] >= user[0]) userEmoticonValue += (100 - emoticonDiscount[i])* emoticon[i] / 100
            }

            if (userEmoticonValue >= user[1]) subscribeNum++
            else priceSum += userEmoticonValue
        }
        return intArrayOf(subscribeNum, priceSum)
    }

    fun selectMax(a: IntArray, b: IntArray): IntArray {
        return when {
            a[0] > b[0] -> a
            a[0] < b[0] -> b
            a[1] > b[1] -> a
            else -> b
        }
    }
}

fun main() {
    val k = Kakao_150369()
    val users = arrayOf(
        intArrayOf(40, 10000),
        intArrayOf(25, 10000)
    )
    val emoticons = intArrayOf(7000, 9000) //
    val a = k.solution(users, emoticons)

    println("${a[0]} ${a[1]}")
}

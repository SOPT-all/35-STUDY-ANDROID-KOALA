import java.util.*

fun main() {
    val br = FastReader()
    val n = br.nextInt()
    val k = br.nextInt()

    val coins = IntArray(n)
    var size = 0
    var minCoin = Int.MAX_VALUE

    for (i in 0 until n) {
        val coin = br.nextInt()
        if (coin <= k && !containsCoin(coins, size, coin)) {
            coins[size++] = coin
            if (coin < minCoin) minCoin = coin
        }
    }

    if (size == 0 || minCoin > k) {
        print(-1)
        return
    }

    val dp = IntArray(k + 1) { 10001 }
    dp[0] = 0
  
    if (size > 1) insertionSort(coins, size)

    for (i in 0 until size) {
        val coin = coins[i]
        var amount = coin
        while (amount <= k) {
            val newCount = dp[amount - coin] + 1
            if (newCount < dp[amount]) {
                dp[amount] = newCount
            }
            amount++
        }
        
        if (dp[k] < 10001) {
            val remainingMin = (k - amount) / coin + 1
            if (remainingMin >= dp[k]) break
        }
    }
    
    print(if (dp[k] == 10001) -1 else dp[k])
}

private class FastReader {
    private val br = System.`in`.bufferedReader()
    private var st: StringTokenizer? = null
    
    fun nextInt(): Int {
        while (st == null || !st!!.hasMoreTokens()) {
            st = StringTokenizer(br.readLine())
        }
        return st!!.nextToken().toInt()//쓸건데?
    }
}

private fun containsCoin(coins: IntArray, size: Int, target: Int): Boolean {
    for (i in 0 until size) {
        if (coins[i] == target) return true
    }
    return false
}

private fun insertionSort(arr: IntArray, size: Int) {
    for (i in 1 until size) {
        val key = arr[i]
        var j = i - 1
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
    }
}
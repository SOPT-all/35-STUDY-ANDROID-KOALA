fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }

    val coins = buildSet {
        repeat(n) {
            add(readLine().toInt())
        }
    }.sorted()

    val dp = IntArray(k + 1) { 10001 }
    dp[0] = 0 
    
    coins.forEach { coin ->
        for (amount in coin..k) {
            dp[amount] = minOf(dp[amount], dp[amount - coin] + 1)
        }
    }
    
    print(if (dp[k] == 10001) -1 else dp[k])
}
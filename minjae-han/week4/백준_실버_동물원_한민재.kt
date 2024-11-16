fun main() {
    val n = readLine()!!.toInt()
    val MOD = 9901
    
    val dp = Array(n + 1) { IntArray(3) }
    
    dp[1][0] = 1
    dp[1][1] = 1
    dp[1][2] = 1
    
    for (i in 2..n) {
        dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD
        dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD
        dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD
    }
    
    val result = (dp[n][0] + dp[n][1] + dp[n][2]) % MOD
    println(result)
}
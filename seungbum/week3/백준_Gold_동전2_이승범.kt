package koala.baekjoon

import kotlin.math.min

fun main(args: Array<String>) {
    val (n, k) = readln().split(" ").map { it.toInt() }
    var coins = IntArray(n)
    val dp = IntArray(k + 1) { 10001 }
    repeat(n) { index ->
        val coin = readln().toInt()
        if (!coins.contains(coin))
            coins[index] = coin
    }

    coins = coins.filter { it != 0 && it <= k }.toIntArray()
    coins.sort()

    dp[0] = 0
    for (i in 1..k) {
        for (coin in coins) {
            if (i - coin >= 0) {
                dp[i] = min(dp[i], dp[i - coin] + 1)
            }
        }
    }
        println(if(dp[k] == 10001) -1 else dp[k])
}


/*
1. coin을 sort하고 큰수부터 비교
1-1. 아땋게 비교할건데?
 k 라는 특정 값이 있고 이걸 만들어야함
  -> coin을 * 거나 + 해서 만들어야함
  -> dp로 coin의 배수 다 넣어주기
2. 개수를 세고 개수보다 크다면 바로 return
3, 개수 출력
    답지보고 풀었습니다!
 */

package baekjoon

import java.io.*

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val dpSize = br.readLine().toInt()

//    val dp = Array<IntArray>(dpSize + 1){ IntArray(3){1} }
//    dp[0][1] = 0
//    dp[0][2] = 0
//
//    for(i in 2..dpSize){
//        dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]
//        dp[i][1] = dp[i-1][0] + dp[i-1][2]
//        dp[i][2] = dp[i-1][0] + dp[i-1][1]
//    }

    val dp = IntArray(dpSize+1)
    dp[0] = 1
    dp[1] = 3
    for(i in 2..dpSize){
        dp[i] = (dp[i-1] * 2 + dp[i-2]) % 9901 // 모듈러 연산의 분배법칙
    }

    print(dp[dpSize])

}
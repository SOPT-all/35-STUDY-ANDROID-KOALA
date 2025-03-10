package koala.baekjoon

import java.util.*


fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val dp = Array(N + 1) { IntArray(3) }
    Arrays.fill(dp[1], 1)
    for (i in 2..N) {
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]
        dp[i][1] = dp[i - 1][0] + dp[i - 1][2]
        dp[i][2] = dp[i - 1][0] + dp[i - 1][1]

        dp[i][0] %= 9901
        dp[i][1] %= 9901
        dp[i][2] %= 9901
    }
    println("${(dp[N][0] + dp[N][1] + dp[N][2]) % 9901}")
}

/*
    사자를 배치하는 경우의 수를 9901로 나눈 나머지 출력
    사자를 한마리도 배치하지않는 경우의 수
    0 -> 1
    1 -> 4c1 *2 8
    2 -> 4c2 *2 12
    3 ->4c3 *2 8
    4 -> 4c4 *2  2

    1. dp로 플어봦
    2. dp[0] = 1 , dp[1] = 8 , dp[2] = 5+ 5+ 3 + 3+ 1+ 1 18 , dp[3] = 3+ 3+ 1 + 1 8
        dp[4] = 1+1 2
    3. N개의 블럭에는 N가지 까지의 사자가 들어갈 수 있따
    4.dp[100000][1000000]
    5.dp[0][0] = 1  1
    6.dp[1][0] = 1,dp[1][1] = 2 3
    7.dp[2][0] = 1,dp[2][1] = 4 , dp[2][2] = 2  7
    8.dp[3][0] = 1,dp[3][1] = 6 , dp[3][2] = 8 , dp[3][3] =2    17
    9.dp[4][0] = 1,dp[4][1] = 8 , dp[4][2] = 18 , dp[4][3] = 12 , dp[4][4] =2
    어떻게 쌓일까?
    1.N개중에 t마리의 사자를 넣는다고 생각해보자 dp[n][t] = x -> dp[n+1][t]
    2.그냥 2개만 추가되는거임 -> 4 개의 3  -> 5개의  3
       - -
       - - -> 3개의2개가 1개 /위에서 1개를 고르면 2줄중 1개가 1개
       - -
       - -

    다틀림
    왼쪽 오른쪽 아무것도 없을때를 나눠서 넣어주는거임 ㅠ
 */
package koala.baekjoon

import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val sumTable = Array(n + 1) { IntArray(n + 1) }
    val sb = StringBuilder()


    for (i in 1..n) {
        st = StringTokenizer(readLine())
        for (j in 1..n) {
            sumTable[i][j] = sumTable[i - 1][j] + sumTable[i][j - 1] - sumTable[i - 1][j - 1] + st.nextToken().toInt()
        }
    }
    repeat(m) {
        st = StringTokenizer(readLine()) // ⬅️ StringTokenizer 사용
        val x1 = st.nextToken().toInt()
        val y1 = st.nextToken().toInt()
        val x2 = st.nextToken().toInt()
        val y2 = st.nextToken().toInt()
        val sum =
            sumTable[x2][y2] - sumTable[x2][y1 - 1] - sumTable[x1 - 1][y2] + sumTable[x1 - 1][y1 - 1]

        sb.append(sum).append("\n")
    }
    println(sb)
}

/*
  나는 표와 좌표 2개를 가지고 있지 x좌표 y좌표
 */
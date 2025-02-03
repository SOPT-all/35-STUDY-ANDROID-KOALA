package week7

class Solution {
    fun solution(p: String): String {
        if (p.isEmpty()) return p

        val index = getIndex(p)
        val u = p.substring(0, index + 1)
        val v = p.substring(index + 1)

        return if (u[0] == '(' && u[u.length - 1] == ')') u + solution(v)
        // first, last, startsWith, endsWith는 속도가 10배정도 차이남 why??
        else {
            val answer = StringBuilder("(")
                .append(solution(v))
                .append(")")
            u.substring(1, u.length - 1).forEach {
                answer.append(if (it == '(') ")" else "(")
            }
            answer.toString()
        }
    }

    private fun getIndex(p: String): Int {
        var count = 0
        var idx = 0
        for (i in p.indices) {
            if (p[i] == '(') count += 1 else count -= 1
            if (count == 0) {
                idx = i
                break
            }
        }
        return idx
    }
}
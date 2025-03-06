package week11

private val score = IntArray(11)
private var maxScore = 0
private var answer = intArrayOf()

fun solution(n: Int, info: IntArray): IntArray {
    getCombination(0, info)
    return if (maxScore == 0) intArrayOf(-1) else answer
}

fun getCombination(depth: Int, info: IntArray) {
    if (depth == info.sum()) {
        compareScore(score, info)
        return
    }

    for (i in info.indices) {
        if (score[i] <= info[i]) {
            val available = info[i] + 1.coerceAtMost(depth)
            score[i] = available
            getCombination(depth + available, info)
            score[i] = 0
        }
    }
}

fun compareScore(score: IntArray, info: IntArray) {
    val scores = intArrayOf(0, 0)
    repeat(score.size) {
        if (score[it] != 0 || info[it] != 0) {
            if (score[it] > info[it]) scores[0] += 10 - it else scores[1] += 10 - it
        }
    }
    if (scores[0] > scores[1] && scores[0] - scores[1] >= maxScore) {
        answer = score.clone()
        maxScore = scores[0] - scores[1]
    }
}
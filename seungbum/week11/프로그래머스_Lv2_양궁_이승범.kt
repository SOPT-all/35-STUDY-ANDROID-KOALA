package koala.programmers

import kotlin.math.max

/*
    어피치가 n발을 쏜 후에 라이언이 n발을 쏨
    k점을 맞췄을때 더 많은 화살을 k점에 맞힌선수가 k점을 가져감/ 단 둘이 같을 경우 어피치가 가져감
    k점을 몇발을 맞춰도 k점만 가져감 / 안 맞히면 못 가져감

    지금은 어피치가 n발을 쏙 라이언이 쏠차례임 /
    구해야하는것 : 라이언이 어피치를 가장 큰 점수차로 이기려면?
    우승할 수 없다면 -1 return

    info는 0 - 10의 원소를 가지고!이때 info[0] = 10  각각의 원소에는 k개의 화살개수가 잇으며 합치면 n개임
    라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러개라면 가장 낮은 점수를 더 많이 맞힌 경우를 return
    같으면 그다음으로 낮은 점수를 많이 맞힌 경우

    1. 이길 수 없는 경우는 언제가 있을까?
        내가 가질 수있는 최대 점수를 구하는게 빠르겠지.
        최대면 1발을써서 얻을 수있는거랑 2발을섰을때랑 비교하는거지
        1발을 쐈을때 최대로 얻을 수 있는 비용 -> 0개 짜리를 쏘는거겠지 -> 위에서 부터 내려와서 제일 높은곳
        2발을 쐈을때 최대로 얻는 비용 -> 위에서부터 내려오면서 0이라면 1개쏘고 만약 k개의 화살이 꽂혀있다면 k+1개의 화살이 필요함
        따라서 k+1개의 화살을 다른데 쐇을때랑 아닐때의 값을 비교해야함
        만약 10을 내가 가지고 9에서 화살이 k개가 박혀있을때 9를 포기하고 9아래에서 n-1개의 화살을 썼을때 vs 9에서 k+1게를 쓰고 다음꺼 섰을때
        백트래킹 문제구나!
 */

class Kakao_92342 {
    lateinit var info: IntArray
    var bestLionInfo: IntArray = intArrayOf(-1)
    var maxDiff: Int = 0
    fun solution(n: Int, info: IntArray): IntArray {
        this.info = info
        val lionInfo = IntArray(11) { 0 }
        chooseArrowNum(0, n, lionInfo)
        return bestLionInfo
    }

    fun chooseArrowNum(index: Int, remainingArrow: Int, lionInfo: IntArray) {
        var lionInformation = lionInfo.plus(0)
        if (remainingArrow == 0 || index == 11) {
            if (remainingArrow > 0)
                lionInfo[10] += remainingArrow

            val (lionScore, apeachScore) = calculateScore(lionInfo)
            val scoreDiff = lionScore - apeachScore

            if (scoreDiff > maxDiff) {
                maxDiff = scoreDiff
                bestLionInfo = lionInfo.copyOf()
            } else if (scoreDiff == maxDiff && scoreDiff > 0) {
                if (isBetter(lionInfo, bestLionInfo)) {
                    bestLionInfo = lionInfo.copyOf()
                }
            }

            if (remainingArrow > 0) {
                lionInfo[10] -= remainingArrow
            }
            return

        }
        if (remainingArrow > info[index]) {
            lionInfo[index] = info[index] + 1
            chooseArrowNum(index + 1, remainingArrow - lionInfo[index], lionInfo)
            lionInfo[index] = 0 // 백트래킹
        }

        // 2. 해당 점수를 포기하기
        chooseArrowNum(index + 1, remainingArrow, lionInfo)
        return
    }

    fun calculateScore(lionInfo: IntArray): Pair<Int, Int> {
        var lionScore = 0
        var apeachScore = 0

        for (i in 0..10) {
            if (info[i] == 0 && lionInfo[i] == 0) continue
            if (lionInfo[i] > info[i]) lionScore += 10 - i
            else apeachScore += 10 - i
        }

        return Pair(lionScore, apeachScore)
    }

    fun isBetter(lionInfo: IntArray, bestInfo: IntArray): Boolean {
        for (i in 10 downTo 0) {
            if (lionInfo[i] > bestInfo[i]) return true
            if (lionInfo[i] < bestInfo[i]) return false
        }
        return false
    }
}




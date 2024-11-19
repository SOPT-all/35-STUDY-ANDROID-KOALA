package baekjoon

import java.io.*

fun main(args: Array<String>){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val maxPersonHeight = br.readLine().toInt()
    val leftTallerPeopleNumbers = br.readLine().split(" ").map{it.toInt()}
    val answer = IntArray(maxPersonHeight)

    for(i in 1..maxPersonHeight){
        val targetEmptySpaceNumber = maxPersonHeight - i - leftTallerPeopleNumbers[i-1]
        var countEmptySpace = 0
        var start = maxPersonHeight-1

        while(true){
            if(answer[start]==0) {
                if(countEmptySpace == targetEmptySpaceNumber){
                    answer[start] = i
                    break
                }else{
                    countEmptySpace++
                    start--
                }
            }else{
                start--
            }
        }
    }

    val sb = StringBuilder()
    for(i in answer){
        sb.append(i).append(" ")
    }
    println(sb.toString())
}
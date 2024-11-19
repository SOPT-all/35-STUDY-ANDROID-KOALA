package programmers

fun solution(survey: Array<String>, choices: IntArray): String {
    var answer: String = ""
    val scoreBoard = mutableMapOf(
        "RT" to 0,
        "CF" to 0,
        "JM" to 0,
        "AN" to 0,
        "TR" to 0,
        "FC" to 0,
        "MJ" to 0,
        "NA" to 0
    )

    for(i in 0 until survey.size){
        scoreBoard[survey[i]] = scoreBoard[survey[i]]!! + (4 - choices[i])
    }
    val sb = StringBuilder()
    sb.append(if(scoreBoard["RT"]!! - scoreBoard["TR"]!! >= 0) "R" else "T")
    sb.append(if(scoreBoard["CF"]!! - scoreBoard["FC"]!! >= 0) "C" else "F")
    sb.append(if(scoreBoard["JM"]!! - scoreBoard["MJ"]!! >= 0) "J" else "M")
    sb.append(if(scoreBoard["AN"]!! - scoreBoard["NA"]!! >= 0) "A" else "N")

    answer = sb.toString()
    print(answer)

    return answer
}

fun main(args: Array<String>){
    solution(
        survey = arrayOf("AN", "CF", "MJ", "RT", "NA"),
        choices = intArrayOf(5, 3, 2, 7, 5)
    )
}
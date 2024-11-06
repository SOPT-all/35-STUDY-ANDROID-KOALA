package programmers


import java.util.*

fun solution(fees: IntArray, records: Array<String>): IntArray {
    val totalTimes = IntArray(10000)
    val inTimes = Array(10000){""}
    val answerList: MutableList<Int> = mutableListOf()

    val defaultTime = fees[0]
    val defaultFee = fees[1]
    val unitTime = fees[2]
    val unitFee = fees[3]

    records.forEach {
        val time = it.slice(0..4)
        val carNumber = it.slice(6..9).toInt()
        if (inTimes[carNumber] == "") inTimes[carNumber] = time
        else {
            totalTimes[carNumber] += calculateTimeDiff(inTimes[carNumber], time)
            inTimes[carNumber] = ""
        }
    }
    for(carNumber in 0..9999){
        if(inTimes[carNumber]!=""){
            totalTimes[carNumber] += calculateTimeDiff(inTimes[carNumber])
        }
        if(totalTimes[carNumber] > defaultTime){
            answerList.add(defaultFee + Math.ceil((totalTimes[carNumber]-defaultTime)/unitTime.toDouble()).toInt()*unitFee)
        }else if(totalTimes[carNumber] in 1..defaultTime) answerList.add(defaultFee)
    }
    
    return answerList.toIntArray()
}

fun calculateTimeDiff(timeIn: String, timeOut: String = "23:59"): Int{
    var st = StringTokenizer(timeIn, ":")
    val timeInHour = st.nextToken().toInt()
    val timeInMinute = st.nextToken().toInt()

    st = StringTokenizer(timeOut, ":")
    val timeOutHour = st.nextToken().toInt()
    val timeOutMinute = st.nextToken().toInt()

     val totalTime = (timeOutHour * 60 + timeOutMinute) - (timeInHour * 60 + timeInMinute)

    return totalTime
}

fun main(args: Array<String>){
    solution(fees = intArrayOf(180, 5000, 10, 600), records = arrayOf("05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"))
}
package koala.programmers

/*
1.today -> 년도.달.날짜 형태로 주어짐
2.term -> A~Z 중 하나로 "약관종류 유효기간" 형태로 주어짐
-> 이때 유효기간은 1~100이하의 정수임
3.privacies -> "날짜 약관종류" 형태로 주어짐
날짜 -> 년도.달.날짜 형태로 주어짐
날짜
-> 2000 ~ 2022
-> 1 ~ 12
-> 1 ~ 28
풀이 :
우리가 찾아야하는건 유효기간이 지난 privacies의 번호
우리가 today와비교해야하는건 privacies에 유효기간을 더한 값이 today 이전인가?
 */

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar

fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
    val answer = mutableListOf<Int>()

    val df = SimpleDateFormat("yyyy.MM.dd")
    val todayTime = df.parse(today).time
    val termMap: MutableMap<String, Int> = mutableMapOf()
    terms.forEach { tm ->
        val to = tm.split(" ")
        termMap[to[0]] = to[1].toInt()
    }

    privacies.forEachIndexed { idx, privaciy ->
        val cal = Calendar.getInstance()
        cal.time = df.parse(privaciy.split(" ")[0])
        cal.add(Calendar.MONTH, termMap[privaciy.split(" ")[1]]!!)
        cal.add(Calendar.DAY_OF_MONTH, -1)
        if (todayTime > cal.time.time)
            answer.add(idx + 1)
    }

    return answer.toIntArray()
}

fun main() {
    // 테스트 데이터
    val today = "2022.05.19"
    val terms = arrayOf("A 6", "B 12", "C 3")
    val privacies = arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")

    // solution 함수 호출
    val result = solution(today, terms, privacies)

    // 결과 출력
    println("결과: ${result.joinToString(", ")}")
}
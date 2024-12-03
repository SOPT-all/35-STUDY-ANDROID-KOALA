package koala.programmers

fun solution(new_id: String): String {
    val regex = Regex("[^a-z0-9._-]")
    var newId = regex.replace(new_id.lowercase(), "")

    while (newId.contains(".."))
        newId = newId.replace("..", ".")
    if (newId.startsWith(".")) newId = newId.substring(1, newId.lastIndex + 1)
    if (newId.endsWith(".")) newId = newId.substring(0, newId.lastIndex )
    if (newId.isEmpty()) newId += "a"
    if (newId.length > 15) newId = newId.substring(0, 15)
    if (newId.endsWith(".")) newId = newId.substring(0, newId.lastIndex )
    if (newId.length < 3) for (i in newId.length..2) newId += newId[newId.lastIndex]
    return newId
}

fun main() {
    print(solution("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"))
}

/*
 1. 아이디의 길이는 3<= <= 15
 2. 소문자 , 숫자, - ,_ , . 만 사용가능
 3. . 은 처음과 끝에 사용하지 못하고 연속적 사용 x
 4. 규칙에 맞지 않을 경우 새로운 아이디 추천
    1. 대문자 -> 소문자
    2. 가능한 문자를 제외하고 모두 제거
    3. .. -> .
    4. start end에 위치한 . 제거
    5. id가 empty할 경우 + "a"
    6. 15자 이상이라면 15개 초과 나머지 문자 모두제거
        이떼 .이 마지막이면 .문자 제거
    7. 2자 이하라면  마지막 문자를 3이 될때까지 반복
 */
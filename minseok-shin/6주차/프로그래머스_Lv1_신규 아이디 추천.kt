package week4

class Solution {
    fun solution(new_id: String): String {
        var answer: String = ""

        // TODO: 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        // TODO: 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        // TODO: 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        // TODO: 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        // TODO: 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        // TODO: 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // TODO: 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        // TODO: 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

        val allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789._-"
        answer = new_id.lowercase() // 1단계
        answer = answer.filter { it in allowedChars } // 2단계

        while (".." in answer) answer = answer.replace("..", ".") // 3단계


        answer = answer.trim('.') // 4단계

        if (answer.isEmpty()) answer = "a" // 5단계

        if (answer.length >= 16) answer = answer.substring(0, 15).trim('.') // 6 단계

        while (answer.length < 3) answer += answer.last() // 7단계

        return answer
    }
}
package koala.programmers



    fun solution7(p: String): String {

        if (p.isEmpty()) return p //재귀함수 종료

        var count = 0
        val pivot = p.first() // [0] 대신 first 사용
        val idx = p.indices.first {
            count += if (p[it] == pivot) 1 else -1
            count == 0
        }
        val u = p.substring(0..idx)
        val v = p.drop(idx + 1) // if문 보다는 무언가를 string에서 제거할때는 drop

        return if (checkRightString(u))
            u + solution(v)
        else buildString {
            append("(" + solution(v) + ")")
            append(u.drop(1).dropLast(1)
                .map { if (it == '(') ")" else "(" }
                .joinToString("")
            )
        }
    }

    private fun checkRightString(p: String): Boolean {
        val end = p.lastIndex
        for (i in 0 until (end + 1) / 2) {
            if (p[0] != '(' && p[end - i] != ')') return false
        }
        return true
    }


/*
    '(' 의 개수와 ')' 의 개수가 같다면 이를 균형잡힌 괄호 문자열
    기본적으로 제공되는 문자열은 균형잡힌 괄호 문자열입니다.
    () 괄호의 짝이 모두 맞을경우에는 이를 올바른 괄호 문자열이라고 부릅니다.
    1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    -> p.isEmpty -> return p
    2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
    -> 짝수개의 (의 개수와 )의 개수가 동일한 문자열로 2개를 나눈다는 뜻입니다.
    단, u는 '(' 의 개수와 ')' 의 개수가 같은 문자열로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
    -> 이말은 시작 혹은 끝에 연속된)(이 나온다면 바로 멈춰야한다.
    ->그래서 ) ( 중하나라도 나온다면 그 문자열이 연속되게 나타나고 짝까지 맞춘게 u
3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
  4-3. ')'를 다시 붙입니다.
  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
  4-5. 생성된 문자열을 반환합니다.
  ))()()))

  )count 로가자 만약 시작이 ) 이다!하면! count+ 하는거지
  근데 만약에 가다가 (이게 나와 count -- 만약 다시 (++ 하고 count = 0 이되는ㅅㄴ가 종료
  거기까지가 u인건고 v에 대해서는 다시한번 이함수를 적용하면 되는거지!
 */
fun main() {
    val s = "()))((()"
    print(solution7(s))
}
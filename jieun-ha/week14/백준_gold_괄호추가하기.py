""" 16637
입력 :
수식의 길이 N(홀수)
길이가 N인 수식 (0~9 정수와 +, -, *)

조건 :
연산자 우선순위는 모두 동일

결과 :
괄호를 0~n개 추가해 만들 수 있는 식의 결과의 최댓값 구하기
1. 괄호 안에 연산자가 하나만 들어가도록
2. 중첩된 괄호 사용 불가

출력 :
최댓값(2^31보다 작고 -2^31보다 큼)

아이디어 :
노드 수가 간선 수보다 많은 그래프, DFS - 재귀함수 활용
짝수 index에는 숫자(0, 2, 4..)
홀수 index에는 문자(1, 3, 5..)
"""
import sys
input = sys.stdin.readline

n = int(input())
exp = list(input())

max_value = -2**31

def calculate(a, b, operator):
    a = int(a)
    b = int(b)

    if operator == '+':
        return a + b
    elif operator == '-':
        return a - b
    elif operator == '*':
        return a * b

# i는 항상 짝수(숫자의 인덱스), current_value는 누적 결과값
def dfs(i, current_value):
    global max_value

    if i >= n-1: # 종료 조건
        max_value = max(max_value, current_value)
        return

    if i + 2 < n: # 괄호 없이 연산
        new_value1 = calculate(current_value, exp[i+2], exp[i+1])
        dfs(i + 2, new_value1 )

    if i + 4 < n : # 괄호 추가해 연산
        new_value2 = calculate(current_value, calculate(exp[i+2], exp[i+4], exp[i+3]), exp[i+1])
        dfs(i + 4, new_value2)

dfs(0, int(exp[0]))
print(max_value)
import sys 
input = sys.stdin.readline

n, m = map(int, input().split())
table = [list(map(int, input().split())) for _ in range(n)]

dp_table = [[0] * (n+1) for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(1, n+1):
        dp_table[i][j] =  dp_table[i][j-1] + dp_table[i-1][j] - dp_table[i-1][j-1] + table[i-1][j-1]

for _ in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    sum = dp_table[x2][y2] - dp_table[x1-1][y2] - dp_table[x2][y1-1] + dp_table[x1-1][y1-1]
    print(sum)

'''
< 입력값 >
표의 크기 n (nxn)
합 구해야 하는 횟수 m
둘째 줄부터 n개의 줄에 1행부터 n행까지 차례대로
다음 m개의 줄에 네 개의 정수 (x1, y1), (x2, y2) 주어지면 합 구해서 출력

< 출력값 >
m줄에 (x1, y1)부터 (x2, y2) 합 출력

< DP - Bottom up 방식 활용 >
기저 상태 -> (0, 0), (0, 1)
dp table 채우기
원하는 조건만 찾아서 출력
'''

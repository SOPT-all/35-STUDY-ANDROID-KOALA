""" 17070
새 집의 크기 NxN
1x1 크기의 정사각형 칸으로 나누어져 있음
- 각각의 칸은 (r,c) = (행, 열)
- 행과 열의 번호는 1부터 시작
- 각각의 칸은 빈 칸 or 벽

파이프는 연속된 2칸을 차지하는 크기(회전 가능)
가로2칸/세로2칸/대각선4칸
 →, ↘, ↓ 방향으로만 밀 수 있음(밀면서 회전시킬 수 있지만 45도만 가능한 것)
미는 쪽으로는 빈칸이어야 함

초기값 : 파이프는 (1,1) (1,2) 차지(가로)
파이프의 한쪽 끝을 (N,N)로 이동시키는 방법의 개수 구하기

1번 이동 시 이동한 파이프의 시작점 = 이동 전 파이프의 끝점 (n,n)
[ 이동 방법 ]
1. 파이프가 가로로 되어 있을 때
- (n, n+1)이 비어 있고 한쪽 끝이 (n, n+1)에 위치 →
- (n, n+1), (n+1, n), (n+1, n+1)이 비어 있고 한쪽 끝이 (n+1, n+1)에 위치 ↘
2. 파이프가 세로로 되어 있을 때
- (n+1, n)이 비어 있고 한쪽 끝이 (n+1, n)에 위치 ↓
- (n, n+1), (n+1, n), (n+1, n+1)이 비어 있고 한쪽 끝이 (n+1, n+1)에 위치 ↘
3. 파이프가 대각선으로 되어 있을 때
- (n, n+1)이 비어 있고 한쪽 끝이 (n, n+1)에 위치 →
- (n+1, n)이 비어 있고 한쪽 끝이 (n+1, n)에 위치 ↓
- (n, n+1), (n+1, n), (n+1, n+1)이 비어 있고 한쪽 끝이 (n+1, n+1)에 위치 ↘

입력 :
집의 크기 N (3<=N<=16)
N개 줄 동안 집의 상태(빈 칸은 0, 벽은 1)

출력 :
(N, N)으로 이동시키는 방법의 수 (0<=답<=1,000,000)

아이디어 :
경우의 수니까 dp table로 접근하자.
dp table을 n+1xn+1로 만들어서 순서쌍 맞추고
파이프의 끝에 올 수 있는 개수를 누적합으로 저장
최종적으로 (n,n)에 저장된 숫자가 정답이 되도록
dp table은 3차원 배열로 만들어서 현재 파이프의 생김새를 저장(가로 0, 세로 1, 대각선 2)
"""
def dp(arr):
    # 1행은 가로만 올 수 있음
    for i in range(2, house_size):
        if arr[0][i] == 0:
            dp_table[0][0][i] = dp_table[0][0][i-1]

    # 1열에 파이프의 끝이 오는 경우 없음 -> (1,1)부터 dp 채우기
    for c in range(1, house_size):
        for r in range(1, house_size):
            # 대각선 파이프의 끝점(이전 파이프가 가로/세로/대각선일 때 모두 가능)
            if arr[c][r] == 0 and arr[c][r-1] == 0 and arr[c-1][r] == 0:
                dp_table[2][c][r] = dp_table[0][c-1][r-1] + dp_table[1][c-1][r-1] + dp_table[2][c-1][r-1]

            # 가로 파이프의 끝점(이전 파이프가 가로/대각선일 때 가능)
            # 세로 파이프의 끝점(이전 파이프가 세로/대각선일 때 가능)
            if arr[c][r] == 0:
                dp_table[0][c][r] = dp_table[0][c][r-1] + dp_table[2][c][r-1]
                dp_table[1][c][r] = dp_table[1][c-1][r] + dp_table[2][c-1][r]

house_size = int(input())
house = [list(map(int, input().split())) for _ in range(house_size)]

dp_table = [[[0 for col in range(house_size)] for row in range(house_size)] for depth in range(3)]
dp_table[0][0][1] = 1

dp(house)

print(dp_table[0][house_size-1][house_size-1] + dp_table[1][house_size-1][house_size-1] + dp_table[2][house_size-1][house_size-1])
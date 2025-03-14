def solution(cap, n, deliveries, pickups):
    answer = 0

    # 뒤에부터 탐색
    delivery = deliveries[::-1]
    pickup = pickups[::-1]

    deliveryCnt = 0
    pickupCnt = 0

    for i in range (n):
        deliveryCnt += delivery[i]
        pickupCnt += pickup[i]

        while deliveryCnt > 0 or pickupCnt > 0:
            deliveryCnt -= cap
            pickupCnt -= cap
            answer += (n-i)*2

    return answer

'''
마지막 집부터 배달하고 남은 만큼 수거하고 돌아오기
- delivery해야 하는 양과 pickup해야 하는 양 저장
- delivery한 만큼 pickup할 수 있으므로 cap만큼 빼주기
    - 다 못한 경우 0에 다녀와야 하므로 answer 추가해주기(왕복 거리)
    - deliveryCnt랑 pickupCnt 둘다 0될 때까지 반복
마지막 집 끝나면 마지막-1번째 집
...반복복
'''